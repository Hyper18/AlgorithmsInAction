using namespace std;
#include <cstdio>
#include <cstdlib>
#include <iostream>

#define OK 0
#define ERROR -1
#define OVERFLOW -2

typedef int Status;

// Definition for a binary tree node.
typedef struct TreeNode {
    char val;
    TreeNode* left;
    TreeNode* right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
}TreeNode, *BinaryTree;

Status InitTree(BinaryTree& T) {
    T = NULL;
    
    return OK;
}

void Build(char* nums, int sub, int len, TreeNode*& tree) {
    if (sub >= len)
        return;
    tree = new TreeNode;
    tree->val = nums[sub];
    Build(nums, sub * 2 + 1, len, tree->left);
    Build(nums, sub * 2 + 2, len, tree->right);
}

void Print(TreeNode* p) {
    if (p == NULL) {
        return;
    }
    cout << p->val;
    Print(p->left);
    Print(p->right);
}

int main() {
    char nums[10];
    cin >> nums;
    BinaryTree tree;

    InitTree(tree);
    Build(nums, 0, 10, tree);
    Print(tree);
}
