import java.io.*;
import java.util.*;


/* Intent - Find all permutations of a given string */
public class StringPermutations {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String test = "abcde";
        
        findPermutations(test.toCharArray(), 0, test.length());
    }
    
    static void findPermutations(char[] input, int idx, int len) {
        if (idx == len-1) {
            System.out.println(input);
            return;
        }
        
        for (int j = idx; j < len; j++) {
            swap(idx, j, input);
            findPermutations(input, idx+1, len);
            swap(idx, j, input);
        }
    }
    
    static void swap(int i, int j, char[] test) {
        char temp = test[i];
        test[i] = test[j];
        test[j] = temp;
    }
}
