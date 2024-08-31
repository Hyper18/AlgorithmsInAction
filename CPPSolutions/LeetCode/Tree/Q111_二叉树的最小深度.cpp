using namespace std;

#include <algorithm>
#include "../../Headers/Tree/TreeNode.h"

class Solution {
public:
    int minDepth(TreeNode *root) {
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