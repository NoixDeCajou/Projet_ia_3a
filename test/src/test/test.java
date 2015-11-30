package test;




public class test {
	
	 static trajet l1_1;
	
	 static void initialisation()
	{
		
		l1_1 = new trajet("T1","T2",371,408,-1,1);
	}
	
	public static void main(String[] args) {
		
		initialisation();
		System.out.println(l1_1.toString());
		
	}

}
