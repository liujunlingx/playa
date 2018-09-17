package com.company.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellUtil {

    public static void main(String[] args) {

        execShell("mkdir /Users/liujunling/work");

    }

    private static void execShell(String cmd){
        BufferedReader reader;
        Process process;
        try {
            process = Runtime.getRuntime().exec(cmd);
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            for(String line = reader.readLine();line != null;line = reader.readLine()){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
