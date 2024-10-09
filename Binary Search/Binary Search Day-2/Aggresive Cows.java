import java.io.*;
import java.util.*;
import java.util.*;

class Solution{

    public static int aggressiveCows(int stalls[],int k){
       //Write your code here
       int n = stalls.length;
       Arrays.sort(stalls);
       int low =1;
       int high = stalls[n-1]-stalls[0];
       while(low <= high){
        int mid = (low+ high)/2; 
        if(canWePlace(stalls,mid,k)== true){
            low = mid+1;
        }else{
            high = mid-1;
        }
       }
      return high;
    
    }
    public static boolean canWePlace(int[] stalls, int dist, int cows){
        int n = stalls.length;
        int countCows = 1;
        int lastplacedcow = stalls[0];
        for(int i = 1; i<n; i++){
            if(stalls[i] - lastplacedcow >= dist){
                countCows++;
                lastplacedcow = stalls[i];
            }
            if(countCows == cows){
                return true;
            }

        }
         return false;
    }


}

class Main {
        public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
        Solution obj=new Solution();
		System.out.println(obj.aggressiveCows(nums,k));

    }
}
