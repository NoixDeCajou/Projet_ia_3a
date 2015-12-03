

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
	
public void CreationFichier(ArrayList<Bus> lesBus, ArrayList<Trajet>trajets,int tempTotal,int kmTotal)
{
	// Ouverture du fichier 
	
	File solution = new File("LesGuignolsDelIA_TeamRannou_V2.txt");
	String chaine="";
	int saut = 0;
	

	
	try{
		FileWriter fw = new FileWriter(solution);
		
		//Nombre de kilomètre total des bus
		/*for (Bus B: lesBus)
		{
			TotalKM=TotalKM+B.getKilometrageTotal();
			//distance
		}*/
		
		//Affichage des noms du groupe
		String nom = "# "+getEleve1()+", "+getEleve2()+", "+getEleve3()+", "+getEleve4()+", "+getEleve5()+System.getProperty("line.separator");
		fw.write(nom);
		fw.write(lesBus.size()+","+tempTotal+","+kmTotal+System.getProperty("line.separator"));
		
		int i =1;
		
		// Pour chaque bus affecter 
		for (Bus B: lesBus)
		{
			// Boucle pour chaque trajet parcourut
			for (Trajet T: B.getTrajetParcouru())
			{
				// Gestion de la virgule de fin
				if (saut==1)
				{
					chaine= chaine+",";
				}
				chaine =(chaine+"l"+T.ligne+":"+T.sens+":"+"v"+T.getNumeroArret());
				saut=1;
			}
			// On ecrit les informations sur le fichier
			fw.write("bus"+i+","+chaine+System.getProperty("line.separator"));
			i++;
			chaine="";
			saut=0;
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
