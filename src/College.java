import java.util.ArrayList;

/**
 * Created by Adrian Adewunmi on 18/11/21.
 * Version: 1.0
 * College Class: This class is used to keep track of all the students, teachers and
 * college funds
 */

public class College {
    private final String collegeName;
    private final ArrayList<Student> students;
    private final ArrayList<Teacher> teachers;
    private double totalMoneyEarned;
    private double totalMoneySpent;
    private double totalMoneyLeft;

    /**
     * Constructor for College Class
     * @param collegeName : The name of the college
     *
     */

    public College(String collegeName) {
        this.collegeName = collegeName;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.totalMoneyEarned = 0;
        this.totalMoneySpent = 0;
        this.totalMoneyLeft = 0;
    }

    /**
     * Gets the college name
     * @return: The name of the college
     */

    public String getCollegeName() {
        return collegeName;
    }
    /**
     * Gets list of students
     * @return: The list of students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Gets list of teachers
     * @return: The list of teachers
     */
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Gets total money earned
     * @return: The total money earned
     */
    public double getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    /**
     * Gets total money spent
     * @return: The total money spent
     */
    public double getTotalMoneySpent() {
        return totalMoneySpent;
    }

    /**
     * Adds a student to the list of students
     * @param student: The student to be added
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Adds a teacher to the list of teachers
     * @param teacher: The teacher to be added
     */

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     * Finds a teacher by ID
     * @param teacherID: The teacher ID
     */
    public void findTeacher(String teacherID) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherID)) {
                System.out.println(teacher.toString());
            }
        }
    }

    /**
     * Deletes a teacher from the list of teachers
     */
    ArrayList<Teacher> deletedTeacherList = new ArrayList<>();
    public void removeTeacher(String teacherID) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherID)) {
                deletedTeacherList.add(teacher);
            }
        }
        teachers.removeAll(deletedTeacherList);
    }
    /**
     * Increases teacher salary
     * @param teacherID: The teacher ID
     * @param salary: The salary to be added
     * @return: The new salary
     */
    public double increaseTeacherSalary(String teacherID, double salary) {
        double newSalary = 0;
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherID)) {
                teacher.setSalary(teacher.getSalary() + salary);
                newSalary = teacher.getSalary();
            }
        }
        return newSalary;
    }

    /**
     * Adds money to the total money earned
     * @return totalMoneyEarned
     */
    public double calculateTotalMoneyEarned() {
        for (Student student : students) {
            totalMoneyEarned += student.getAmountPaidTuitionFees();
        }
        return totalMoneyEarned;
    }
    /**
     * Adds money to the total money spent
     * @return: Total money spent
     */
    public double calculateTotalMoneySpent() {
        for (Teacher teacher : teachers) {
            totalMoneySpent += teacher.getSalary();
        }
        return totalMoneySpent;
    }
    /**
     * Calculates the total money left
     * @return: Total money left
     */
    public void calculateTotalMoneyLeft() {
        totalMoneyLeft = totalMoneyEarned - totalMoneySpent;
    }
    /**
     * Gets total money left
     * @return: Total money left
     */
    public double getTotalMoneyLeft() {
        return totalMoneyLeft;
    }
}
