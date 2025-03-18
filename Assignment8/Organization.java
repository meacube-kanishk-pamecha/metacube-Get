import java.util.ArrayList;
import java.util.List;

class Organization {

    List<Department> ansDep = new ArrayList<>();

    /**
     * List of department add the department at each call
     * return boolean
     */
    boolean addDepartment(Department d1) {
        if (!ansDep.contains(d1)) {
            ansDep.add(d1);
            return true;
        }
        return false;
    }

    /**
     * getEmployees is a function to get all the employees in the orgqnization
     * 
     * @return List<Employee> which has all the department in the employees.
     */
    List<Employee> getEmployees() {

        List<Employee> ans = new ArrayList<>();
        // adding all the employees of each department in the list
        for (Department d : ansDep) {
            ans.addAll(d.getEmployees());
        }
        return ans;
    }

}