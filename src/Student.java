/**
 * Created by Adrian Adewunmi on 16/11/21.
 * Version 1.0
 * Student Class: This class keeps track of the student's name, ID and status of tuition fees.
 */

class Student {
    private int id;
    private String name;
    private String courseName;
    private String courseCode;
    private double tuitionFees;
    private double amountPaidTuitionFees;

    public Student(int id, String name, String courseName, String courseCode, double tuitionFees) {
        this.id = id;
        this.name = name;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.tuitionFees = tuitionFees;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setAmountPaidTuitionFees(double amountPaidTuitionFees) {
        this.amountPaidTuitionFees = amountPaidTuitionFees;
    }

    public double getAmountPaidTuitionFees() {
        return amountPaidTuitionFees;
    }

    public double updateTuitionFees(){
        tuitionFees = getTuitionFees();
        amountPaidTuitionFees = getAmountPaidTuitionFees();
        return tuitionFees = tuitionFees - amountPaidTuitionFees;
    }
}
