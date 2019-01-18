package Systeme;

import java.util.ArrayList;
import java.util.Arrays;

public class Constant 
{
	private static int mapWidth = 20;
	private static int mapHeight = 10;
	
	
	public static int getMapWidth() 
	{
		return mapWidth;
	}

	public static int getMapHeight() 
	{
		return mapHeight;
	}
	


	
	private static String pathEnfant = "/ressources/enfant.jpg";
	private static String pathEnfant2 = "/ressources/enfant.jpg";
	

	public static String getPathEnfant() {
		return pathEnfant;
	}

	public static String getPathEnfant2() {
		return pathEnfant2;
	}
	
	private static String pathErrorGif = "/ressources/fille1.png";
	
	public static String getPathErrorGif() {
		return pathErrorGif;
	}
	
	
	private static String pathFille1 = "/ressources/fille1.png";
	private static String pathFille2 = "/ressources/fille2.png";
	private static String pathFille3 = "/ressources/fille3.png";
	private static String pathGarcon = "/ressources/garcon.png";
	private static String pathCour= "/ressources/cour.png";	
	private static String pathProf= "/ressources/prof.png";	
	
	public static String getPathFille1() {
		return pathFille1;
	}
	
	public static String getPathFille2() {
		return pathFille2;
	}
	
	public static String getPathFille3() {
		return pathFille3;
	}
	
	public static String getPathGarcon() {
		return pathGarcon;
	}
	
	public static String getPathCour() {
		return pathCour;
	}
	
	public static String getPathProf() {
		return pathProf;
	}

	
	private Constant() 
	{
	}
}
