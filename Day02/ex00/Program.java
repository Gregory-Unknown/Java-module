package ex00;

import java.io.*;

public class Program {

    public static void main(String[] args) throws IOException {
        MapReader mr = new MapReader();
        mr.readFile();
        mr.writeFile();
    }

}

