
// A Java program to print all anagrams together
import java.util.*;

public class Main {
    // Given a list of words in wordArr[],
    static String encode(String str){
        int[] fre = new int[26];   
        for(char ch : str.toCharArray()){
            int pos = (int)(ch-'a');
            fre[pos]++;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i =0; i< 26;i++){
            if(fre[i] > 0){
                sb.append((char)(i+'a'));
                sb.append(fre[i]);
            }
        }
        return sb.toString();
    }
    static void printAnagramsTogether(String wordArr[], int size) {
        //your code here
        HashMap<String,ArrayList<String>> map = new HashMap<>();

        ArrayList<String> firstofeachgroup = new ArrayList<>();
        for(String word: wordArr){
            String e = encode(word);
            if(map.containsKey(e) == false){
                ArrayList<String> grp = new ArrayList<>();
                firstofeachgroup.add(word);
                grp.add(word);
                map.put(e,grp);
            }else{
                ArrayList<String>grp = map.get(e);
                grp.add(word);
                map.put(e,grp);
            }
        }
        Collections.sort(firstofeachgroup);
        for(String grpLeader : firstofeachgroup){
            String e = encode(grpLeader);
            for(String ele: map.get(e)){
                System.out.print(ele+" ");
            }
        }

    }

    // Driver program to test above functions
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] wordArr = new String[n];
        for (int i = 0; i < n; i++)
            wordArr[i] = sc.next();
        sc.close();
        printAnagramsTogether(wordArr, n);
    }
}