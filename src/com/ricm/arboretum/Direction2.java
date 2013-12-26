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

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.graphics.drawable.Drawable;

public class Direction2 extends MapActivity{

	private MapView mapView;

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

		ArrayItemizedOverlay itemizedOverlay = new ArrayItemizedOverlay(defaultMarker);

		// create a GeoPoint with the latitude and longitude coordinates
		GeoPoint geoPoint = new GeoPoint(45.193626,5.7783196);

		// create an OverlayItem with title and description
		OverlayItem item = new OverlayItem(geoPoint, "MyPoint", "This is my own point.");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));

		// add the OverlayItem to the ArrayItemizedOverlay
		itemizedOverlay.addItem(item);

		// add the ArrayItemizedOverlay to the MapView
		mapView.getOverlays().add(itemizedOverlay);

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
	protected void onDestroy() {
		super.onPause();
	}
}

