using namespace std;

#include <bits/stdc++.h>
#include "../../Headers/Tree/TreeNode.h"

class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode *root) {
        vector <vector<int>> res;
        if (root == NULL) {
            return res;
        }
        queue < TreeNode * > q;
        q.push(root);
        while (!q.empty()) {
            int n = q.size();
            vector<int> level;
            for (int i = 0; i < n; i++) {
                TreeNode *node = q.front();
                q.pop();
                level.push_back(node->val);
                if (node->left != NULL) {
                    q.push(node->left);
                }
                if (node->right != NULL) {
                    q.push(node->right);
                }
            }
            res.push_back(level);
        }
        reverse(res.begin(), res.end());

        return res;
    }
};