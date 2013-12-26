package com.ricm.arboretum;

import java.io.File;

import org.mapsforge.android.maps.MapActivity;
import org.mapsforge.android.maps.MapView;
import org.mapsforge.android.maps.overlay.ArrayItemizedOverlay;
import org.mapsforge.android.maps.overlay.ItemizedOverlay;
import org.mapsforge.android.maps.overlay.OverlayItem;
import org.mapsforge.android.maps.overlay.OverlayList;
import org.mapsforge.core.GeoPoint;
import org.mapsforge.map.reader.header.FileOpenResult;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public class Direction2 extends MapActivity implements LocationListener{

	private MapView mapView;
	private LocationManager locationManager;
	private SensorManager sm;
	private Sensor my_sensor;
	private OverlayItem item;
	private OverlayItem item2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);



		//chargement du fichier map
		File map = new File(Environment.getExternalStorageDirectory().toString() + "/grenoble.map");
		//ajout de la map proprement
		mapView = new MapView(this);
		mapView.setMapFile(map);

		//on rend la map cliquable
		mapView.setClickable(true);
		//on rend la map zoomable
		mapView.setBuiltInZoomControls(true);

		//affichage de la map
		setContentView(mapView);	


		Drawable defaultMarker = getResources().getDrawable(R.drawable.location); 
		Drawable location = getResources().getDrawable(R.drawable.location_oriented); 

		ArrayItemizedOverlay itemizedOverlay = new ArrayItemizedOverlay(defaultMarker);
		ArrayItemizedOverlay itemizedOverlay2 = new ArrayItemizedOverlay(location);

		// create a GeoPoint with the latitude and longitude coordinates
		GeoPoint myPos = new GeoPoint(0,0);
		GeoPoint arbo = new GeoPoint(45.193626,5.7783196);

		// create an OverlayItem with title and description
		item = new OverlayItem(arbo, "Arboretum", "Localisation de l'arboretum.");
		item2 = new OverlayItem(myPos, "Moi", "Ma position.");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		item2.setMarker(ItemizedOverlay.boundCenter(location));

		// add the OverlayItem to the ArrayItemizedOverlay
		itemizedOverlay.addItem(item);
		itemizedOverlay2.addItem(item2);


		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 0, this);
		sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

		if (sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
			//success! there's a magnetometer
		}else{
			Toast.makeText(this,"Noob accélérometer", Toast.LENGTH_LONG).show();
		}

		// add the ArrayItemizedOverlay to the MapView
		mapView.getOverlays().add(itemizedOverlay);
		mapView.getOverlays().add(itemizedOverlay2);

	}

	@Override
	protected void onResume() {
		super.onResume();
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, this); 
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, this); 
	}

	@Override
	protected void onPause() {
		super.onPause();
		locationManager.removeUpdates(this); 
	}

	@Override
	protected void onDestroy() {
		super.onPause();
	}

	@Override
	public void onLocationChanged(Location arg0) {
		GeoPoint my_pos=new GeoPoint(arg0.getLatitude(),arg0.getLongitude());
		item2.setPoint(my_pos);
		mapView.refreshDrawableState();
		// TODO Auto-generated method stub


	}
	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}
}

