
public abstract class Employee {

  private String name;
  private static int id = 1;

  Employee() {
    id++;
  }

  /**
   * abstract Method of getBasicSalary
  */
  abstract int getBasicSalary();

  /**
   * abstract Method of getBonus
  */
  abstract int getBonus();

  /**
   * abstract Method of getCompensation
  */
  abstract int getCompensation();

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

}
