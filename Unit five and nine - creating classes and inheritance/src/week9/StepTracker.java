package week9;

public class StepTracker {
    private int daysActive = 0;
    private int dailySteps;
    private int minSteps;
    private int totalSteps = 0;
    private int numberDays = 0;

    public StepTracker(int min) {
        minSteps = min;
    }


    public void addDailySteps(int steps) {
        dailySteps = steps;
        totalSteps += steps;
        numberDays++;
        if (dailySteps >= minSteps)
            daysActive++;
    }
    public int activeDays() {
        return daysActive;
    }

    public double averageSteps() {
        return (double) totalSteps/numberDays;
    }


}
