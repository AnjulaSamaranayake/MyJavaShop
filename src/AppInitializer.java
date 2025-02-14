import java.util.Scanner;

public class AppInitializer {

    //Database Area (Using 2D Array)
    static String[][] users = new String[3][2];

    public static void main(String[] args) {

       // 1) Login ?
       // 2) Register ?
       // 3) Exit ?

        Scanner input = new Scanner(System.in);

        String[] startQ = {

                "1) Do you want to login ?"
                , "2) Do you want to Register ?"
                , "3) Do you want to Exit ?"
        };

        for (String temp : startQ) {
            System.out.println(temp);
        }

        int userInput = input.nextInt();

        switch (userInput) {
            case 1: break;
            case 2: break;
            case 3: break;
            default: return;
        }
    }

    // Login Process
    public static boolean login () {
        return false;
    }

    //Register Process
    public static boolean register () {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your Email: ");
        String email = input.nextLine();

        System.out.println("Please enter your Password: ");
        String password = input.nextLine();

        if(users[users.length-1][0] !=null) {
            System.out.println("Sorry.. Our Database is FULL...!! ");
            return false;
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i][0] == null) {
                users[i][0] = email;
                users[i][1] = password;
                return true;
            } else {
                if (users[i][0].equalsIgnoreCase(email)) {
                    System.out.println("This Email is already Exists..!!");
                    return false;
                }
            }
        }
        return false;
    }
}