import java.util.ArrayList;

public class Professor {
	private static int _numOfProf = 0;
	private String _profName;
	private int _profID; // We will make prof ID in our input file
	private ArrayList<Subject> _subjectsTaught;

	// Constructor
	public Professor(String name) {
		_profName = name;
		_subjectsTaught = new ArrayList<Subject>();
		_profID = ++_numOfProf;
	}

	// Getter Setters
	public String getProfName() {
		return _profName;
	}

	public void setProfName(String profName) {
		this._profName = profName;
	}

	public int getProfID() {
		return _profID;
	}

	public void setProfID(int profID) {
		this._profID = profID;
	}

	// Adds subjects in arraylist
	public void addSubject(Subject sub) {
		this._subjectsTaught.add(sub);
	}

	public Subject getSubject(int index) {
		return _subjectsTaught.get(index);
	}

	public int getSize() {
		return _subjectsTaught.size();
	}

}
