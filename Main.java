abstract class Student {
    protected String name;
    protected int rollNumber;
    protected double marks;

    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public abstract String calculateGrade();

    public void displayInfo() {
        System.out.println("--------------------------------------------------");
        System.out.println("Student Name       : " + name);
        System.out.println("Roll Number        : " + rollNumber);
        System.out.println("Total Marks        : " + marks);
        System.out.println("Final Grade        : " + calculateGrade());
        System.out.println("--------------------------------------------------");
    }

    // Getters and setters (demonstrates Encapsulation)
    public String getName() { return name; }
    public int getRollNumber() { return rollNumber; }
    public double getMarks() { return marks; }

    public void setMarks(double marks) { this.marks = marks; }
}


// ------------------------- UNDERGRADUATE STUDENT CLASS -------------------------

class Undergraduate extends Student {

    // Constructor calls base class constructor
    public Undergraduate(String name, int rollNumber, double marks) {
        super(name, rollNumber, marks);
    }

    /*
     * Undergraduate grading rules:
     * A: 80 and above
     * B: 60 - 79
     * C: 40 - 59
     * Fail: Below 40
     */
    @Override
    public String calculateGrade() {
        if (marks >= 80) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 40) return "C";
        else return "Fail";
    }
}


// ------------------------- POSTGRADUATE STUDENT CLASS -------------------------

class Postgraduate extends Student {

    // Constructor
    public Postgraduate(String name, int rollNumber, double marks) {
        super(name, rollNumber, marks);
    }

    /*
     * Postgraduate grading rules:
     * A: 85 and above
     * B: 70 - 84
     * C: 50 - 69
     * Fail: Below 50
     */
    @Override
    public String calculateGrade() {
        if (marks >= 85) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 50) return "C";
        else return "Fail";
    }
}


// ------------------------- STUDENT MANAGEMENT CLASS -------------------------

class StudentManagement {

    private Student[] students;  // Array of Student (demonstrates polymorphism)
    private int count;

    public StudentManagement(int size) {
        students = new Student[size];
        count = 0;
    }

    // Add a new student (reference of base class can hold subclass objects)
    public void addStudent(Student s) {
        if (count < students.length) {
            students[count++] = s;
        } else {
            System.out.println("Cannot add more students. List is full!");
        }
    }

    // Display all students (Polymorphism occurs here)
    public void displayAllStudents() {
        if (count == 0) {
            System.out.println("No students available to display.");
            return;
        }

        System.out.println("\n========== STUDENT RECORDS ==========");
        for (int i = 0; i < count; i++) {
            students[i].displayInfo(); // Calls overridden method
        }
    }
}


// ------------------------- MAIN CLASS -------------------------

public class Main {
    public static void main(String[] args) {

        // Creating a management system object
        StudentManagement sm = new StudentManagement(10);

        // Adding Undergraduate students
        sm.addStudent(new Undergraduate("Rahul Sharma", 101, 75.0));
        sm.addStudent(new Undergraduate("Sneha Patel", 102, 52.5));

        // Adding Postgraduate students
        sm.addStudent(new Postgraduate("Arjun Verma", 201, 90.0));
        sm.addStudent(new Postgraduate("Priya Nair", 202, 48.0));

        // Display all records
        sm.displayAllStudents();
    }
}


