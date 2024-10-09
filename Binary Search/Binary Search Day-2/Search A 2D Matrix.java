import java.util.*;

public class Main {

    public static boolean bs(int[] row, int x){
        int low =0;
        int high = row.length-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(row[mid] == x){
                return true;
            }else if(x> row[mid]){
                low = mid +1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }
    public static boolean SearchA2DMatrix(int[][] mat, int x) {
        //Write your code here
        
            int n = mat.length;
            int m = mat[0].length;

            for(int i =0 ; i<n ;i++){
                if(mat[i][0] <= x && x<= mat[i][m-1]){
                    return bs(mat[i] ,x);
                }
            }
            return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j<n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if(SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}