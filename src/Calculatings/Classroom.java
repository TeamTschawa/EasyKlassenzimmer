package Calculatings;

public class Classroom {
	
	private double studentsPerTeacher;
	private double percentageOfGirls;
	private double percentageOfForeigners;
	
	public Classroom(double studentsPerTeacher, double percentageOfGirls, double percentageOfForeigners){
		this.studentsPerTeacher  = studentsPerTeacher;
		this.percentageOfGirls = percentageOfGirls;
		this.percentageOfForeigners = percentageOfForeigners;
	}
	
	public double getStudentsPerTeacher() {
		return studentsPerTeacher;
	}
	public void setStudentsPerTeacher(double studentsPerTeacher) {
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
	

}
