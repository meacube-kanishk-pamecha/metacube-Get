import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Department {

    private String name;
    private int salary;
    Set<Employee> ans = new HashSet<>();

    public Department(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    /**
     * join adds a employee to the Set 
     * @param  Employee e that is to be added in the List
     * @return  boolean if it is added then true else false
     */
    boolean join(Employee e) {
        ans.add(e);
        return true;
    }

    /**
     * relive if we wants to remove a employee from the department 
     * @param Employee e 
     * @return
     */
    boolean relive(Employee e) {
        boolean d = ans.contains(e);
        //checks it is present or not
        if(d) {ans.remove(e);return true;}
        return false;
    }

    public String getName() {
        return name;
    }

    /**
     * getEmployees it  is a function for getting all the employees in department
     * @return List<Employee>  added all the employess in it.
     */
    List<Employee> getEmployees() {
        List<Employee> answer = new ArrayList<>();
        // from hashSet it conver to list and return that list
        for (Employee employee : ans) {
            answer.add(employee);
           
        }
        return answer;
    }

}