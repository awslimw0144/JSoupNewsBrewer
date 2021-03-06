package com.viclim.soup.application;

import quickfix.*;
import quickfix.field.Account;
import quickfix.field.TradeAllocIndicator;

public class QuickFixServerDemo {
    public static void main(String...args){
        SocketAcceptor socketAcceptor = null;
        try {
            SessionSettings executorSettings = new SessionSettings(
                    "./acceptorSettings.txt");
            Application application = new TradeAppAcceptor();
            FileStoreFactory fileStoreFactory = new FileStoreFactory(
                    executorSettings);
            MessageFactory messageFactory = new DefaultMessageFactory();
            FileLogFactory fileLogFactory = new FileLogFactory(executorSettings);
            socketAcceptor = new SocketAcceptor(application, fileStoreFactory,
                    executorSettings, fileLogFactory, messageFactory);
            socketAcceptor.start();
        } catch (ConfigError configError) {
            configError.printStackTrace();
        } finally {
            socketAcceptor.stop();
        }
    }
}
