/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution{
	int pInorder;
	int pPostorder;
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        pInorder = inorder.length - 1;
        pPostorder = postorder.length - 1;
        return buildTree(inorder, postorder, null);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end){
        if(pPostorder < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pPostorder--]);
        if(inorder[pInorder] != root.val) {
            root.right = buildTree(inorder, postorder, root);
        }
        pInorder--;
        if((end == null) || (inorder[pInorder] != end.val)) {
            root.left = buildTree(inorder, postorder, end);
        }
        return root;
    }
}

