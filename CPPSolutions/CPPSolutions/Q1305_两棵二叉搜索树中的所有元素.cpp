using namespace std;
#include <vector>
#include <algorithm>
#include <iterator>

class Solution {
public:
    vector<int> getAllElements(TreeNode* root1, TreeNode* root2) {
        vector<int> res1, res2, res;
        inorder(root1, res1);
        inorder(root2, res2);
        merge(res1.begin(), res1.end(), res2.begin(), res2.end(), back_inserter(res));

        return res;
    }

    void inorder(TreeNode* root, vector<int>& res) { // 这里注意vector的引用传递
        if (!root) {
            return;
        }
        inorder(root->left, res);
        res.push_back(root->val);
        inorder(root->right, res);
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