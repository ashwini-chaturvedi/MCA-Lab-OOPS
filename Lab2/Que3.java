package Lab2;

class Students{
    static int count;
    int studentId;

    Students(){
        count++;
        studentId=count;
    }

    static void totalStudents(){
        System.out.println("Total Number of Students:"+count);
    }
    static int nextAvailableId(){
        return count+1;
    }
}
public class Que3 {
    public static void main(String[] args) {
        Students student1=new Students();
        Students student2=new Students();
        Students student3=new Students();
        System.out.println("Student1.id:"+student1.studentId);
        System.out.println("Student2.id:"+student2.studentId);
        System.out.println("Student3.id:"+student3.studentId);
        System.out.println("Total Students:"+Students.count);
        System.out.println("Next Available Student Id:"+Students.nextAvailableId());

    }
}
