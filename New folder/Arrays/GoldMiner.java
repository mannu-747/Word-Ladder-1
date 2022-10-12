import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        int max=Integer.MIN_VALUE;
        int[][] dp= new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        // code here
        for(int i=0;i<n;i++){
            int gold=GoldMiner(M,i,0,n,m,dp);
            max=Math.max(max,gold);
        }return max;
    }
    static int GoldMiner(int[][] go,int x,int y,int n,int m, int[][] dp){
        if(x<0 || x==n || y==m)
        return 0;
        if(dp[x][y]!=-1)
        return dp[x][y];
        int rud=GoldMiner(go,x-1,y+1,n,m,dp);
        int ri=GoldMiner(go,x,y+1,n,m,dp);
        int rdd=GoldMiner(go,x+1,y+1,n,m,dp);
        return dp[x][y]= go[x][y]+Math.max(Math.max(rud,rdd),ri);
    }
}