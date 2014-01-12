package com.ricm.arboretum;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class SousMenuVisite extends BaseActivity implements OnClickListener {

	private Button btnOnline;
	private Button btnOffline;
	@Override
	//test de mon push
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sousmenuvisite);
		//Toast.makeText(this, "Oh, un toast",Toast.LENGTH_LONG).show();
		//Toast.makeText(this, "Oh, un autre toast",Toast.LENGTH_LONG).show();

		btnOnline = (Button) findViewById(R.id.btnOnline);
		btnOnline.setOnClickListener(this);
		btnOffline = (Button) findViewById(R.id.btnOffline);
		btnOffline.setOnClickListener(this);
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
		if(v.getId() == R.id.btnOnline){
			Intent intentV = new Intent(this, Visite.class);
			startActivity(intentV);
		}else if(v.getId() == R.id.btnOffline){
			Intent intentH = new Intent(this, HorsLigne.class);
			startActivity(intentH);
		}
	}




}
