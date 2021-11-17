
/**
 * Created by Adrian Adewunmi on 17/11/21.
 * Version 1.0
 * Teacher Class: This class keeps track of the teacher's name, id, and salary.
 */

public class Teacher {
    private final int id;
    private final String name;
    private String salary;

    /**
     * Constructor for the Teacher class
     * @param id: The teacher's id
     * @param name: The teacher's name
     * @param salary: The teacher's salary
     */

    public Teacher(int id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    /**
     * Gets the teacher's id
     * @return: The teacher's id
     */
    public int getId() {
        return id;
    }
    /**
     * Gets the teacher's name
     * @return: The teacher's name
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the teacher's salary
     * @return: The teacher's salary
     */
    public String getSalary() {
        return salary;
    }
    /**
     * Sets the teacher's salary
     * @param salary: The teacher's salary
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }
}
