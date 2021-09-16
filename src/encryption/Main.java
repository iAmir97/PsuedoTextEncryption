package encryption;
import dec;
import static encryption.enc.RanLet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MainMenu();
//        int [] ar={1,2,3};
        
    }

    public static void MainMenu(){
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to this Future hopefully working Encrypting app:" +
                "\nWould you like to:" +
                "\n1- Encrypt" +
                "\n2- Decrypt");

        // this switch case is to drive the user to the either enc or dec
        String ans1 = s.next();

        switch (ans1) {
            case "1":
                enc.MainEnc();
                break;
            case "2":
                dec.MainMenu();
                break;
             default:
                 System.out.println("Wrong Answer, try again");
                MainMenu();
                break;
        }
    }
}
