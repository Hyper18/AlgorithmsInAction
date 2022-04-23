using namespace std;
#include <vector>
#include <unordered_map>

class Solution {
public:
    unordered_map<int, int> idx_map; // 记录中序遍历的val-idx对应关系

    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int idx = 0;
        for (auto& val : inorder) {
            idx_map[val] = idx++;
        }
        int n = inorder.size();
        return build(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    TreeNode* build(vector<int>& inorder, vector<int>& postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if (postLeft > postRight) {
            return NULL;
        }
        int rootVal = postorder[postRight];
        TreeNode* root = new TreeNode(rootVal);
        int rootPos = idx_map.at(rootVal);

        int leftSubTrees = rootPos - inLeft;
        root->left = build(inorder, postorder, inLeft, rootPos - 1, postLeft, postLeft + leftSubTrees - 1);
        root->right = build(inorder, postorder, rootPos + 1, inRight, postLeft + leftSubTrees, postRight - 1);

        return root;
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