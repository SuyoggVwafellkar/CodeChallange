
//Given an unsorted integer array containing many duplicate elements,
// rearrange it such that the same element appears together
// and the relative order of the first occurrence of each element remains unchanged.
//        For example:
//        Input:  { 1, 2, 3, 1, 2, 1 }
//        Output: { 1, 1, 1, 2, 2, 3 }

//        Input:  { 5, 4, 5, 5, 3, 1, 2, 2, 4 }
//        Output: { 5, 5, 5, 4, 4, 3, 1, 2, 2 }

import java.util.ArrayList;
import java.util.List;

public class CodingChallenge3107 {

    public static void ArraySorting(int[] input) {

        List<Integer> list1 = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {

            if (list1.contains(input[i])) {
                continue;
            }
            for (int j = 0; j < input.length; j++) {
                if (input[i] == input[j]) {
                    list1.add(input[i]);
                }
            }
        }
        System.out.println(list1);
    }
    public static void main(String[] args) {

        int[] input = {5, 4, 5, 5, 3, 1, 2, 2, 4};
        ArraySorting(input);

    }


}
