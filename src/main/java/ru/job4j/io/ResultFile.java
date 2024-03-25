package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("data/dataresult.txt")) {
            for (int i = 1; i <= 10; i++) {
                String rsl = "1 * " + i + " = " + i;
                output.write(rsl.getBytes());
                output.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
