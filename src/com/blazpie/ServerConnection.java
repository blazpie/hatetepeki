package com.blazpie;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerConnection {

    HttpServer serv;

    public ServerConnection () throws IOException {
        serv = HttpServer.create(new InetSocketAddress(8800), 0);
        serv.createContext("/hello", new Hello());
        serv.createContext("/dupa", new Dupa());
        serv.setExecutor(null);
        serv.start();
    }




}
