package org.example.deadlock;

import java.awt.desktop.SystemSleepEvent;

public class TestDeadlockExample {
    public static void main(String[] args) {
        final String resource1 = "ratan jaiwal";
        final String resource2 = "ratan jaiwal";
        Thread t1 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1: locekd resource 1");
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                    }

                    synchronized (resource2) {
                        System.out.println("Thread 1: locekd resource 2");
                    }
                }
            }
        };

        Thread t2 = t2.run(); {
            synchronized (resource2) {
                System.out.println("Thread 2: locekd resource 2");
            }
            try {
                Thread.sleep(200);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }}
