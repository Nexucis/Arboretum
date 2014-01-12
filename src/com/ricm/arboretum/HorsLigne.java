package com.ricm.arboretum;

import java.io.File;

import org.mapsforge.android.maps.MapView;
import org.mapsforge.android.maps.overlay.ArrayItemizedOverlay;
import org.mapsforge.android.maps.overlay.ItemizedOverlay;
import org.mapsforge.android.maps.overlay.OverlayItem;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;

public class HorsLigne extends BaseMapActivity{

	private MapView mapView;
	private OverlayItem item;
	private OverlayItem item2;
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
		CharSequence tA14[] = {"Frangon piquoti", "Petit houx", "Petit houx à langues", "Arbre aux mouchoirs"};
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
		Drawable markerPlante = getResources().getDrawable(R.drawable.plante); 

		ArrayItemizedOverlay itemizedOverlay = new MyItemizedOverlay(defaultMarker, this);
		ArrayItemizedOverlay itemizedOverlay2 = new MyItemizedOverlay(ItemizedOverlay.boundCenter(markerPlante), this);

		my_item = new OverlayItem(Global.getArbo(), "Arboretum", "Localisation de l'arboretum.");
		//je me centre sur moi
		mapView.setCenter(my_item.getPoint());
		//puis je zoom *2
		mapView.zoom((byte) 6, 6);


		// create an OverlayItem with title and description
		item = new OverlayItem(Global.getSoleil(), "Soleil", "Localisation du soleil");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		// add the OverlayItem to the ArrayItemizedOverlay
		itemizedOverlay.addItem(item);
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

		// add the ArrayItemizedOverlay to the MapView
		mapView.getOverlays().add(itemizedOverlay);
		mapView.getOverlays().add(itemizedOverlay2);

	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}





}
