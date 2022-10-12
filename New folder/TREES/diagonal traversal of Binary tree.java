/* given a binary tree implement diagonal traversal of tree(recursive)

Input :
            8
         /     \
        3      10
      /   \      \
     1     6     14
         /   \   /
        4     7 13
Output : 8 10 14 3 6 7 13 1 4
Explanation:

Diagonal Traversal of binary tree : 
 8 10 14 3 6 7 13 1 4*/
void pre(Node*root,map<int,vector<int>>&m,int d,int h){
    if(!root) return;
    m[h-d].push_back(root->data);
    pre(root->left,m,d-1,h+1);
    pre(root->right,m,d+1,h+1);
}

vector<int> diagonal(Node *root)
{
   // your code here
    map<int,vector<int>>m;
   pre(root,m,0,0);
   vector<int>ans;
   for(auto it:m){
       for(auto i:m[it.first]) ans.push_back(i);
   }
   return ans;
   
   
}