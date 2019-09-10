import java.io.*;
import java.util.Scanner;

public class logg {
    public static void main(String[] args) {
        int seconds = 12;
        boolean repeat = true;
        startMenu();
        int opt = chooseOption();
        String message = "hehehe";
        optChosen(opt ,seconds, message, repeat);
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
        int i = sc.nextInt();
        sc.close();
        return i;

    }

    public static void optChosen(int opt, int seconds, String message , boolean repeat) {
        while((opt == 0) || (opt == 1) ||(opt == 2) || (opt == 3) ||(opt == 4) || (opt == 5)){
        if (opt <= -1 || opt >= 7) {
            System.out.println("404 Logg not found. System shutdown will now commense in " + seconds + "seconds");
            systemCrash(seconds);
        }
        if (opt == 1) {
            LogEntry entry = new LogEntry(message);
            String showLog = showLog(entry);
            System.out.println(showLog);
        }

        if (opt == 2) {
            LogEntry entry = new LogEntry(newPost(message));
            String showLog = showLog(entry);
            System.out.println(showLog);
        }

        /*if(opt == 3){
            editPost();
        }*/

        if (opt == 4) {
            LogEntry entry = new LogEntry(newPost(message));
            System.out.println("Filename?");
            Scanner u = new Scanner(System.in);
            String filename = u.nextLine() + ".txt";
            try (PrintStream out = new PrintStream(new FileOutputStream(filename))) {
                out.print(showLog(entry));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            u.close();
        }

        if (opt == 5) {
            LogEntry entry = new LogEntry(newPost(message));
            System.out.println("What was the file called?.... (remmber without .txt)");
            Scanner u = new Scanner(System.in);
            String filename = u.nextLine() + ".txt";
            String line = null;
            readLog(entry, filename, line);
            u.close();
        }

        if (opt == 6) {
            exit();
        }
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
    public static String showLog(LogEntry entry){
        return entry.toString();
    }

    public static String newPost(String message){
        Scanner c = new Scanner(System.in);
        message = c.nextLine();
        c.close();
        return message;
    }

    public static String readLog(LogEntry entry, String filename, String line){
        line = null;
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);


            while ((line = bufferedReader.readLine()) != null){
                return line;
            }
            bufferedReader.close();
        } catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            filename + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
