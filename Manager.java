import java.util.ArrayList;

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
