package org.example;

import java.io.IOException;

public class Main {
    private static final int SIZE = 300;

    public static void main(String[] args) throws IOException {
        String srcFolder = "C:\\Users\\Слава\\Desktop\\image";
        String dstFolder = "C:\\Users\\Слава\\Desktop\\image1";
        ManageThread.startThread(srcFolder, dstFolder, SIZE);
    }
}