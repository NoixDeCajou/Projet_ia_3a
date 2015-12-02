package imerir.iaproj.common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Fichier {
	
	// Ma liste de trajet
	private String eleve1 = "Anthony Martin";
	private String eleve2 = "Mickael Campoy";
	private String eleve3 = "Nathan Dubot";
	private String eleve4 = "Gaellic Rannou";
	private String eleve5 = "Remi Lavielle";
	
	//Constructeur
	


public void CreationFichier(ArrayList<Bus> lesBus, ArrayList<Trajet>trajets)
{
	// Ouverture du fichier 
	
	File solution = new File("Solution.txt");
	String chaine="";
	int TotalKM =0;
	
	
	
	try{
		FileWriter fw = new FileWriter(solution);
		
		//Nombre de kilomètre total des bus
		for (Bus B: lesBus)
		{
			TotalKM=TotalKM+B.getKilometrageTotal();
		}
		
		//Affichage des noms du groupe
		String nom = "# "+getEleve1()+", "+getEleve2()+", "+getEleve3()+", "+getEleve4()+", "+getEleve5()+System.getProperty("line.separator");
		fw.write(nom);
		fw.write(lesBus.size()+", distance"+", "+TotalKM+System.getProperty("line.separator"));
		
		int i =1;
		
		// Pour chaque bus affecter 
		for (Bus B: lesBus)
		{
			
			for (Trajet T: B.getTrajetParcouru())
			{
				chaine =(chaine+T.ligne+":"+T.sens+":"+", ");
			}
			
			fw.write("bus"+i+", "+chaine+System.getProperty("line.separator"));
			i++;
			chaine="";
		}
		
		//On force l'ecriture
		fw.flush();
		//Fermeture du flux
		fw.close();
	}
	
	catch(IOException e)
	{
		System.out.println("Erreur dans l'ecriture du fichier");
		e.printStackTrace();
	}
	
}


public String getEleve1() {
	return eleve1;
}

public String getEleve2() {
	return eleve2;
}

public String getEleve3() {
	return eleve3;
}

public String getEleve4() {
	return eleve4;
}

public String getEleve5() {
	return eleve5;
}



}
