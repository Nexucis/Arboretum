package com.ricm.arboretum;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button btnArboretum;
	private Button btnLocalisation;
	private Button btnHorsLigne;
	private int idPhoto = 0;
	private static final int TAKE_PICTURE=1;
	ActionBar actionBar;
	static final private int MENU_ITEM = Menu.FIRST;
	
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
		int menuItemText = 1;
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

}
