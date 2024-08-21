#include <cstdio>
#include <vector>
#include "../../Headers/Tree/TreeNode.h"

using namespace std;

class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        vector<int> res;
        inorder(root, res);

        return res[k - 1];
    }

    void inorder(TreeNode* root, vector<int>& res) {
        if (!root) return;

        inorder(root->left, res);
        res.push_back(root->val);
        inorder(root->right, res);
    }
};