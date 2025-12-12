package Lab7;
class Counter{
    int count=0;

    public synchronized void increment(){
        this.count++;
    }
    public int getCount(){
        return this.count;
    }
}
class SynchronizationThread extends Thread {
    Counter counter;

    public SynchronizationThread(String name,Counter counter) {
        super(name);
        this.counter=counter;
    }

    @Override
    public  void run() {
        for (int i = 1; i <= 1000; i++) {
            counter.increment();
        }
    }
}

public class Que8 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter();
        SynchronizationThread t1 = new SynchronizationThread("Thread-1",counter);
        SynchronizationThread t2 = new SynchronizationThread("Thread-2",counter);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter.getCount());

    }
}
