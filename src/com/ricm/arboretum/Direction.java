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
	 SensorManager sm;
	 Sensor my_sensor;
	 Marker m;

	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		  
		  
		   File map = new File(Environment.getExternalStorageDirectory().toString() + "/grenoble.map");
		  
		   mapView = new MapView(this);

		  //Toast.makeText(this,map.exists()+"", Toast.LENGTH_LONG).show();
		  //Toast.makeText(this,"Welcome to my application", Toast.LENGTH_LONG).show();
		  
		  mapView.setMapFile(map);

		  
		  //on récupère la position actuelle : 0,0 permet de ne pas "fausser" l'affichage
		  GeoPoint p = new GeoPoint(0,0);
		  //on définie notre image sur la map qui correspond à notre emplacement
		  m = new Marker(p,getResources().getDrawable(R.drawable.location_oriented));
		  
		  ListOverlay mOverlayList = new ListOverlay(); 
		  List<OverlayItem> overlayItems = mOverlayList.getOverlayItems();
		  mapView.getOverlays().add(mOverlayList);

		  overlayItems.add(m);

		  //on rend la map cliquable
		  mapView.setClickable(true);
		  //on rend la map zoomable
		  mapView.setBuiltInZoomControls(true);
		  //on centre la map sur notre position
		  mapView.getMapViewPosition().setCenter(p);
		  
		  locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
		  locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 0, this);
		  
		  
		  sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		      
		  if (sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
		   //success! there's a magnetometer
		  }
		  
		  else Toast.makeText(this,"Noob accélérometer", Toast.LENGTH_LONG).show();

		  
		  setContentView(mapView);
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
	 public void onLocationChanged(Location arg0) {
	  // TODO Auto-generated method stub
	  Log.v("Location", locationManager.toString());
	  
	  //je récupère ma position actuel
	  GeoPoint my_pos=new GeoPoint(arg0.getLatitude(),arg0.getLongitude());
	  m.setGeoPoint(my_pos);
	  //je l'ajoute à ma map
	  mapView.getMapViewPosition().setCenter(my_pos);
	  //refresh
	  mapView.redraw();
	  
	 }

	 @Override
	 public void onProviderDisabled(String arg0) {
	  // TODO Auto-generated method stub
	  //Log.v("Location", locationManager.toString()); 
	      
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
