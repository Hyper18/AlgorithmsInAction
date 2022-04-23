using namespace std;
#include <vector>

class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int n = preorder.size();
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    TreeNode* build(vector<int>& preorder, vector<int>& inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return NULL;
        }
        int preRootPos = preLeft;
        int preRootVal = preorder[preRootPos];
        TreeNode* root = new TreeNode(preRootVal);
        int inRootPos = inLeft;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == preRootVal) {
                inRootPos = i;
                break;
            }
        }
        int leftSubTrees = inRootPos - inLeft;
        root->left = build(preorder, inorder, preLeft + 1, preLeft + leftSubTrees, inLeft, inRootPos - 1);
        root->right = build(preorder, inorder, preLeft + leftSubTrees, preRight, inRootPos + 1, inRight);

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