using namespace std;
#include <algorithm>

class Solution {
public:
    int minDepth(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        if (root->left == NULL && root->right == NULL) {
            return 1;
        }
        
        int ans = INT_MAX;
        if (root->left != NULL) {
            ans = min(ans, minDepth(root->left));
        }
        if (root->right != NULL) {
            ans = min(ans, minDepth(root->right));
        }

        return ans + 1;
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