package Lab7;

class Counters {
    int count = 0;
    static int staticCount = 0;

    public synchronized void increment() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public synchronized static void incrementStatic() {
        staticCount++;
    }

    public static int getStaticCount() {
        return staticCount;
    }
}

class StaticSyncThread extends Thread {
    boolean isStatic;
    Counters counters;

    StaticSyncThread(String name, boolean flag, Counters counters) {
        super(name);
        this.isStatic = flag;
        this.counters = counters;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100000; i++) {    // INCREASE workload
            if (isStatic) {
                Counters.incrementStatic();
            } else {
                counters.increment();
            }
        }
    }
}

public class Que10 {
    public static void main(String[] args) throws InterruptedException {


        Counters counters = new Counters(); // one object for instance race test

        StaticSyncThread t1 = new StaticSyncThread("T1", false, counters);
        StaticSyncThread t2 = new StaticSyncThread("T2", false, counters);
        StaticSyncThread t3 = new StaticSyncThread("T3", true, null);
        StaticSyncThread t4 = new StaticSyncThread("T4", true, null);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Instance Count (Race Condition): " + counters.getCount());
        System.out.println("Expected Instance Count: 200000");

        System.out.println("Static Count (Race Condition): " + Counters.getStaticCount());
        System.out.println("Expected Static Count: 200000");


    }
}
