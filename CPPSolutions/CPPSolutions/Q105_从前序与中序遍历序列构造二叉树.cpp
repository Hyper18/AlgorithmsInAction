using namespace std;
#include <vector>
#include <unordered_map>

class Solution {
public:
    unordered_map<int, int> idx_map; // ��¼���������val-idx��Ӧ��ϵ

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int idx = 0;
        for (auto& val : inorder) {
            idx_map[val] = idx++;
        }
        int n = inorder.size();
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    TreeNode* build(vector<int>& preorder, vector<int>& inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return NULL;
        }
        int rootVal = preorder[preLeft];
        TreeNode* root = new TreeNode(rootVal);
        int rootPos = idx_map.at(rootVal);

        int leftSubTrees = rootPos - inLeft;
        root->left = build(preorder, inorder, preLeft + 1, preLeft + leftSubTrees, inLeft, rootPos - 1);
        root->right = build(preorder, inorder, preLeft + leftSubTrees + 1, preRight, rootPos + 1, inRight);

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