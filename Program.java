import java.util.ArrayList;

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

class Developer extends Employee {
    private ArrayList<Technology> technologies;

    public Developer(String firstName, String lastName, String address, String email, String pesel, int hireYear) {
        super(firstName, lastName, address, email, pesel, hireYear);
        this.technologies = new ArrayList<>();
    }

    public void addTechnology(Technology technology) {
        this.technologies.add(technology);
    }

    @Override
    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        int bonus = 0;
        for (Technology tech : technologies) {
            bonus += tech.getBonus();
        }
        return baseSalary + bonus;
    }
}

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

class Manager extends Employee {
    private ArrayList<Goal> goals;

    public Manager(String firstName, String lastName, String address, String email, String pesel, int hireYear) {
        super(firstName, lastName, address, email, pesel, hireYear);
        this.goals = new ArrayList<>();
    }

    public void addGoal(Goal goal) {
        this.goals.add(goal);
    }

    @Override
    public int calculateSalary() {
        int baseSalary = super.calculateSalary();
        int bonus = 0;
        int currentMonth = 4; // Zakładając, że aktualny miesiąc to kwiecień
        for (Goal goal : goals) {
            if (goal.getMonth() == currentMonth) {
                bonus += goal.getBonus();
            }
        }
        return baseSalary + bonus;
    }
}

class Technology {
    private String name;
    private int bonus;

    public Technology(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}

class Goal {
    private int year;
    private int month;
    private int day;
    private String description;
    private int bonus;

    public Goal(int year, int month, int day, String description, int bonus) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.description = description;
        this.bonus = bonus;
    }

    public int getMonth() {
        return month;
    }

    public int getBonus() {
        return bonus;
    }
}

public class Program {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        // Tworzenie i dodawanie programistów
        Developer dev = new Developer("John", "Doe", "New York", "john@doe.com", "123456789", 2020);
        Technology t = new Technology("Java", 800);
        dev.addTechnology(t);
        employees.add(dev);
        // Tworzenie i dodawanie testerów
        Tester tester = new Tester("Jane", "Smith", "Los Angeles", "jane@smith.com", "987654321", 2021);
        tester.addTestType("UI/UX");
        employees.add(tester);
        // Tworzenie i dodawanie menadżerów
        Manager manager = new Manager("Bob", "Johnson", "Chicago", "bob@johnson.com", "1122334455", 2019);
        Goal g = new Goal(2010, 10, 15, "Implementing FB login", 1000);
        manager.addGoal(g);
        employees.add(manager);
        // Obliczanie całkowitej kwoty do wypłaty
        int totalAmount = 0;
        for (Employee employee : employees) {
            totalAmount += employee.calculateSalary();
        }
        System.out.println("Total amount to be paid this month: " + totalAmount + " USD");
    }
}
