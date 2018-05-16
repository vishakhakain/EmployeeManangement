package employeemanagement;

import static employeemanagement.EmployeeManagement.scn;
import java.util.Collections;
import java.util.ArrayList;
import static employeemanagement.Utilities.nextInt;

public class Statistics {

    public static void statisticsData() {
        int choice6=1;
        do {
            
        
        
     
        int choice4 = nextInt("Statistics\n**********\nPlease choose one of the following operations\n"
                + "**********************************************"
                + "\n1.Overall average salary \n"
                + "2.Average salary by Profession\n"
                + "3.Overall gender distribution\n"
                + "4.Gender distribution by profession\n"
                + "5.Overall bonus payment\n"
                + "6.Bonus paymen1 by profession\n"
                + "7.Highest salary\n"
                + "8.Lowest salary\n"
                + "9.All available statistics\n"
                + "10.Go back to main menu");
        switch (choice4) {
            case 1:
                overallAverageSalary();
                break;
            case 2:
                AverageSalaryByProfession();
                break;
            case 3:
                overallGenderDistribution();
                break;
            case 4:

                genderDistribustionByProfession();
                break;
            case 5:

                overallBonus();
                break;
            case 6:
                bonusByProfession();
                break;
            case 7:

                highestSalary();
                break;
            case 8:

                lowestSalary();
                break;
            
            case 9:
                System.out.println("1.");
                overallAverageSalary();
                System.out.println("2.");
                AverageSalaryByProfession();
                System.out.println("3.");
                overallGenderDistribution();
                System.out.println("4.");
                genderDistribustionByProfession();
                System.out.println("5.");
                overallBonus();
                System.out.println("6.");
                bonusByProfession();
                System.out.println("7.");
                highestSalary();
                System.out.println("8.");
                lowestSalary();
                break;
            case 10:
            choice6=0;
            break;
                default:
                    System.out.println("***Not a valid option.Please choose between 1 to 10***");
                    choice6=1;
                    break;
        }
            
//            choice6=nextInt("What would you like to do now? \n1.Statistics data again\n2.Main menu ");
//            if (choice6==2) {
//               EmployeeManagement.choice2=1; 
//              
//            }
           
        } while (choice6==1);
    }
        

    public static void overallAverageSalary() {
        double totalSalary = 0;

        for (Employees emp1 : Employees.employee) {

            totalSalary += emp1.getSalary();
        }

        System.out.println("The avreage salary of all employees\n************************************\n" + totalSalary / Employees.employee.size()+"\n************************************\n");
    }

    public static void overallBonus() {
        double totalBonus = 0;

        for (Employees emp1 : Employees.employee) {

            totalBonus += emp1.getBonus();
        }

        System.out.println("The total bonus of all employees\n*************************************\n" + totalBonus+"\n*************************************\n");
    }

    public static void AverageSalaryByProfession() {
        double totalSalaryManager = 0;
        double totalSalaryProgrammer = 0;
        double totalSalaryTechnician = 0;
        double totalSalarySecretary = 0;
        int countM = 0;
        int countP = 0;
        int countT = 0;
        int countS = 0;

        for (Employees emp1 : Employees.employee) {
            switch (emp1.getProfession()) {
                case MANAGER:

                    totalSalaryManager += emp1.getSalary();
                    countM++;
                    break;
                case PROGRAMMER:

                    totalSalaryProgrammer += emp1.getSalary();
                    countP++;
                    break;
                case TECHNICIAN:

                    totalSalaryTechnician += emp1.getSalary();
                    countT++;
                    break;
                case SECRETARY:

                    totalSalarySecretary += emp1.getSalary();
                    countS++;
                    break;
                default:
                    System.out.println("Give a valid input");
            }

        }
        System.out.println("The avreage salary  by Profession\n**********************************\n+------------------------------------+");
        System.out.printf("+%-20s| %-14s+", "Profession", "Average Salary");
        System.out.println("\n+------------------------------------+");
        System.out.printf("+%-20s| %-14s+", "MANAGER", totalSalaryManager / countM);
        System.out.printf("\n+%-20s| %-14s+", "PROGRAMMER", totalSalaryProgrammer / countP);
        System.out.printf("\n+%-20s| %-14s+", "TECHNICIAN", totalSalaryTechnician / countT);
        System.out.printf("\n+%-20s| %-14s+", "SECRETARY", totalSalarySecretary / countS);
        System.out.println("\n+------------------------------------+");


    }

