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

public class HorsLigne extends Nfc_MapActivity{

	private MapView mapView;
	private OverlayItem item;
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
		CharSequence tA14[] = {"Frangon piquoti", "Petit houx", "Petit houx à langues", "Ardore aux mouchoirs"};
		CharSequence tA15[] = {"Skimmia du Japon", "Miscarthus", "Cyprès de lawson", "Tulipier de Virginie"};
		CharSequence tA16[];
		CharSequence tA17[];
		CharSequence tA18[];
		CharSequence tA19[];
		CharSequence tA20[];
		CharSequence tA21[];
		CharSequence tA22[];
		CharSequence tA23[];


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
								Global.setNomFichier("soleil.html");
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
								Global.setNomFichier("ceinture_asteroides.html");
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
								Global.setNomFichier("jupiter.html");
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
								Global.setNomFichier("mercure.html");
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
								Global.setNomFichier("uranus.html");
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
								Global.setNomFichier("saturne.html");
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
								Global.setNomFichier("venus.html");
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
								Global.setNomFichier("terre.html");
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
								Global.setNomFichier("mars.html");
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
								Global.setNomFichier("neptune.html");
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
								Global.setNomFichier("ceinture_kuiper.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("Objets_epars.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("Objets_detaches.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_ceinture_kuiper);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}
				else if(item.getPoint() == Global.getGroupeA0()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA0, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("Erablemegundo.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("Chicoducanada.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA1()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA1, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("Melezedujapon.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("Holodisquediscolore.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("Sequoia.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA2()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA2, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("Coteneastor.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA3()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA3, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("cedre.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("erabletrident.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("erablechampetre.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("erable.html");
								startActivity(intent);
							}else if(which == 4){
								Global.setNomFichier("erabledepensylvanie.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA4()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA4, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("epiceadebosnie.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("pinpanacio.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("pindecorse.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("erablepeau.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA5()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA5, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("cedrehimalaya.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("caryacordee.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("plataneorient.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA6()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA6, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("genevriercommun.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA7()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA7, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("sapinalgerie.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("pinweymouth.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("viornevelue.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA8()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA8, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("cornouillerflorifere.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("rosierchataigne.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("peuplier.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA9()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA9, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("pterocarier.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA10()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA10, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("mahoniabeal.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("amelandecanada.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("noisetierturquie.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("noisetiercoudier.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA11()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA11, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("forsythiablanc.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("alangiumplatane.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("escalonierouge.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA12()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA12, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("chevrefeuille.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("noisetiertortueux.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("juliana.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("coretejapon.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA13()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA13, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("erablemontpellier.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("cadeoxycedre.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("sakhalines.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("magnolia.html");
								startActivity(intent);
							}else if(which == 4){
								Global.setNomFichier("magnoliasoulange.html");
								startActivity(intent);
							}else if(which == 5){
								Global.setNomFichier("viomeburkwood.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA14()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setItems(tA14, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							if(which == 0){
								Global.setNomFichier("fragonpiquoti.html");
								startActivity(intent);
							}else if(which == 1){
								Global.setNomFichier("petithoux.html");
								startActivity(intent);
							}else if(which == 2){
								Global.setNomFichier("petitlangue.html");
								startActivity(intent);
							}else if(which == 3){
								Global.setNomFichier("ardoremouchoirs.html");
								startActivity(intent);
							}
						}
					});
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setPositiveButton("Retour", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA15()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA16()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA17()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA18()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA19()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA20()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA21()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA22()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setIcon(R.drawable.icon_plante2);
					builder.setTitle(item.getTitle());
					builder.setMessage(item.getSnippet());
					builder.setPositiveButton("OK", null);
					builder.show();
				}else if(item.getPoint() == Global.getGroupeA23()){
					Builder builder = new AlertDialog.Builder(this.context2, AlertDialog.THEME_HOLO_DARK);
					builder.setIcon(R.drawable.icon_plante2);
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
		//item3 = new OverlayItem(test, "Test", "Localisation de l'arboretum.");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		// add the OverlayItem to the ArrayItemizedOverlay
		itemizedOverlay.addItem(item);
		item = new OverlayItem(Global.getCeinture(), "Ceinture d'asteroides", "la ceinture d'asteroides");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);


		item = new OverlayItem(Global.getJupiter(), "Jupiter", "Localisation de Jupiter");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getSaturne(), "Saturne", "Localisation de Saturne");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getUranus(), "Uranus", "Localisation d'Uranus");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getMercure(), "Mercure", "Localisation de Mercure");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getTerre(), "Terre", "Localisation de la Terre");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getVenus(), "Venus", "Localisation de Venus");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getMars(), "Mars", "Localisation de Mars");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getNeptune(), "Neptune", "Localisation de Neptune");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		item = new OverlayItem(Global.getObjNeptune(), "Objet de Neptunes", "Localisation des Objets de Neptune");
		item.setMarker(ItemizedOverlay.boundCenter(defaultMarker));
		itemizedOverlay.addItem(item);

		//Ajout des arbres 

		//A0 : Chicot du Canada / Erable mégundo
		item = new OverlayItem(Global.getGroupeA0(), "Premier groupe de plante", "Localisation du premier groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(ItemizedOverlay.boundCenter(markerPlante)));
		itemizedOverlay.addItem(item);

		//A1 : Mélèze du Japon / Holodisque Discolore / Sequoia toujours vert, bois rouge
		item = new OverlayItem(Global.getGroupeA1(), "Deuxieme groupe de plante", "Localisation du deuxieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(ItemizedOverlay.boundCenter(markerPlante)));
		itemizedOverlay.addItem(item);

		//A2 : Cotonéastor à feuilles bullées
		item = new OverlayItem(Global.getGroupeA2(), "Troisieme groupe de plante", "Localisation du troisieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A3 : Cèdre du Liban / Erable trident / Erable champêtre / Erable / Erable de Pensylvanie
		item = new OverlayItem(Global.getGroupeA3(), "Quatrieme groupe de plante", "Localisation du quatrieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A4 : Epicea de Bosnie / Pin panicio / Pin de Corse / Erable à peau de serpent 
		item = new OverlayItem(Global.getGroupeA4(), "Cinquieme groupe de plante", "Localisation du cinquieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A5 Cèdre de l'Himalaya, Déodar / Carya cordée / Hêtre, Fau, Fayard, Platane d'orient
		item = new OverlayItem(Global.getGroupeA5(), "Sixieme groupe de plante", "Localisation du sixieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A6 Genévrier commun
		item = new OverlayItem(Global.getGroupeA6(), "Septieme groupe de plante", "Localisation du septieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A7 Sapin d'Algérie / Pin weymouth / Viorne velue
		item = new OverlayItem(Global.getGroupeA7(), "Huitieme groupe de plante", "Localisation du huitieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A8 Cornouiller florifère / Rosier chataîgne / Peuplier
		item = new OverlayItem(Global.getGroupeA8(), "Neuvieme groupe de plante", "Localisation du neuvieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A9 Ptérocarier
		item = new OverlayItem(Global.getGroupeA9(), "Dixieme groupe de plante", "Localisation du dixieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A10 Mahonia de Beal / Amélande du Canada / Noisetier de Turquie / Noisetier coudier
		item = new OverlayItem(Global.getGroupeA10(), "Onzieme groupe de plante", "Localisation du onzieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A11 Forsythia blanc / Alangium à feuilles de Platane / Escalonie rouge
		item = new OverlayItem(Global.getGroupeA11(), "Douzieme groupe de plante", "Localisation du douzieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A12 Chèvrefeuille des tatars / Noisetier tortueux / Epine-vignette de Juliana / Corête du Japon
		item = new OverlayItem(Global.getGroupeA12(), "Treizieme groupe de plante", "Localisation du treizieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A13 Erable de montpellier / Cade Oxycèdre / Saule des îles Sakhalines / Magnolia à fleur de lis 
		//Magnolia de soulange / Viome de Burkwood
		item = new OverlayItem(Global.getGroupeA13(), "Quatorzieme groupe de plante", "Localisation du quatorzieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A14 Fragon Piquoti / Petit houx / Petit houx à langues / Ardore aux mouchoirs
		item = new OverlayItem(Global.getGroupeA14(), "Quinzieme groupe de plante", "Localisation du quinzieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A15 Skimmia du Japon / Miscarthus / Cyprès de lawson / Tulipier de Virginie
		item = new OverlayItem(Global.getGroupeA15(), "Seizieme groupe de plante", "Localisation du seizieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A16 Kolwitzia / Arbre de soie / Yucca / Poncinus / Lilas blanc / Abelia / Indigotier / Forsythia / Chêne vert, Yeuse
		item = new OverlayItem(Global.getGroupeA16(), "Dix-septieme groupe de plante", "Localisation du dix-septieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A17 Cyprès de lawson / Cyprès géant / Bananier des indiens / Orne champêtre / Groseiller à maqueraux / Chalef en ombelle
		item = new OverlayItem(Global.getGroupeA17(), "Dix-huitieme groupe de plante", "Localisation du dix-huitieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A18 Noisetier pourpre / Châtaignier / Groseiller doré / Alisier torminal / Epine-du-christ / Fusain d'Europe
		item = new OverlayItem(Global.getGroupeA18(), "Dix-neuvieme groupe de plante", "Localisation du dix-neuvieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A19 Houx bleu / Viorne à feuilles ridées / Seringat / Osmanthe à feuilles de houx
		item = new OverlayItem(Global.getGroupeA19(), "Vingtieme groupe de plante", "Localisation du vingtieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A20 Erable velouté / Seringat de lewis / Weigelia / Cornouiller mâle / Osmara burkwoodii / Burk & Skie / Magnolia à grandes fleurs
		item = new OverlayItem(Global.getGroupeA20(), "Vingt et unieme groupe de plante", "Localisation du vingt et unieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A21 Véglier du Japon / Troëne de Californie / Troëne de Chine / Peuplier d'Italie
		item = new OverlayItem(Global.getGroupeA21(), "Vingt deuxieme groupe de plante", "Localisation du vingt deuxieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A22 Aulore cordé / Marronier du Japon / Marronier à petites fleurs / non inconnue à corriger / Dardari Simon-Louis 'Jules d'Anière'
		item = new OverlayItem(Global.getGroupeA22(), "Vingt troisieme groupe de plante", "Localisation du vingt troisieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

		//A23 Cyprès toujours vert / Charme 
		item = new OverlayItem(Global.getGroupeA23(), "Vingt quatrieme groupe de plante", "Localisation du vingt quatrieme groupe de plantes");
		item.setMarker(ItemizedOverlay.boundCenter(markerPlante));
		itemizedOverlay.addItem(item);

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
