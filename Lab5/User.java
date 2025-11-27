package Lab5;

class Users{
    public static int userId;

    public int id;

    Users(){
        userId=userId+1;
        this.id=userId;
        System.out.println("Lab5.User "+userId+" has been created:"+id);
    }
}
public class User {
    public static void main(String[] args) {
        Users  user1=new Users();
        Users  user2=new Users();
        Users  user3=new Users();
        Users  user4=new Users();
        Users  user5=new Users();
        Users  user6=new Users();
        Users  user7=new Users();

    }

}
