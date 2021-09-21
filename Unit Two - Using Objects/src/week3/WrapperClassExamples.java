package week3;

public class WrapperClassExamples {
    public static void main(String[] args) {
        Integer x = new Integer(7); // explicitly constructing a Integer Object
        Double d = new Double(3.4);

        Double num = 3.4;           // auto-boxing (Java creates a Double object before assignment)

        double d1 = num;

       System.out.println(num.doubleValue());
       System.out.println(num);

       System.out.println(x);
       System.out.println(x.intValue());

       System.out.println(Integer.MAX_VALUE);
       System.out.println(Integer.MIN_VALUE);

       System.out.println(Long.MAX_VALUE);
       System.out.println(Long.MIN_VALUE);


    }
}
