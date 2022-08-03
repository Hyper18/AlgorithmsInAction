#pragma once
#include <iostream>
// Definition for a binary tree node.
typedef struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
}TreeNode, * BinaryTree;

// search
TreeNode* searchBST(BinaryTree T, int val) {
    while (T != NULL && val != T->val)
        T = val < T->val ? T->left : T->right;
    
    return T;
}