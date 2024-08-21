#include <bits\stdc++.h>
#include <unordered_set>
#include "../../Headers/Tree/TreeNode.h"

using namespace std;

class FindElements {
public:
    unordered_set<int> set;

    FindElements(TreeNode* root) {
        dfs(root, 0);
    }

    void dfs(TreeNode* root, int x) {
        if (root == nullptr) {
            return;
        }
        root->val = x;
        set.insert(root->val);
        dfs(root->left, 2 * x + 1);
        dfs(root->right, 2 * x + 2);
    }

    bool find(int target) {
        return set.find(target) != set.end();
    }
};



 