package com.viclim.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Find_New_Instrument_Job implements Runnable, Callable {

    private String instrument;

    @Override
    public void run() {
        for(int i=0; i<200; i++){
            System.out.println("Finding new instrument attempt #" + i);

            // Mock interrupt
            if(i==1){
                this.instrument = "DBS.SI";
                System.out.println("Instrument found : "+this.instrument+ " at attempt #" + i);
            }
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object call() {
        for(int i=0; i<200; i++){
            System.out.println("Finding new instrument attempt #" + i);

            // Mock interrupt
            if(i==4){
                this.instrument = "DBS.SI";
                System.out.println("Instrument found : "+this.instrument+ " at attempt #" + i);
            }
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.instrument;
    }
}
