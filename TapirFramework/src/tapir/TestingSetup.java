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
			
		
		/* Se identific� una expresi�n regular correspondiente al funcionamiento b�sico que tiene
		todo enemigo, y se encontr� que no funciona exactamente como deber�a ya que el enemigo 
		sigue recibiendo da�o a�n despu�s de haberse ejecutado el m�todo morir.
		*/
		
		// Testing setup for Enemigo class
		//Definition of the methods and their corresponding symbols
		mapObjectsToCallSequence = new HashMap<>(); 
		mapMethodsToSymbols = new HashMap<String, String>();
		mapMethodsToSymbols.put("PaqueteEnemigos.Enemigo.setGrafico", "g");
		mapMethodsToSymbols.put("PaqueteEnemigos.Enemigo.recibirDa�o", "d");
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
