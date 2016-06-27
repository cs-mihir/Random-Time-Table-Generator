import java.util.ArrayList;

public class Subject {
	private String _subjectID;
	private String _subjectName;
	private Professor _profOfSubject;
	private String _profName; //Store prof name. Easy to search in prof arraylist
	private ArrayList<StudentGroup> _studentGroups;
	private Classroom _classOfSubject;

	public Subject(String id, String name, String profName) {
		_subjectID = id;
		_subjectName = name;
		_profName = profName;
		_studentGroups = new ArrayList<StudentGroup>();
	}

	public String getSubjectID() {
		return _subjectID;
	}

	public void setSubjectID(String _subjectID) {
		this._subjectID = _subjectID;
	}

	public String getSubjectName() {
		return _subjectName;
	}

	public void setSubjectName(String _subjectName) {
		this._subjectName = _subjectName;
	}

	public Professor getProfOfSubject() {
		return _profOfSubject;
	}

	public void setProfOfSubject(Professor _profOfSubject) {
		this._profOfSubject = _profOfSubject;
	}

	public String getProfName() {
		return _profName;
	}

	public void setProfName(String _profName) {
		this._profName = _profName;
	}

	public void addStudentGroup(StudentGroup sg) {
		this._studentGroups.add(sg);
	}

	public int totalStudentGroups() {
		// TODO Auto-generated method stub
		return this._studentGroups.size();
	}


	public StudentGroup getStudentGroup(int k) {
		// TODO Auto-generated method stub
		return this._studentGroups.get(k);
	}

	public Classroom getClassOfSubject() {
		return _classOfSubject;
	}

	public void setClassOfSubject(Classroom classOfSubject) {
		this._classOfSubject = classOfSubject;
	}

	public int getTotalStudents() {
		int total = 0;
		for(int i=0;i<_studentGroups.size();i++) {
			total += _studentGroups.get(i).getTotalStudents();
		}
		return total;
	}

}
