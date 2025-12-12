import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

 class EnterpriseNumberProcessor {

    // --- Configuration Constants ---
    private static final int NUM_WORKER_THREADS = 4;
    private static final int TOTAL_NUMBERS_TO_PROCESS = 50;
    private static final int QUEUE_CAPACITY = 10;
    private static final int POISON_PILL = -1; // Signal to stop threads

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   HIGH-PERFORMANCE NUMBER PROCESSOR SYSTEM");
        System.out.println("=================================================");
        System.out.println("Initializing System...");

        // 1. Thread-Safe Queue
        // Acts as a buffer between the Producer and Consumers
        BlockingQueue<Integer> taskQueue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

        // 2. Thread-Safe Result Storage
        // CopyOnWriteArrayList is safe for concurrent writing
        List<ProcessingResult> results = new CopyOnWriteArrayList<>();

        // 3. Statistics Counters (Atomic for thread safety)
        AtomicInteger successCount = new AtomicInteger(0);
        AtomicInteger totalProcessed = new AtomicInteger(0);

        // 4. Create the Thread Pool for Workers
        ExecutorService workerPool = Executors.newFixedThreadPool(NUM_WORKER_THREADS);

        // 5. Start the Producer (The "Generator")
        // We run this in a separate single thread
        Thread producerThread = new Thread(new NumberGenerator(taskQueue, TOTAL_NUMBERS_TO_PROCESS));
        producerThread.setName("Producer-Thread");
        producerThread.start();

        // 6. Start the Consumers (The "Workers")                                     
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUM_WORKER_THREADS; i++) {
            workerPool.submit(new NumberWorker(taskQueue, results, successCount, totalProcessed));
        }

        // 7. Shutdown Sequence
        // We wait for the producer to finish generating numbers
        try {
            producerThread.join();
            System.out.println("\n[System] All numbers generated. Waiting for workers to drain queue...");

            // Initiate graceful shutdown of workers
            workerPool.shutdown();
            workerPool.awaitTermination(1, TimeUnit.MINUTES);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("System interrupted during operation.");
        }

        long endTime = System.currentTimeMillis();

        // 8. Final Report
        printReport(results, totalProcessed.get(), successCount.get(), (endTime - startTime));
    }

    private static void printReport(List<ProcessingResult> results, int total, int primes, long duration) {
        System.out.println("\n=================================================");
        System.out.println("             FINAL PROCESSING REPORT             ");
        System.out.println("=================================================");
        System.out.println("Total Duration      : " + duration + " ms");
        System.out.println("Total Numbers Scanned: " + total);
        System.out.println("Prime Numbers Found  : " + primes);
        System.out.println("Non-Prime Numbers    : " + (total - primes));
        System.out.println("-------------------------------------------------");
        System.out.println("Last 5 Results Log:");

        // Show last 5 entries as a sample
        int start = Math.max(0, results.size() - 5);
        for (int i = start; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
        System.out.println("=================================================");
    }
}

/**
 * COMPONENT 1: THE PRODUCER
 * Generates random numbers and puts them into the shared queue.
 */
class NumberGenerator implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final int limit;
    private final Random random;

    public NumberGenerator(BlockingQueue<Integer> queue, int limit) {
        this.queue = queue;
        this.limit = limit;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < limit; i++) {
                int num = random.nextInt(10000) + 1;
                System.out.println("[Producer] Generated: " + num);

                // .put() blocks if the queue is full (Backpressure handling)
                queue.put(num);

                // Artificial delay to simulate data fetching
                Thread.sleep(50);
            }

            // Add Poison Pills (One for each worker thread to ensure they all stop)
            // Note: In this simplified version, we just let the Executor shutdown handle it,
            // but explicitly adding -1 is a robust pattern.
            for(int i=0; i<4; i++) {
                queue.put(-1);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/**
 * COMPONENT 2: THE CONSUMER
 * Takes numbers from the queue and performs heavy calculation.
 */
class NumberWorker implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final List<ProcessingResult> results;
    private final AtomicInteger successCounter;
    private final AtomicInteger processedCounter;

    public NumberWorker(BlockingQueue<Integer> queue,
                        List<ProcessingResult> results,
                        AtomicInteger successCounter,
                        AtomicInteger processedCounter) {
        this.queue = queue;
        this.results = results;
        this.successCounter = successCounter;
        this.processedCounter = processedCounter;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            while (true) {
                // .take() blocks if the queue is empty (waits for work)
                Integer number = queue.take();

                // Check for Poison Pill (Stop signal)
                if (number == -1) {
                    break;
                }

                // Perform heavy processing
                boolean isPrime = checkPrime(number);

                // Record statistics
                processedCounter.incrementAndGet();
                if (isPrime) {
                    successCounter.incrementAndGet();
                }

                // Create a result object and save it
                ProcessingResult result = new ProcessingResult(threadName, number, isPrime);
                results.add(result);

                // Optional: Print live status
                // System.out.println("\t -> " + threadName + " finished " + number);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // CPU Intensive Task
    private boolean checkPrime(int num) {
        if (num <= 1) return false;
        // Inefficient algorithm chosen on purpose to consume CPU cycles
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

/**
 * COMPONENT 3: DATA MODEL
 * Represents a single unit of completed work.
 */
class ProcessingResult {
    private final String processorName;
    private final int number;
    private final boolean isPrime;
    private final long timestamp;

    public ProcessingResult(String processorName, int number, boolean isPrime) {
        this.processorName = processorName;
        this.number = number;
        this.isPrime = isPrime;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return String.format("Time: %d | Worker: %-15s | Number: %-5d | Prime: %s",
                timestamp, processorName, number, isPrime ? "YES" : "NO");
    }
}

public class Solution {


    public static void main(String[] args) {


    }
}
