package com.ricm.arboretum;

import java.io.File;


import org.mapsforge.android.maps.MapView;
import org.mapsforge.android.maps.overlay.ArrayItemizedOverlay;
import org.mapsforge.android.maps.overlay.ItemizedOverlay;
import org.mapsforge.android.maps.overlay.OverlayItem;
import org.mapsforge.core.GeoPoint;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;

public class Visite extends BaseMapActivity implements LocationListener {

	private MapView mapView;
	private LocationManager locationManager;
	private SensorManager sm;
	private Sensor my_sensor;

	//marker des planetes
	private OverlayItem item;
	//marker des plantes
	private OverlayItem item2;
	//marker de notre position
	private OverlayItem item3;

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
	private int mSoundPlanete;
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

		CharSequence tSoleil[] = { "Soleil"};
		CharSequence tTerre[] = {"Terre"};
		CharSequence tMars[] = {"Mars"};
		CharSequence tVenus[] = {"Venus"};
		CharSequence tCeinture[] = {"Ceinture d'astéroïdes"};
		CharSequence tJupiter[] = {"Jupiter"};
		CharSequence tMercure[] = {"Mercure"};
		CharSequence tUranus[] = {"Uranus"};
		CharSequence tSaturne[] = {"Saturne"};
		CharSequence tNeptune[] = {"Neptune"};
		CharSequence tTransNeptu[] = {"Ceinture de Kuiper", "Objets épars", "Objets détachés"};
		CharSequence tA0[] = {"Erable Mégundo", "Chicot du Canada"};
		CharSequence tA1[] = {"Mélèze du Japon", "Holodisque Discolore", "Sequoia toujours vert"};
		CharSequence tA2[] = {"Cotonéastor à feuilles bullées"};
		CharSequence tA3[] = {"Cèdre du Liban", "Erable trident", "Erable champêtre", "Erable de Pensylvanie"};
		CharSequence tA4[] = {"Epicea de Bosnie", "Pin panicio", "Pin de Corse", "Erable à peau de serpent"};
		CharSequence tA5[] = {"Cèdre de l'Himalaya", "Carya cordée", "Platane d'orient"};
		CharSequence tA6[] = {"Genévrier commun"};
		CharSequence tA7[] = {"Sapin d'Algérie", "Pin weymouth", "Viorne velue"};
		CharSequence tA8[] = {"Cornouiller florifère", "Rosier chataîgne", "Peuplier"};
		CharSequence tA9[] = {"Ptérocarier"};
		CharSequence tA10[] = {"Mahonia de Beal", "Amélande du Canada", "Noisetier de Turquie", "Noisetier coudier"};
		CharSequence tA11[] = {"Forsythia blanc", "Alangium à feuilles de Platane", "Escalonie rouge"};
		CharSequence tA12[] = {"Chèvrefeuille des tatars", "Noisetier tortueux", "Epine-vignette de Juliana", "Corête du Japon"};
		CharSequence tA13[] = {"Erable de montpellier", "Cade Oxycèdre", "Saule des îles Sakhalines", "Magnolia à fleur de lis", "Magnolia de soulange", "Viome de Burkwood"};
		CharSequence tA14[] = {"Frangon piquoti", "Petit houx", "Petit houx à langues", "Ardore aux mouchoirs"};
		CharSequence tA15[] = {"Skimmia du Japon", "Miscarthus", "Cyprès de lawson", "Tulipier de Virginie"};
		CharSequence tA16[] = {"Kolowitzia", "Arbre de soie", "Yucca", "Poncinus", "Lilas blanc", "Abelia", "Indigotier", "Forsythia", "Chêne vert, Yeuse"};
		CharSequence tA17[] = {"Cyprès de lawson", "Cyprès géant", "Bananier des indiens", "Orne champêtre", "Groseiller à maqueraux", "Chalef en ombelle"};
		CharSequence tA18[] = {"Noisetier pourpre", "Châtaignier", "Groseiller doré", "Alisier torminal", "Epine-du-christ", "Fusain d'Europe"};
		CharSequence tA19[] = {"Houx bleu", "Viorgne à feuille ridées", "Seringat", "Osmanthe à feuille de houx"};
		CharSequence tA20[] = {"Erable velouté", "Seringat de lewis", "Weigelia", "Cornouiller mâle", "Osmara burkwoodii", "Magnolia à grandes fleurs"};
		CharSequence tA21[] = {"Troëne de Californie", "Troëne de Chine", "Peuplier d'Italie"};
		CharSequence tA22[] = {"Aulne Cordé", "Marronier du Japon", "Marronier à petites fleurs"};
		CharSequence tA23[] = {"Charme"};

