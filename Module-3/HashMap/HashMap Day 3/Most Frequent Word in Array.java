import java.io.*;
import java.util.*;

class Solution {
    public void mostFrequent(String []arr, int n) {
        // write your code here
        int maxFreq =0;
        HashMap<String,Integer> map = new HashMap<>();
        for(String w : arr){
            map.put(w, map.getOrDefault(w,0) + 1);
            maxFreq = Math.max(maxFreq,map.get(w));

        }
        HashSet<String> set = new HashSet<>();
        for(String w : map.keySet()){
            if(map.get(w) == maxFreq){
                set.add(w);
            }
        }
        for(String w : arr){
            if(set.size() != 1){
                if(set.contains(w))set.remove(w);
            }else{
                for(String ans : set){
                    System.out.println(ans);
                    return;
                }
            }
        }

    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String []arr = new String[n];
        for(int i=0;i<n;++i){
                arr[i] = sc.next();
        }
        Solution Obj = new Solution();
        Obj.mostFrequent(arr,n);  
        System.out.println('\n');
    }
}
