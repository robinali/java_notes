/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


bool hasPathSum(struct TreeNode* root, int sum){
    if(!root) {
        return false;
    }
    int newSum = sum - root->val;
    if(root->right && root->left) {
        return hasPathSum(root->left, newSum) || hasPathSum(root->right, newSum);
    }
    if(!root->right && !root->left) {
        return (newSum == 0);
    }
    if(!root->right) {
        return hasPathSum(root->left, newSum);
    }
    else {
        return hasPathSum(root->right, newSum);
    }
}

