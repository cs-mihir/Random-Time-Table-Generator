import java.util.ArrayList;

public class StudentGroup {
	private ArrayList<Student> _students;
	private ArrayList<Subject> _subjectsLearning;
	private ArrayList<String> _nameOfSubjects;
	private int _grpID;
	private String _grpName;
	private int _totalStudents;
	
	public StudentGroup(int id,String name) {
		_grpID = id;
		_grpName = name;
		_students = new ArrayList<Student>();
		_nameOfSubjects = new ArrayList<String>();
		_subjectsLearning = new ArrayList<Subject>();
	}
	
	public void addStudent(Student student) {
		_students.add(student);
	}

	public int getGrpID() {
		return _grpID;
	}

	public void setGrpID(int _grpID) {
		this._grpID = _grpID;
	}

	public String getGrpName() {
		return _grpName;
	}

	public void setGrpName(String _grpName) {
		this._grpName = _grpName;
	}

	public int getTotalStudents() {
		_totalStudents = this._students.size();
		return _totalStudents;
	}

	public void setTotalStudents(int _totalStudents) {
		this._totalStudents = _totalStudents;
	}
	
	
	public void addSubject(Subject sub) {
		this._subjectsLearning.add(sub);
	}
	
	public Subject getSubject(int index) {
		return this._subjectsLearning.get(index);
	}

	
	public void addSubjectName(String sub) {
		this._nameOfSubjects.add(sub);
	}
	
	public String getSubjectName(int index) {
		return this._nameOfSubjects.get(index);
	}
	public Student getStudent(int index) {
		return this._students.get(index);
	}
}