    public static void genderDistribustionByProfession() {

        double countManagerM = 0;
        double countManagerF = 0;
        double countProgrammerM = 0;
        double countProgrammerF = 0;
        double countTechnicianM = 0;
        double countTechnicianF = 0;
        double countSecretaryM = 0;
        double countSecretaryF = 0;
        double size = Employees.employee.size();

        for (Employees emp1 : Employees.employee) {
            switch (emp1.getProfession()) {
                case MANAGER:

                    if (emp1.getGender() == Gender.FEMALE) {
                        countManagerF++;
                    } else {
                        countManagerM++;
                    }
                    break;
                case PROGRAMMER:

                    if (emp1.getGender() == Gender.FEMALE) {
                        countProgrammerF++;
                    } else {
                        countProgrammerM++;
                    }
                    break;
                case TECHNICIAN:

                    if (emp1.getGender() == Gender.FEMALE) {
                        countTechnicianF++;
                    } else {
                        countTechnicianM++;
                    }
                    break;
                case SECRETARY:

                    if (emp1.getGender() == Gender.FEMALE) {
                        countSecretaryF++;
                    } else {
                        countSecretaryM++;
                    }
                    break;
                default:
                    System.out.println("Give a valid input");
            }

        }

//        System.out.println("Gender Distribution by Profession\n**********************************\n+----------------------------------------------------+");
//        System.out.printf("+%-20s| %-10s|%-19s+", "Profession", "Gender", "Gender Distribution");
//        System.out.println("\n+----------------------------------------------------+");
//        System.out.printf("+%-20s| %-10s|%-19s+", "MANAGER", "FEMALE", (countManagerF/size)*100);
//        System.out.printf("\n+%-20s| %-10s|%-19s+", "", "MALE", (countManagerM/size)*100);
//        System.out.println("\n+----------------------------------------------------+");
//        System.out.printf("+%-20s| %-10s|%-19s+", "PROGRAMMER", "FEMALE", (countProgrammerF/size)*100);
//        System.out.printf("\n+%-20s| %-10s|%-19s+", "", "MALE", (countProgrammerM/size)*100);
//        System.out.println("\n+----------------------------------------------------+");
//        System.out.printf("+%-20s| %-10s|%-19s+", "TECHNICIAN", "FEMALE", (countTechnicianF/size)*100);
//        System.out.printf("\n+%-20s| %-10s|%-19s+", "", "MALE", (countTechnicianM/size)*100);
//        System.out.println("\n+----------------------------------------------------+");
//        System.out.printf("+%-20s| %-10s|%-19s+", "SECRETARY", "FEMALE", (countSecretaryF/size)*100);
//        System.out.printf("\n+%-20s| %-10s|%-19s+", "", "MALE", (countSecretaryM/size)*100);
//        System.out.println("\n+----------------------------------------------------+");
        System.out.println("Gender Distribution by Profession\n**********************************\n+-----------------------------------------+");
        System.out.printf("+%-20s| %-19s+", "Profession", "Gender Distribution");
        System.out.println("\n+-----------------------------------------+");
        System.out.printf("+%-20s| %-19s+", "MANAGER", (countManagerF / size) * 100 + "% FEMALE");
        System.out.printf("\n+%-20s| %-19s+", "", (countManagerM / size) * 100 + "% MALE");
        System.out.println("\n+-----------------------------------------+");
        System.out.printf("+%-20s| %-19s+", "PROGRAMMER", (countProgrammerF / size) * 100 + "% FEMALE");
        System.out.printf("\n+%-20s| %-19s+", "", (countProgrammerM / size) * 100 + "% MALE");
        System.out.println("\n+-----------------------------------------+");
        System.out.printf("+%-20s| %-19s+", "TECHNICIAN", (countTechnicianF / size) * 100 + "% FEMALE");
        System.out.printf("\n+%-20s| %-19s+", "", (countProgrammerM / size) * 100 + "% MALE");
        System.out.println("\n+-----------------------------------------+");
        System.out.printf("+%-20s| %-19s+", "SECRETARY", (countSecretaryF / size) * 100 + "% FEMALE");
        System.out.printf("\n+%-20s| %-19s+", "", (countSecretaryM / size) * 100 + "% MALE");

        System.out.println("\n+-----------------------------------------+");
    }

