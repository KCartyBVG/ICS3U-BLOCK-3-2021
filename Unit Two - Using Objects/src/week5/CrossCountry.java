package week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        processRunner(in);  //caling the function 3 times, once for each runner.
        processRunner(in);
        processRunner(in);

        in.close();
    }

    private static void processRunner(Scanner in) {
        String firstName, lastName;             // creating all variables to use.
        String mileOne, mileTwo, finishTime;

        String splitTwo, splitThree;

        System.out.print("Please insert your first name: ");
        firstName = in.nextLine();

        System.out.print("Please insert your last name: ");
        lastName = in.nextLine();

        System.out.print("Please insert your mile one time: ");
        mileOne = in.nextLine();

        System.out.print("Please insert your time after your second mile: ");
        mileTwo = in.nextLine();

        System.out.print("Please insert your final time: ");
        finishTime = in.nextLine();


         splitTwo = subtractTimes(mileTwo, mileOne);
         splitThree = subtractTimes(finishTime, mileTwo);


          System.out.println("Summary for " + lastName + ", " + firstName);
          System.out.println("Split one: " + mileOne);
          System.out.println("Split two: " + splitTwo);
          System.out.println("Split three:" + splitThree);
        }

    /**
     * subtractTimes is used to find the splits (the difference between the given times).
     * @param endTime
     * @param startTime
     * @return
     */
    private static String subtractTimes(String endTime, String startTime) {
        double endInSeconds = convertToSeconds(endTime); //both endTime and startTime are Strings and need to be converted to doubles to be used. 
        double startInSeconds = convertToSeconds(startTime);

        double diffInSeconds = endInSeconds - startInSeconds;

        return convertToTime(diffInSeconds); // use convertToTime to convert the difference back into a String 
    }

    /**
     * convertToTime is used to convert the new time (diffInSeconds) into a String
     * @param diffInSeconds
     * @return
     */
    private static String convertToTime(double diffInSeconds) { 
        int mins = getMinutes(diffInSeconds); // using getMinutes to seperate the minutes from the seconds.
        double seconds = getSeconds(diffInSeconds); // using getSeconds to get the remaining seconds.

        return String.format("%d:%06.3f", mins, seconds);
    }

    /**
     * getSeconds is used to seperate the seconds and the minutes and return the seconds only.
     * @param diffInSeconds
     * @return
     */
    private static double getSeconds(double diffInSeconds) {
        double seconds = diffInSeconds%60; // modding by 60 will divide all the seconds by 60 and return the remainder(the seconds without the full minutes)
        return seconds;
    }

    /**
     * getMinutes is used to seperate the minutes from the seconds and return the minutes only.
     * @param diffInSeconds
     * @return
     */
    private static int getMinutes(double diffInSeconds) {
        return (int) (diffInSeconds/60); //dividing the total seconds by 60 will find the number of full minutes. casting it to an int will get rid of the decimals.
        
    }

    /**
     * convertToSeconds is used to convert the String given by the user into a double. the double will be the total amount of seconds.
     * @param Time
     * @return
     */
    private static double convertToSeconds(String time) {
    int colon = time.indexOf(":"); 
    String mins = time.substring(0, colon); // seperating the minutes from the seconds in the String
    String seconds = time.substring(colon+1);

    Double minsNum = Double.valueOf(mins); //converting the Strings(seconds and minutes) into double so be used at numbers. 
    Double secondsNum = Double.valueOf(seconds);

    double minsToSeconds = minsNum*60; // taking the number of minutes and multiplying by 60 to convert into seconds.

    double totalSeconds = minsToSeconds+ secondsNum; //findign the total amount of seconds by adding the seconds and the minutes(converted to seconds).

    return totalSeconds;
    }
}
