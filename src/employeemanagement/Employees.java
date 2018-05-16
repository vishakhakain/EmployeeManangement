package employeemanagement;

import static employeemanagement.EmployeeManagement.scn;
import static employeemanagement.Profession.*;
import static employeemanagement.Utilities.multidate;
import static employeemanagement.Utilities.nextDouble;
import static employeemanagement.Utilities.nextLine;
import static employeemanagement.Utilities.multiLine;
import static employeemanagement.Utilities.nextInt;
import static employeemanagement.Utilities.sc;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Employees  {

    private int id;
    public static int numid = 1;
    private String firstName;
    private String lastName;
    private String address;
    private Profession profession;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate joiningDate;
    private double salary;
    private double bonus;

    public double getSalary() {
        return salary;
    }

    public Profession getProfession() {
        return profession;
    }

    public Gender getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public double getBonus() {
        return bonus;
    }

    static ArrayList<Employees> employee = new ArrayList<>();

    public Employees(String firstName, String lastName, String address, Profession profession, Gender gender, LocalDate dateOfBirth, double salary) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.profession = profession;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.joiningDate = LocalDate.now();
        this.salary = salary;
        this.bonus = calculateBonus(salary);
        this.id = numid;
        ++numid;
    }

    public Employees() {
    }

    public static void manageEmployee() throws ParseException {

        System.out.println("Employee Management\n********************");
        boolean loop = true;
        int choice6 = 0;
        do {

            int choice2 = nextInt("Please choose one of the following operations"
                    + "\n*********************************************"
                    + " \n1.Add employee \n2.Update employee \n3.Delete employee \n4.Search employee \n5.Go back to main menu");

            switch (choice2) {
                case 1:

                    addEmployee();
                    choice6 = 1;
                    break;
                case 2:
                    updateEmployeeData();
                    choice6 = 1;
                    break;
                case 3:
                    removeEmployeeData();
                    choice6 = 1;
                    break;
                case 4:

                    searchEmployee();
                    choice6 = 1;
                    break;
                case 5:

                    choice6 = 0;
                    break;

                default:
                    choice6 = 1;
                    System.out.println("*Not a valid option.Please choose between 1 to 5*");
                    break;
            }
//            choice6 = nextInt("What would you like to do now? \n1.Employee management again \n2.Main menu ");
//            if (choice6 == 2) {
//                EmployeeManagement.choice2 = 1;
//
//            }

        } while (choice6 == 1);
    }

    public static void addEmployee() throws ParseException {
        boolean loop = true;
        while (loop == true) {

//            System.out.println("Enter the employee's first name: ");
//            String firstName = scn.nextLine();
//            System.out.println("Enter the employee's last name: ");
//            String lastName = scn.nextLine();
//            System.out.println("Enter the employee's  adress:");
//            String address = scn.nextLine();
            Profession p = Utilities.nextEnumProfession("Enter the employee's  profession Programmer/Secretary/Technician/Manager : ");

            Gender g = Utilities.nextEnumGender("Enter the employee's gender Male/Female:");
            //            System.out.println("Enter the employee's  date Of Birth yyyy-mm-dd:");
//            String dob = scn.nextLine();
//            System.out.println("Enter the employee's  salary:");
//            double salary = scn.nextDouble();

            switch (p) {
                case PROGRAMMER:
                    Programmer emp1 = new Programmer(nextLine("Enter the employee's first name: "), nextLine("Enter the employee's last name: "), multiLine("Enter the employee's  adress:"), p, g, multidate("Enter the employee's  date of birth dd/MM/yyyy:"), nextDouble("Enter the employee's  salary:"));
                    employee.add(emp1);
                    break;
                case SECRETARY:
                    Secretary emp2 = new Secretary(nextLine("Enter the employee's first name: "), nextLine("Enter the employee's last name: "), multiLine("Enter the employee's  adress:"), p, g, multidate("Enter the employee's  date of birth dd/MM/yyyy"), nextDouble("Enter the employee's  salary:"));
                    employee.add(emp2);

                    break;
                case TECHNICIAN:
                    Technician emp3 = new Technician(nextLine("Enter the employee's first name: "), nextLine("Enter the employee's last name: "), multiLine("Enter the employee's  adress:"), p, g, multidate("Enter the employee's  date of birth dd/MM/yyyy:"), nextDouble("Enter the employee's  salary:"));
                    employee.add(emp3);
                    break;
                case MANAGER:
                    Manager emp4 = new Manager(nextLine("Enter the employee's first name: "), nextLine("Enter the employee's last name: "), multiLine("Enter the employee's  adress:"), p, g, multidate("Enter the employee's  date of birth (dd/MM/yyyy):"), nextDouble("Enter the employee's  salary:"));
                    employee.add(emp4);
                    break;
                default:
//                    Employees emp5 = new Employees(nextLine("Enter the employee's first name: "), nextLine("Enter the employee's last name: "), multiLine("Enter the employee's  adress:"), p, g, multidate("Enter the employee's  date of birth (dd/MM/yyyy):"), nextDouble("Enter the employee's  salary:"));
//                    employee.add(emp5);
                    break;
            }
            int choice3 = 2;
            do {
                choice3 = nextInt("Employee added.Do you want to add a new employee? \n1.Yes\n2.No");
                if (choice3 > 2 || choice3 == 0) {
                    System.out.println("***Not a valid option.Please enter 1 or 2***");
                } else if (choice3 == 2) {
                    loop = false;
                } else {
                    loop = true;
                }
            } while (choice3 > 2 || choice3 == 0);
        }
        System.out.println("\nEmployee details are shown below\n********************************");
        showEmployeeData();
    }

    public static void prepareEmployeeData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Programmer emp2 = new Programmer("John", "Lundgren", "Baggensgatan 2", Profession.PROGRAMMER, Gender.MALE, LocalDate.parse("02/02/1981", formatter), 23000);
        employee.add(emp2);
        Secretary emp3 = new Secretary("Alice", "Karlsson", "Drottninggatan 14", Profession.SECRETARY, Gender.FEMALE, LocalDate.parse("02/12/1977", formatter), 32000);
        employee.add(emp3);
        Technician emp4 = new Technician("Elsa", "Sandberg", "Hamngatan 23", Profession.TECHNICIAN, Gender.FEMALE, LocalDate.parse("22/08/1983", formatter), 45000);
        employee.add(emp4);
        Technician emp5 = new Technician("Tio", "Lindqvist", "Sturegatan 45", Profession.TECHNICIAN, Gender.MALE, LocalDate.parse("14/05/1777", formatter), 78000);
        employee.add(emp5);
        Manager emp6 = new Manager("Jessica", "Danielsson", "Lejonbacken 18", Profession.MANAGER, Gender.FEMALE, LocalDate.parse("21/07/1956", formatter), 41000);
        employee.add(emp6);
        Manager emp7 = new Manager("Alexander", "Nilsson", "Myntgatan 34", Profession.MANAGER, Gender.MALE, LocalDate.parse("16/09/1971", formatter), 30000);
        employee.add(emp7);
        Programmer emp8 = new Programmer("Thomas", "Larsson", "Tyska Brinken 17", Profession.PROGRAMMER, Gender.MALE, LocalDate.parse("19/01/1977", formatter), 17000);
        employee.add(emp8);
        Secretary emp9 = new Secretary("Robina", "Dahlberg", "Tegelbacken 120", Profession.SECRETARY, Gender.FEMALE, LocalDate.parse("01/01/1990", formatter), 29000);
        employee.add(emp9);
       Programmer emp10 = new Programmer("Marie", "Berg", "Sturegatan 56", Profession.PROGRAMMER, Gender.FEMALE, LocalDate.parse("12/04/1984", formatter), 39000);
        employee.add(emp10);
        Programmer emp11 = new Programmer("Cathy", "Bergdrom", "Sturegatan 56", Profession.PROGRAMMER, Gender.FEMALE, LocalDate.parse("02/02/1987", formatter), 78000);
        employee.add(emp11);
    }

    public static void showEmployeeData() {
//    System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------+");
//    System.out.printf("+%-4s|%-20s|%-20s|%-20s|%-20s| %-10s|%-15s|%-15s|%-15s |%-6s+", "ID","FirstName", "LastName", "Adress", "Profession", "Gender","Date Of Birth","Date of Joining","Salary","Bonus");
////      System.out.println();
//    System.out.println("\n+-----------------------------------------------------------------------------------------------------------------------------------------------------+");
        printTableFormatHeader();
        employee.forEach((employ) -> {
            printTableFormat(employ);
//        System.out.format("+%-4s|%-20s|%-20s|%-20s|%-20s| %-10s|%-15s|%-15s|%-15s|%-6s+", employ.id,
//                employ.firstName,employ.lastName,employ.address,employ.profession,employ.gender,employ.dateOfBirth,employ.joiningDate,employ.salary,employ.bonus);

        });
        printTableFormatFooter();
//    System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------+");
//          
    }

    public static void showEmployeeDatabyID(int id1) {

        employee.forEach((Employees employ) -> {
            if (employ.id == id1) {
                printTableFormatHeader();
                printTableFormat(employ);
                printTableFormatFooter();

            }

        });

//    System.out.println("+-----------------------------------------------------------------------------------------------------------------------------------------------------------+");
//          
    }

    public static void updateEmployeeData() throws ParseException {
        showEmployeeData();

        int idEntered = nextInt("Select ID number of the Employee to be updated");
        int retValue = 0;
        showEmployeeDatabyID(idEntered);

        for (Employees employees : employee) {
            if (idEntered == employees.id) {
                int loop1 = 0;

                do {
                    System.out.println("What would you like to update?\n1.FirstName\n2.LastName\n3.Adress\n4.Date Of Birth\n5.Salary");
                    int field = scn.nextInt();
                    scn.nextLine();
                    switch (field) {
                        case 1://FirstName
                           
                            String newFirstName = nextLine("Please enter the new first name :");
                            employees.firstName = newFirstName;
                            System.out.println("Employee details after update");
                            printTableFormatHeader();
                            printTableFormat(employees);
                            printTableFormatFooter();
                            retValue = 1;

                            break;
                        case 2://LastName
                            
                            String newLastName = nextLine("Please enter the new Last name :");
                            employees.lastName = newLastName;
                            System.out.println("Employee details after update");
                            printTableFormatHeader();
                            printTableFormat(employees);
                            printTableFormatFooter();
                            retValue = 1;
                            break;
                        case 3://Address
                           
                            String newAddress = nextLine("Please enter the new address :");
                            employees.address = newAddress;
                            System.out.println("Employee details after update");
                            printTableFormatHeader();
                            printTableFormat(employees);
                            printTableFormatFooter();
                            retValue = 1;
                            break;
                        case 4://Date Of Birth
                            
                           
                            employees.dateOfBirth = multidate("Enter the employee's  date of birth dd/MM/yyyy:");
                            System.out.println("Employee details after update");
                            printTableFormatHeader();
                            printTableFormat(employees);
                            printTableFormatFooter();
                            retValue = 1;
                            break;
                        case 5://Salary
                           
                            int newSalary = nextInt("Please enter the new salary :");
                            employees.salary = newSalary;
                            System.out.println("Employee details after update");
                            printTableFormatHeader();
                            printTableFormat(employees);
                            printTableFormatFooter();
                            retValue = 1;
                            break;
                        default:
                            System.out.println("Not a valid option.Please choose between 1 to 5");
                    }
                   
                    loop1 = nextInt("Do you want to update any more details of employee id " + employees.id + "\n1.Yes\n2.No");
                    
                } while (loop1 == 1);
                showEmployeeData();
            } else {
                retValue = 1;
            }

        }

        if (retValue == 1) {
            System.out.println("***Employee not found.Please enter a valid input***");
        }
    }

    public static void removeEmployeeData() {
        System.out.println("Employee details before delete");
        showEmployeeData();
        int choice3 = 1;
        while (choice3 == 1) {

            int idEntered = nextInt("Enter ID number of the employee account to be deleted");
            if (checkEmployeeData(idEntered) >= 0) {

                employee.remove(checkEmployeeData(idEntered));
                System.out.println("Account with employee id " + idEntered + " deleted.");
                choice3 = nextInt("Do you want to delete another account?\n1.Yes\n2.No ");

            } else {
                System.out.println("***Employee not found.Please enter a valid id***");
                choice3 = 1;
            }

        }
        System.out.println("Employee details after delete");
        showEmployeeData();

    }

    public static void printTableFormatHeader() {
        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("+%-4s|%-20s|%-20s|%-20s|%-20s| %-10s|%-15s|%-15s|%-15s|%-10s+", "ID", "FirstName", "LastName", "Adress", "Profession", "Gender", "Date Of Birth", "Date of Joining", "Salary", "Bonus");
//      System.out.println();
        System.out.println("\n+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
    }

    public static void printTableFormat(Employees employees) {
        System.out.format("+%-4s|%-20s|%-20s|%-20s|%-20s| %-10s|%-15s|%-15s|%-15s|%-10s+", employees.id,
                employees.firstName, employees.lastName, employees.address, employees.profession, employees.gender, employees.dateOfBirth, employees.joiningDate, employees.salary, employees.bonus);
        System.out.println();
    }

    public static void printTableFormatFooter() {

        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
    }

    public abstract double calculateBonus(double salary);
//    {
////        double bonus = 0;
////        return bonus;
//
//    }

    public static void searchEmployee() {
        showEmployeeData();

        int choice5 = nextInt("You can search the employee by \n1.id\n2.First Name\n3.LastName\n4.Profession.\nPlease enter a value :");

        switch (choice5) {
            case 1:
                System.out.println("Enter employee id:");
                int id = scn.nextInt();
                scn.nextLine();
                if (checkEmployeeData(id) >= 0) {
                    printTableFormatHeader();
                    printTableFormat(Employees.employee.get(checkEmployeeData(id)));
                    printTableFormatFooter();

                } else {
                    System.out.println("***Employee not found.Please try again***");
                }

                break;
            case 2:
                scn.nextLine();
                System.out.println("Enter employee first name:");
                String firstName = scn.nextLine();
                for (Employees employee : employee) {
                    if (employee.firstName.equalsIgnoreCase(firstName)) {
                        printTableFormatHeader();
                        printTableFormat(employee);
                        printTableFormatFooter();
                    }

                }

                break;
            case 3:

                System.out.println("Enter employee last name:");
                String lastName = scn.nextLine();
                for (Employees employee : employee) {
                    if (employee.lastName.equalsIgnoreCase(lastName)) {
                        printTableFormatHeader();
                        printTableFormat(employee);
                        printTableFormatFooter();
                    }

                }

                break;
            case 4:
                scn.nextLine();
                System.out.println("Enter employee profession:");
                String profession2 = scn.nextLine().toUpperCase();
                printTableFormatHeader();
                for (Employees employees : employee) {
                    if (employees.profession.equals(Profession.valueOf(profession2))) {

                        printTableFormat(employees);

                    }

                }
                printTableFormatFooter();
                break;

            default:
                System.out.println("Please enter a valid input!");
        }
    }

    public static int checkEmployeeData(int IDEntered) {
        int choice4 = -1;
        for (Employees employees : employee) {
            if (employees.id == IDEntered) {
                choice4 = employee.indexOf(employees);
                System.out.println(choice4);
                break;
            }

        }
        return choice4;

    }

    @Override
    public String toString() {
        return "Employees{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", profession=" + profession + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", joiningDate=" + joiningDate + ", salary=" + salary + ", bonus=" + bonus + '}';
    }

}
