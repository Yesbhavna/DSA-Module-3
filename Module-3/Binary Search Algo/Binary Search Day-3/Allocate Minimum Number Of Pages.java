import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public long MinimumPages(int[] A, int B) {
        //Write your code here
        if(A.length < B){
            return -1;
        }
        long lo =0;
        long hi =0;
        for(int pages : A){
            lo = Math.max(pages,lo);
            hi += pages;
        }
        long pans = -1;
        while(lo<= hi){
            long mid = (lo+hi)/2;
            if(isPossible(A,B,mid) == true){
                pans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return pans ;

    }
    public boolean isPossible(int[] A, int B, long maxCap){
        int stud = 1;
        int currpages = 0;
        for(int pages : A){
            if(currpages + pages <= maxCap){
                currpages += pages;
            }else{
                stud++;
                currpages = pages;
            }
        }
        if(stud >B){
            return false;
        }else{
            return true;
        }
    }
}

class Main {
    

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    
	    int N = sc.nextInt();
	    int B = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++)
            A[i] = sc.nextInt();

        Solution Obj = new Solution(); 
        System.out.println(Obj.MinimumPages(A,B));
	}
}