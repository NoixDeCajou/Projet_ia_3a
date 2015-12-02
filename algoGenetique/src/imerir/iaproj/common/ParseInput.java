package imerir.iaproj.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.lang.NumberFormatException;
import java.net.MalformedURLException;
import java.net.URL;

public class ParseInput {

	public static void main(String[] args) {


		ArrayList<Trajet> trajets;

		try {

			trajets = ParseInput.parseFile( new File("C:\\Users\\imerir\\Documents\\Projet_IA3A\\trunk\\algoGenetique\\horaires.csv").toURI().toURL() );

			for(Trajet v : trajets){

				System.out.println(v);

			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public ParseInput() {
		// TODO Auto-generated constructor stub
	}

	public static ArrayList <Trajet> parseFile (URL ressource) {

		ArrayList <Trajet> trajets = new ArrayList <Trajet>();

		BufferedReader br = null;
		try {

			br = new BufferedReader( new InputStreamReader( ressource.openStream() ) );

		    String lineString = null;

		    String ligne = "";
		    char sens = 'r';
		    String t = "";


		    ArrayList <Trajet> trajetsLigne = new ArrayList <Trajet>();

		    while ((lineString = br.readLine()) != null) {

		       // System.out.println(lineString);

		       if(lineString.startsWith("ligne")){

		    	   ligne = lineString;

		    	   if(sens == 'a'){
		    		   sens = 'r';
		    	   }
		    	   else if(sens == 'r'){
		    		   sens = 'a';
		    	   }


					trajets.addAll(trajetsLigne);

		    	   trajetsLigne = new ArrayList<Trajet>();
		       }
		       else if( lineString.startsWith("T") ){


		    	   String[] strs = lineString.split(",");
		    	   int i = 0;

		    	   for(String str : strs){

		    		   if(str.startsWith("T") == false){


		    			   //System.out.println("str: " + str);

		    			   if( str.equals("") == false ) {


			    			   // System.out.println(ligne + " "  + t + ", "+ i + ": " + str);

			    			   // System.out.println( "length: " + trajetsLigne.size() );

			    			   if( i == trajetsLigne.size() ){
			    				   //System.out.println("in the if if, str : " + str);

			    				   trajetsLigne.add(new Trajet( t , t , getMinute(str), getMinute(str), getLigne(ligne), sens, 0, i+1));

			    			   }
			    			   else if( i < trajetsLigne.size() ) {

			    				   //System.out.println("in the if else, str: " + str);


			    				   if(trajetsLigne.get(i).getFirstSet() == false){

			    					   trajetsLigne.get(i).setDepart( t );
				    				   trajetsLigne.get(i).sethDepart( getMinute(str) );

				    				   trajetsLigne.get(i).setFirstSet( true );

			    				   }

			    				   trajetsLigne.get(i).setArrive( t );
			    				   trajetsLigne.get(i).sethArrive( getMinute(str) );
			    			   }

		    			   }
		    			   else {
		    				   //System.out.println("in the else, str: " + str);
		    				   //System.out.println("in the else, bool: " + ( i < trajetsLigne.size() ));


		    				   if ( i >= trajetsLigne.size() ){

		    					   trajetsLigne.add(new Trajet( t , t , 0, 0, getLigne(ligne), sens, false, 0, i+1));
		    				   }

		    			   }

		    			   i++;
		    		   }
		    		   else {

		    			  t = str;
		    		   }

		    	   }


		       }
		       else if( lineString.startsWith("Dist") ){

		    	   String[] strs = lineString.split(",");
		    	   int i = 0;

		    	   for(String str : strs){

		    		   if(str.startsWith("Dist") == false){


		    			   trajetsLigne.get(i).setDistance( Integer.parseInt(str) );


		    			   i++;

		    		   }

		    	   }

		       }


		    }




		    trajets.addAll(trajetsLigne);



		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{

			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return trajets;

	}

	static int getMinute(String s) throws NumberFormatException{


		String[] numbers = s.split(":");

		int minutes = Integer.parseInt(numbers[0]) * 60 + Integer.parseInt(numbers[1]);

		return minutes;

	}

	static int getLigne(String s) throws NumberFormatException{

		String ligne = "ligne ";

		s = s.replaceAll(ligne, "");

		int i = Integer.parseInt(s);

		return i;

	}

}
