package week11;

public class Sound {
    private int[] samples;


    public int limitAmplitudes(int limit) {
        int changes = 0;

        for (int i = 0; i < samples.length; i++) {
            if (samples[i] > limit){
                samples[i] = limit;
                changes++;
            }else if (samples[i] < -limit){
                samples[i] = -limit;
                changes++;
            }
         }
         return changes; 
    }

    public void trimSilenceFromBeginning() {
        int numZeros = 0;
        boolean isZero = true;

        for (int i = 0; isZero; i++) {
            if (samples[i] == 0){
                numZeros++;
            }else
                isZero = false;
        }
        int index = 0;

        int[] arr = new int[samples.length-numZeros];
        for (int i = numZeros-1; i < arr.length; i++) {
            arr[index] = samples [i];
            index++;
        }

        samples = arr;
    }
}
