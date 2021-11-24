package week12;

import java.util.ArrayList;

import week11.ForEachExample;

public class ArrayListExamples {
public static void main(String[] args) {
        
    
    ArrayList<String> words = new ArrayList<String>();

    words.add("stuff");
    words.add("more stuff");

    words.remove(0);
    words.add(0,"alphabet");

    for (int i = 0; i< words.size(); i++) {
        System.out.println(words.get(i));
    }
}
}
