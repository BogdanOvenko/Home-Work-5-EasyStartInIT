import java.util.Arrays;

/**
 * Created by Bogdan on 07.04.2017.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{26, 59, 64, 1, 19, 35, 49, 41, 28};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int firstIndex, int lastIndex){
        if (lastIndex <= firstIndex) return;
        int middleIndex = firstIndex + (lastIndex - firstIndex)/2;
        mergeSort(array, 0, middleIndex);
        mergeSort(array, middleIndex + 1, lastIndex);
        merge(array, firstIndex, middleIndex, lastIndex);
    }

    public static void merge(int[] array, int firstIndex, int middleIndex, int lastIndex){
        int[] buffer = Arrays.copyOf(array, array.length);
        int i = firstIndex, j = middleIndex + 1;
        for(int k = firstIndex; k <= lastIndex; k++){
            if(i > middleIndex){
                array[k] = buffer[j];
                j++;
            } else if(j > lastIndex){
                array[k] = buffer[i];
                i++;
            } else if(buffer[i] < buffer[j]){
                array[k] = buffer[i];
                i++;
            } else {
                array[k] = buffer [j];
                j++;
            }
        }
    }
}
