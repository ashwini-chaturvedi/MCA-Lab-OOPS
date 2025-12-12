package Lab7;

class ThreadLifecycle extends Thread {
    @Override
    public void run() {
        System.out.println("State After Start:" + Thread.currentThread().getState());

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(5000);
                System.out.println(i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }
}

public class Que3 {
    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycle t1 = new ThreadLifecycle();//NEW
        System.out.println("State After Creation:" + t1.getState());
        t1.start();//RUNNABLE
        Thread.sleep(300);  // small delay so we catch TIMED_WAITING
        System.out.println("State in Main Loop: " + t1.getState());


        t1.join();
        System.out.println("State After Termination:" + t1.getState());


    }
}
