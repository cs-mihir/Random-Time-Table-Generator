import java.util.ArrayList;
import java.util.Random;

import javax.print.attribute.IntegerSyntax;

public class TimeTable {

	private ArrayList<Professor> profs;
	private ArrayList<Subject> courses;
	private ArrayList<StudentGroup> groups;
	private ArrayList<Classroom> rooms;
	private Subject[][] slots;
	private int[] dayFreq;
	private int[] weekFreq;

	// Constructor of TimeTable Class
	// Takes ArrayList of professors,subjects,studentGroups and all classRooms
	// available
	public TimeTable(ArrayList<Professor> profdata, ArrayList<Subject> courses, ArrayList<StudentGroup> studentGroups,
			ArrayList<Classroom> rooms) {
		this.profs = profdata;
		this.courses = courses;
		this.groups = studentGroups;
		this.rooms = rooms;
		slots = new Subject[5][5];
		dayFreq = new int[courses.size()];
		weekFreq = new int[courses.size()];
	}

	// This Method Fills Slots of each day
	public void fillSlots() {

		Random randomGenerator = new Random();
		// We will use this RandomGenerator to get a number corresponding to
		// index of a subject in our arrayList
		for (int i = 0; i < 5; i++) {
			resetDayFreq();
			// resets Frequency of each subject 0 for a particular day
			for (int j = 0; j < 5; j++) {
				/*
				 * We will generate a random number which corresponds to index
				 * of a particular subject in arrayList and we will check our
				 * constraints
				 */
				while (true) {
					int m = randomGenerator.nextInt(courses.size());
					/*
					 * checks if on that day the course is taken or not and in
					 * that week the subjects has no more than 3 hrs If so we
					 * will add that randomly picked subject in that day's slot
					 * else we will generate a new random number
					 */

					if (dayFreq[m] == 0 && weekFreq[m] < 3) {
						slots[i][j] = courses.get(m);
						dayFreq[m] = 1;
						weekFreq[m] += 1;
						break;
					} else {
						continue;
					}
				}
			}
		}

		/*
		 * Here we will select the classroom for a subject according to our
		 * classrooms' strength and our subjects' total no. of students
		 */
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = rooms.size() - 1; k >= 0; k--) {
					if (slots[i][j].getTotalStudents() < rooms.get(k).getMaxCapacity()) {
						slots[i][j].setClassOfSubject(rooms.get(k));
						break;
					}
				}
			}
		}

	}

	// Resets frequency of each subject for a particular day to zero
	private void resetDayFreq() {
		for (int i = 0; i < dayFreq.length; i++) {
			dayFreq[i] = 0;
		}
	}

	// prints the timetable
	public void printTimeTable() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Day " + (i + 1));
			for (int j = 0; j < 5; j++) {
				System.out.println("Slot " + (j + 1));
				// Prints day-slot wise subject name and ID
				System.out.println(slots[i][j].getSubjectName() + " " + slots[i][j].getSubjectID());
				// Prints professor of that subject
				System.out.println("Professor of this subject " + slots[i][j].getProfName());
				// Prints all student groups studying that subject
				System.out.println("Student Groups which study this Subject");
				for (int k = 0; k < slots[i][j].totalStudentGroups(); k++) {
					System.out.println(slots[i][j].getStudentGroup(k).getGrpName());
				}
				// Prints where the subject is being held
				System.out.println("Subject Conducted At " + slots[i][j].getClassOfSubject().getNameOfClassroom());
				System.out.println();
			}
			System.out.println();
		}
	}

	public void handleQuery(String query) {
		String[] split = query.split(":");
		if(split[0].equals("prof")) {
			if(split[1].equals("name")) {
				for(int i=0;i<5;i++) {
					for(int j=0;j<5;j++) {
						if(slots[i][j].getProfName().equals(split[2])) {
							System.out.println("Day "+(i+1));
							System.out.println("Slot "+(j+1));
							System.out.println("Lecture "+slots[i][j].getSubjectName());
						}
					}
				}
			}
			else if(split[1].equals("id")) {
				for(int i=0;i<5;i++) {
					for(int j=0;j<5;j++) {
						if(slots[i][j].getProfOfSubject().getProfID()==(Integer.parseInt(split[2]))) {
							System.out.println("Day "+(i+1));
							System.out.println("Slot "+(j+1));
							System.out.println("Lecture "+slots[i][j].getSubjectName());
						}
					}
				}
			}
		}
		
	}
}
