package cn.neud.concurrent;

public class ThreadState {

    public static void main(String[] args) {
//        newRunnableTerminated();
        blocked();
    }

    static final Object LOCK = new Object();

    public static void b() {
        Thread t2 = new Thread(() -> {
            synchronized (LOCK) {
                System.out.println("before waiting");
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2");
        LOCK.notify();
    }

    public static void blocked() {
        Thread t2 = new Thread(() -> {
            System.out.println("before sync");
            synchronized (LOCK) {
                System.out.println("in sync");
            }
        }, "t2");

        t2.start();
        System.out.println(t2.getState());
        synchronized (LOCK) {
            System.out.println(t2.getState());
        }
        System.out.println(t2.getState());
    }

    public static void newRunnableTerminated() {
        Thread t1 = new Thread(() -> System.out.println("running..."));

        System.out.println("state: " + t1.getState()); // 1
        t1.start();
        System.out.println("state: " + t1.getState()); // 2

        System.out.println("state: " + t1.getState()); // 3
    }
}
