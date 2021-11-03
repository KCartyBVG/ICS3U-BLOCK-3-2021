package week9;

public class StepTracker {
    private int daysActive;
    private int minSteps;
    private int totalSteps;
    private int numberDays;

    public StepTracker(int min) {
        minSteps = min;
        totalSteps = 0;
        numberDays = 0;
        daysActive = 0;

    }


    public void addDailySteps(int steps) {
        totalSteps += steps;
        numberDays++;
        if (steps >= minSteps)
            daysActive++;
    }
    public int activeDays() {
        return daysActive;
    }

    public double averageSteps() {
        return (double) totalSteps/numberDays;
    }


}
