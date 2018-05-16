
package employeemanagement;

import java.time.LocalDate;


public class Technician extends Employees {

  
    
    public Technician (String firstName, String lastName, String address, Profession profession, Gender gender, LocalDate dateOfBirth, double salary) {
     super(firstName, lastName, address, profession, gender, dateOfBirth, salary);
      
    }
    
    public  double calculateBonus(double salary){
     double bonus= Math.ceil(salary*.15);
     return bonus;
    
    }

}
