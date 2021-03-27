package com.viclim.soup.application;

import com.viclim.thread.Find_New_Instrument_Job;

public class Active_PortFolio {
    /**
     *  Thread Lifecycle
     *  NEW
     *  RUNNABLE  <--- WAITING
     *    ^  |            ^
     *    |  v            |
     *  RUNNING   --------
     *  TERMINATED
     */
    public static void main(String...args) throws InterruptedException {
        // Initialization !
        Runnable rFindNewInstrument = new Find_New_Instrument_Job();
        Runnable rTrading = new Trading();

        // Assign a job to each thread
        Thread job_Find_New_Instrument = new Thread(rFindNewInstrument);
        Thread job_Perform_Trading = new Thread(rTrading);

        job_Perform_Trading.start();
        job_Find_New_Instrument.start();
    }
}


/**
 * NOTE
 * Multithread : https://programmingsoup.com/multithreading-in-java
 * API TEST DOC FORQUANT : https://iexcloud.io/docs/api/
 */