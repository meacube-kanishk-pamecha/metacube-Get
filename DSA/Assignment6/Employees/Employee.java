package Employees;

public class Employee implements Comparable<Employee> {
    private int age;
    private int salary;
    private String name;

    Employee(int age, int salary, String name) {
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    @Override
    public String toString() {
        return  salary + "->" + age + "->" + name ;
    }

    /*
     * compareTo function compares the current object with the passed object and return int
     * @param Employee o the object which is to be compared with the current object
     */
    @Override
    public int compareTo(Employee o) {
        if (this.salary < o.getSalary())
            return 1;
        else if (this.salary == o.getSalary())
            return this.age > o.age ? 1 : -1;
        else
            return -1;
    }
}
