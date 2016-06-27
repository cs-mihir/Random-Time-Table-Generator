import java.util.ArrayList;

public class Student {
	private String _studentID;
	private String _studentName;
	private ArrayList<Subject> _subjectsLearning;
	
	public Student(String id, String name) {
		_studentID = id;
		_studentName = name;
		_subjectsLearning = new ArrayList<Subject>();
	}

	public String getStudentID() {
		return _studentID;
	}

	public void setStudentID(String _studentID) {
		this._studentID = _studentID;
	}

	public String getStudentName() {
		return _studentName;
	}

	public void setStudentName(String _StudentName) {
		this._studentName = _StudentName;
	}

	public void addSubject(Subject sub) {
		_subjectsLearning.add(sub);
	}

	public Subject getSubject(int index) {
		return _subjectsLearning.get(index);
	}

}
