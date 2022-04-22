using namespace std;
#include <algorithm>

class Solution {
public:
    bool isBalanced(TreeNode* root) {
       return root == NULL ? true : abs(f(root->left) - f(root->right)) <= 1 && isBalanced(root->left) && isBalanced(root->right);
    }

    int f(TreeNode* node) {
        return node == NULL ? 0 : max(f(node->left), f(node->right)) + 1;
    }
}; 

// Definition for a binary tree node.
struct TreeNode {
     int val;
     TreeNode* left;
     TreeNode* right;
     TreeNode() : val(0), left(nullptr), right(nullptr) {}
     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
     TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
 };