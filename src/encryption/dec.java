package encryption;

import java.util.Scanner;

public class dec {

    public static void MainMenu() {
        System.out.println("Welcome to the main menu of decryption: "
                + "\n Enter the code to be decrypted:");

        Scanner s = new Scanner(System.in);
        String code = s.nextLine();
        System.out.println(dec(code));
        Main.MainMenu();
    }

    public static String dec(String code) {
        String one, two;
        one = decryption2(code);
        two = decryption(one);
        return two;
    }

    public static String decryption(String code) {
        char[] ch = code.toCharArray();
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '5' || ch[i] == '6' || ch[i] == '%' || ch[i] == '^' || ch[i] == '9') {
                count++;
            }
        }
        char[] ch2 = new char[count];
        for (int j = 0; j < ch.length; j++) {
            if (ch[j] == '5' || ch[j] == '6' || ch[j] == '%' || ch[j] == '^' || ch[j] == '9') {
                if (count2 % 10 != 4 && count2 % 10 != 9) {
                    if (ch[j] == '9') {
                        ch2[count2] = ' ';
                        count2++;
                    } else {
                        ch2[count2] = ch[j + 1];
                        count2++;
                    }
                } else if (count2 % 10 == 4 || count2 % 10 == 9) {
                    count2++;
                }
            }
        }
        String dec = new String(ch2);
        return dec;
    }

    public static String decryption2(String code) {
        char[] ch = code.toCharArray();
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '7' || ch[i] == '8') {
                count++;
            }
        }
        char[] ch2 = new char[count];
        for (int j = 0; j < ch.length; j++) {
            if (ch[j] == '7' || ch[j] == '8') {
                ch2[count2] = ch[j + 1];
                count2++;
            }
        }
        String dec = new String(ch2);
        System.out.println(dec);
        return dec;
    }
}
