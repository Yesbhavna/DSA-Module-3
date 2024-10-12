import java.io.*;
import java.util.*;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // Your code here.
        int n = arr.length;
        
        int si = 0;
        int ei = n - 1;

        while (si <= ei) {

            int mid = (si + ei) / 2;
                if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                    return mid;
                } else if (arr[mid + 1] > arr[mid]) {
                    //right part is increasing
                    //search for peak index in right
                    si = mid + 1;
                } else {
                    //search in left part
                    ei = mid - 1;
                }   
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.peakIndexInMountainArray(arr1);
        System.out.print(result + " ");
        System.out.println('\n');
    }
}