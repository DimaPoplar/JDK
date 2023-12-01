package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        File file2 = new File("file.txt");
        try (FileWriter file = new FileWriter(file2)) {
            file.write("asd");
        }
    }
}