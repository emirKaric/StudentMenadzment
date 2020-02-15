import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Meni {
	private static StudentMenadzmet studentskaSluzba;

	static {
		studentskaSluzba = new StudentMenadzmet();
	}

	public static void show() {
		int brojOpcije;
		Scanner unos = new Scanner(System.in);
		do {
			printMeni();
			brojOpcije = unos.nextInt();
			izvrsiOpciju(brojOpcije, unos);
		} while (brojOpcije != 5);
	}

	private static void printMeni() {
		System.out.println("\n\n------------- App v1.0---------------\n\n");
		System.out.println("\tDate: " + new Date());
		System.out.println("\\n\\n----------------------------\\n\\n");
		System.out.println("Meni:");
		System.out.println("1. Dodaj studenta");
		System.out.println("2. Ispisi studente");
		System.out.println("3. Ispisi jednog studenta");
		System.out.println("4. Update student");
		System.out.println("5. EXIT");
	}

	private static void printUpdateMeni() {
		System.out.println("Sta zelite promijeniti kod korisnika:");
		System.out.println("1. Ime");
		System.out.println("2. Prezime");
		System.out.println("3. Datum rodjenja");
	}

	private static void izvrsiOpciju(int opcija, Scanner unos) {
		unos.nextLine();
		switch (opcija) {
		case 1:
			System.out.println("Unesite ime studenta: ");
			String firstName = unos.nextLine();
			System.out.println("Unesite prezime studenta: ");
			String lastName = unos.nextLine();
			System.out.println("Unesite datum rodjenja studenta u formatu dd.mm.yyyy ");
			String dob = unos.nextLine();
			studentskaSluzba.addStudent(firstName, lastName, dob);
			break;
		case 2:
			ArrayList<Student> allStudents = studentskaSluzba.getAllStudents();
			System.out.println("\n\n==================================\n\n");
			for (Student student : allStudents) {
				System.out.println("\n------------------------------\n");
				System.out.println(student);
			}
			break;
		case 3:
			Student temp = null;
			while (temp == null) {
				System.out.println("Unesi ID studenta: ");
				temp = studentskaSluzba.getStudent(unos.nextLine());
			}
			System.out.println(temp);
			break;
		case 4:
			char dodatniUnos = 'F';
			System.out.println("Uneiste ID studenta: ");
			String ID = unos.nextLine().trim();
			Student tempStudent = studentskaSluzba.getStudent(ID);
			if (tempStudent == null) {
				System.out.println("Odabrani student se ne nalazi u bazi");
				return;
			}
			do {
				printUpdateMeni();
				int updateOpcija = unos.nextInt();
				switch (updateOpcija) {
				case 1:
					System.out.println("Unesite novo ime studenta: ");
					String firstName1 = unos.nextLine();
					studentskaSluzba.updateStudentFirstName(ID, firstName1);
					break;
				case 2:
					System.out.println("Unesite novo ime studenta: ");
					String lastName1 = unos.nextLine();
					studentskaSluzba.updateStudentLastName(ID, lastName1);
					break;
				case 3:
					System.out.println("Unesite novo ime studenta: ");
					String dob1 = unos.nextLine();
					studentskaSluzba.updateStudentDob(ID, dob1);
					break;
				}
				unos.nextLine();
				System.out.println("Da li zelite promijeniti jos nesto kod korisnika T/F: ");
				dodatniUnos = unos.next().charAt(0);
			} while (Character.toUpperCase(dodatniUnos) == 'T');
			break;
		}
	}
}