package com.blazpie;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            ServerConnection s = new ServerConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
