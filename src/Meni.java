import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * Naizmjenicno sam koristio termine Student i Korisnik (ZNACE ISTO)
 * 
 * 
 */

public class Meni {
	private static StudentMenadzmet studentskaSluzba;

	static {
		studentskaSluzba = new StudentMenadzmet();
	}

	// ------------------ISPISIVANJE CIJELOG UI APLIKACIJE---------------------
	public static void show() {
		int brojOpcije;
		Scanner unos = new Scanner(System.in);
		do {
			printMeni();
			System.out.print("Opcija: ");
			brojOpcije = unos.nextInt();
			izvrsiOpciju(brojOpcije, unos);
		} while (brojOpcije != 6);
		unos.close();
	}

	// ---------------------------PRINTA GLAVNI MENI---------------------
	private static void printMeni() {
		System.out.println("\n------------------- App v1.0---------------------------\n");
		System.out.println("\tDate: " + new Date());
		System.out.println("\n-------------------------------------------------\n");
		System.out.println("Meni:");
		System.out.println("1. Dodaj studenta");
		System.out.println("2. Ispisi studente");
		System.out.println("3. Ispisi jednog studenta");
		System.out.println("4. Update student");
		System.out.println("5. Remove");
		System.out.println("6. EXIT");
	}

	// --------------------- PRINTA MENI ZA UPDATOVANJE STUDENTA----------------------
	private static void printUpdateMeni() {
		System.out.println("Sta zelite promijeniti kod korisnika:");
		System.out.println("1. Ime");
		System.out.println("2. Prezime");
		System.out.println("3. Datum rodjenja");
		System.out.print("Unos: ");
	}

	// ------------------------ OPERACIJE IZ GLAVNOG MENIJA------------------------
	private static void izvrsiOpciju(int opcija, Scanner unos) {
		unos.nextLine();
		switch (opcija) {
		case 1:
			addKorisnik(unos);
			break;
		case 2:
			printAllStudents();
			break;
		case 3:
			Student temp = null;
			while (temp == null) {
				System.out.println("Unesi ID studenta: ");
				temp = studentskaSluzba.getStudent(unos.nextLine());
			}
			printStudent(temp);
			break;
		case 4:
			updateStudent(unos);
			break;
		case 5:
			removeKorisnik(unos);
			break;
		}
	}
	
	// OVO SAM ZABORAVIO DA TREBA JA SE ZEZO U APLIKACIJI NISAM NI TESTIRO
	private static void removeKorisnik(Scanner unos) {
		System.out.println("Uneiste ID korisnika: ");
		String ID = unos.nextLine();
		System.out.println("Da li ste sigurni da zelite izbrisati studenta T/F: ");
		char beze = unos.nextLine().charAt(0);
		if(beze == 'T' || beze == 't')
			studentskaSluzba.remove(studentskaSluzba.getStudent(ID));
	}

	// ------------------ DODAJE KORISNIKA ---------------------
	private static void addKorisnik(Scanner unos) {
		System.out.println("Unesite ime studenta: ");
		String firstName = unos.nextLine();
		System.out.println("Unesite prezime studenta: ");
		String lastName = unos.nextLine();
		System.out.println("Unesite datum rodjenja studenta u formatu dd.mm.yyyy ");
		String dob = unos.nextLine();
		studentskaSluzba.addStudent(firstName, lastName, dob);
	}
	
	// ------------ PRINTA ARRAY KORISNIKA --------------------
	private static void printAllStudents() {
		ArrayList<Student> allStudents = studentskaSluzba.getAllStudents();
		System.out.println("\n\n==================================\n\n");
		for (Student student : allStudents) {
			System.out.println("\n------------------------------\n");
			System.out.println(student);
		}
		System.out.println("\n\n==================================\n\n");
	}

	private static void printStudent(Student student) {
		System.out.println(student);
	}
	
	// ---------------FUNKCIJA ZA UPDATE KORISNIKA----------------
	private static void updateStudent(Scanner unos) {
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
			unos.nextLine();
			updateOptions(updateOpcija, unos, ID);
			System.out.println("Da li zelite promijeniti jos nesto kod korisnika T/F: ");
			dodatniUnos = unos.next().charAt(0);
			
		} while (Character.toUpperCase(dodatniUnos) == 'T');

	}
	// ----------------- SWITCH CASE ZA UPDATE KORISNIKA ------------------
	private static void updateOptions(int opcija, Scanner unos, String ID) {
		switch (opcija) {
		case 1:
			String firstName = unosPodatka("Unesite novo ime studenta: ", unos);
			studentskaSluzba.updateStudentFirstName(ID, firstName);
			break;
		case 2:
			String lastName = unosPodatka("Unesite novo prezime studenta: ", unos);
			studentskaSluzba.updateStudentLastName(ID, lastName);
			break;
		case 3:
			String dob1 = unosPodatka("Unesite novu godinu rodjenja studenta: ", unos);
			studentskaSluzba.updateStudentDob(ID, dob1);
			break;
		}
	}
	
	// --------------------- PRIMA PORUKU I NA OSNOVU TOGA VRACA STRING ---------------------------- 
	private static String unosPodatka(String poruka, Scanner unos) {
		System.out.println(poruka);
		return unos.nextLine();
	}
}