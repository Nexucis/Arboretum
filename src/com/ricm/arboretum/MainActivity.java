package com.ricm.arboretum;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.ActionBar;
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

public class MainActivity extends Nfc_Activity implements OnClickListener {

	private Button btnArboretum;
	private Button btnLocalisation;
	//code pour le menu photo
	private int idPhoto = 0;
	private static final int TAKE_PICTURE=1;
	ActionBar actionBar;
	static final private int MENU_ITEM = Menu.FIRST;
	//code du download manager
	long ref1;
	long ref2;
	BroadcastReceiver receiver;
	
	private final int groupIdPhoto = 1;
	private final int groupIdSon = 2;
	
	@Override
	//test de mon push
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (no_nfc) Toast.makeText(this, R.string.no_NFC, Toast.LENGTH_SHORT).show();
		setContentView(R.layout.activity_main);

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
		menu.add(groupIdPhoto, MENU_ITEM, Menu.NONE, "Appareil Photo");
		menu.add(groupIdSon, MENU_ITEM, Menu.NONE, "Son desactivé");
		menu.setGroupCheckable(groupIdSon, true,false);
		menu.getItem(2).setVisible(false);
		
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
		
		//Menu photo
		if(item.getGroupId() == groupIdPhoto)
		{
			startActivityForResult(intent,TAKE_PICTURE);
		}
		//Menu son
		if(item.getGroupId() == groupIdSon)
		{
			if(!Global.getSonActive())
			{
				Toast.makeText(this, "Son activé", Toast.LENGTH_SHORT).show();	
			}
			else
			{
				Toast.makeText(this, "Son désactivé", Toast.LENGTH_SHORT).show();	
			}
			Global.setSonActive(!Global.getSonActive());
			item.setChecked(!Global.getSonActive());	
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
		unregisterReceiver(receiver);
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
		
		//Init du downloadmanager
		String serviceString = Context.DOWNLOAD_SERVICE;
		DownloadManager downloadManager = (DownloadManager)getSystemService(serviceString);
		//fichiers a telecharger
		Uri mapGre = Uri.parse("http://paul.labat.free.fr/Arboretum/grenoble.map");
		Uri mapArbo = Uri.parse("http://paul.labat.free.fr/Arboretum/Arboretum.map");		
		
		//Permet de recevoir que les telechargement sont fini.
		IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
		receiver = new BroadcastReceiver(){

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
		
		//Creer les dossiers, s'ils n'existe pas
		if(!photo.exists())
		{
			photo.mkdirs();
		}

		if(!map.exists())
		{
			map.mkdir();
		}
		
		//si les map n'existent pas, on les download
		if(!arbo.exists())
		{
			Toast.makeText(this, "La carte de Grenoble est en cours de téléchargement.", Toast.LENGTH_SHORT).show();
			DownloadManager.Request request1 = new Request(mapGre);
			request1.setDestinationUri(Uri.fromFile(new File(Environment.getExternalStorageDirectory()+File.separator+"Arboretum"+File.separator+"Map"+File.separator,"grenoble.map")));
			request1.setNotificationVisibility(Request.VISIBILITY_VISIBLE);
			ref1 = downloadManager.enqueue(request1);
		}
		if(!gre.exists())
		{
			Toast.makeText(this, "La carte de l'arboretum est en cours de téléchargement.", Toast.LENGTH_SHORT).show();
			DownloadManager.Request request2 = new Request(mapArbo);
			request2.setDestinationUri(Uri.fromFile(new File(Environment.getExternalStorageDirectory()+File.separator+"Arboretum"+File.separator+"Map"+File.separator,"Arboretum.map")));
			request2.setNotificationVisibility(Request.VISIBILITY_VISIBLE);
			ref2 = downloadManager.enqueue(request2);
		}

		
		
	}
	
	

}
