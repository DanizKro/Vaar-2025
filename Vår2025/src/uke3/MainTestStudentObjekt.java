package uke3;

public class MainTestStudentObjekt {

	public static void main(String[]args) {
		
		Student[] student = new Student[2];
		NettStudent[] nettStudent = new NettStudent[2];
		
		Student student1 = new Student(1, "A","B","C");
		NettStudent nettstudent1 = new NettStudent(1, "A","B","C", "D");
		
		//Det er lov å legge til et NettStudent-objekt i klassen Student, fordi NettStudent er en sub-klasse av Student
		student[0] = student1;
		student[1] = nettstudent1;
		
		//Det er ikke lov å legge til et Student-objekt i klassen Nettstudent, fordi Student er superklassen til Nettstudent
		nettStudent[0] = nettstudent1;
		// nettStudent[1] = student1;
		
		
	}
}
