package Lab7;

class DaemonThreads extends Thread {
    int num;

    DaemonThreads(String name, int val) {
        super(name);
        this.num = val;
    }

    @Override
    public void run() {
        for (int i = 1; i <= num; i++) {
            System.out.println("Thread Name: " + getName() + " Count: " + i);

            try {
                Thread.sleep(3000); // slow down so behavior is visible
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Que5 {
    public static void main(String[] args) {
        DaemonThreads t1 = new DaemonThreads("User Thread", 20);
        DaemonThreads t2 = new DaemonThreads("Daemon Thread", 100);

        t2.setDaemon(true); // must be set BEFORE start()

        t1.start();  // user thread
        t2.start();  // daemon thread

        System.out.println("Main Thread Finished");
    }
}
