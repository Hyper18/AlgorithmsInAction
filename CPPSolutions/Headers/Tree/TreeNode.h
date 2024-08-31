//
// Created by Vincent on 2024/8/21.
//

#ifndef CPPSOLUTIONS_TREENODE_H
#define CPPSOLUTIONS_TREENODE_H

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

#endif //CPPSOLUTIONS_TREENODE_H
