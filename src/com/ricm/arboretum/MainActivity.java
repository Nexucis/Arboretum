package com.ricm.arboretum;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button btnArboretum;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toast.makeText(this, "Oh, un toast",Toast.LENGTH_LONG).show();
		Toast.makeText(this, "Oh, un autre toast",Toast.LENGTH_LONG).show();
		
		btnArboretum = (Button) findViewById(R.id.btnArboretum);
		btnArboretum.setOnClickListener(this);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, Visite.class);
		startActivity(intent);
	}
	

	

}
