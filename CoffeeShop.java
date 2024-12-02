import java.util.concurrent.locks.*;

public class CoffeeShop {
    private static final int MAX_CAPACITY = 3; // Maximum counter capacity
    private static int counter = 0;           // Current coffee count on the counter
    private static final Lock lock = new ReentrantLock();
    private static final Condition counterFull = lock.newCondition();
    private static final Condition counterEmpty = lock.newCondition();

    public static void main(String[] args) {
        Thread barista1 = new Thread(() -> barista("Barista 1"));
        Thread barista2 = new Thread(() -> barista("Barista 2"));
        Thread customer1 = new Thread(() -> customer("Customer 1"));
        Thread customer2 = new Thread(() -> customer("Customer 2"));
        Thread customer3 = new Thread(() -> customer("Customer 3"));
        Thread reviewer = new Thread(() -> coffeeReviewer("Coffee Reviewer"));

        barista1.start();
        barista2.start();
        customer1.start();
        customer2.start();
        customer3.start();
        reviewer.start();
    }

    private static void barista(String name) {
        try {
            while (true) {
                lock.lock();
                try {
                    while (counter == MAX_CAPACITY) {
                        System.out.println(name + " is waiting. Counter is full.");
                        counterFull.await();
                    }
                    counter++;
                    System.out.println(name + " prepared coffee. Counter: " + counter);
                    counterEmpty.signalAll();
                } finally {
                    lock.unlock();
                }
                Thread.sleep(1000); // Simulate time to prepare coffee
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void customer(String name) {
        try {
            while (true) {
                lock.lock();
                try {
                    while (counter == 0) {
                        System.out.println(name + " is waiting. Counter is empty.");
                        counterEmpty.await();
                    }
                    counter--;
                    System.out.println(name + " picked up coffee. Counter: " + counter);
                    counterFull.signalAll();
                } finally {
                    lock.unlock();
                }
                Thread.sleep(1500); // Simulate time to drink coffee
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void coffeeReviewer(String name) {
        try {
            while (true) {
                lock.lock();
                try {
                    while (counter == 0) {
                        System.out.println(name + " is waiting. Counter is empty.");
                        counterEmpty.await();
                    }
                    counter--;
                    System.out.println(name + " sampled coffee. Counter: " + counter);
                    System.out.println("Barista 1 is notified. Counter is empty.");
                    System.out.println("Barista 2 is notified. Counter is empty.");
                    counterFull.signalAll();
                } finally {
                    lock.unlock();
                }
                Thread.sleep(2000); // Simulate time to review coffee
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
