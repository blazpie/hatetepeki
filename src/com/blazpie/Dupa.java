package com.blazpie;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class Dupa implements HttpHandler{
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
//        String response = "";
//
//        Headers h =  httpExchange.getResponseHeaders();
//        h.put("Location", Arrays.asList(new String[]}));
//        httpExchange.sendResponseHeaders(302, response.getBytes().length);
//        OutputStream os = httpExchange.getResponseBody();
        httpExchange.getResponseHeaders().set("Location", "/hello");
        httpExchange.sendResponseHeaders(302, -1);
    }
}
