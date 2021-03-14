package com.viclim.soup.application;

import com.ib.controller.*;
import com.viclim.utils.connection.ConnectionHandlerImplementation;
import com.viclim.utils.logger.LoggerImplementation;

public class TWS_Conn {

    //We need instances of our logger implementation
    static LoggerImplementation inLogger = new LoggerImplementation();
    static LoggerImplementation outLogger = new LoggerImplementation();
    //We need an instance of our connection handler implementation
    static ConnectionHandlerImplementation connectionHandler = new ConnectionHandlerImplementation();
    //We need an instance of the ApiController
    static ApiController apiController = new ApiController(connectionHandler, inLogger, outLogger);

    public static void main(String... args){
        System.out.println("Attempting to connect");
        apiController.connect("localhost", 7497, 0);
    }
}
