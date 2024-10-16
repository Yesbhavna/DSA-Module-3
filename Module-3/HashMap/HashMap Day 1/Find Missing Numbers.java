import java.util.*;

class Solution {
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        //Write your code here
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for(int ele : arr){
            map1.put(ele, map1.getOrDefault(ele, 0)+1);

        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
         for(int ele : brr){
            map2.put(ele, map2.getOrDefault(ele, 0)+1);

        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int key : map2.keySet()){
            if(map1.containsKey(key) == true){
                if(map1.get(key) != map2.get(key)){
                    ans.add(key);
                }
            }else{
                ans.add(key);
            }
        }
        Collections.sort(ans);
        if(ans.size() == 0){
            System.out.println(-1);
            return;
        }
        for(int ele: ans){
            System.out.print(ele + " ");
        }

    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for(int i=0; i<m; i++){
            brr[i]= sc.nextInt();
        }

        Solution Obj = new Solution();
        Obj.missingNumbers(n,arr,m,brr);
    }
}