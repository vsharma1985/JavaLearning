package com.sample.learning;
public class Immutable {
     private final int value;

     public Immutable(int value) {
         this.value = value;
     }

     public int getValue() {
         return value;
     }
}