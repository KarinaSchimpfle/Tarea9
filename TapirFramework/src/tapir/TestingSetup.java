package tapir;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import PaqueteEnemigos.Enemigo;

public class TestingSetup {
	public static void setup() {
		HashMap<Integer, String> mapObjectsToCallSequence = null; 
		HashMap<String, String> mapMethodsToSymbols = null; 
		Pattern regularExpression = null; 
		Matcher matcher = null;
		
		//Specification of the test class\
		TestingCore.mapClassToTestingInformation = new HashMap<>();
			
		
		/* Se identificó una expresión regular correspondiente al funcionamiento básico que tiene
		todo enemigo, y se encontró que no funciona exactamente como debería ya que el enemigo 
		sigue recibiendo daño aún después de haberse ejecutado el método morir.
		*/
		
		// Testing setup for Enemigo class
		//Definition of the methods and their corresponding symbols
		mapObjectsToCallSequence = new HashMap<>(); 
		mapMethodsToSymbols = new HashMap<String, String>();
		mapMethodsToSymbols.put("PaqueteEnemigos.Enemigo.setGrafico", "g");
		mapMethodsToSymbols.put("PaqueteEnemigos.Enemigo.recibirDaño", "d");
		mapMethodsToSymbols.put("PaqueteEnemigos.Enemigo.disparar", "i");
		mapMethodsToSymbols.put("PaqueteEnemigos.Enemigo.mover", "u");
		mapMethodsToSymbols.put("PaqueteEnemigos.Enemigo.morir", "m");
		
		//Definition of the regular expression
		regularExpression = Pattern.compile("g(d|i|u)*m");
		//Initializing the regular expressions controller
		matcher = regularExpression.matcher("");	
		// All information related to how the Account class is testing is store in a TestingInformation instance
		TestingInformation ti2 = new TestingInformation(Enemigo.class.toString(), mapObjectsToCallSequence, mapMethodsToSymbols, regularExpression, matcher, true);
		TestingCore.mapClassToTestingInformation.put(Enemigo.class.toString(), ti2);
		
		mapObjectsToCallSequence = null; 
		mapMethodsToSymbols = null; 
		regularExpression = null; 
		matcher = null;
		
		
	}
	
}
