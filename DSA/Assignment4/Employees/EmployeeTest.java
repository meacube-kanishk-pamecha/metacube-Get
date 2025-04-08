package Employees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.HashSet;

public class EmployeeTest {

    public static void main(String[] args) {
        Employee e = new Employee("Kanishk ", "Nansas");
        List<Employee> ans = new ArrayList<>();
        ans.add(e);
        ans.add(new Employee("Kbnishk ", "jamsas"));
        ans.add(new Employee(1, "Ab", "dkshd"));
        ans.add(new Employee(1, "AA", "dshd"));

        // sorting by id
        Comparator<Employee> myComparator = new sortById();
        Collections.sort(ans, myComparator);
        System.out.println("sorted by is");
        // printing the employee present in the list
        for (Employee employee : ans) {
            System.out.println(employee);
        }

        // sorted by name
        Comparator<Employee> comparatorName = new sortByName();
        Collections.sort(ans, comparatorName);
        System.out.println("sorted by is");
        // printing the employee present in the list
        for (Employee employee : ans) {
            System.out.println(employee);
        }

        
        // for making only unique objects
        HashSet<Employee> hs = new HashSet<>();
        for (Employee emp : ans) {
            hs.add(emp);
        }

        // printing all the employees
        for (Employee employee : hs) {
            System.out.println(employee);
        }
    }
}

// sorting the Employee class objects on the basis of Id
class sortById implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.empId - e2.empId;
    }
}

// sorting the Employee class objects on the basis of Name
class sortByName implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}