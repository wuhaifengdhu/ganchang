package com.gan.chang;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MyQueue{
    static class Book{
        String name;
        int priority;
        Book(String name, int priority){
            this.name = name;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", priority=" + priority +
                    '}';
        }
    }
    public static void main(String[] args){
        PriorityQueue<Book> myQueue = new PriorityQueue<Book>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.priority - o2.priority;
            }
        });
        myQueue.add(new Book("some one like", 1));
        myQueue.add(new Book("some one like", 12));
        myQueue.add(new Book("some one like", 13));
        myQueue.add(new Book("some one like", 11));
        myQueue.add(new Book("some one like", 1));
        while (! myQueue.isEmpty()){
            System.out.println(myQueue.poll());
        }
    }

}
