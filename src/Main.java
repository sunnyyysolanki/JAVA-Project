import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.nio.file.Paths;




class Main {
    public Date Timestamp;
    String s = "";

    String name = "";
    String s1 = "";
    String FilePath = "./";
    int new_id, old_id;
    int sender_ac;
    String acc_no;
    String Name, Age, Gender, AccountType;
    String MobileNum, Aadhaar, user_name, pass;
    String AC_N;
    double Dep_amount, With_amount, depositAmount;
    double Ini_balance;
    double sender_Initial_balance;
    double sender_final_balance;
    double transfer_amount;

    public void login() throws Exception {
        try {
            Scanner sc = new Scanner(System.in);
            Scanner sc1 = new Scanner(System.in);
            System.out.print("Account Number: ");
            AC_N = sc.nextLine();


            File file = new File(FilePath + AC_N + ".txt");
            System.out.print("Password: ");
            s1 = sc1.nextLine();
            Scanner dataReader = new Scanner(file);
            acc_no = dataReader.nextLine();
            user_name = dataReader.nextLine();
            pass = dataReader.nextLine();

            if (AC_N.equals(acc_no)) {
                if (s1.equals(pass)) {
                    System.out.println("Hello " + user_name + ",welcome to ABC bank.");
                    System.out.println("Login Successful");
                    String line = Files.readAllLines(Paths.get(FilePath + AC_N + ".txt")).get(8);
                    Ini_balance = Double.parseDouble(line);
                    dash_board();
                } else {
                    System.out.println("Wrong Password... Please Try Again");
                    acc_choice();
                }
            }


        } catch (IOException e) {
            System.out.println("Error: Account No." + AC_N + " Does not Exist");
            acc_choice();
        }

    }

    void create() throws Exception {


        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Scanner sca = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter Account Holder Name: ");
        name = sc.nextLine();

//           if(file.exists())
//            {
//                System.out.println("Account Already Exist...");
//                acc_choice();
//            }
//            else {
//                System.out.println("Account Number: ");
//                acc_no= sc.nextLong();
        System.out.print("Set Password: ");
        s1 = sc1.nextLine();

        System.out.print("Age : ");
        Age = scn.nextLine();

        System.out.print("Mobile number : ");
        MobileNum = sca.nextLine();

        System.out.print("Gender :");
        Gender = scn.nextLine();

        System.out.print("Aadhaar Number:");
        Aadhaar = sca.nextLine();

        System.out.print("Account type(saving /current ) :");
        AccountType = scn.nextLine();

        System.out.print("Enter Initial Amount to Deposit :");
        Ini_balance = sca.nextDouble();
        System.out.println("\n");
        System.out.println("Your account is successfully created..");
        System.out.println("\n");

// account.txt
        File file1 = new File(FilePath + "account.txt");
        file1.createNewFile();
        Scanner scanner = new Scanner(file1);
        if (file1.length() != 0) {
            old_id = scanner.nextInt();
            new_id = old_id + 1;
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(FilePath + "account.txt", true));
            buffWriter.write(String.valueOf(new_id));
            buffWriter.close();
        } else {
            old_id = 547901000;
            new_id = old_id + 1;
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(FilePath + "account.txt", true));
            buffWriter.write(String.valueOf(new_id));
            buffWriter.close();
        }

        List<String> fileContents1 = Files.readAllLines(Paths.get(FilePath + "account.txt"));

        // modify the first line of the file to contain the new balance
        fileContents1.set(0, String.valueOf(new_id));
        Files.write(Paths.get(FilePath + "account.txt"), fileContents1);
        AC_N = String.valueOf(new_id);

