package Calculatings;

public class Classroom {

	private int studentsPerTeacher;
	private double percentageOfGirls;
	private double percentageOfBoys;
	private double percentageOfForeigners;
	private int girlsInClass;
	private int boysInClass;
	private int foreignersInClass;

	public Classroom(int studentsPerTeacher, double percentageOfGirls,
			double percentageOfBoys, double percentageOfForeigners,
			int girlsInClass, int boysInClass, int foreignersInClass) {
		this.studentsPerTeacher = studentsPerTeacher;
		this.percentageOfGirls = percentageOfGirls;
		this.setPercentageOfBoys(percentageOfBoys);
		this.percentageOfForeigners = percentageOfForeigners;
		this.setGirlsInClass(girlsInClass);
		this.setBoysInClass(boysInClass);
		this.setForeignersInClass(foreignersInClass);
	}

	public double getStudentsPerTeacher() {
		return studentsPerTeacher;
	}

	public void setStudentsPerTeacher(int studentsPerTeacher) {
		this.studentsPerTeacher = studentsPerTeacher;
	}

	public double getPercentageOfGirls() {
		return percentageOfGirls;
	}

	public void setPercentageOfGirls(double percentageOfGirls) {
		this.percentageOfGirls = percentageOfGirls;
	}

	public double getPercentageOfForeigners() {
		return percentageOfForeigners;
	}

	public void setPercentageOfForeigners(double percentageOfForeigners) {
		this.percentageOfForeigners = percentageOfForeigners;
	}

	public double getPercentageOfBoys() {
		return percentageOfBoys;
	}

	public void setPercentageOfBoys(double percentageOfBoys) {
		this.percentageOfBoys = percentageOfBoys;
	}

	public int getGirlsInClass() {
		return girlsInClass;
	}

	public void setGirlsInClass(int girlsInClass) {
		this.girlsInClass = girlsInClass;
	}

	public int getBoysInClass() {
		return boysInClass;
	}

	public void setBoysInClass(int boysInClass) {
		this.boysInClass = boysInClass;
	}

	public int getForeignersInClass() {
		return foreignersInClass;
	}

	public void setForeignersInClass(int foreignersInClass) {
		this.foreignersInClass = foreignersInClass;
	}

}
