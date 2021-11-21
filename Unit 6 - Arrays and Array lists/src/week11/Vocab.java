package week11;
public class Vocab{
private String[] theVocab = new String[1];

public boolean findWord(String str){
    for(String w : theVocab){
        if (str.equals(str))
            return true;
    }
    return false;
}

public int countNotInVocab(String[] wordArray) {
    int count = 0;
    for(String w : wordArray) {
        if(findWord(w))
            count++;
    }
    return count;
}

public String[] notInVocab(String[] wordArray){
    String[] arr = new String[countNotInVocab(wordArray)];
    int index = 0;
    for (int i = 0; i < wordArray.length; i++) {
        if (!findWord(wordArray[i])){
            arr[index] = wordArray[i];
            index++;
        }
    }
    return arr;
}




}