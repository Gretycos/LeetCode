package lc.labuladong.DataStructure.tree.Q700;

import lc.TreeNode;

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (val < root.val){
            return searchBST(root.left, val);
        }
        if (val > root.val){
            return searchBST(root.right, val);
        }
        return root;
    }
}

public class Main {
}
