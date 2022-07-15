package baiTap1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Bai4 {
    static int max1 = 1200;
    static int min1 = 400;
    static int range1 = (max1 - min1);
    static Set<Point> set1 = new HashSet<>();

    static int max2X = 4500;
    static int min2X = 3500;
    static int max2Y = 1300;
    static int min2Y = 300;
    static int range2X = (max2X - min2X);
    static int range2Y = (max2Y - min2Y);
    static Set<Point> set2 = new HashSet<>();

    static int max3 = 3000;
    static int min3 = 1800;
    static int range3 = (max3 - min3);
    static Set<Point> set3 = new HashSet<>();

    static Set<Point> setAll = new HashSet<>();

    public static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " ; " + y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static Set<Point> Random1() {
        int randomX;
        int randomY;
        while (set1.size() < 8000) {
            randomX = Integer.valueOf((int)(Math.random() * range1) + min1);
            randomY = Integer.valueOf((int)(Math.random() * range1) + min1);
            if (Math.sqrt((randomX-800)*(randomX-800) + (randomY-800)*(randomY-800)) < 400) {
                set1.add(new Point(randomX,randomY));
            }
        }
        return set1;
    }

    public static Set<Point> Random2() {
        int randomX;
        int randomY;
        while (set2.size() < 10000) {
            randomX =  Integer.valueOf((int)(Math.random() * range2X) + min2X);
            randomY =  Integer.valueOf((int)(Math.random() * range2Y) + min2Y);
            if (Math.sqrt((randomX-4000)*(randomX-4000) + (randomY-800)*(randomY-800)) < 500) {
                set2.add(new Point(randomX,randomY));
            }
        }
        return set2;
    }

    public static Set<Point> Random3() {
        int randomX;
        int randomY;
        while (set3.size() < 12000) {
            randomX =  Integer.valueOf((int)(Math.random() * range3) + min3);
            randomY =  Integer.valueOf((int)(Math.random() * range3) + min3);
            if (Math.sqrt((randomX-2400)*(randomX-2400) + (randomY-2400)*(randomY-2400)) < 600) {
                set3.add(new Point(randomX,randomY));
            }
        }
        return set3;
    }

    public static void main(String[] args) {
        Random1();
        Random2();
        Random3();
        System.out.println(set1.size());
        System.out.println(set2.size());
        System.out.println(set3.size());

        for (Point p : set1) {
            setAll.add(p);
        }
        for (Point p : set2) {
            setAll.add(p);
        }
        for (Point p : set3) {
            setAll.add(p);
        }
        System.out.println(setAll.size());

        try {
//          append = true để thêm dữ liệu mà ko ghi đè
            FileWriter fw = new FileWriter("Bai4.data.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Point point : setAll) {
                bw.write(point.toString());
                bw.newLine();
            }

            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
