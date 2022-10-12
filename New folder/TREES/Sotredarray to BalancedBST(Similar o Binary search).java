/* package whatever; // don't place package name!

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.\
*/
 Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        
        return ArrayToBST(nums,0,nums.length-1);
    }
    
    /* 
       This function is just like Binary Search 
       We just have to create TreeNode  
    */   
    public TreeNode ArrayToBST(int nums[],int left,int right) {
        if(left > right)  return null;    
        /* condition in binary search if left index is greater than right */
        
        int mid = left + (right-left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = ArrayToBST(nums,left,mid-1);
        
        node.right = ArrayToBST(nums,mid+1,right);
        
        return node;
    }
}