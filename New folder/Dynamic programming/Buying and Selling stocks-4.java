/*You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again) */

import java.util.*;
import java.lang.*;
import java.io.*;
/*optimised solution(tabulation solution)*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp= new int[n+1][2][k+1];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<2;buy++){
                for(int cap=1;cap<=k;cap++){
                      int pro=0;
         if(buy==1){
            pro=Math.max(dp[ind+1][0][cap]-prices[ind],dp[ind+1][1]   [cap]);
        }
        else
            pro=Math.max(dp[ind+1][1][cap-1]+prices[ind],dp[ind+1][0][cap]);
       dp[ind][buy][cap]=pro;
                }
            }                   
        }
        return dp[0][1][k];
    
}
}
//solution 1 (memoisitation)
public class Solution {
	public static int maxProfit(ArrayList<Integer> prices, int n) {
		// Write your code here.
        int[][][] dp= new int[n+1][2][k+1];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<2;buy++){
                for(int cap==;cap<=k;cap++){
                      dp[i][j][cap]=-1;
       
        return solve(prices,n,dp,k,ind,1);
	}
    static int solve(ArrayList<Integer> prices, int n,int[][][] dp,int cap,int ind,int buy){
        if(ind==n || cap==0)
            return 0;//base case
        if(dp[ind][buy][cap]!=-1)
            return dp[ind][buy][cap];//handling overlapping conditions
        int pro=0;
        if(buy==1){
            pro=Math.max(solve(prices,n,dp,cap,ind+1,0)-prices.get(ind),0+solve(prices,n,dp,cap,ind+1,1));
            //if purchased then we are subtracting,else we are adding zero to sum 
        }
        else
            pro=Math.max(solve(prices,n,dp,cap-1,ind+1,1)+prices.get(ind),0+solve(prices,n,dp,cap,ind+1,0));
        return dp[ind][buy][cap]=pro;
        //this is selling condition ,if are selling we need to add prices(ind),else add 0 
        
    }
}