		/**
		 * Handles a tap event on the given item.
		 */
		@Override
		protected boolean onTap(int index) {
			OverlayItem item = createItem(index);
			final Intent intent = new Intent(context2, DescriptionArbo.class);
			if (item != null) {
				if(item.getPoint() == Global.getSoleil()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);

					builder.setItems(tSoleil, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("planetes/soleil.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_soleil);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getCeinture()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tCeinture, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("planetes/ceinture_asteroides.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_ceinture_asteroides);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getJupiter()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tJupiter, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("planetes/jupiter.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_jupiter);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getMercure()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tMercure, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("planetes/mercure.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_mercure);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getUranus()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tUranus, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("planetes/uranus.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_uranus);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getSaturne()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tSaturne, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("planetes/saturne.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_saturn);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getVenus()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tVenus, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("planetes/venus.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_venus);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getTerre()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tTerre, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("planetes/terre.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_terre);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getMars()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tMars, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("planetes/mars.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_mars);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getNeptune()){
					Builder builder = new AlertDialog.Builder(this.context2);
					builder.setItems(tNeptune, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("planetes/neptune.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_neptune);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getObjNeptune()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tTransNeptu, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("planetes/ceinture_kuiper.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("planetes/Objets_epars.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("planetes/Objets_detaches.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_ceinture_kuiper);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}
				else if(item.getPoint() == Global.getGroupeA0()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA0, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/erablemegundo.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/chicoducanada.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA1()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA1, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/melezedujapon.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/holodisquediscolore.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/sequoia.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA2()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA2, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/coteneastor.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA3()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA3, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/cedre.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/erabletrident.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/erablechampetre.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("plantes/erable.html");
								startActivity(intent);
							}else if(which == 4){
								Global.setNomFichier("plantes/erabledepensylvanie.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA4()){//A reverifier pinpanicio
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA4, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/epiceadebosnie.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/pinpanicio.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/pindecorse.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("plantes/erablepeau.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA5()){//a verifier hymalaya
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA5, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/cedredehimalaya.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/caryacordee.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/plataneorient.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA6()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA6, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/genevriercommun.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA7()){//pinweymouth
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA7, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/sapinalgerie.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/pinweymouth.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/viornevelue.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA8()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA8, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/cornouillerflorifere.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/rosierchataigne.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/peuplier.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA9()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA9, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/pterocarier.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA10()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA10, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/mahoniabeal.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/amelandecanada.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/noisetierturquie.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("plantes/noisetiercoudier.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA11()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA11, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/forsythiablanc.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/alangiumplatane.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/escalonierouge.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA12()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA12, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/chevrefeuille.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/noisetiertortueux.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/juliana.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("plantes/coretejapon.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA13()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA13, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/erablemontpellier.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/cadeoxycedre.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/sakhalines.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("plantes/magnolia.html");
								startActivity(intent);
							}else if(which == 4){
								Global.setNomFichier("plantes/magnoliasoulange.html");
								startActivity(intent);
							}else if(which == 5){
								Global.setNomFichier("plantes/viomeburkwood.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA14()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA14, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/fragonpiquoti.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/petithoux.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/petitlangue.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("plantes/ardoremouchoirs.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA15()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA15, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/skimmia.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/miscarthus.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/cypreslawson.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("plantes/tulipiervirginie.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA16()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA16, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/kolwitzia.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/arbresoie.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/yucca.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("plantes/poncinus.html");
								startActivity(intent);
							}else if(which == 4){
								Global.setNomFichier("plantes/lilasblanc.html");
								startActivity(intent);
							}else if(which == 5){
								Global.setNomFichier("plantes/abelia.html");
								startActivity(intent);
							}else if(which == 6){
								Global.setNomFichier("plantes/indigotier.html");
								startActivity(intent);
							}else if(which == 7){
								Global.setNomFichier("plantes/forsythia.html");
								startActivity(intent);
							}else if(which == 8){
								Global.setNomFichier("plantes/yeuse.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA17()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA17, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/cypreslawson.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/cypresgeant.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/bananierindiens.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("plantes/ornechampetre.html");
								startActivity(intent);
							}else if(which == 4){
								Global.setNomFichier("plantes/groseillermaqueraux.html");
								startActivity(intent);
							}else if(which == 5){
								Global.setNomFichier("plantes/chalefombelle.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA18()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA18, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/noisetierpourpre.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/chataignier.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/groseillerdore.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("plantes/alisiertorminal.html");
								startActivity(intent);
							}else if(which == 4){
								Global.setNomFichier("plantes/epine-du-christ.html");
								startActivity(intent);
							}else if(which == 5){
								Global.setNomFichier("plantes/fusaineurope.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA19()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA19, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/houxbleu.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/viorne.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/seringat.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("plantes/osmanthe.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA20()){//osmara
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA20, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/erableveloute.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/seringatlewis.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/weigelia.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("plantes/cornouillermale.html");
								startActivity(intent);
							}else if(which == 4){
								Global.setNomFichier("plantes/osmaraburkwoodii.html");
								startActivity(intent);
							}else if(which == 5){
								Global.setNomFichier("plantes/magnoliafleurs.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA21()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA21, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/troenecalifornie.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/troenechine.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/peuplieritalie.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA22()){//marronier japon
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA22, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/aulnecorde.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("plantes/marronierjapon.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plantes/marronierfleurs.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA23()){//valider
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA23, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("plantes/charme.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}

			}
			return true;
		}

	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if(Global.getSonActive())
		{
			mSoundManager= new SoundManager(this,5);
			mSoundNotif = mSoundManager.add(this, R.raw.notif);
			mSoundPlanete = mSoundManager.add(this, R.raw.planetenotif);
		}

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
		ArrayItemizedOverlay itemizedOverlay3 = new ArrayItemizedOverlay(location);
		ArrayItemizedOverlay itemizedOverlay2 = new MyItemizedOverlay(ItemizedOverlay.boundCenter(markerPlante), this);

		// create a GeoPoint with the latitude and longitude coordinates
		GeoPoint myPos = new GeoPoint(0,0);
		//test = new GeoPoint(45.1938761,5.7682984);



		// create an OverlayItem with title and description
		//item3 = new OverlayItem(test, "Test", "Localisation de l'arboretum.");
		item3 = new OverlayItem(myPos, "Moi", "Ma position.");
		item3.setMarker(ItemizedOverlay.boundCenter(location));

		// add the OverlayItem to the ArrayItemizedOverlay
		itemizedOverlay3.addItem(item3);
		//je me centre sur moi
		mapView.setCenter(item3.getPoint());
		//puis je zoom *2
		mapView.zoom((byte) 6, 6);


		// create an OverlayItem with title and description
		item = new OverlayItem(Global.getSoleil(), "Soleil", "Localisation du soleil");
		//item3 = new OverlayItem(test, "Test", "Localisation de l'arboretum.");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		// add the OverlayItem to the ArrayItemizedOverlay
		itemizedOverlay.addItem(item);
		//itemizedOverlay.addItem(item3);


		//Ajout des planetes
		item = new OverlayItem(Global.getCeinture(), "Ceinture d'asteroides", "la ceinture d'asteroides");
		itemizedOverlay.addItem(item);


		item = new OverlayItem(Global.getJupiter(), "Jupiter", "Localisation de Jupiter");
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getSaturne(), "Saturne", "Localisation de Saturne");
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getUranus(), "Uranus", "Localisation d'Uranus");
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getMercure(), "Mercure", "Localisation de Mercure");
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getTerre(), "Terre", "Localisation de la Terre");
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getVenus(), "Venus", "Localisation de Venus");
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getMars(), "Mars", "Localisation de Mars");
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getNeptune(), "Neptune", "Localisation de Neptune");
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getObjNeptune(), "Objet de Neptunes", "Localisation des Objets de Neptune");
		itemizedOverlay.addItem(item);

		//Ajout des arbres 
		//A0 : Chicot du Canada / Erable mégundo
		item2 = new OverlayItem(Global.getGroupeA0(), "Premier groupe de plante", "Localisation du premier groupe de plantes");
		item2.setMarker(ItemizedOverlay.boundCenter(ItemizedOverlay.boundCenter(markerPlante)));
		itemizedOverlay2.addItem(item2);
		//A1 : Mélèze du Japon / Holodisque Discolore / Sequoia toujours vert, bois rouge
		item2 = new OverlayItem(Global.getGroupeA1(), "Deuxieme groupe de plante", "Localisation du deuxieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A2 : Cotonéastor à feuilles bullées
		item2 = new OverlayItem(Global.getGroupeA2(), "Troisieme groupe de plante", "Localisation du troisieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A3 : Cèdre du Liban / Erable trident / Erable champêtre / Erable / Erable de Pensylvanie
		item2 = new OverlayItem(Global.getGroupeA3(), "Quatrieme groupe de plante", "Localisation du quatrieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A4 : Epicea de Bosnie / Pin panicio / Pin de Corse / Erable à peau de serpent 
		item2 = new OverlayItem(Global.getGroupeA4(), "Cinquieme groupe de plante", "Localisation du cinquieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A5 Cèdre de l'Himalaya, Déodar / Carya cordée / Hêtre, Fau, Fayard, Platane d'orient
		item2 = new OverlayItem(Global.getGroupeA5(), "Sixieme groupe de plante", "Localisation du sixieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A6 Genévrier commun
		item2 = new OverlayItem(Global.getGroupeA6(), "Septieme groupe de plante", "Localisation du septieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A7 Sapin d'Algérie / Pin weymouth / Viorne velue
		item2 = new OverlayItem(Global.getGroupeA7(), "Huitieme groupe de plante", "Localisation du huitieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A8 Cornouiller florifère / Rosier chataîgne / Peuplier
		item2 = new OverlayItem(Global.getGroupeA8(), "Neuvieme groupe de plante", "Localisation du neuvieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A9 Ptérocarier
		item2 = new OverlayItem(Global.getGroupeA9(), "Dixieme groupe de plante", "Localisation du dixieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A10 Mahonia de Beal / Amélande du Canada / Noisetier de Turquie / Noisetier coudier
		item2 = new OverlayItem(Global.getGroupeA10(), "Onzieme groupe de plante", "Localisation du onzieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A11 Forsythia blanc / Alangium à feuilles de Platane / Escalonie rouge
		item2 = new OverlayItem(Global.getGroupeA11(), "Douzieme groupe de plante", "Localisation du douzieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A12 Chèvrefeuille des tatars / Noisetier tortueux / Epine-vignette de Juliana / Corête du Japon
		item2 = new OverlayItem(Global.getGroupeA12(), "Treizieme groupe de plante", "Localisation du treizieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A13 Erable de montpellier / Cade Oxycèdre / Saule des îles Sakhalines / Magnolia à fleur de lis 
		//Magnolia de soulange / Viome de Burkwood
		item2 = new OverlayItem(Global.getGroupeA13(), "Quatorzieme groupe de plante", "Localisation du quatorzieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A14 Fragon Piquoti / Petit houx / Petit houx à langues / Ardore aux mouchoirs
		item2 = new OverlayItem(Global.getGroupeA14(), "Quinzieme groupe de plante", "Localisation du quinzieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A15 Skimmia du Japon / Miscarthus / Cyprès de lawson / Tulipier de Virginie
		item2 = new OverlayItem(Global.getGroupeA15(), "Seizieme groupe de plante", "Localisation du seizieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A16 Kolwitzia / Arbre de soie / Yucca / Poncinus / Lilas blanc / Abelia / Indigotier / Forsythia / Chêne vert, Yeuse
		item2 = new OverlayItem(Global.getGroupeA16(), "Dix-septieme groupe de plante", "Localisation du dix-septieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A17 Cyprès de lawson / Cyprès géant / Bananier des indiens / Orne champêtre / Groseiller à maqueraux / Chalef en ombelle
		item2 = new OverlayItem(Global.getGroupeA17(), "Dix-huitieme groupe de plante", "Localisation du dix-huitieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A18 Noisetier pourpre / Châtaignier / Groseiller doré / Alisier torminal / Epine-du-christ / Fusain d'Europe
		item2 = new OverlayItem(Global.getGroupeA18(), "Dix-neuvieme groupe de plante", "Localisation du dix-neuvieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A19 Houx bleu / Viorne à feuilles ridées / Seringat / Osmanthe à feuilles de houx
		item2 = new OverlayItem(Global.getGroupeA19(), "Vingtieme groupe de plante", "Localisation du vingtieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A20 Erable velouté / Seringat de lewis / Weigelia / Cornouiller mâle / Osmara burkwoodii / Burk & Skie / Magnolia à grandes fleurs
		item2 = new OverlayItem(Global.getGroupeA20(), "Vingt et unieme groupe de plante", "Localisation du vingt et unieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A21 Véglier du Japon / Troëne de Californie / Troëne de Chine / Peuplier d'Italie
		item2 = new OverlayItem(Global.getGroupeA21(), "Vingt deuxieme groupe de plante", "Localisation du vingt deuxieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A22 Aulore cordé / Marronier du Japon / Marronier à petites fleurs / non inconnue à corriger / Dardari Simon-Louis 'Jules d'Anière'
		item2 = new OverlayItem(Global.getGroupeA22(), "Vingt troisieme groupe de plante", "Localisation du vingt troisieme groupe de plantes");
		itemizedOverlay2.addItem(item2);

		//A23 Cyprès toujours vert / Charme 
		item2 = new OverlayItem(Global.getGroupeA23(), "Vingt quatrieme groupe de plante", "Localisation du vingt quatrieme groupe de plantes");
		itemizedOverlay2.addItem(item2);


		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 0, this);
		sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

		if (sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
			//success! there's a magnetometer
		}else{
			Toast.makeText(this,"Problème accelerometer", Toast.LENGTH_LONG).show();
		}

		// add the ArrayItemizedOverlay to the MapView
		mapView.getOverlays().add(itemizedOverlay);
		mapView.getOverlays().add(itemizedOverlay2);
		mapView.getOverlays().add(itemizedOverlay3);


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


	public boolean estDansZone(GeoPoint ptsInt, GeoPoint pos){

		// +- 0.00015 zone de 1.5 metres, je verifie donc si notre position se situe dans une zone de 1.5 metres autour de nous.
		if(pos.getLatitude() >= (ptsInt.getLatitude() - 0.00015) && pos.getLatitude() <= (ptsInt.getLatitude() + 0.00015) 
				&& pos.getLongitude() >= (ptsInt.getLongitude() - 0.00015) && pos.getLongitude() <= (ptsInt.getLongitude() + 0.00015) ){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public void onLocationChanged(Location arg0) {
		GeoPoint my_pos=new GeoPoint(arg0.getLatitude(),arg0.getLongitude());
		item3.setPoint(my_pos);

		//pour raffraichir en touchant l'écran
		//mapView.refreshDrawableState();

		//pour recentrer à chaque changement de position
		mapView.setCenter(my_pos);

		if(Global.getSonActive())
		{
			if(sSoleil && estDansZone(Global.getSoleil(), my_pos)){
				mSoundManager.play(mSoundPlanete);
				sSoleil = false;
			}
			if(sCeinture && estDansZone(Global.getCeinture(), my_pos)){
				mSoundManager.play(mSoundPlanete);
				sCeinture = false;
			}
			if(sMercure && estDansZone(Global.getMercure(), my_pos)){
				mSoundManager.play(mSoundPlanete);
				sMercure = false;
			}
			if(sSaturne && estDansZone(Global.getSaturne(), my_pos)){
				mSoundManager.play(mSoundPlanete);
				sSaturne = false;
			}
			if(sJupiter && estDansZone(Global.getJupiter(), my_pos)){
				mSoundManager.play(mSoundPlanete);
				sJupiter = false;
			}
			if(sTerre && estDansZone(Global.getTerre(), my_pos)){
				mSoundManager.play(mSoundPlanete);
				sTerre = false;
			}
			if(sUranus && estDansZone(Global.getUranus(), my_pos)){
				mSoundManager.play(mSoundPlanete);
				sUranus = false;
			}
			if(sNeptune && estDansZone(Global.getNeptune(), my_pos)){
				mSoundManager.play(mSoundPlanete);
				sNeptune = false;
			}
			if(sVenus && estDansZone(Global.getVenus(), my_pos)){
				mSoundManager.play(mSoundPlanete);
				sVenus = false;
			}
			if(sObjNeptune && estDansZone(Global.getObjNeptune(), my_pos)){
				mSoundManager.play(mSoundPlanete);
				sObjNeptune = false;
			}
			if(sMars && estDansZone(Global.getMars(), my_pos)){
				mSoundManager.play(mSoundPlanete);
				sMars = false;
			}
			if(sGroupeA0 && estDansZone(Global.getGroupeA0(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA0 = false;
			}
			if(sGroupeA1 && estDansZone(Global.getGroupeA1(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA1 = false;
			}
			if(sGroupeA2 && estDansZone(Global.getGroupeA2(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA2 = false;
			}
			if(sGroupeA3 && estDansZone(Global.getGroupeA3(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA3 = false;
			}
			if(sGroupeA4 && estDansZone(Global.getGroupeA4(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA4 = false;
			}
			if(sGroupeA5 && estDansZone(Global.getGroupeA5(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA5 = false;
			}
			if(sGroupeA6 && estDansZone(Global.getGroupeA6(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA6 = false;
			}
			if(sGroupeA7 && estDansZone(Global.getGroupeA7(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA7 = false;
			}
			if(sGroupeA8 && estDansZone(Global.getGroupeA8(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA8 = false;
			}
			if(sGroupeA9 && estDansZone(Global.getGroupeA9(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA9 = false;
			}
			if(sGroupeA10 && estDansZone(Global.getGroupeA10(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA10 = false;
			}
			if(sGroupeA11 && estDansZone(Global.getGroupeA11(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA11 = false;
			}
			if(sGroupeA12 && estDansZone(Global.getGroupeA12(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA12 = false;
			}
			if(sGroupeA13 && estDansZone(Global.getGroupeA13(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA13 = false;
			}
			if(sGroupeA14 && estDansZone(Global.getGroupeA14(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA14 = false;
			}
			if(sGroupeA15 && estDansZone(Global.getGroupeA15(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA15 = false;
			}
			if(sGroupeA16 && estDansZone(Global.getGroupeA16(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA16 = false;
			}
			if(sGroupeA17 && estDansZone(Global.getGroupeA17(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA17 = false;
			}
			if(sGroupeA18 && estDansZone(Global.getGroupeA18(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA18 = false;
			}
			if(sGroupeA19 && estDansZone(Global.getGroupeA19(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA19 = false;
			}
			if(sGroupeA20 && estDansZone(Global.getGroupeA20(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA20 = false;
			}
			if(sGroupeA21 && estDansZone(Global.getGroupeA21(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA21 = false;
			}
			if(sGroupeA22 && estDansZone(Global.getGroupeA22(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA22 = false;
			}
			if(sGroupeA23 && estDansZone(Global.getGroupeA23(), my_pos)){
				mSoundManager.play(mSoundNotif);
				sGroupeA23 = false;
			}
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
