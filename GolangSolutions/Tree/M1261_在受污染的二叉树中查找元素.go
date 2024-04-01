/*
	@author Hyperspace
	@date 2024/03/12
	@file M1261_在受污染的二叉树中查找元素.go
*/

package Tree

type FindElements struct {
	ValSet map[int]bool
}

func Constructor(root *TreeNode) FindElements {
	valSet := map[int]bool{}
	dfs(valSet, root, 0)
	return FindElements{
		ValSet: valSet,
	}
}

func dfs(valSet map[int]bool, root *TreeNode, x int) {
	if root == nil {
		return
	}
	root.Val = x
	valSet[x] = true
	dfs(valSet, root.Left, x*2+1)
	dfs(valSet, root.Right, x*2+2)
}

func (fe *FindElements) Find(target int) bool {
	return fe.ValSet[target]
}
