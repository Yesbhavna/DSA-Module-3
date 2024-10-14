import java.util.*;

class Solution {
    int size = 750000;
    //0-1000000
    List<Integer>[] hashtable;

    Solution(){
        hashtable = new LinkedList[size];
    }

    private int getHashValue(int key){
        return(key % size);
    }
    public void add(int key) {
        //Complete the function
        int hv = getHashValue(key);
        if(hashtable[hv] == null){
            hashtable[hv] = new LinkedList<>();
            hashtable[hv].add(key);
        }else{
            //collision 
            if(hashtable[hv].indexOf(key) == -1){
                hashtable[hv].add(key);
            }
        }

        
    }

    public void remove(int key) {
        //Complete the function
        int hv = getHashValue(key);
        if(hashtable[hv] == null){
            return;
        }else{
            if(hashtable[hv].indexOf(key) != -1){
                hashtable[hv].remove(hashtable[hv].indexOf(key));
            }
        }
    }

    public boolean contains(int key) {
        //Complete the function
        int hv = getHashValue(key);
        if(hashtable[hv] != null){
            if(hashtable[hv].indexOf(key) != -1){
                return true;
            }
        }
        return false;

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Solution Obj = new Solution();
        for (int i = 0; i < q; i++) {
            int choice = sc.nextInt();
            int key = sc.nextInt();
            if (choice == 1) {
                // Add
                Obj.add(key);
            } else if (choice == 2) {
                // contains
                if (Obj.contains(key)) {
                    System.out.print("True ");
                } else {
                    System.out.print("False ");
                }
            } else if (choice == 3) {
                // remove
                Obj.remove(key);
            }
        }
        System.out.println();
        sc.close();
    }
}