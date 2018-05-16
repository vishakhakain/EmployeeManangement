/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagement;


import static employeemanagement.EmployeeManagement.scn;
import static employeemanagement.Utilities.nextDouble;
import static employeemanagement.Utilities.nextInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte1.other;

public class Utilities {

    public static Scanner sc = new Scanner(System.in);

    public static String nextLine(String s) {

        String str = " ";

        System.out.println(s);
        str = sc.nextLine();
        while (!str.matches("[a-zA-Z]+")) {
            System.out.println("Invalid input.Please enter only characters: ");

            str = sc.nextLine();

        }
        return str;
    }

    public static double nextDouble(String s) {
        double db = 0;
        System.out.println(s);
        try {

            db = sc.nextDouble();
            sc.nextLine();
        } catch (Exception e) {
            sc.nextLine();
            db = nextDouble("Invalid input.Pleas enter only numbers:");
        }
        return db;

    }

    /**
     *
     * @param s
     * @return
     */
    public static Profession nextEnumProfession(String s) {

        Profession en = null;
        System.out.println(s);
        try {

            en = Profession.valueOf(sc.nextLine().toUpperCase());

        } catch (Exception e) {
            System.out.println("*Invalid input. Please enter one of the listed values*");

            nextEnumProfession(s);
        }
        return en;

    }

    public static Gender nextEnumGender(String s) {

        Gender en = Gender.FEMALE;
        System.out.println(s);
        try {

            en = Gender.valueOf(sc.nextLine().toUpperCase());

        } catch (Exception e) {
            System.out.println("Invalid input.Please enter one of the listed values :");

            nextEnumGender(s);
        }
        return en;

    }

    public static int nextInt(String s) {
        int inte = 0;
        System.out.println(s);
        try {

            inte = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            sc.nextLine();
            inte = nextInt("Invalid input.Please enter only  numbers:");
        }
        return inte;
    }

    public static String multiLine(String s) {

        String str = " ";

        System.out.println(s);
        str = sc.nextLine();
        while (!str.matches("[a-zA-Z-0-9 ]+")) {
            System.out.println("Invalid input.Please enter characters and/or  numbers: ");

            str = sc.nextLine();

        }
        return str;
    }

    public static String multiGender(String s) {

        String str = " ";

        System.out.println(s);
        str = sc.nextLine();
        while (str != "male" || str != "female" || str != "other");
        {
            System.out.println("Please enter a valid gender(Male/Female): ");

            str = sc.nextLine();

        }
        return str;
    }

    public static LocalDate multidate(String message) throws ParseException {
        LocalDate birthdate = LocalDate.now();
        boolean loop = true;
        do {

            try {
                System.out.println(message);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String d = sc.nextLine();
                birthdate = LocalDate.parse(d, formatter);
                loop=true;
              
            } catch (Exception e) {
                System.out.println("Invalid format");
                loop=false;
                
            }
        } while (loop==false);return birthdate;
    }

}
