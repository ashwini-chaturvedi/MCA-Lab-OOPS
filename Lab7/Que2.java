package Lab7;

class ThreadClass extends Thread{
    ThreadClass(String name){
        super(name);
    }
    @Override
    public void run() {
        System.out.println("Thread Name:"+Thread.currentThread().getName());
        for(int i=1;i<=10;i++){
            System.out.print(i+",");
        }
        System.out.println();
    }
}
class RunnableInterface implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread Name:"+Thread.currentThread().getName()+"\n");
        for(int i=1;i<=10;i++){
            System.out.print(i+",");
        }
        System.out.println();
    }
}
public class Que2 {
    public static void main(String[] args) {
        ThreadClass t1=new ThreadClass("Thread From Class");
        RunnableInterface task=new RunnableInterface();
        Thread t2=new Thread(task);
        t1.start();
        t2.start();
    }
}