//Each user file
        File file = new File(FilePath + AC_N + ".txt");

        try {
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(FilePath + AC_N + ".txt", true));
            buffWriter.write(AC_N + System.lineSeparator());
            buffWriter.write(name + System.lineSeparator());
            buffWriter.write(s1 + System.lineSeparator());
            //   buffWriter.write(acc_no + System.lineSeparator());
            buffWriter.write(Age + System.lineSeparator());
            buffWriter.write(MobileNum + System.lineSeparator());
            buffWriter.write(Gender + System.lineSeparator());
            buffWriter.write(Aadhaar + System.lineSeparator());
            buffWriter.write(AccountType + System.lineSeparator());
            buffWriter.write(Ini_balance + System.lineSeparator());
            buffWriter.close();
        } catch (IOException e) {
            System.out.println("error");
        }


        dash_board();

        //   }
    }


    public void acc_choice() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("_______________________________");
        System.out.println("_______________________________");
        System.out.println("       BANKING MANAGEMENT      ");
        System.out.println("_______________________________");
        System.out.println("_______________________________");
        System.out.println("\t1.Login\n\t2.Create New Account\n\t3.Exit");
        System.out.print("Enter your choice : ");
        int choice = sc.nextInt();
        Main temp = new Main();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                create();
                break;
            case 3:
                System.out.println("...");
                break;
            default:
                System.out.println("Enter valid choice!!!..");
                acc_choice();

        }
    }

    public void my_information() throws IOException {

        File file = new File(FilePath + AC_N + ".txt");
        Scanner scanner = new Scanner(file);
        System.out.println("Account Number :" + scanner.nextLine());
        System.out.println("Name : " + scanner.nextLine());
        String s6 = scanner.nextLine();
        // System.out.println("Account Number : " +scanner.nextLine());
        System.out.println("Age : " + scanner.nextLine());
        System.out.println("Mobile Number :" + scanner.nextLine());
        System.out.println("Gender : " + scanner.nextLine());
        System.out.println("Aadhaar : " + scanner.nextLine());
        System.out.println("Account Type : " + scanner.nextLine());
        System.out.println("Current balance :" + scanner.nextLine());

        scanner.close();
    }
