package ex00;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapReader {
    private Map<String, String> map;

    public MapReader() {
        map = new HashMap<>();
    }
    public void readFile() throws IOException {
        FileInputStream fileInput = new FileInputStream("/Users/esobchak/Desktop/Day02/src/ex00/signature.txt");
        Scanner scanner = new Scanner(fileInput);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] value = str.split(", ");
            map.put(value[1].replaceAll("\\s+", ""), value[0]);
        }
        scanner.close();
        fileInput.close();
    }
    public void writeFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/esobchak/Desktop/Day02/src/ex00/result.txt", true);
        Scanner scan = new Scanner(System.in);
        String input;
        while (!(input = scan.nextLine()).equals("42")) {

            try {
                FileInputStream file = new FileInputStream(input);
                StringBuilder strHex = new StringBuilder();

                for (int i = 0; i < 16; ++i)
                    strHex.append(String.format("%02X", file.read()));
                int flag = 0;
                for (String item : map.keySet()) {
                    String tmp = strHex.toString();
                    String value = "";
                    if (tmp.startsWith(item)) {
                        value = map.get(item);
                        fileOutputStream.write(value.getBytes());
                        fileOutputStream.write('\n');
                        flag = 1;
                        System.out.println("PROCESSED");
                    }
                }
                if (flag == 0)
                    System.out.println("UNDEFINED");
            } catch (IOException e) {
                e.printStackTrace();
                scan.close();
                fileOutputStream.close();

            }
            scan.close();
            fileOutputStream.close();
        }
    }
}
