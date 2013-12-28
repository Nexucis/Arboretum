package com.ricm.arboretum;

import java.io.File;

import org.mapsforge.android.maps.MapActivity;
import org.mapsforge.android.maps.MapView;
import org.mapsforge.android.maps.overlay.ArrayItemizedOverlay;
import org.mapsforge.android.maps.overlay.ItemizedOverlay;
import org.mapsforge.android.maps.overlay.OverlayItem;
import org.mapsforge.core.GeoPoint;

import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;

public class HorsLigne extends MapActivity{

	private MapView mapView;
	private OverlayItem item;
	private GeoPoint interet;
	private GeoPoint soleil;
	private GeoPoint ceinture;
	private GeoPoint jupiter;
	private GeoPoint saturne;
	private GeoPoint uranus;
	private GeoPoint mercure;
	private GeoPoint arbo;
	private OverlayItem my_item;


	/*
	 * Inner Class
	 * Elle sert pour la gestion des listes d'items, concretement, les markers jumele a une geolocalisation
	 * elle est obligatoire afin de redefinir ontap. En fait, quand l'utilisateur appuyera sur un marqueur,
	 * si celui-ci a ete stocke dans l'arraylist de type MyItemizedOverlay, le code va aller verifier si le doigt 
	 * a toucher un des items de la liste et verifier ontap.
	 * C'est la la grande difference avec mapsforge 0.3.1, ici on cree les markers de tout pieces, et on les stock apres 
	 * leur avoir assigner un geopoint
	 */
	private class MyItemizedOverlay extends ArrayItemizedOverlay{



		private final Context context2;

		/**
		 * Constructs a new MyItemizedOverlay.
		 * 
		 * @param defaultMarker
		 *            the default marker (may be null).
		 * @param context
		 *            the reference to the application context.
		 */		
		MyItemizedOverlay(Drawable defaultMarker, Context context) {
			super(defaultMarker);
			this.context2 = context;
		}



		/**
		 * Handles a tap event on the given item.
		 */
		@Override
		protected boolean onTap(int index) {
			OverlayItem item = createItem(index);
			if (item != null) {
				if(item.getPoint() == soleil){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == ceinture){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == jupiter){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == mercure){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == uranus){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == saturne){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}

			}
			return true;
		}

	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);



		//chargement du fichier map
		File map = new File(Environment.getExternalStorageDirectory().toString() + "/Arboretum/Map/Arboretum.map");
		//ajout de la map proprement
		mapView = new MapView(this);
		mapView.setMapFile(map);

		//on rend la map cliquable
		mapView.setClickable(true);
		//on rend la map zoomable
		mapView.setBuiltInZoomControls(true);

		//affichage de la map
		setContentView(mapView);	


		Drawable defaultMarker = getResources().getDrawable(R.drawable.planetarium); 

		ArrayItemizedOverlay itemizedOverlay = new MyItemizedOverlay(defaultMarker, this);

		// create a GeoPoint with the latitude and longitude coordinates
		soleil = new GeoPoint(45.1942296,5.7772561);
		//test = new GeoPoint(45.1938761,5.7682984);
		
		arbo = new GeoPoint(45.193626,5.7783196);
		my_item = new OverlayItem(arbo, "Arboretum", "Localisation de l'arboretum.");
		//je me centre sur moi
		mapView.setCenter(my_item.getPoint());
		//puis je zoom *2
		mapView.zoom((byte) 6, 6);

		// create an OverlayItem with title and description
		item = new OverlayItem(soleil, "Soleil", "Localisation du soleil");
		//item3 = new OverlayItem(test, "Test", "Localisation de l'arboretum.");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		// add the OverlayItem to the ArrayItemizedOverlay
		itemizedOverlay.addItem(item);
		//itemizedOverlay.addItem(item3);

		ceinture = new GeoPoint(45.1943799, 5.7778569);
		item = new OverlayItem(ceinture, "Ceinture d'asteroides", "la ceinture d'asteroides");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);


		jupiter = new GeoPoint(45.1944986, 5.7782611);
		item = new OverlayItem(jupiter, "Jupiter", "Localisation de Jupiter");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);


		saturne = new GeoPoint(45.1943126, 5.7790359); 
		item = new OverlayItem(saturne, "Saturne", "Localisation de Saturne");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		uranus = new GeoPoint(45.1932206, 5.7787777); 
		item = new OverlayItem(uranus, "Uranus", "Localisation d'Uranus");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);


		mercure = new GeoPoint(45.1942652, 5.7774021);
		item = new OverlayItem(mercure, "Mercure", "Localisation de Mercure");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		// add the ArrayItemizedOverlay to the MapView
		mapView.getOverlays().add(itemizedOverlay);

		//je me centre sur l'arbo
		//mapView.setCenter(item.getPoint());
		//puis je zoom *2
		//mapView.zoom((byte) 1, 1);

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
