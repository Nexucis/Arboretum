package com.ricm.arboretum;


import java.io.File;
import java.util.List;

import org.mapsforge.android.maps.MapActivity;
import org.mapsforge.android.maps.MapView;
import org.mapsforge.android.maps.overlay.ListOverlay;
import org.mapsforge.android.maps.overlay.Marker;
import org.mapsforge.android.maps.overlay.OverlayItem;
import org.mapsforge.core.model.GeoPoint;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class Direction extends MapActivity implements LocationListener{

	LocationManager locationManager;
	MapView mapView;

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		File map = new File(Environment.getExternalStorageDirectory().toString() + "/grenoble.map");
		
		

		if(map.exists()){
			mapView = new MapView(this);
			mapView.setClickable(true);
			mapView.setBuiltInZoomControls(true);
			Toast.makeText(this,"la map existe", Toast.LENGTH_SHORT).show();
			mapView.setMapFile(map);
			setContentView(mapView);
		}else{
			Toast.makeText(this,"la map n'existe pas", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}



}
