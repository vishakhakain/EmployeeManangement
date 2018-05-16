package employeemanagement;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import static employeemanagement.Utilities.nextInt;

public class EmployeeManagement {

    static Scanner scn = new Scanner(System.in);
    static int choice2 = 0;

    public static void main(String[] args) throws ParseException {
System.out.println("Welcome to the Employee Management System");
        Employees.prepareEmployeeData();
        do {

            System.out.println("******************************************");
            System.out.println("               Main Menu");
            System.out.println("******************************************");
//            System.out.println("");
//            System.out.println("1-Employee management (add, update, delete,search)\n2-Employee statistics\n3-Exit");
            int choice1 = nextInt("1-Employee management (add, update, delete,search)\n2-Employee statistics\n3-Exit");
            switch (choice1) {
                case 1:
                    Employees.manageEmployee();
                    choice2=1;
                    break;

                case 2:
                    Statistics.statisticsData();
                    choice2=1;
                    break;
                case 3:
                    choice2 = 2;
                    break;
                default:
                    choice2 = 1;
                    System.out.println("***Not a valid option.Please choose between 1 to 3***");
                    break;
            }
//            if (choice1 == 0) {
//                
//
//            } else {
//                System.out.println("Would you like to do go back to the main menu?\n1.Yes\n2.No");
//                

//            }
        } while (choice2 == 1);
        System.out.println("Thank you.Welcome back!");
    }

}
