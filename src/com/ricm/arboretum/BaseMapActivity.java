package com.ricm.arboretum;

import java.io.File;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseMapActivity extends Nfc_MapActivity{


	//code pour le menu photo
	private int idPhoto = 0;
	private static final int TAKE_PICTURE=1;
	protected ActionBar actionBar;
	static final private int MENU_ITEM = Menu.FIRST;

	private final int groupIdPhoto = 1;
	private final int groupIdSon = 2;
	private final int groupIdCredit = 3;

	protected void OnCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//Gestion de la barre d'action
		actionBar = getActionBar();
		actionBar.show();
		actionBar.setTitle("Arboricom");
	}

	public boolean onPrepareOptionsMenu(Menu menu){
		if(!Global.getSonActive()){
			menu.getItem(1).setChecked(true);
		}else{
			menu.getItem(1).setChecked(false);
		}if(Global.isCredit()){
			menu.getItem(2).setVisible(false);
		}
		return true;
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main, menu);
		menu.add(groupIdPhoto, MENU_ITEM, Menu.NONE, "Appareil Photo");
		menu.add(groupIdSon, MENU_ITEM, Menu.NONE, "Son desactivé");
		menu.add(groupIdCredit, MENU_ITEM, Menu.NONE, "Crédits");
		menu.setGroupCheckable(groupIdSon, true,false);
		menu.getItem(1).setCheckable(true);
		if(!Global.getSonActive()){
			menu.getItem(1).setChecked(true);
		}else{
			menu.getItem(1).setChecked(false);
		}if(Global.isCredit()){
			menu.getItem(2).setVisible(false);
		}
		
		menu.getItem(3).setVisible(false);

		return true;
	}
	//Ajout d'un menu qui permet de lancer l'appareil photo
	public boolean onOptionsItemSelected(MenuItem item)
	{
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		Intent intentc = new Intent(this, Credit.class);
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
		if(item.getGroupId() == groupIdCredit){
			Global.setCredit(true);
			startActivity(intentc);
		}
		return false;

	}

}
