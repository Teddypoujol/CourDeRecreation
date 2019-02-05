package Systeme;

import java.util.ArrayList;
import java.util.Arrays;

import Interface.Tileset;
/**
 * Classe contenant toute les constantes importantes du projet, les chemins 
 * vers les ressources et la taille de la map
 * 
 * @author Poujol Teddy
 * @author Bellin Clara
 * @see Tileset
 * @version 2.0
 */
public class Constant 
{
	private static int mapWidth = 15;
	private static int mapHeight = 10;
	
	
	public static int getMapWidth() 
	{
		return mapWidth;
	}

	public static int getMapHeight() 
	{
		return mapHeight;
	}

	
	
	private static String pathEnfants = "/ressources/enfants.png";
	private static String pathCour= "/ressources/cour.png";	
	private static String pathProf= "/ressources/prof.png";	
	private static String pathCoeur= "/ressources/coeur2.png";	
	
	private static String pathProf2= "/ressources/college-professor.jpg";
	private static String pathEnfantParam = "/ressources/fille.png";
	private static String pathEnfantParam2 = "/ressources/garcon.png";
	
	public static String getPathCoeur() {
		return pathCoeur;
	}
	
	public static String getPathEnfantParam() {
		return pathEnfantParam;
	}
	
	public static String getPathEnfantParam2() {
		return pathEnfantParam2;
	}
	
	public static String getPathEnfants() {
		return pathEnfants;
	}
	

	
	public static String getPathCour() {
		return pathCour;
	}
	
	public static String getPathProf() {
		return pathProf;
	}

	public static String getPathProf2() {
		return pathProf2;
	}
	
	private Constant() 
	{
	}
}