    public static void bonusByProfession() {
        double bonusManager = 0;
        double bonusProgrammer = 0;
        double bonusTechnician = 0;
        double bonusSecretary = 0;

        for (Employees emp1 : Employees.employee) {
            switch (emp1.getProfession()) {
                case MANAGER:
                    bonusManager += emp1.getBonus();

                    break;
                case PROGRAMMER:

                    bonusProgrammer += emp1.getBonus();
                    break;
                case TECHNICIAN:

                    bonusTechnician += emp1.getBonus();

                    break;
                case SECRETARY:

                    bonusSecretary += emp1.getBonus();

                    break;
                default:
                    System.out.println("Give a valid input");
            }

        }

        System.out.println("The total bonus by profession\n"
                + "******************************* ");
        System.out.println("+--------------------------------+");
        System.out.printf("+%-20s| %-10s+", "Profession", "Bonus");
        System.out.println("\n+--------------------------------+");

        System.out.printf("+%-20s| %-10s+", "MANAGER", bonusManager);
        System.out.printf("\n+%-20s| %-10s+", "PROGRAMMER", bonusProgrammer);
        System.out.printf("\n+%-20s| %-10s+", "TECHNICIAN", bonusTechnician);
        System.out.printf("\n+%-20s| %-10s+", "SECRETARY", bonusSecretary);
        System.out.println("\n+--------------------------------+");
    }

    public static void overallGenderDistribution() {
        double femalePercentage = 0;
        double malePercentage = 0;

        int size = Employees.employee.size();

        for (Employees emp1 : Employees.employee) {

            switch (emp1.getGender()) {
                case FEMALE:
                    femalePercentage++;
                    break;
                case MALE:
                    malePercentage++;
                    break;
                default:

                    break;
            }
        }

        System.out.println("The overall gender distribution \n********************************\nFEMALE: " + (femalePercentage / size) * 100 + "%\nMALE:" + (malePercentage / size) * 100 + "% \n********************************\n");
    }

    public static void highestSalary() {
        double maxSalary = 0;

        for (Employees emp2 : Employees.employee) {
            if (maxSalary < emp2.getSalary()) {
                maxSalary = emp2.getSalary();
                ;
            }
        }
        System.out.println("The highest salary \n*******************\n" + maxSalary + "\n*****************\nThe Employee details are:");
        Employees.printTableFormatHeader();
        for (Employees emp3 : Employees.employee) {
            if (maxSalary == emp3.getSalary()) {

                Employees.printTableFormat(Employees.employee.get(emp3.getId() - 1));

            }
        }
        Employees.printTableFormatFooter();

    }

    public static void lowestSalary() {
        double minSalary = Employees.employee.get(0).getSalary();

        for (Employees emp2 : Employees.employee) {
            if (minSalary > emp2.getSalary()) {
                minSalary = emp2.getSalary();
                ;
            }
        }
        System.out.println("The lowest salary \n*****************\n " + minSalary + "\n*****************\nThe Employee details are:");
        Employees.printTableFormatHeader();
        for (Employees emp3 : Employees.employee) {
            if (minSalary == emp3.getSalary()) {

                Employees.printTableFormat(Employees.employee.get(emp3.getId() - 1));

            }
        }
        Employees.printTableFormatFooter();

    }
}
