package com.viclim.soup.application;

import com.viclim.thread.Find_New_Instrument_Job;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class Trading implements Runnable {
    private int count;

    private Map<String,String> mInstruments = new HashMap<>();

    public Trading(){
        // Initialize
        this.count = 1;
        // Default Portfolio
        this.mInstruments.put("OCBC.SI","OCBC BANK");
        this.mInstruments.put("UOB.SI","UOB BANK");
        System.out.println("Portfolio loaded");
    }

    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<String> newInstrument = new Find_New_Instrument_Job();
        Future<String> futureInstrument = executorService.submit(newInstrument);

//        while(true) {
//            try {
//                if (futureInstrument.get() != null | !futureInstrument.get().isEmpty()) {
//                    this.mInstruments.put("NEW_" + this.count, futureInstrument.get());
//                }
//                System.out.println("TRADE #" + this.count);
//                this.mInstruments.forEach((sInsCode, sInsName) -> {
//                    System.out.println("Instrument [" + sInsName + "] is currently traded at $$");
//                });
//                System.out.println("\n");
//                this.count++;
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
        while(true){
            try {
                System.out.println("# Trade " + this.count);
                this.mInstruments.forEach((sInsCode, sInsName) -> {
                    System.out.println("Instrument [" + sInsName + "] ");
                });
                System.out.println("\n");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
