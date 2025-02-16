import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AppInitializer {

    //Database Area (Using 2D Array)
    static String[][] users = new String[3][2];
    static String[][] customer = new String[100][4];

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

        boolean existStage = false;

        while (!existStage) {

            for (String temp : startQ) {
                System.out.println(temp);
            }

            int userInput = input.nextInt();

            switch (userInput) {
                case 1:
                    if(login()){
                        dashboard();
                        existStage = true;
                    }
                    break;
                case 2:
                    if(register()){
                        dashboard();
                        existStage = true;
                    }
                    break;
                case 3:
                    System.out.println("Bye Bye..!");
                    existStage = true;
                    break;
                default:
                    System.out.println("You have entered an invalid option!");
                    return;
            }
        }
    }

    // Login Process
    public static boolean login () {

        printData("Login");

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your Email: ");
        String email = input.nextLine();

        System.out.println("Please enter your Password: ");
        String password = input.nextLine();

        for(int i = 0; i < users.length; i++) {
            if(users[i][0] != null && users[i][0].equalsIgnoreCase(email)){
                if(users[i][1].equals(password)){
                    System.out.println("Welcome Again...!");
                    return true;
                } else {
                    System.out.println("Wrong Password!");
                    return false;
                }
            }
        }
        System.out.println("User not found!");
        return false;
    }

    //Register Process
    public static boolean register () {

        printData("Register");

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

    //Dashboard
    public static void dashboard() {

        printData("Dashboard");

        System.out.println("Welcome to the Dashboard...!");
        System.out.println();

        Scanner input = new Scanner(System.in);

        String[] dashboardQ = {
                "1)Customer Manage ",
                "2)Item Manage ",
                "3)Oder Manage ",
                "4)Logout "
        };

        while (true){
            for (String temp : dashboardQ) {
                System.out.println(temp);
            }
            int userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    customerManage();
                    break;
                case 2:
                    //Item manage
                    break;
                case 3:
                    //oder manage
                    break;
                case 4:
                    System.out.println("Bye Bye..!");
                    return;
                default:
                    System.out.println("You have entered an invalid option!");
                    return;
            }
        }
    }

    //print date and time
    public static void printData(String location){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

        String myDate = dateFormat.format(date);
        String myTime = timeFormat.format(date);

        System.out.println("==="+myDate+"==="+myTime+"==="+location);
    }

    //Customer Manage
    public static void customerManage(){
        printData("Customer Manage ");

        Scanner input = new Scanner(System.in);

        String[] customerQ = {
                "1) Save Customer ",
                "2) Find Customer ",
                "3) Update Customer ",
                "4) Delete Customer ",
                "5) Find all Customers ",
                "6) Back to Dashboard "

        };

        while (true){
            for (String temp : customerQ) {
                System.out.println(temp);
            }

            int userInput = input.nextInt();

            switch (userInput) {
                case 1:
                    saveCustomer();
                    break;
                case 2:
                    //Find customer
                    break;
                case 3:
                    //Update Customer
                    break;
                case 4:
                    //Delete Customer
                    break;
                case 5:
                    //Find all Customers
                    break;
                case 6:
                    dashboard();
                    return;
                default:
                    System.out.println("You have entered an invalid option!");
                    return;
            }
        }
    }

    // Save Customer
    public static void saveCustomer() {
        printData("Save Customer\n");

        Scanner input = new Scanner(System.in);

        String nic,name,address;
        double salary;

        while (true){
            System.out.println("Please enter customer NIC number: ");
            nic = input.nextLine();
            System.out.println("Please enter customer Name: ");
            name = input.nextLine();
            System.out.println("Please enter customer Address: ");
            address = input.nextLine();
            System.out.println("Please enter customer Salary: ");
            salary = input.nextDouble();


            if(customer[customer.length-1][0] != null){
                System.out.println("Sorry.. Our Database is FULL...!! ");
                return;
            }

            for(int i=0;i < customer.length;i++){
                if(customer[i][0] != null && customer[i][0].equalsIgnoreCase(nic)){
                    System.out.println("Customer already exists!");
                    break;

                } else {
                customer[i][0] = nic;
                customer[i][1] = name;
                customer[i][2] = address;
                customer[i][3] = String.valueOf(salary);

                System.out.println("Customer saved Successfully...!\n");
                System.out.println(" 1) Do you want to save another customer? ");
                System.out.println(" 2) Back to Dashboard");
                int option = input.nextInt();

                switch (option) {
                    case 1:
                        saveCustomer();
                        break;
                    case 2:
                        dashboard();
                        break;
                    default:
                        System.out.println("You have entered an invalid option!");
                        return;
                }
            }

            }
        }
    }
}