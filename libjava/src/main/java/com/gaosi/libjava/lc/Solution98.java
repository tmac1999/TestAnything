package com.gaosi.libjava.lc;

import java.util.ArrayList;

/**
 * Created by mrz on 2021-01-31.
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class Solution98 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
//            if (root.left != null) {
//                isValidBST(root);
//            } else {
//
//            }

            ArrayList<Integer> arrayList = new ArrayList();
            inorder(arrayList, root);
            for (int i = 0; i < arrayList.size() - 1; i++) {
                if (arrayList.get(i) >= arrayList.get(i + 1)){
                    return false;
                }
            }
            return true;
        }
    }

    private void inorder(ArrayList<Integer> arrayList, TreeNode root) {
        if (root==null) return;
        if (root.left == null) {
            arrayList.add(root.val);
        } else {
            inorder(arrayList, root.left);
            arrayList.add(root.val);
        }
        if (root.right != null) {
            inorder(arrayList, root.right);
        }
    }
}
