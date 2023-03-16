package org.example.task4;
public class A {
    public static void main(String[] args) {
//        Create a thread that waits for a signal from another thread using wait and notify.

        Object lock = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 1: Waiting signal from Thread 2");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Signal received from Thread 2");
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2: Preparing to send signal to Thread 1");
                try {
                    Thread.sleep(2000); // Simulate some processing time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify(); // Thread B sends signal to Thread A
                System.out.println("Thread 2: Signal sent to Thread 1");
            }
        });

        thread1.start();
        thread2.start();
    }
}
