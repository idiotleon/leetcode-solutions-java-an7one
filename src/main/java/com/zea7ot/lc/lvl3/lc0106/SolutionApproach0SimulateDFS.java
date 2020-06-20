/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34807/Java-iterative-solution-with-explanation
 */
package com.zea7ot.lc.lvl3.lc0106;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproach0SimulateDFS {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // sanity check
        if(inorder == null 
            || inorder.length == 0 
            || postorder == null 
            || postorder.length == 0 
            || inorder.length != postorder.length) 
                return null;
        
        final int L = inorder.length;
        int idxInorder = L - 1, idxPostorder = L - 1;
        
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[idxPostorder]);
        stack.push(root);
        idxPostorder--;
        
        while(idxPostorder >= 0){
            while(!stack.isEmpty() && stack.peek().val == inorder[idxInorder]){
                prev = stack.pop();
                idxInorder--;
            }
            
            TreeNode node = new TreeNode(postorder[idxPostorder]);
            if(prev != null){
                prev.left = node;
            }else if(!stack.isEmpty()){
                TreeNode top = stack.peek();
                top.right = node;
            }
            
            stack.push(node);
            prev = null;
            idxPostorder--;
        }
        return root;
    }
}