package baiTap1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai7 {

    public static void uRL() {
        Scanner scanner = new Scanner(System.in);
        String url = "";
        while (true){
            System.out.println("mời nhâp URL :");
            url = scanner.nextLine();
            Pattern p = Pattern.compile("^http(s|)://[a-zA-Z0-9]+\\.[a-z]{2,6}\\S+$");
            if (p.matcher(url).find()) {
                System.out.println("URL được chấp nhận là: " + url);
            }else {
                System.err.println("URL không được chấp nhận là: " + url);
            }
        }
    }

    public static void main(String[] args) {
        uRL();
    }
}
