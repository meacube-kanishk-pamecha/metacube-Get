import java.util.List;

class Payroll{

    /**
     * getpaySlip is a getPaySlip function that prints the details of the employees 
     * @param Organization n1 objects of the organization that prints the the employees detail
     */
   public  static void  getpaySlip(Organization n1)
    {
        List<Employee> listEmployees = n1.getEmployees();
        //iterating over all the employess of organization
        for (Employee employee : listEmployees) {
            System.out.println(employee.getName()+" has a Salary : "+employee.getCompensation()+ " With Tax : "+employee.getCompensation()*5/10);
        }


    }

}