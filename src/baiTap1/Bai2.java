package baiTap1;

import java.io.*;
import java.util.*;

public class Bai2 {
    static List<String> arr = new ArrayList<>();
    static Set<String> hasSet = new LinkedHashSet<>();
    public static void FileReader() {
        try {
            FileReader fr = new FileReader("E:/new_code/baiTap/input_2/01.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                StringTokenizer st = new StringTokenizer(line, " .,!=+-");
                for (int i = 0; st.hasMoreTokens(); i++) {
//                    System.out.println(i + ": " + st.nextToken());
                    arr.add(st.nextToken());
                }
            }

            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void FileWriter() {
        try {
//          append = true để thêm dữ liệu mà ko ghi đè
            FileWriter fw = new FileWriter("E:/new_code/baiTap/input_2/02.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (String s : arr) {
                bw.write(s);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileReader();
//        FileWriter();
        hasSet.addAll(arr);
        for (String s2 : hasSet) {
            int a = 0;
            for (String s1 : arr) {
                if (s2.equals(s1)) {
                    a++;
                }
            }
            System.out.println(s2 + " : " + a);
        }
    }
}
