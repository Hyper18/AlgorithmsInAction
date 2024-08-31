using namespace std;

#include <algorithm>
#include "../../Headers/Tree/TreeNode.h"

class Solution {
public:
    bool isBalanced(TreeNode *root) {
        return root == NULL ? true : abs(f(root->left) - f(root->right)) <= 1 && isBalanced(root->left) &&
                                     isBalanced(root->right);
    }

    int f(TreeNode *node) {
        return node == NULL ? 0 : max(f(node->left), f(node->right)) + 1;
    }
};