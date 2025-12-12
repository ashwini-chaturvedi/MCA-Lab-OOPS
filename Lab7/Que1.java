package Lab7;

class MyThread extends Thread{
    boolean isOdd;
    int num;
    MyThread(String name,boolean flag,int num){
        super(name);
        this.isOdd=flag;
        this.num=num;
    }

    @Override
    public void run() {
        for(int i=1;i<=num;i++){
            if(isOdd){
                if(i%2!=0) System.out.print("Thread Name:"+Thread.currentThread().getName()+" Odd:"+i+"\n");
            }else{
                if(i%2==0) System.out.print("Thread Name:"+Thread.currentThread().getName()+" Even:"+i+"\n");
            }
        }
    }
}
public class Que1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1=new MyThread("Thread-1",true,10);
        MyThread t2=new MyThread("Thread-2",false,10);

        t1.start();

        t2.start();
    }
}
