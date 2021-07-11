import org.junit.jupiter.api.*;

import java.util.*;

public class Test {

   SortUtil sortUtil;
   TestInfo testInfo;
   TestReporter testReporter;
   Random random;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){
        sortUtil = new SortUtil();
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        random = new Random();
        this.testReporter.publishEntry("\nRunning "+testInfo.getDisplayName() + " with tags " + testInfo.getTags()+"\n");
    }


    @org.junit.jupiter.api.Test
    @Tag("Sorting_just_one_number")
    public void Test2(){  //Sorting just one number

        Integer[] input = getArray(1);
//        Integer[] expected = {20};
        Integer[] reality = sortUtil.selectionSort(input,"desc");

        boolean sorted = isSorted_desc(reality,reality.length);
        boolean notAltered = isEqual(input,reality);

       showMessage(sorted,notAltered,"Sorting_just_one_number (with " + input.length +" elements)");

    }

    @org.junit.jupiter.api.Test
    @Tag("Sorting_two_number")
    public void Test3(){  //Sorting_two_number

        Integer[] input = getArray(2);

        Integer[] reality = sortUtil.selectionSort(input,"ascending");

        /* checking the two checkpoint*/
        boolean sorted = isSorted_Asc(reality,reality.length);
        boolean notAltered = isEqual(input,reality);

        showMessage(sorted,notAltered,"Sorting_just_one_number (with " + input.length +" elements)");

    }

    @org.junit.jupiter.api.Test
    @Tag("Sorting_random_sized_list")
    public void Test4(){  //Sorting_random_sized_list

        int size = random.nextInt(2657);
        Integer[] input = getArray(size);

        Integer[] reality = sortUtil.selectionSort(input,"ascending");

        /* checking the two checkpoint*/
        boolean sorted = isSorted_Asc(reality,reality.length);
        boolean notAltered = isEqual(input,reality);

        showMessage(sorted,notAltered,"Sorting_random_sized_list (with " + input.length +" elements)");

    }

    @org.junit.jupiter.api.Test
    @Tag("Sorting_random_element_list")
    public void Test5(){  //The numbers in the list is initialized randomly


        Integer[] input = getArray(); //getting random list

        Integer[] reality = sortUtil.selectionSort(input,"ascending");

        /* checking the two checkpoint*/
        boolean sorted = isSorted_Asc(reality,reality.length);
        boolean notAltered = isEqual(input,reality);

        showMessage(sorted,notAltered,"Sorting_random_element_list (with " + input.length +" elements)");

    }

    @org.junit.jupiter.api.Test
    @Tag("Sorting_ascending_ordered_element_list")
    public void Test6(){  //The_numbers_in_the_is_sorted_in_ascending_order

        Integer[] input = getArray("asc");

        Integer[] reality = sortUtil.selectionSort(input,"desc");

        /* checking the two checkpoint*/
        boolean sorted = isSorted_desc(reality,reality.length);
        boolean notAltered = isEqual(input,reality);

        showMessage(sorted,notAltered,"Sorting_ascending_ordered_element_list (with " + input.length +" elements)");

    }

    @org.junit.jupiter.api.Test
    @Tag("Sorting_descending_ordered_element_list")
    public void Test7(){  //The_numbers_in_the_is_sorted_in_ascending_order


        Integer[] input = getArray("desc");

        Integer[] reality = sortUtil.selectionSort(input,"ascending");

        /* checking the two checkpoint*/
        boolean sorted = isSorted_Asc(reality,reality.length);
        boolean notAltered = isEqual(input,reality);

        showMessage(sorted,notAltered,"Sorting_descending_ordered_element_list (with "+input.length +" elements)");

    }


    @org.junit.jupiter.api.Test
    @Tag("Sorting_same_element_list")
    public void Test8(){  //The_numbers_in_the_is_sorted_in_ascending_order


        Integer[] input = getArray("same");

        Integer[] reality = sortUtil.selectionSort(input,"ascending");

        /* checking the two checkpoint*/
        boolean sorted = isSorted_Asc(reality,reality.length);
        boolean notAltered = isEqual(input,reality);

        showMessage(sorted,notAltered,"Sorting_same_element_list (with "+input.length +" elements)");

    }




    /*================= This Part is for Helper Methods==================*/

    private boolean isSorted_Asc(Integer[] arr, int n)
    {
        if (n == 1 || n == 0)
            return true;

        if (arr[n - 1] < arr[n - 2])
            return false;

        return isSorted_Asc(arr, n - 1);

    }

    private boolean isSorted_desc(Integer[] arr, int n)
    {
        if (n == 1 || n == 0)
            return true;

        if (arr[n - 1] > arr[n - 2])
            return false;

        return isSorted_desc(arr, n - 1);
    }

    private boolean isEqual(Integer[] arr1, Integer[] arr2){

        List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(arr1));
        List<Integer> l2 = new ArrayList<Integer>(Arrays.asList(arr2));

        Collections.sort(l1);
        Collections.sort(l2);

        return l1.equals(l2);

    }

    private void showMessage(boolean firstcheck, boolean secondCheck, String testTag){

        if (firstcheck && secondCheck)
        {
            System.out.println(testTag+" test passed!\n");
            Assertions.assertEquals(1,1); // dummy
        }
        else {
            System.out.println(testTag+" test Failed\n");
            Assertions.assertEquals(1,0); //dummy
        }

    }

    private  Integer[] getArray(int size){

        Integer[] arr = new Integer[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(2891);
        }
        return arr;
    }

    private Integer[] getArray(){
        int size = random.nextInt(9878);
        Integer[] arr = new Integer[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(2891);
        }
        return arr;
    }

    private Integer[] getArray(String order){
        int size = random.nextInt(9763);
        int starter = random.nextInt(9876);

        Integer[] arr = new Integer[size];

        for (int i = 0; i <size ; i++) {

            arr[i] = starter;
            if (order.equalsIgnoreCase("asc"))
                starter++; //making the list asc
            else if (order.equalsIgnoreCase("desc"))
                starter--; //making the list desc

           // System.out.println(arr[i]+" ");
        }
        return arr;
    }





    @org.junit.jupiter.api.Test
    @Tag("Sorting_a_blank_list")
    public void Test1(){  //i) Sorting a blank list

        Integer[] input = {};
//        Integer[] expected = {};
        Integer[] reality = sortUtil.selectionSort(input,"desc");

        boolean sorted = isSorted_desc(reality,reality.length);
        boolean notAltered = isEqual(input,reality);

        showMessage(sorted,notAltered,"Sorting_a_blank_list (with "+input.length +" elements) ");


    }



}
