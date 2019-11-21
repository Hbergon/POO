package Main;
import Troupes.*;

import java.util.ArrayList;

import Struct.*;

public class Main {

	public static void main(String[] args) {
		Piquier test = new Piquier();
		System.out.println(test.getPdv());
		
		Chevalier test2 = new Chevalier();
		System.out.println(test2.getPdv());
		
		Onagre test3 = new Onagre();
		System.out.println(test3.getPdv());
		
		Chateau testC = new Chateau();
		System.out.println(testC.getProd());
		
		
		testC.addToTroupe(test);
		testC.addToTroupe(test2);
		System.out.println(testC.getTroupe());
		
		testC.addToFile(test3);
		System.out.println(testC.getList());
		testC.removeFirstList();
		System.out.println(testC.getList());
		
		/*ArrayList<Troupes> array = new ArrayList<Troupes>();
		array.add(test);
		array.add(test2);*/
		

		
	}

}
