package com.singletonexample;


public class SingletonTest {
 public static void main(String[] args) {
     // Get Logger instance 1
     Logger logger1 = Logger.getInstance();
     logger1.log("First message");

     // Get Logger instance 2
     Logger logger2 = Logger.getInstance();
     logger2.log("Second message");

     // Verify both references are the same
     if (logger1 == logger2) {
         System.out.println("Both logger1 and logger2 are the same instance.");
     } else {
         System.out.println("Different instances (this should not happen!).");
     }
 }
}
