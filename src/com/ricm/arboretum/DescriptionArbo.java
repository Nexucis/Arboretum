package com.ricm.arboretum;

import java.util.Locale;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.speech.tts.TextToSpeech;

@SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
public class DescriptionArbo extends BaseActivity implements TextToSpeech.OnInitListener {

	private static String TAG = "DescriptionArbo";
	
	private WebView webview;
	public static TextToSpeech tts;
	 
	 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		//Creation de la webview
		webview = new WebView(this);
		setContentView(webview);
		
		//pour autoriser le zoom
		WebSettings webSettings = webview.getSettings(); 
		webSettings.setBuiltInZoomControls(true);
		
		//Init du TTS
		tts = new TextToSpeech(this, this);
			
		//permet l'utilisation de javascript
		webSettings.setJavaScriptEnabled(true);
		
		//rajoute l'interface javascript pour utiliser ses m√©thodes
		webview.addJavascriptInterface(new WebAppInterface(this), "Android");
		
		//chargement depuis le dossier assets de l'application
		if (!intent.hasExtra(Nfc_Activity.EXTRA_MESSAGE)){
			Log.v(TAG,"Pas de extra message");
			webview.loadUrl("file:///android_asset/webview/" + Global.getNomFichier());
		} 
		else
		{ 
			String message = intent.getStringExtra(Nfc_Activity.EXTRA_MESSAGE);
			Log.v(TAG,"ExtraMessage trouvÈ : "+message);
			String html = Global.stringToHtml(message);
			if (html == null) 
				Toast.makeText(this, "La page correspondant au tag n'a pas ÈtÈ trouvÈ", Toast.LENGTH_SHORT).show();
			else
				webview.loadUrl(Global.stringToHtml(message));
		}

	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		if(tts!=null)
		{
			tts.stop();
		}
		super.onPause();
	}

	@Override
	protected void onStop() {
		if(tts!=null)
		{
			tts.stop();
		}
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		//on arrete l'utilisation du TTS
		if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
		super.onDestroy();
	}

	@Override
	public void onInit(int status) {
		int result;
		if (status == TextToSpeech.SUCCESS) {
			 
            result = tts.setLanguage(Locale.FRANCE);
 
            if (result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(getBaseContext(), "Votre langue n'est pas support√© par le TTS", Toast.LENGTH_SHORT).show();
            } else if(result == TextToSpeech.LANG_MISSING_DATA){
            	Toast.makeText(getBaseContext(), "Votre langue n'est pas install√© sur votre device.", Toast.LENGTH_SHORT).show();
            	//Si langage pas dispo, on lance un intent qui va demander a l'utilisateur de l'installer depuis le market
            	 Intent installIntent = new Intent();
                 installIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                 startActivity(installIntent);
            }
            else
            {
            	Toast.makeText(getBaseContext(), "TTS charg√©", Toast.LENGTH_SHORT).show();
            }
 
        } else {
        	Toast.makeText(getBaseContext(), "Pas de TTS pour vous !", Toast.LENGTH_SHORT).show();
            
        }
		
	}
	
	  public static void speakOut(String s) {
	        tts.speak(s, TextToSpeech.QUEUE_ADD, null);
	    }
	
	
}
