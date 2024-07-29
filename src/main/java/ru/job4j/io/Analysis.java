package ru.job4j.io;

import java.io.*;

public class Analysis {

    public void unavailable(String source, String target) {
        try (BufferedReader input = new BufferedReader(new FileReader(source));
             PrintWriter output = new PrintWriter(new FileOutputStream(target))) {

             String line;
             boolean isUnavailable = false;
             String startTime = "";
             String endTime = "";

             while ((line = input.readLine()) != null) {
                 String[] arr = line.split(" ");
                 String status = arr[0];
                 String time = arr[1];

             if (!isUnavailable && (status.equals("400") || status.equals("500"))) {
                 isUnavailable = true;
                 startTime = time;
             } else if (isUnavailable && (status.equals("200") || status.equals("300"))) {
                 isUnavailable = false;
                 endTime = time;
                 output.write(String.format("%s; %s;\n", startTime, endTime));
             }

             }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
