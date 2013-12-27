package com.ricm.arboretum;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

@SuppressLint("JavascriptInterface")
public class DescriptionArbo extends Activity {

	private WebView webview;
	
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		//Creation de la webview
		webview = new WebView(this);
		setContentView(webview);
		//pour autoriser le zoom
		WebSettings webSettings = webview.getSettings(); 
		webSettings.setBuiltInZoomControls(true);
		//permet l'utilisation de javascript
		webSettings.setJavaScriptEnabled(true);
		//rajoute l'interface javascript pour utiliser ses méthodes
		webview.addJavascriptInterface(new WebAppInterface(this), "Android");
		//chargement depuis la racine de l'appareil
		webview.loadUrl("file:///android_asset/webview/void.html");

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
		super.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
}