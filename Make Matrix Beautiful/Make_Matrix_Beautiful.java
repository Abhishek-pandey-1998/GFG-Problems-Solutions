//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[][] matrix = IntMatrix.input(br, N, N);
            
            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        
        
        int max = 0;    // max to track the max from all row and col sum
        int[] row = new int[N]; //array to store row sum
        int[] col = new int[N]; //array to store col sum
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                row[i]+=matrix[i][j];
                col[j]+=matrix[i][j];
                if(max<col[j]){
                    max=col[j];
                }
            }
            if(max<row[i]){
                max=row[i];
            }
        }
        
        int res=0;   //resulting variable
        for(int i=0;i<N;i++){
            if(row[i]<max){
                res+=max-row[i];
            }
        }
        return res;
    }
}
        
