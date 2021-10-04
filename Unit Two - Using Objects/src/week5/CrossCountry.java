package week5;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        processRunner(in);
        processRunner(in);
        processRunner(in);

        in.close();
    }

    private static void processRunner(Scanner in) {
        String firstName, lastName;
        String mileOne, mileTwo, mileThree;

        String splitTwo, splitThree;

        /**
         * get the name and mile one, mile two, finish time from the user
         */

         splitTwo = subtractTimes(mileTwo, mileOne);
         splitThree = subtractTimes(mileThree, mileTwo);

         /**
          * display a summary for the runner
          */
    }

    private static String subtractTimes(String endTime, String startTime) {
        double endInSeconds = convertToSeconds(endTime);
        double startInSeconds = convertToSeconds(startTime);

        double diffInSeconds = endInSeconds - startInSeconds;

        return convertToTime(diffInSeconds);
    }

    private static String convertToTime(double diffInSeconds) { 
        double mins = getMinutes(diffInSeconds);
        double seconds = getSeconds(diffInSeconds);

        return mins + ":" + seconds;
    }

    private static double getSeconds(double diffInSeconds) {
        double seconds = diffInSeconds%60;
        return seconds;
    }

    private static double getMinutes(double diffInSeconds) {
        double mins = (int) (diffInSeconds/60);
        return mins;
    }

    private static double convertToSeconds(String Time) {
    int colon = Time.indexOf(":");
    String mins = Time.substring(0, colon);
    String seconds = Time.substring(colon);

    Double minsNum = Double.valueOf(mins);
    Double secondsNum = Double.valueOf(seconds);

    double totalSeconds = minsNum + secondsNum;

    return totalSeconds;
    }
}
