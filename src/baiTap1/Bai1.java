package baiTap1;

import java.util.LinkedHashSet;
import java.util.Set;

public class Bai1 {
    static int max = 4900000;
    static int min = 1000000;
    static int range = (max - min) + 1;
    static Set<Integer> set1 = new LinkedHashSet<>();
    static Set<Integer> set11 = new LinkedHashSet<>();
    static Set<Integer> set2 = new LinkedHashSet<>();

    public static Set<Integer> Random1() {
        int random;
        while (set1.size() < 2000000) {
            random = Integer.valueOf((int) (Math.random() * range) + min);
            set1.add(random);
        }
        set11.addAll(set1);
        return set1;
    }

    public static Set<Integer> Random2() {
        int random;
        while (set2.size() < 2000000) {
            random = Integer.valueOf((int) (Math.random() * range) + min);
            set2.add(random);
        }
        return set2;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Random1();
        Random2();
        System.out.println("số lượng phần tử tập 1 là: "+set1.size());
        System.out.println("số lượng phần tử tập 2 là: "+set2.size());
        set1.addAll(set2);
        System.out.println("số lượng phần tử tập hợp là: "+set1.size());
        set11.retainAll(set2);
        System.out.println("số lượng phần tử tập giao là: "+set11.size());
        long end = System.currentTimeMillis();
        System.out.println("thời gian chạy là: "+ (end - start) +" Millisecond");
    }
}
