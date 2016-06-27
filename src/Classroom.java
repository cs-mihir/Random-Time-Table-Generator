
public class Classroom {
	private String _nameOfClassroom;
	private int _maxCapacity;

	//Constructor
	public Classroom(String name, int capacity) {
		_nameOfClassroom = name;
		_maxCapacity = capacity;
	}

	//Getter Setter
	public String getNameOfClassroom() {
		return _nameOfClassroom;
	}

	public void setNameOfClassroom(String _nameOfClassroom) {
		this._nameOfClassroom = _nameOfClassroom;
	}

	public int getMaxCapacity() {
		return _maxCapacity;
	}

	public void setMaxCapacity(int _maxCapacity) {
		this._maxCapacity = _maxCapacity;
	}

}
