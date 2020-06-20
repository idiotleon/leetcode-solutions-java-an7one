/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * References:
 *  https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34807/Java-iterative-solution-with-explanation/122507
 *  https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34807/Java-iterative-solution-with-explanation
 */
package com.zea7ot.lc.lvl3.lc0106;

import java.util.ArrayDeque;
import java.util.Deque;

import com.zea7ot.data_structure.tree.TreeNode;

public class SolutionApproach0SimulateDFS1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // sanity check
        if(inorder == null 
            || inorder.length == 0 
            || postorder == null 
            || postorder.length == 0 
            || inorder.length != postorder.length) 
                return null;
        
        final int L = inorder.length;        
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode root = new TreeNode(postorder[L - 1]);
        stack.push(root);
        
        for(int i = L - 2, j = L - 1; i >= 0; --i){
            // postorder[i] is the rightmost node,
            // the child till the element in inorder traveral that is not equal
            if(stack.peek().val != inorder[j]){
                stack.push(stack.peek().right = new TreeNode(postorder[i]));
            }else{
                TreeNode temp = null;
                // to pop out all elements matching inorder elements
                while(!stack.isEmpty() && stack.peek().val == inorder[j]){
                    temp = stack.pop();
                    j--;
                }
                // to continue in post-order fashion
                stack.push(temp.left = new TreeNode(postorder[i]));
            }
        }
        
        return root;
    }
}