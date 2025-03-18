import org.junit.Test;

public class OverallTest {
    @Test
    public void Test() {
        Employee e1 = new Developer("Kanishk", 50000);
        Employee e2 = new Developer("Jay", 5000);
        Employee e3 = new Developer("Maynk", 500000);
        Employee e4 = new Developer("Jay", 5000);
        Employee e5 = new Developer("Maynk", 500000);
        Department d = new Department("Woring");
        d.join(e3);
        d.join(e1);
        d.join(e4);
        d.join(e5);
        Department d2 = new Department("Not Woring");
        d2.join(e2);
        Organization n1 = new Organization();
        n1.addDepartment(d);
        n1.addDepartment(d2);
        for (var s : n1.getEmployees()) {
            System.out.println(s.getName());
        }
        System.out.println(d.relive(e3));
        System.out.println("\nResult After releaving employee");
        for (var v : n1.getEmployees()) {
            System.out.println(v.getName());
        }

        Payroll.getpaySlip(n1);
    }
}
