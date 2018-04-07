package com.haifwu;

public class TestRunnable implements Runnable{
    private static int taskCount = 0;
    private final int id = taskCount ++;

    public TestRunnable(){
        System.out.println("Message in construct method! " + id);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Message " + i + " from " + this.getClass() + " " + id);
            Thread.yield();
        }
        System.out.println("Runnable " + id + " finished!");
    }
}
