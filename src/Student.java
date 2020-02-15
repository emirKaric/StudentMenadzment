public class Student {
	private String studentId;
	private String firstName;
	private String lastName;
	private String dob;
	private String indexNumber;
	
	public Student() {}
	
	public Student(String studentId, String firstName, String lastName, String dob, String indexNumber) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.indexNumber = indexNumber;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(String indexNumber) {
		this.indexNumber = indexNumber;
	}
	
	// Studenti su jednaki ako im je jednak indexNumber i studentId
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((indexNumber == null) ? 0 : indexNumber.hashCode());
			result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			if (indexNumber == null) {
				if (other.indexNumber != null)
					return false;
			} else if (!indexNumber.equals(other.indexNumber))
				return false;
			if (studentId == null) {
				if (other.studentId != null)
					return false;
			} else if (!studentId.equals(other.studentId))
				return false;
			return true;
		}

	@Override
	public String toString() {
		return "\n======Student ID " + studentId + "=========\n Ime: " + firstName + "\n Prezime: " +
				lastName + "\n Godina rodjenja: "+ dob + "\n Broj indexa: " + indexNumber;
	}
}