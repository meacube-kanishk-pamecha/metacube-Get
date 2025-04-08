package Employees;

public class Employee {
    static int count = 0;
    int empId;
    String name;
    String address;

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + "]";
    }



    /**
     * Employee class constructor for creating the objects of the Employee class
     * 
     * @param String name Name of the employee
     * @param String address it takes and used to store the address of the employe
     */
    public Employee(String name, String address) {
        this.empId = count++;
        this.name = name;
        this.address = address;
    }

    /**
     * Employee class constructor for creating the objects of the Employee class
     * 
     * @param int    id
     * @param String name Name of the employee
     * @param String address it takes and used to store the address of the employe
     */
    public Employee(int id, String name, String address) {
        this.empId = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + empId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (empId != other.empId)
            return false;
        return true;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}