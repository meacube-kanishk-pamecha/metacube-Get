class Developer extends Employee{
    String name;
    int salary;
    // developer constructor to get the name name and salary
    Developer(String name, int salary){
        this.name=name;
        this.salary = salary;
    }
    int getBasicSalary() {
        
        return salary;
    }
    
    int getBonus(){
        int bonus = 10/100;
        return bonus*getBasicSalary();
      
    }
    // implementing the get name
    public String getName() {
        return name;
    }
    // implement of getting compensation
    int getCompensation(){
      return getBasicSalary()+getBonus();
    }
  }