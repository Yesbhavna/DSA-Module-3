import java.util.*;

public class Main {
    // TC: O(log N), SC: O(1)
    public static int findIndex(int key, int[] arr) {
        int low =0, high = arr.length-1;

        while(low <= high){
            //find the mid 

            int mid = low + (high-low)/2;
            if(arr[mid] == key){
                return mid;
            }else if (arr[mid] > key){
                //move left;
                high = mid -1;
            }else {
                // move right 
                low = mid+ 1;
            }
        }
        return -1;
       
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, key;
        n = sc.nextInt();
        key = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(findIndex(key, arr));
        sc.close();
    }
}