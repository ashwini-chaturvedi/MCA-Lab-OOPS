package Lab5;

class Student{
    int studentID;
    String studentName;
    char grade;
    Student(int studentID,String studentName){
        this.studentID=studentID;
        this.studentName=studentName;
    }
    Student(int studentID, String studentName, char grade) {
        this(studentID,studentName);//this() method to call the Overloaded constructor of the same class
        this.grade = grade;
    }
}
public class Que1 {
    public static void main(String[] args) {

    }
}
