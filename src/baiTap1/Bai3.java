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
    static List<Word> arrWord = new ArrayList<>();

    static String nameFolder = "E:/new_code/baiTap/input_3/";
    static String s;
    static int x = 0;

    public static class Word{
        private String name;
        private  int number;

        public Word(String name, int number) {
            this.name = name;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Word{" +
                    "name='" + name + '\'' +
                    ", number=" + number +
                    '}';
        }
    }
    public static class Act implements Callable<String> {
        @Override
        public String call() throws Exception {
            synchronized (this) {
                s = nameFolder + listOfFiles[x].getName();
                call2(s);
                x++;
            }
            return null;
        }

        public void call2(String sS) {
            try {
                FileReader fr = new FileReader(sS);
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
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(6);
        Callable<String> act = new Act();

        for (File file : listOfFiles) {
            executor.submit(act);
        }

        executor.shutdown();
        if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
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
                arrWord.add(new Word(s2,a));
                System.out.println(s2 + " : " + a + " lần xuất hiện");
            }

//            Collections.sort(arrWord, new Comparator<Word>() {
//                @Override
//                public int compare(Word o1, Word o2) {
//                    return o1.number - o2.number;
//                }
//            });


        } else {
        }
    }
}
