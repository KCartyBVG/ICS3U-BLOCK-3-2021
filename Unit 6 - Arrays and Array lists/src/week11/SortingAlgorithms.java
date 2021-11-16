package week11;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = {80, 70, 10, 15, 20, 5, 90, 85}; //not sorted

        //selectionSort(arr); // returns sorted method 

        insertionSort(arr);
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1;i<arr.length;i++){ //starts at one, assumes the first one is in the right place
          int temp = arr[i];
           int j;
            for (j = i;j>0 && temp < arr[j];j--){ // shifts elements as long as j<0 and temp(current element) is smaller than j(what your checking and shifting)
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }

    private static void selectionSort(int[] arr) {
        for(int i=0; i<arr.length-1;i++){ // sort the next item
            int smallestIndex = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < arr[smallestIndex]) // find the smallest. compares with the past smallest
                    smallestIndex = j;
            }
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;

        }
    }
}
