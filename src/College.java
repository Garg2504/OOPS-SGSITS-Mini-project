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
     * @param collegeName: The name of the college
     *
     */

    public College(String collegeName) {
        this.collegeName = collegeName;
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
        totalMoneyLeft = 0;
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
     * Adds money to the total money earned
     * @return: Total money earned
     */
    public void calculateTotalMoneyEarned() {
        for (Student student : students) {
            totalMoneyEarned += student.getAmountPaidTuitionFees();
        }
    }
    /**
     * Adds money to the total money spent
     * @return: Total money spent
     */
    public void calculateTotalMoneySpent() {
        for (Teacher teacher : teachers) {
            totalMoneySpent += teacher.getSalary();
        }
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
