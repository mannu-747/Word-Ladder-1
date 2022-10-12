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
vector<int> diagonal(Node *root)
{
   // your code here
    vector<int>ans;
    queue<Node*>q;
    q.push(root);
    while(!q.empty()){
        Node*t = q.front();
        q.pop();
        while(t){
            if(t->left) q.push(t->left);
            ans.push_back(t->data);
            t = t->right;
        }
    }
    return ans;
}