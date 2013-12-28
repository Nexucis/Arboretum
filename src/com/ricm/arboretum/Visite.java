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

public class Visite extends MapActivity implements LocationListener {

	private MapView mapView;
	private LocationManager locationManager;
	private SensorManager sm;
	private Sensor my_sensor;

	//marker de notre position
	private OverlayItem item;
	//marker des planetes
	private OverlayItem item2;
	//marker des plantes
	private OverlayItem item3;


	private GeoPoint interet;
	private GeoPoint soleil;
	private GeoPoint ceinture;
	private GeoPoint jupiter;
	private GeoPoint saturne;
	private GeoPoint uranus;
	private GeoPoint mercure;
	private GeoPoint venus;
	private GeoPoint terre;
	private GeoPoint mars;
	private GeoPoint neptune;
	private GeoPoint objNeptune;

	private GeoPoint groupeA1;
	private GeoPoint groupeA2;
	private GeoPoint groupeA3;
	private GeoPoint groupeA0;
	private GeoPoint groupeA4;
	private GeoPoint groupeA5;
	private GeoPoint groupeA6;
	private GeoPoint groupeA7;
	private GeoPoint groupeA8;
	private GeoPoint groupeA9;
	private GeoPoint groupeA10;
	private GeoPoint groupeA11;
	private GeoPoint groupeA12;
	private GeoPoint groupeA13;
	private GeoPoint groupeA14;
	private GeoPoint groupeA15;
	private GeoPoint groupeA16;
	private GeoPoint groupeA17;
	private GeoPoint groupeA18;
	private GeoPoint groupeA19;
	private GeoPoint groupeA20;
	private GeoPoint groupeA21;
	private GeoPoint groupeA22;
	private GeoPoint groupeA23;

	private boolean sSoleil = true;
	private boolean sCeinture = true;
	private boolean sJupiter = true;
	private boolean sSaturne = true;
	private boolean sUranus = true;
	private boolean sMercure = true;
	private boolean sTerre = true;
	private boolean sVenus = true;
	private boolean sMars = true;
	private boolean sNeptune = true;
	private boolean sObjNeptune = true;
	
	private boolean sGroupeA0 = true;
	private boolean sGroupeA1 = true;
	private boolean sGroupeA2 = true;
	private boolean sGroupeA3 = true;
	private boolean sGroupeA4 = true;
	private boolean sGroupeA5 = true;
	private boolean sGroupeA6 = true;
	private boolean sGroupeA7 = true;
	private boolean sGroupeA8 = true;
	private boolean sGroupeA9 = true;
	private boolean sGroupeA10 = true;
	private boolean sGroupeA11 = true;
	private boolean sGroupeA12 = true;
	private boolean sGroupeA13 = true;
	private boolean sGroupeA14 = true;
	private boolean sGroupeA15 = true;
	private boolean sGroupeA16 = true;
	private boolean sGroupeA17 = true;
	private boolean sGroupeA18 = true;
	private boolean sGroupeA19 = true;
	private boolean sGroupeA20 = true;
	private boolean sGroupeA21 = true;
	private boolean sGroupeA22 = true;
	private boolean sGroupeA23 = true;

