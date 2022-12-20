public class Students {

	public int studentNumber;
	public String studentName;
	public String studentGrade;

	public Students() {
		studentNumber = 0;
		studentName = "default";
		studentGrade = "default";
	}
	public Students(String newName, String newGrade, int newNumber) {
		studentNumber = newNumber;
		studentName = newName;
		studentGrade = newGrade;
	}
	public void changeAllInfo (String moveName, String moveGrade, int moveNumber) {
		studentName = moveName;
		studentGrade = moveGrade;
		studentNumber = moveNumber;
	}
}