//    public void deposit() throws IOException {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter amount to deposit: ");
//        double depositAmount = sc.nextDouble();
//        Ini_balance=Ini_balance + depositAmount; // add the deposit amount to the initial balance
//        //File file = new File(FilePath + s + ".txt");
//        // read the contents of the file into a list of strings
//        List<String> fileContents = Files.readAllLines(Paths.get(FilePath + AC_N + ".txt"));
//
//        // modify the first line of the file to contain the new balance
//        fileContents.set(8, String.valueOf(Ini_balance));
//
//        // write the modified contents back to the file
//        try {
//            Files.write(Paths.get(FilePath + s + ".txt"), fileContents);
//            System.out.println("Your deposit of " + depositAmount + " rupees was successful. Your new balance is " + Ini_balance);
//        } catch (IOException e) {
//            System.out.println("An error occurred while processing your deposit.");
//        }
//    }

    public void deposit() throws IOException {
        Timestamp = new Date();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        Dep_amount = sc.nextDouble();
        Ini_balance = Ini_balance + Dep_amount; // add the deposit amount to the initial balance
        //File file = new File(FilePath + s + ".txt");
        // read the contents of the file into a list of strings
        List<String> fileContents = Files.readAllLines(Paths.get(FilePath + AC_N + ".txt"));

        // modify the first line of the file to contain the new balance
        fileContents.set(8, String.valueOf(Ini_balance));

        // write the modified contents back to the file
        try {
            Files.write(Paths.get(FilePath + AC_N + ".txt"), fileContents);
            System.out.println("Your deposit of " + Dep_amount + " rupees was successful. Your new balance is " + Ini_balance);
            String sg = new StringBuilder().append("Rs.").append(Dep_amount).append(" was credited on (").append(Timestamp).append("). Available Amount is: ").append(Ini_balance).toString();
            BufferedWriter buffWriter = new BufferedWriter(new FileWriter(FilePath + AC_N + ".txt", true));
            buffWriter.write(sg + System.lineSeparator());
            buffWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred while processing your deposit.");
        }
    }


    public void withdraw() throws IOException {
        Timestamp = new Date();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount to withdraw : ");
        With_amount = sc.nextDouble();

        if (With_amount < Ini_balance) {
            Ini_balance = Ini_balance - With_amount;
            List<String> fileContents = Files.readAllLines(Paths.get(FilePath + AC_N + ".txt"));

            // modify the first line of the file to contain the new balance
            fileContents.set(8, String.valueOf(Ini_balance));

            // write the modified contents back to the file
            try {
                Files.write(Paths.get(FilePath + AC_N + ".txt"), fileContents);
                System.out.println("Your withdraw of " + With_amount + " rupees was successful. Your new balance is " + Ini_balance);
                String sg = new StringBuilder().append("Rs.").append(With_amount).append(" was Debited on (").append(Timestamp).append("). Available Amount is: ").append(Ini_balance).toString();
                BufferedWriter buffWriter = new BufferedWriter(new FileWriter(FilePath + AC_N + ".txt", true));
                buffWriter.write(sg + System.lineSeparator());
                buffWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred while processing your deposit.");
            }
            if (Ini_balance < 500) {
                System.out.println("Minimum balance is not maintained (Minimum balance required 500 rupees. )");
            } else if (With_amount > Ini_balance) {

                System.out.println("Your can not withdraw more then " + Ini_balance + " rupees.");
            }

        }
    }

    public void transaction() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FilePath + AC_N + ".txt"));
        String ln;
        int n = 9;
        int line_Index = 0;
        boolean found = false;
        while ((ln = br.readLine()) != null) {
            if (line_Index == n) {
                System.out.println(ln);
                n++;
            }line_Index++;

        }
    }


    public void change() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter New Password : ");
        s1 = sc.nextLine();
        List<String> fileContents = Files.readAllLines(Paths.get(FilePath + AC_N + ".txt"));

        // modify the first line of the file to contain the new balance
        fileContents.set(2, String.valueOf(s1));

        // write the modified contents back to the file
        try {
            Files.write(Paths.get(FilePath + AC_N + ".txt"), fileContents);
            System.out.println("Your Password is Successfully Changed");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void transfer() throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account number");
        sender_ac = sc.nextInt();

        File file = new File(FilePath + sender_ac + ".txt");
        if(file.exists()){
            System.out.println("Enter amount");
            transfer_amount = sc.nextDouble();
            if(transfer_amount<Ini_balance){
               // String line = Files.readAllLines(Paths.get(FilePath +sender_ac + ".txt")).get(8);
                String line = Files.readAllLines(Paths.get(FilePath +sender_ac + ".txt")).get(8);
                sender_Initial_balance = Double.parseDouble(line);
               // sender_Initial_balance = Double.parseDouble(line);
                sender_final_balance =sender_Initial_balance + transfer_amount;
                List<String> fileContents3 = Files.readAllLines(Paths.get(FilePath + sender_ac + ".txt"));

                // modify the first line of the file to contain the new balance
                fileContents3.set(8, String.valueOf(sender_final_balance));
                Ini_balance = Ini_balance - transfer_amount;
                List<String> fileContents2 = Files.readAllLines(Paths.get(FilePath + AC_N + ".txt"));

                // modify the first line of the file to contain the new balance
                fileContents2.set(8, String.valueOf(Ini_balance));

            }else {
                System.out.println("Insufficient balance!!");
                dash_board();
            }


        }else {
            System.out.println("Account does not exists.");
        }

    }


        public void current_balance() {

        System.out.println("Current balance is " + Ini_balance);
    }

    public void dash_board() throws Exception {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("_______________________________");
            System.out.println("_______________________________");
            System.out.println("           Dash Board          ");
            System.out.println("_______________________________");
            System.out.println("_______________________________");
            System.out.println("\t1.My Information\n\t2.Deposit\n\t3.Withdraw\n\t4.Current Balance\n\t5.Change Password\n\t6.Transaction History\n7.transfer\n\t8.Logout\n");
            System.out.print("Enter Your choice :");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    my_information();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    current_balance();
                    break;
                case 5:
                    change();
                    break;

                case 6:
                    transaction();
                    break;
                case 7:
                    transfer();
                    break;
                case 8:
                    System.out.println("You have been successfully Logged Out....");
                    acc_choice();
                    break;

                default:
                    System.out.println("Enter valid choice!!!...");
                    break;
            }

        } while (choice != 8);

    }

    public static void main(String[] args) throws Exception {
        Main ob = new Main();
        ob.acc_choice();
    }


}






