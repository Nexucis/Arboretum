package com.ricm.arboretum;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.ActionBar;
import android.app.Activity;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnArboretum;
	private Button btnLocalisation;
	private Button btnHorsLigne;
	private int idPhoto = 0;
	private static final int TAKE_PICTURE=1;
	ActionBar actionBar;
	static final private int MENU_ITEM = Menu.FIRST;
	
	long ref1;
	long ref2;
	
	
	@Override
	//test de mon push
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Toast.makeText(this, "Oh, un toast",Toast.LENGTH_LONG).show();
		//Toast.makeText(this, "Oh, un autre toast",Toast.LENGTH_LONG).show();

		btnArboretum = (Button) findViewById(R.id.btnArboretum);
		btnArboretum.setOnClickListener(this);
		btnLocalisation = (Button) findViewById(R.id.btnLocalisation);
		btnLocalisation.setOnClickListener(this);
		
		//Gestion de la barre d'action
		actionBar = getActionBar();
		actionBar.show();
		actionBar.setTitle("Arboricom");
		
		initAppli();
		
	}
	//rajoute un menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main, menu);
		int groupId = 0;
		int menuItemId = MENU_ITEM;
		int menuItemOrder = Menu.NONE;
		MenuItem menuItem = menu.add(groupId, menuItemId, menuItemOrder, "Appareil Photo");
		
		return true;
	}
	//Ajout d'un menu qui permet de lancer l'appareil photo
	public boolean onOptionsItemSelected(MenuItem item)
	{
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		File file = new File(Environment.getExternalStorageDirectory()+File.separator+"Arboretum"+File.separator+"photo",""+idPhoto+".jpg");
		idPhoto++;
		Uri outputFileUri = Uri.fromFile(file);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
		
//		item.setIntent(intent);
		if(item.isVisible())
		{
			startActivityForResult(intent,TAKE_PICTURE);
		}
		return false;
		
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



	public void onClick(View v){
		if(v.getId() == R.id.btnArboretum){
			Intent intentV = new Intent(this, SousMenuVisite.class);
			startActivity(intentV);
		}else if(v.getId() == R.id.btnLocalisation){
			Intent intentH = new Intent(this, Direction2.class);
			startActivity(intentH);
		}
	}
	
	private void initAppli()
	{
		//Permet de créer le dossier pour la photo, a voir pour créer le dossier map et arboretum et permettre de ddl les maps
		File photo = new File(Environment.getExternalStorageDirectory()+File.separator+"Arboretum"+File.separator+"photo");
		File map = new File(Environment.getExternalStorageDirectory()+File.separator+"Arboretum"+File.separator+"Map");
		File arbo = new File(Environment.getExternalStorageDirectory()+File.separator+"Arboretum"+File.separator+"Map","Arboretum.map");
		File gre = new File(Environment.getExternalStorageDirectory()+File.separator+"Arboretum"+File.separator+"Map","grenoble.map");
		
		String serviceString = Context.DOWNLOAD_SERVICE;
		DownloadManager downloadManager = (DownloadManager)getSystemService(serviceString);
		Uri mapGre = Uri.parse("http://paul.labat.free.fr/Arboretum/grenoble.map");
		Uri mapArbo = Uri.parse("http://paul.labat.free.fr/Arboretum/Arboretum.map");		
		
		
		IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
		BroadcastReceiver receiver = new BroadcastReceiver(){

			@Override
			public void onReceive(Context context, Intent intent) {
				long ref = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
				if(ref1 == ref)
				{
					Toast.makeText(context, "Carte de Grenoble téléchargée.", Toast.LENGTH_SHORT).show();
				}
				if(ref2 == ref)
				{
					Toast.makeText(context, "Carte de l'arboretum téléchargée.", Toast.LENGTH_SHORT).show();
				}
				
			}
			
		};
		registerReceiver(receiver,filter);
		
		//Creer les dossiers
		if(!photo.exists())
		{
			photo.mkdirs();
		}

		if(!map.exists())
		{
			map.mkdir();
		}
		
		//si les map n'existent pas
		if(!arbo.exists())
		{
			Toast.makeText(this, "La carte de Grenoble est en cours de téléchargement.", Toast.LENGTH_SHORT).show();
			DownloadManager.Request request1 = new Request(mapGre);
			request1.setDestinationUri(Uri.fromFile(new File(Environment.getExternalStorageDirectory()+File.separator+"Arboretum"+File.separator+"Map"+File.separator,"grenoble.map")));
			request1.setNotificationVisibility(Request.VISIBILITY_VISIBLE);
			ref1 = downloadManager.enqueue(request1);
		}
		else
		{
			Toast.makeText(this, "La carte de Grenoble existe.", Toast.LENGTH_SHORT).show();
		}
		if(!gre.exists())
		{
			Toast.makeText(this, "La carte de l'arboretum est en cours de téléchargement.", Toast.LENGTH_SHORT).show();
			DownloadManager.Request request2 = new Request(mapArbo);
			request2.setDestinationUri(Uri.fromFile(new File(Environment.getExternalStorageDirectory()+File.separator+"Arboretum"+File.separator+"Map"+File.separator,"Arboretum.map")));
			request2.setNotificationVisibility(Request.VISIBILITY_VISIBLE);
			ref2 = downloadManager.enqueue(request2);
		}
		else
		{
			Toast.makeText(this, "La carte de l'arboretum existe.", Toast.LENGTH_SHORT).show();
		}

		
		unregisterReceiver(receiver);
	}
	
	

}
