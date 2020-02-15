import java.util.ArrayList;

// Imaju unique polja kod studenta ali ta polja ja generisem pa nece doc do ponavljanja
// Ima li smisla koristit set?

public class StudentMenadzmet {
	ArrayList<Student> studenti;
	private static Integer generateIndex;
	private static Integer generateId;

	static {
		generateId = 1;
		generateIndex = 160000;
	}

	public StudentMenadzmet() {
		studenti = new ArrayList<Student>();
	}

	// ------------------------ADD---------------------
	public void addStudent(String firstName, String lastName, String dob) {
		studenti.add(new Student("" + generateId, firstName, lastName, dob, "" + generateIndex));
		generateId++;
		generateIndex++;
	}
		
	// --------------GET-----------------
	public ArrayList<Student> getAllStudents() {
		return studenti;
	}
	
	public Student getStudent(String ID) {
		for (Student student : studenti) {
			if (student.getStudentId().equals(ID))
				return student;
		}
		return null;
	}
	
	
	// --------------------UPDATE--------------------

	// Ovo je malo koplikovano ako korisnik unosi samo ID zato sto je konzolna
	// aplikacija
	// Moze se uradit u onoj klasi gdje se
	public boolean updateStudentFirstName(String ID, String firstName) {
		Student tempStudent = getStudent(ID);
		if(tempStudent == null)
			return false;
		tempStudent.setFirstName(firstName);
		return true;
	}

	public boolean updateStudentLastName(String ID, String lastName) {
		Student tempStudent = getStudent(ID);
		if(tempStudent == null)
			return false;
		tempStudent.setLastName(lastName);
		return true;
	}

	public boolean updateStudentDob(String ID, String dob) {
		Student tempStudent = getStudent(ID);
		if(tempStudent == null)
			return false;
		tempStudent.setDob(dob);
		return true;
	}
	
	// --------------------REMOVE--------------------
	public boolean remove(Student student) {
		if(student == null)
			return false;
		return studenti.remove(student);
	}
}