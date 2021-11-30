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
    public boolean findTeacher(String teacherID) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes a teacher from the list of teachers
     */
    ArrayList<Teacher> deletedTeacherList = new ArrayList<>();
    public boolean removeTeacher(String teacherID) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherID)) {
                deletedTeacherList.add(teacher);
                teachers.removeAll(deletedTeacherList);
                return true;
            }
        }
        return false;
    }
    /**
     * Increases teacher salary
     * @param teacherID : The teacher ID
     * @param salaryIncrease : The salary to be added
     * @return: The new salary
     */
    public double increaseTeacherSalary(String teacherID, double salaryIncrease) {
        double newSalary = 0;
            for (Teacher teacher : teachers) {
                if (teacher.getId().equals(teacherID)) {
                    if (salaryIncrease > 0) {
                        teacher.setSalary(teacher.getSalary() + salaryIncrease);
                        newSalary = teacher.getSalary();
                        System.out.println("Salary Increased Successfully!");
                    }else {
                        System.out.println("Salary increase cannot be negative");
                    }
                }
            }
        return newSalary;
    }

    /**
     * Adds money to the total money earned
     * @return totalMoneyEarned
     */
    public double calculateTotalMoneyEarned() {
        try{
            for (Student student : students) {
                totalMoneyEarned += student.getAmountPaidTuitionFees();
            }
        }catch (ArithmeticException e){
            System.out.println("Total money earned cannot be negative");
            e.printStackTrace();
        }
        return totalMoneyEarned;
    }
    /**
     * Adds money to the total money spent
     * @return: Total money spent
     */
    public double calculateTotalMoneySpent() {
        try{
            for (Teacher teacher : teachers) {
                totalMoneySpent += teacher.getSalary();
            }
        }catch (ArithmeticException e){
            System.out.println("Total money spent cannot be negative");
            e.printStackTrace();
        }
        return totalMoneySpent;
    }
    /**
     * Calculates the total money left
     * @return: Total money left
     */
    public double calculateTotalMoneyLeft() {
        try{
        totalMoneyLeft = totalMoneyEarned - totalMoneySpent;
        }catch (ArithmeticException e){
            System.out.println("Total money left cannot be negative");
            e.printStackTrace();
        }
        return totalMoneyLeft;
    }
    /**
     * Gets total money left
     * @return: Total money left
     */
    public double getTotalMoneyLeft() {
        return totalMoneyLeft;
    }
    /**
     * Print the list of teachers
     */
    public void printListOfTeachers() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
    }
}
