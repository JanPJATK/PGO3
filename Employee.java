class Employee {
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String email;
    protected String pesel;
    protected int hireYear;
    public Employee(String firstName, String lastName, String address, String email, String pesel, int hireYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.pesel = pesel;
        this.hireYear = hireYear;
    }

    public int calculateSalary() {
        int baseSalary = 3000;
        int currentYear = 2024; // Zakładając, że obecny rok to 2024
        int yearsWorked = currentYear - hireYear;
        return baseSalary + (yearsWorked * 1000);
    }
}