package encryption;

import java.util.Random;
import java.util.Scanner;

public class enc {

    public static void MainEnc() {
        // main menu of the encryption
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Encryption menu:"
                + "\nEnter the Phrase you wish to Encrypt: ");
        String Phrase = s.nextLine();
        System.out.println(encr(Phrase));
        Main.MainMenu();
    }

    public static String encr(String Phrase) {
        String enc;
        String full;
        enc = Encrypting(Phrase);
        full = Encrypting2(SpaceChecker(enc));

        return full;
    }

    
    
    public static char RanLet() {
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '1', '2', '3', '4', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'S',
            'R', 'T', 'U', 'V', 'X', 'Y', 'Z', '*', '+', '=', '&', '$', '@'};
        Random r = new Random();
        char Letter = alphabet[r.nextInt(alphabet.length)];
        return Letter;
    }

    public static String RanLets(int i) {
        String Letters = "5";
        Letters = Letters + RanLet();
        Letters = Letters.substring(1);

        for (int j = 0; j < i - 1; j++) {
            Letters = Letters + RanLet();
        }
        return Letters;
    }

    public static char[] Shifting(char[] phrase) {
        int sc;
        if (phrase.length >= 4) {
            sc = 4;
        } else {
            sc = phrase.length;
        }
        char[] phrase2 = new char[phrase.length - sc];
        for (int i = 0; i < phrase2.length; i++) {
            phrase2[i] =  phrase[i + sc];
        }

        return phrase2;
    }

    public static String mark1() {
        Random r = new Random();
        String[] mark1 = {"5", "6", "%", "^"};
        return mark1[r.nextInt(4)];
    }

    public static String Encrypting(String Phrase) {
        char[] PH = Phrase.toCharArray();
        
        Random r = new Random();
        String enc = null;
        String full = null;
        int count;
        count = PH.length;
        char[] SC1;

        int sc;
        for(int i=0;i<count;i++){
            if (PH.length >= 4) {
                sc = 4;

            } else {
                sc = PH.length;
            }
            SC1 = new char[sc + 1];
            for (int j = 0; j < sc; j++) {
                if (PH[j] == ' ') {
                    PH[j] = '9';
                }
                SC1[j] = PH[j];
                SC1[sc] = RanLet();
                count--;
            }

            for (int k = 0; k < sc; k++) {
                if (enc == null) {
                    enc =RanLets(3)+""+ mark1() + "" + SC1[k] + "" + RanLets(r.nextInt(5));
                } else {
                    enc = enc + "" + mark1() + "" + SC1[k] + "" + RanLets(r.nextInt(5));
                }
            }
            if(sc >= 4){
            enc = enc + "" +mark1()+""+ Character.toUpperCase(SC1[sc]);
            }
            PH=Shifting(PH);
            count++;
        }
        full = full + "" + enc;
        full = full.substring(4);
        return full;
    }

    public static String Encrypting2(String Phrase) {
        char[] PH = Phrase.toCharArray();
        
        Random r = new Random();
        String enc = null;
        String full = null;
        int count;
        count = PH.length;
        char[] SC1;

        int sc;
        for(int i=0;i<count;i++){
            if (PH.length >= 4) {
                sc = 4;

            } else {
                sc = PH.length;
            }
            SC1 = new char[sc + 1];
            for (int j = 0; j < sc; j++) {
                if (PH[j] == ' ') {
                    PH[j] = '9';
                }
                SC1[j] = PH[j];
                SC1[sc] = RanLet();
                count--;
            }

            for (int k = 0; k < sc; k++) {
                if (enc == null) {
                    enc =RanLets(3)+""+ mark2() + "" + SC1[k] + "" + RanLets(r.nextInt(5));
                } else {
                    enc = enc + "" + mark2() + "" + SC1[k] + "" + RanLets(r.nextInt(5));
                }
            }
            PH=Shifting(PH);
            count++;
        }
        full = full + "" + enc;
        full = full.substring(4);
        return full;
    }

    public static String mark2() {
        Random r = new Random();
        String[] mark1 = {"7", "8"};
        return mark1[r.nextInt(2)];
    }

    public static String SpaceChecker(String enc) {
        char[] ch = enc.toCharArray();
        for (int i = 0; i < enc.length(); i++) {
            if (ch[i] == '9') {
                ch[i - 1] = '9';
                ch[i] = RanLet();
            }
        }
        String end = new String(ch);
        return end;
    }

}
