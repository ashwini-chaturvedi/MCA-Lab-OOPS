package Lab7;


class Buffer {
    private int data;
    private boolean hasData = false; // buffer is initially empty

    // Producer puts data
    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait();  // wait until consumer consumes
        }

        data = value;
        hasData = true;

        System.out.println("Produced: " + value);

        notify();   // notify consumer
    }

    // Consumer takes data
    public synchronized int consume() throws InterruptedException {
        while (!hasData) {
            wait();  // wait until producer produces
        }

        int value = data;
        hasData = false;

        System.out.println("Consumed: " + value);

        notify();   // notify producer
        return value;
    }
}

class Producer extends Thread {
    Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.produce(i);
                Thread.sleep(500); // simulate work
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.consume();
                Thread.sleep(500); // simulate work
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Que11 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
