import java.util.ArrayList;

class Tester extends Employee {
    private ArrayList<String> testingTypes;

    public Tester(String firstName, String lastName, String address, String email, String pesel, int hireYear) {
        super(firstName, lastName, address, email, pesel, hireYear);
        this.testingTypes = new ArrayList<>();
    }

    public void addTestType(String testType) {
        this.testingTypes.add(testType);
    }

    @Override
    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        int bonus = testingTypes.size() * 300;
        return baseSalary + bonus;
    }
}