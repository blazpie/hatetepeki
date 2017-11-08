package com.blazpie;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.*;

public class Hello implements HttpHandler {


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        List<String> list = new ArrayList<>();
        list.add("UTF-8");




        String response = marcinsMethod(httpExchange.getRequestURI()).toString();

        Headers h =  httpExchange.getResponseHeaders();
        h.put("Charset", list);
        httpExchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();

        os.write(response.getBytes());
        os.close();

        httpExchange.close();
    }

    private Map<String,String> marcinsMethod(URI uri) {

        String value = uri.toString();

        Map<String, String> map = new HashMap<>();
        List<String> list =  Arrays.asList(value.split("/"));

        String string3 = "";
        for(int i=1; i<list.size(); i++) {
            if(i == 1) {
                map.put("controller", list.get(i));
            } else if (i==2){
                map.put("method", list.get(i));
            } else {
                string3 += "/"  + list.get(i);
            }
        }
        if (string3.length() > 0) map.put("data", string3);
        return map;

    }
}
