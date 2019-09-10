import java.io.IOException;
import java.util.Scanner;

public class logg {
    public static void main(String[] args) {
        int seconds = 12;
        startMenu();
        int opt = chooseOption();
        optChosen(opt ,seconds);
    }

    public static void startMenu(){
        System.out.println(
                "1. Visa loggboken\n" +
                "2. Skriv in en ny post i loggboken\n" +
                "3. Redigera en gammal post i loggboken\n" +
                "4. Spara loggboken\n" +
                "5. Läs in en loggbok\n" +
                "6. Avsluta");
    }

    public static int chooseOption(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void optChosen(int opt , int seconds){
        if (opt <= 0 || opt >=7) {
            System.out.println("404 Logg not found. System shutdown will now commense in " + seconds + "seconds");
            systemCrash(seconds);
        }
        /*if(opt == 1){
            showLogg();
        }

        if(opt == 2){
            newPost();
        }

        if(opt == 3){
            editPost();
        }

        if(opt == 4){
            saveLog();
        }

        if(opt == 5){
            readLog();
        }*/

        if (opt == 6) {
            exit();
        }
    }

    public static void exit(){
        return;
    }

    public static void systemCrash(int seconds){
        Runtime runtime = Runtime.getRuntime();
        try{
            Process process = runtime.exec("shutdown -s -t " + Integer.toString(seconds));
            Thread.sleep(900);  
            javax.swing.JOptionPane.showMessageDialog(null,"GOOOD BYE!\n" + " I sucked your mom");

        }catch(Exception e){
            System.out.println("oof dawg");
        }
    }
}
