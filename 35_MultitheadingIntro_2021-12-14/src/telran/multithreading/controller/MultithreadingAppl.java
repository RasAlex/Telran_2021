package telran.multithreading.controller;

import telran.multithreading.tasks.MyTaskExtends;
import telran.multithreading.tasks.MyTaskImplements;

public class MultithreadingAppl {
    public static final int MAX = 10;
    private static final int SIZE = 3;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starting...");
        MyTaskImplements task1 = new MyTaskImplements("TaskImplements",MAX);
        Thread thread1 = new Thread(task1);
        Thread thread2 = new MyTaskExtends("TaskExtends", MAX);
        MyTaskImplements[] tasks = new MyTaskImplements[SIZE];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new MyTaskImplements("Name#"+ i, MAX);
        }
        Thread[] threads = new Thread[SIZE];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(tasks[i]);
        }
        for (Thread value : threads) {
            value.start();
            //threads[i].join();

        }
        thread1.start();
        thread2.start();
        //task1.run();
        for (int i = 0; i < MAX; i++) {
            System.out.println("Thread Main , count = " +i);
            Thread.sleep(1);

        }
        thread1.join(); //Ожидание завершения треда1
        thread2.join();
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Main thread end");
    }
}