	private int mSoundNotif;
	private SoundManager mSoundManager;


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
				}else if(item.getPoint() == venus){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == terre){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == mars){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == neptune){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == objNeptune){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA0){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA1){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA2){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA3){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA4){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA5){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA6){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA7){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA8){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA9){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA10){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA11){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA12){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA13){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA14){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA15){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA16){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA17){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA18){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA19){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA20){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA21){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA22){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setIcon(android.R.drawable.ic_menu_info_details);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == groupeA23){
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


		mSoundManager= new SoundManager(this,5);
		mSoundNotif = mSoundManager.add(this, R.raw.notif);
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
		Drawable location = getResources().getDrawable(R.drawable.location_oriented); 
		Drawable markerPlante = getResources().getDrawable(R.drawable.plante); 

		//ici on les stock. La deuxieme liste n'est pas MyItemizdOverlay pour
		//la simple raison qu'elle va stocker notre curseur de position
		//dont on ne souhaite pas qu'il y ai de reaction si on tap dessus
		ArrayItemizedOverlay itemizedOverlay = new MyItemizedOverlay(defaultMarker, this);
		ArrayItemizedOverlay itemizedOverlay2 = new ArrayItemizedOverlay(location);
		ArrayItemizedOverlay itemizedOverlay3 = new MyItemizedOverlay(markerPlante, this);

		// create a GeoPoint with the latitude and longitude coordinates
		GeoPoint myPos = new GeoPoint(0,0);
		//test = new GeoPoint(45.1938761,5.7682984);

		// create an OverlayItem with title and description
		//item3 = new OverlayItem(test, "Test", "Localisation de l'arboretum.");
		item2 = new OverlayItem(myPos, "Moi", "Ma position.");
		item2.setMarker(ItemizedOverlay.boundCenter(location));

		// add the OverlayItem to the ArrayItemizedOverlay
		itemizedOverlay2.addItem(item2);

		// create a GeoPoint with the latitude and longitude coordinates
		soleil = new GeoPoint(45.1942296,5.7772561);

		// create an OverlayItem with title and description
		item = new OverlayItem(soleil, "Soleil", "Localisation du soleil");
		//item3 = new OverlayItem(test, "Test", "Localisation de l'arboretum.");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		// add the OverlayItem to the ArrayItemizedOverlay
		itemizedOverlay.addItem(item);
		//itemizedOverlay.addItem(item3);


		//Ajout des planetes
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

		terre = new GeoPoint(45.1943019, 5.7775252);
		item = new OverlayItem(terre, "Terre", "Localisation de la Terre");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		venus = new GeoPoint(45.1942954, 5.7774607);
		item = new OverlayItem(venus, "Venus", "Localisation de Venus");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		mars = new GeoPoint(45.19433, 5.7776101);
		item = new OverlayItem(mars, "Mars", "Localisation de Mars");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		neptune = new GeoPoint(45.1927963, 5.777998);
		item = new OverlayItem(neptune, "Neptune", "Localisation de Neptune");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		objNeptune = new GeoPoint(45.1942652, 5.7774021);
		item = new OverlayItem(objNeptune, "Objet de Neptunes", "Localisation des Objets de Neptune");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);



		//Ajout des arbres 

		//A0 : Chicot du Canada / Erable mégundo
		groupeA0 = new GeoPoint(45.1944015,5.777915);
		item = new OverlayItem(groupeA0, "Premier groupe de plante", "Localisation du premier groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A1 : Mélèze du Japon / Holodisque Discolore / Sequoia toujours vert, bois rouge
		groupeA1 = new GeoPoint(45.194462,5.778040);
		item = new OverlayItem(groupeA1, "Deuxieme groupe de plante", "Localisation du deuxieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A2 : Cotonéastor à feuilles bullées
		groupeA2 = new GeoPoint(45.194637,5.778199);
		item = new OverlayItem(groupeA2, "Troisieme groupe de plante", "Localisation du troisieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A3 : Cèdre du Liban / Erable trident / Erable champêtre / Erable / Erable de Pensylvanie
		groupeA3 = new GeoPoint(45.194303,5.778392);
		item = new OverlayItem(groupeA3, "Quatrieme groupe de plante", "Localisation du quatrieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A4 : Epicea de Bosnie / Pin panicio / Pin de Corse / Erable à peau de serpent 
		groupeA4 = new GeoPoint(45.194475,5.778776);
		item = new OverlayItem(groupeA4, "Cinquieme groupe de plante", "Localisation du cinquieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A5 Cèdre de l'Himalaya, Déodar / Carya cordée / Hêtre, Fau, Fayard, Platane d'orient
		groupeA5 = new GeoPoint(45.194470,5.779105);
		item = new OverlayItem(groupeA5, "Sixieme groupe de plante", "Localisation du sixieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A6 Genévrier commun
		groupeA6 = new GeoPoint(45.194325,5.779103);
		item = new OverlayItem(groupeA6, "Septieme groupe de plante", "Localisation du septieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A7 Sapin d'Algérie / Pin weymouth / Viorne velue
		groupeA7 = new GeoPoint(45.194120,5.779217);
		item = new OverlayItem(groupeA7, "Huitieme groupe de plante", "Localisation du huitieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A8 Cornouiller florifère / Rosier chataîgne / Peuplier
		groupeA8 = new GeoPoint(45.194023,5.779276);
		item = new OverlayItem(groupeA8, "Neuvieme groupe de plante", "Localisation du neuvieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A9 Ptérocarier
		groupeA9 = new GeoPoint(45.193801,5.779350);
		item = new OverlayItem(groupeA9, "Dixieme groupe de plante", "Localisation du dixieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A10 Mahonia de Beal / Amélande du Canada / Noisetier de Turquie / Noisetier coudier
		groupeA10 = new GeoPoint(45.193777,5.779327);
		item = new OverlayItem(groupeA10, "Onzieme groupe de plante", "Localisation du onzieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A11 Forsythia blanc / Alangium à feuilles de Platane / Escalonie rouge
		groupeA11 = new GeoPoint(45.193743,5.779282);
		item = new OverlayItem(groupeA11, "Douzieme groupe de plante", "Localisation du douzieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A12 Chèvrefeuille des tatars / Noisetier tortueux / Epine-vignette de Juliana / Corête du Japon
		groupeA12 = new GeoPoint(45.193413,5.779194);
		item = new OverlayItem(groupeA12, "Treizieme groupe de plante", "Localisation du treizieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A13 Erable de montpellier / Cade Oxycèdre / Saule des îles Sakhalines / Magnolia à fleur de lis 
		//Magnolia de soulange / Viome de Burkwood
		groupeA13 = new GeoPoint(45.193271,5.776999);
		item = new OverlayItem(groupeA13, "Quatorzieme groupe de plante", "Localisation du quatorzieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A14 Fragon Piquoti / Petit houx / Petit houx à langues / Ardore aux mouchoirs
		groupeA14 = new GeoPoint(45.193239,5.778808);
		item = new OverlayItem(groupeA14, "Quinzieme groupe de plante", "Localisation du quinzieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A15 Skimmia du Japon / Miscarthus / Cyprès de lawson / Tulipier de Virginie
		groupeA15 = new GeoPoint(45.193181,5.778490);
		item = new OverlayItem(groupeA15, "Seizieme groupe de plante", "Localisation du seizieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A16 Kolwitzia / Arbre de soie / Yucca / Poncinus / Lilas blanc / Abelia / Indigotier / Forsythia / Chêne vert, Yeuse
		groupeA16 = new GeoPoint(45.193152,5.778128);
		item = new OverlayItem(groupeA16, "Dix-septieme groupe de plante", "Localisation du dix-septieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A17 Cyprès de lawson / Cyprès géant / Bananier des indiens / Orne champêtre / Groseiller à maqueraux / Chalef en ombelle
		groupeA17 = new GeoPoint(45.193094,5.777793);
		item = new OverlayItem(groupeA17, "Dix-huitieme groupe de plante", "Localisation du dix-huitieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A18 Noisetier pourpre / Châtaignier / Groseiller doré / Alisier torminal / Epine-du-christ / Fusain d'Europe
		groupeA18 = new GeoPoint(45.192880,5.777760);
		item = new OverlayItem(groupeA18, "Dix-neuvieme groupe de plante", "Localisation du dix-neuvieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A19 Houx bleu / Viorne à feuilles ridées / Seringat / Osmanthe à feuilles de houx
		groupeA19 = new GeoPoint(45.193037,5.777539);
		item = new OverlayItem(groupeA19, "Vingtieme groupe de plante", "Localisation du vingtieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A20 Erable velouté / Seringat de lewis / Weigelia / Cornouiller mâle / Osmara burkwoodii / Burk & Skie / Magnolia à grandes fleurs
		groupeA20 = new GeoPoint(45.193320,5.777560);
		item = new OverlayItem(groupeA20, "Vingt et unieme groupe de plante", "Localisation du vingt et unieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);
		
		//A21 Véglier du Japon / Troëne de Californie / Troëne de Chine / Peuplier d'Italie
		groupeA21 = new GeoPoint(45.193668,5.777579);
		item = new OverlayItem(groupeA21, "Vingt deuxieme groupe de plante", "Localisation du vingt deuxieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);

		//A22 Aulore cordé / Marronier du Japon / Marronier à petites fleurs / non inconnue à corriger / Dardari Simon-Louis 'Jules d'Anière'
		groupeA22 = new GeoPoint(45.193929,5.777770);
		item = new OverlayItem(groupeA22, "Vingt troisieme groupe de plante", "Localisation du vingt troisieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);
		
		//A23 Cyprès toujours vert / Charme 
		groupeA23 = new GeoPoint(45.194160,5.777865);
		item = new OverlayItem(groupeA23, "Vingt quatrieme groupe de plante", "Localisation du vingt quatrieme groupe de plantes");
		item.setMarker(markerPlante);
		itemizedOverlay.addItem(item);


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

	public boolean estDansZone(GeoPoint ptsInt, GeoPoint pos){

		// +- 0.0002 zone de 2 metres, je verifie donc si notre position se situe dans une zone de 2 metres autour de nous.
		if(pos.getLatitude() >= (ptsInt.getLatitude() - 0.0002) && pos.getLatitude() <= (ptsInt.getLatitude() + 0.0002) 
				&& pos.getLongitude() >= (ptsInt.getLongitude() - 0.0002) && pos.getLongitude() <= (ptsInt.getLongitude() + 0.0002) ){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public void onLocationChanged(Location arg0) {
		GeoPoint my_pos=new GeoPoint(arg0.getLatitude(),arg0.getLongitude());
		item2.setPoint(my_pos);

		//pour raffraichir en touchant l'écran
		//mapView.refreshDrawableState();

		//pour recentrer à chaque changement de position
		mapView.setCenter(my_pos);


		if(sSoleil && estDansZone(soleil, my_pos)){
			mSoundManager.play(mSoundNotif);
			sSoleil = false;
		}
		if(sCeinture && estDansZone(ceinture, my_pos)){
			mSoundManager.play(mSoundNotif);
			sCeinture = false;
		}
		if(sMercure && estDansZone(mercure, my_pos)){
			mSoundManager.play(mSoundNotif);
			sMercure = false;
		}
		if(sSaturne && estDansZone(saturne, my_pos)){
			mSoundManager.play(mSoundNotif);
			sSaturne = false;
		}
		if(sJupiter && estDansZone(jupiter, my_pos)){
			mSoundManager.play(mSoundNotif);
			sJupiter = false;
		}
		if(sTerre && estDansZone(terre, my_pos)){
			mSoundManager.play(mSoundNotif);
			sTerre = false;
		}
		if(sUranus && estDansZone(uranus, my_pos)){
			mSoundManager.play(mSoundNotif);
			sUranus = false;
		}
		if(sNeptune && estDansZone(neptune, my_pos)){
			mSoundManager.play(mSoundNotif);
			sNeptune = false;
		}
		if(sVenus && estDansZone(venus, my_pos)){
			mSoundManager.play(mSoundNotif);
			sVenus = false;
		}
		if(sObjNeptune && estDansZone(objNeptune, my_pos)){
			mSoundManager.play(mSoundNotif);
			sObjNeptune = false;
		}
		if(sMars && estDansZone(mars, my_pos)){
			mSoundManager.play(mSoundNotif);
			sMars = false;
		}
		if(sGroupeA0 && estDansZone(groupeA0, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA0 = false;
		}
		if(sGroupeA1 && estDansZone(groupeA1, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA1 = false;
		}
		if(sGroupeA2 && estDansZone(groupeA2, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA2 = false;
		}
		if(sGroupeA3 && estDansZone(groupeA3, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA3 = false;
		}
		if(sGroupeA4 && estDansZone(groupeA4, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA4 = false;
		}
		if(sGroupeA5 && estDansZone(groupeA5, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA5 = false;
		}
		if(sGroupeA6 && estDansZone(groupeA6, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA6 = false;
		}
		if(sGroupeA7 && estDansZone(groupeA7, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA7 = false;
		}
		if(sGroupeA8 && estDansZone(groupeA8, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA0 = false;
		}
		if(sGroupeA9 && estDansZone(groupeA9, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA9 = false;
		}
		if(sGroupeA10 && estDansZone(groupeA10, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA10 = false;
		}
		if(sGroupeA11 && estDansZone(groupeA11, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA11 = false;
		}
		if(sGroupeA12 && estDansZone(groupeA12, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA12 = false;
		}
		if(sGroupeA13 && estDansZone(groupeA13, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA13 = false;
		}
		if(sGroupeA14 && estDansZone(groupeA14, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA14 = false;
		}
		if(sGroupeA15 && estDansZone(groupeA15, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA15 = false;
		}
		if(sGroupeA16 && estDansZone(groupeA16, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA16 = false;
		}
		if(sGroupeA17 && estDansZone(groupeA17, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA17 = false;
		}
		if(sGroupeA18 && estDansZone(groupeA18, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA18 = false;
		}
		if(sGroupeA19 && estDansZone(groupeA19, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA19 = false;
		}
		if(sGroupeA20 && estDansZone(groupeA20, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA20 = false;
		}
		if(sGroupeA21 && estDansZone(groupeA21, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA21 = false;
		}
		if(sGroupeA22 && estDansZone(groupeA22, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA22 = false;
		}
		if(sGroupeA23 && estDansZone(groupeA23, my_pos)){
			mSoundManager.play(mSoundNotif);
			sGroupeA23 = false;
		}


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
