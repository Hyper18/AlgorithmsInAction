using namespace std;
#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <queue>

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
}TreeNode, * BinaryTree;

Status InitTree(BinaryTree& T) {
    T = NULL;

    return OK;
}

void Build(char* nums, int sub, int len, TreeNode*& T) {
    if (sub >= len)
        return;
    T = new TreeNode;
    T->val = nums[sub];
    Build(nums, sub * 2 + 1, len, T->left);
    Build(nums, sub * 2 + 2, len, T->right);
}

void PrintInOrder(TreeNode* T) {
    if (T == NULL) {
        return;
    }
    PrintInOrder(T->left);
    cout << T->val;
    PrintInOrder(T->right);
}

void PrintPostOrder(TreeNode* T) {
    if (T == NULL) {
        return;
    }
    PrintPostOrder(T->left);
    PrintPostOrder(T->right);
    cout << T->val;
}

void PrintLevelOrder(TreeNode* T) {
    if (T == NULL) {
        return;
    }
    TreeNode* node;
    queue<TreeNode*> q;
    q.push(T);
    while (!q.empty())
    {
        node = q.front();
        cout << node->val;
        if (node->left) {
            q.push(node->left);
        }
        if (node->right) {
            q.push(node->right);
        }
        q.pop();
    }
}

int main() {
    char nums[10];
    cin >> nums;
    BinaryTree tree;

    InitTree(tree);
    Build(nums, 0, 10, tree);

    PrintInOrder(tree);
    cout << endl;
    PrintPostOrder(tree);
    cout << endl;
    PrintLevelOrder(tree);
}
