package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.NumberFormatException;

public class ParseInput {

	public static void main(String[] args) {

		ParseInput pi = new ParseInput();

		ArrayList <Trajet> Trajets = pi.parseFile("C:\\Users\\imerir\\Documents\\Projet_ia_3a\\trunk\\data\\horaires.csv");

		for(Trajet v : Trajets){

			System.out.println(v);


		}
	}

	public ParseInput() {
		// TODO Auto-generated constructor stub
	}

	ArrayList <Trajet> parseFile (String filename) {

		ArrayList <Trajet> Trajets = new ArrayList <Trajet>();

		BufferedReader br = null;
		try {

			br = new BufferedReader(new FileReader(filename ) );


		    String lineString = null;

		    String ligne = "";
		    char sens = 'r';
		    String t = "";


		    ArrayList <Trajet> TrajetsLigne = new ArrayList <Trajet>();

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

					//if(TrajetsLigne.size() > 0){
					//	System.out.println("before add all, size = " + TrajetsLigne.size() + " and ligne = " + TrajetsLigne.get(0).getLigne() );
					//}
					Trajets.addAll(TrajetsLigne);

		    	   TrajetsLigne = new ArrayList<Trajet>();
		       }
		       else if( lineString.startsWith("T") ){


		    	   String[] strs = lineString.split(",");
		    	   int i = 0;

		    	   for(String str : strs){

		    		   if(str.startsWith("T") == false){


		    			   //System.out.println("str: " + str);

		    			   if( str.equals("") == false ) {


			    			   // System.out.println(ligne + " "  + t + ", "+ i + ": " + str);

			    			   // System.out.println( "length: " + TrajetsLigne.size() );

			    			   if( i == TrajetsLigne.size() ){
			    				   //System.out.println("in the if if, str : " + str);

			    				   TrajetsLigne.add(new Trajet( t , t , getMinute(str), getMinute(str), getLigne(ligne), sens, 0));

			    			   }
			    			   else if( i < TrajetsLigne.size() ) {

			    				   //System.out.println("in the if else, str: " + str);


			    				   if(TrajetsLigne.get(i).getFirstSet() == false){

			    					   TrajetsLigne.get(i).setDepart( t );
				    				   TrajetsLigne.get(i).sethDepart( getMinute(str) );

				    				   TrajetsLigne.get(i).setFirstSet( true );

			    				   }

			    				   TrajetsLigne.get(i).setArrive( t );
			    				   TrajetsLigne.get(i).sethArrive( getMinute(str) );
			    			   }

		    			   }
		    			   else {
		    				   //System.out.println("in the else, str: " + str);
		    				   //System.out.println("in the else, bool: " + ( i < TrajetsLigne.size() ));


		    				   if ( i >= TrajetsLigne.size() ){

		    					   TrajetsLigne.add(new Trajet( t , t , 0, 0, getLigne(ligne), sens, false, 0));
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



		       }


		    }

		    //if(TrajetsLigne.size() > 0){
			//	System.out.println("before add all, size = " + TrajetsLigne.size() + " and ligne = " + TrajetsLigne.get(0).getLigne() );
			//}
		    Trajets.addAll(TrajetsLigne);

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


		System.out.println( "Trajets size: " + Trajets.size() );

		return Trajets;

	}

	int getMinute(String s) throws NumberFormatException{


		String[] numbers = s.split(":");

		int minutes = Integer.parseInt(numbers[0]) * 60 + Integer.parseInt(numbers[1]);

		return minutes;

	}

	int getLigne(String s) throws NumberFormatException{

		String ligne = "ligne ";

		s = s.replaceAll(ligne, "");

		int i = Integer.parseInt(s);

		return i;

	}

}
