package com.company.algorithm.collections;

import java.util.Arrays;

public class BinaryTreeRelated {

    /**
     * Node for BinaryTree
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * rebuild a binary tree using preorder and inorder traversal
     */
    private static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        int rootVal = pre[0];
        TreeNode root = new TreeNode(rootVal);
        for(int index = 0;index < in.length;index++){
            if(rootVal == in[index]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,index+1), Arrays.copyOfRange(in,0,index));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,index+1,pre.length), Arrays.copyOfRange(in,index+1,in.length));
            }
        }
        return root;
    }
}
