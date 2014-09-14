package Calculatings;

import java.util.HashMap;

import parser.Parser;

public class Calculator {

	public Classroom classroom;

	private Parser p = new Parser();
	String inputFile = "C:\\Users\\!Simon\\git\\EasyKlassenzimmer\\src\\Calculatings\\data.csv";

	public Calculator() {
		classroom = fillClass();
	}
	
	public Classroom fillClass() {
		HashMap<String, Integer> cls = p.parse(inputFile);

		// Daten aus der HashMap holen
		int foreigners = cls.get("Schüler ausländisch");
		int total = cls.get("Schüler insgesamt");
		int female = cls.get("Schüler weiblich");
		int male = cls.get("Schüler männlich");
		int teacher = 93103; // Lehrerzahl wurde unabhängig von oben genutzter
								// Statistik recherchiert

		// Berechnung des Klassenzimmers
		double percentageGirls = female / (double) total;
		double percentageBoys = male / (double) total;
		double percentageForeigners = foreigners / (double) total;
		int studentsPerTeacher = (int) Math.round(total / (double) teacher);
		int boysInClass = (int) Math.round(percentageBoys
				* (double) studentsPerTeacher);
		int girlsInClass = studentsPerTeacher - boysInClass;
		int foreignersInClass = (int) Math.round(percentageForeigners
				* (double) studentsPerTeacher);

		// System.out.print(); // debugging

		Classroom avgClass = new Classroom(studentsPerTeacher, percentageGirls,
				percentageBoys, percentageForeigners, girlsInClass,
				boysInClass, foreignersInClass);
		return avgClass;
	}

}
