package Lab7;

class ThreadFunctions extends Thread{
    ThreadFunctions(String name){
        super(name);
    }
    @Override
    public void run() {
        System.out.println("Thread Name:"+Thread.currentThread().getName());
        for(int i=1;i<=5;i++){
            System.out.print(i+",");
        }
        System.out.println();
    }
}
public class Que4 {
    public static void main(String[] args) {
        ThreadFunctions t1=new ThreadFunctions("Thread-1");
        ThreadFunctions t2=new ThreadFunctions("Thread-2");
        ThreadFunctions t3=new ThreadFunctions("Thread-3");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
