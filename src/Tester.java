import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Subjects.csv"));

		// Making arraylist of all courses
		ArrayList<StudentGroup> studentGroups = new ArrayList<StudentGroup>();
		ArrayList<Subject> subs = new ArrayList<Subject>();
		ArrayList<Professor> profs = new ArrayList<Professor>();
		ArrayList<Classroom> rooms = new ArrayList<Classroom>();
		sc.nextLine();
		
		while (sc.hasNextLine()) {
			String split[] = sc.nextLine().split(",");
			subs.add(new Subject(split[0],split[1],split[2]));
		}

		// Making arraylist of professors

		profs.add(new Professor(subs.get(0).getProfName()));
		profs.get(0).addSubject(subs.get(0));
		subs.get(0).setProfOfSubject(profs.get(0));
		for (int i = 1; i < subs.size(); i++) {
			int flag = 0;
			for (int j = 0; j < profs.size(); j++) {
				if (profs.get(j).getProfName().equals(subs.get(i).getProfName())) {
					flag += 1;
					profs.get(j).addSubject(subs.get(i));
					subs.get(i).setProfOfSubject(profs.get(j));
					break;
				}
			}
			if (flag == 0) {
				profs.add(new Professor(subs.get(i).getProfName()));
				profs.get(profs.size() - 1).addSubject(subs.get(i));
				subs.get(i).setProfOfSubject(profs.get(profs.size() - 1));
			}

		}

		// Printing Prof Arraylist
		/*
		for (int i = 0; i < profs.size(); i++)
			System.out.println(profs.get(i).getProfName());

		sc.close();

		*/
		
		// Making arraylist of students
		ArrayList<Student> students = new ArrayList<Student>();
		sc = new Scanner(new File("Students.csv"));
		sc.nextLine();
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			// Was printing the details
			// System.out.println(str);
			String temp[] = str.split(",");
			students.add(new Student(temp[0], temp[1]));
			for (int i = 2; i < temp.length; i++) {
				for (int j = 0; j < subs.size(); j++) {
					if (temp[i].equals(subs.get(j).getSubjectID())) {

						students.get(students.size() - 1).addSubject(subs.get(j));
						break;
					}
				}

			}
		}

		// Making StudentGroups

		studentGroups.add(new StudentGroup(studentGroups.size() + 1, "Group" + (studentGroups.size() + 1)));
		studentGroups.get(0).addStudent(students.get(0));

		for (int i = 0; i < students.size(); i++) {
			int flag2 = 0;
			for (int j = 0; j < studentGroups.size(); j++) {
				int flag = 0;
				for (int k = 0; k < 5; k++) {
					for (int u = 0; u < 5; u++) {
						if (students.get(i).getSubject(k).getSubjectID()
								.equals(studentGroups.get(j).getStudent(0).getSubject(u).getSubjectID())) {
							flag++;
							break;
						}

					}
				}
				if (flag == 5) {
					studentGroups.get(j).addStudent(students.get(i));
					flag2 += 1;
				}
			}
			if (flag2 == 0) {
				studentGroups.add(new StudentGroup(studentGroups.size() + 1, "Group" + (studentGroups.size() + 1)));
				studentGroups.get(studentGroups.size() - 1).addStudent(students.get(i));
			}
		}

		// Printing StudentGroups first members
		/*
		 * for(int i=0;i<studentGroups.size();i++) {
		 * System.out.println(studentGroups.get(i).getId());
		 * System.out.println(studentGroups.get(i).getStudent(0).getName()); }
		 */
		sc.close();

		// Linking Courses to studentgroups

		for (int i = 0; i < studentGroups.size(); i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < subs.size(); k++) {
					if (studentGroups.get(i).getStudent(0).getSubject(j).getSubjectID().equals(subs.get(k).getSubjectID())) {
						subs.get(k).addStudentGroup(studentGroups.get(i));
						break;
					}
				}
			}
		}

		// Making arraylist of classrooms
		sc = new Scanner(new File("Classes.csv"));
		sc.nextLine();
		while (sc.hasNextLine()) {
			String[] split = sc.nextLine().split(",");
			rooms.add(new Classroom(split[0], Integer.parseInt(split[1])));
		}

		sc.close();
		// Sorting according to the capacity

		for (int i = 0; i < rooms.size() - 1; i++) {
			for (int j = 0; j < rooms.size() - 1; j++) {
				if (rooms.get(j).getMaxCapacity()< rooms.get(j + 1).getMaxCapacity()) {
					Classroom temp = rooms.remove(j);
					rooms.add(j, temp);
				}
			}
		}

		// Printed Sorted Classrooms
		
		/*
		for (int i = 0; i < rooms.size(); i++) {
			System.out.println(rooms.get(i).getNameOfClassroom());
		}
		 */
		
		TimeTable tt=new TimeTable(profs,subs,studentGroups,rooms);
		tt.fillSlots();
		tt.printTimeTable();
		
		//We will Take Query From File
		/*
		sc = new Scanner(new File("input.txt"));
		int noOfQueries = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<noOfQueries;i++) {
			tt.handleQuery(sc.nextLine());
		}
		*/
	}
}
