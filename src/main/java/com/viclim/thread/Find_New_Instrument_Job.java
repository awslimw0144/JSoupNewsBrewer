package com.viclim.thread;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Find_New_Instrument_Job implements Runnable, Callable {

    private String instrument;
    private int count;
    public Find_New_Instrument_Job(){
        this.count = 0;
    }

    @Override
    public void run() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("INSTRUMENT FOUND : ");
//        return userInput.nextLine();
    }

    @Override
    public Object call() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("INSTRUMENT FOUND : ");
        return userInput.nextLine();
    }
}
