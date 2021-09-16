package week2;

public class StudentExample {
    public static void main(String[] args) {
        // Ritchie is a variable to an instance of the class student 
        // ritchie is an object (instances of a class)
       Student ritchie = new Student("Ritchie", "45645", 10);
        Student yola = new Student("Yola", "123456", 10);

        // ritchie and yola are references to two different students

        Student rastin = ritchie;

        //because rastin and ritchie refer to the same student object it increases the grade for both (still its only 1 object)

        rastin.increaseGrade();

        ritchie = null;
        // Student tristan;     tristan is currently the null reference

        // ritchie.increaseGrade();    // throws java.Long.NullPointerException because ritchie is null

           // yola.addTest(87);
          //  yola.displayAverage();
          //  yola.addTest(91);
        
    }
}
