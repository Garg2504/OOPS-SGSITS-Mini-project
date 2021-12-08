/**
 * Created by Adrian Adewunmi on 16/11/21.
 * Version 1.0
 * Student Class: This class keeps track of the student's name, ID and status of tuition fees.
 */

class Student {
    private final String id;
    private final String name;
    private final String courseName;
    private final String courseCode;
    private final double tuitionFeePrice;
    private double tuitionFee;
    private double tuitionFeePaid;
    private double tuitionFeeBalance;


    /**
     * Constructor for Student class
     * @param id: Student's ID
     * @param name: Student's name
     * @param courseName: Student's course name
     * @param courseCode: Student's course code
     * @param tuitionFeePrice: Student's tuition fees
     */

    public Student(String id, String name, String courseName, String courseCode, double tuitionFeePrice) {
        this.id = id;
        this.name = name;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.tuitionFeePrice = tuitionFeePrice;
        this.tuitionFee = tuitionFeePrice;
        this.tuitionFeePaid = 0;
        this.tuitionFeeBalance = 0;
    }

    /**
     * This method returns the student's ID
     * @return: Student's ID
     */
    public String getId() {
        return id;
    }
    /**
     * This method returns the student's name
     * @return: Student's name
     */
    public String getName() {
        return name;
    }
    /**
     * This method returns the student's course name
     * @return: Student's course name
     */
    public String getCourseName() {
        return courseName;
    }
    /**
     * This method returns the student's course code
     * @return: Student's course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * This method returns the student's tuition fees
     * It is final, used for holding the price of tuition fees
     * @return: Student's tuition fees price
     */
    public double getTuitionFeePrice() {
        return tuitionFeePrice;
    }

    /**
     * This method returns the student's tuition fees
     * It is not final, it holds the price of the tuition fee and
     * used to calculate the balance of the tuition fee
     * @return tuitionFee: Student's tuition fees
     */
    public double getTuitionFee() {
        return tuitionFee;
    }

    /**
     * Sets the student's tuition fee
     * @param tuitionFeePaid: Student's tuition fee paid
     */
    public void setTuitionFeePaid(double tuitionFeePaid) {
        this.tuitionFeePaid = tuitionFeePaid;
    }

    /**
     * Get student tuition fee paid
     * @return tuitionFeePaid: Student's tuition fee paid
     */
    public double getTuitionFeePaid() {
        return tuitionFeePaid;
    }
    /**
     * Get student tuition fee balance
     * @return tuitionFeeBalance
     */
    public double tuitionFeeBalance() {
        tuitionFeeBalance = getTuitionFee() - getTuitionFeePaid();
        return tuitionFeeBalance;
    }

    /**
     * This method returns all the student's details
     * @return: Student's details
     */
    @Override
    public String toString() {
        return "Student ID: " + id +
                ", Name: " + name +
                ", Course Name: " + courseName +
                ", Course Code: " + courseCode +
                ", Tuition Fees: £ " + tuitionFeePrice;
    }

}
