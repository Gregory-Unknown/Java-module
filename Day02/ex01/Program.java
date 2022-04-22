package ex01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Bad number of argument");
            System.exit(-1);
        }
        Similarity similarity = new Similarity(args[0], args[1]);
        similarity.start();
    }

}

