import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;

public class SortUtil {

    public  Integer[] selectionSort(Integer[] arr, String order){

            int n = arr.length;

            // One by one moving boundary of unsorted subarray
            for (int i = 0; i < n-1; i++)
            {
                // Finding the minimum element in unsorted array
                int min_idx = i;
                for (int j = i+1; j < n; j++)
                    if (arr[j] < arr[min_idx])
                        min_idx = j;

                // Swapping the found minimum element with the first element
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }


        if (order.equalsIgnoreCase("ascending"))
                return  arr;
        else {

                Collections.reverse(Arrays.asList(arr));
                return arr;
        }
    }


    public  int[] mergeSort(int[] array)
    {
        if(array == null)
        {
            return null;
        }

        if(array.length > 1)
        {
            int mid = array.length / 2;

            // Split left part
            int[] left = new int[mid];
            System.arraycopy(array, 0, left, 0, mid);

            // Split right part
            int[] right = new int[array.length - mid];
            if (array.length - mid >= 0) System.arraycopy(array, mid, right, 0, array.length - mid);

            mergeSort(left);
            mergeSort(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Merge left and right arrays
            while(i < left.length && j < right.length)
            {
                if(left[i] < right[j])
                {
                    array[k] = left[i];
                    i++;
                }
                else
                {
                    array[k] = right[j];
                    j++;
                }
                k++;
            }
            // Collect remaining elements
            while(i < left.length)
            {
                array[k] = left[i];
                i++;
                k++;
            }
            while(j < right.length)
            {
                array[k] = right[j];
                j++;
                k++;
            }
        }
        return array;
    }

//    // Driver program to test above functions.
//    public static void main(String[] args)
//    {
//        Integer[] arr = {12, 11, 13, 5, 6, 7};
//        int i=0;
//        System.out.println("Given array is");
//
//        for(i=0; i<arr.length; i++)
//            System.out.print(arr[i]+" ");
//
//        selectionSort(arr,"ascending");
//
//        System.out.println("\n");
//        System.out.println("Sorted array is");
//
//        for(i=0; i<arr.length; i++)
//            System.out.print(arr[i]+" ");
//    }
//
//

}
