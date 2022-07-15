package baiTap1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Bai3 {
    static File folder = new File("E:/new_code/baiTap/input_3");
    static File[] listOfFiles = folder.listFiles();

    static List<String> arr = new ArrayList<>();
    static Set<String> hasSet = new LinkedHashSet<>();

    static String s;
    public static class Act implements Callable<String>{

        @Override
        public String call() throws Exception {


                    try {
                        FileReader fr = new FileReader(s);
                        BufferedReader br = new BufferedReader(fr);
                        String line = "";
                        while (true) {
                            line = br.readLine();
                            if (line == null) {
                                break;
                            }
                            StringTokenizer st = new StringTokenizer(line, " .,!=+-");
                            for (int j = 0; st.hasMoreTokens(); j++) {
                                arr.add(st.nextToken());
                            }
                        }

                        br.close();
                        fr.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            return null;
        }
    }



    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(6);
        Callable<String> act = new Act();


        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("E:/new_code/baiTap/input_3/");
                stringBuilder.append(listOfFiles[i].getName());
                 s = stringBuilder.toString();

                executor.submit(act);
            }
        }

//        for (int i = 0; i < 3; i++) {
//            executor.submit(act);
//        }
        executor.shutdown();
        if(executor.awaitTermination(100, TimeUnit.SECONDS)) {
            System.out.println("do chay xong");
            for (String s1 : arr) {
                hasSet.add(s1);
            }
            for (String s2 : hasSet) {
                int a = 0;
                for (String s1 : arr) {
                    if (s2.equals(s1)) {
                        a++;
                    }
                }
                System.out.println(s2 + " : " + a);
            }
        }else {
            System.out.println("do hết giờ");
        }
    }
}
