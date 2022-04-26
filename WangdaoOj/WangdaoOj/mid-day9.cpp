using namespace std;
#include <cstdio>
#include <cstdlib>
#include <iostream>

#define EQ(a, b) ((a) == (b))
#define GT(a, b) ((a) > (b))
#define LT(a, b) ((a) < (b))

typedef int Status;
typedef int KeyType;

// Definition for a binary tree node.
typedef struct TreeNode {
	KeyType val;
	TreeNode* left;
	TreeNode* right;
	TreeNode() : val(0), left(nullptr), right(nullptr) {}
	TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
	TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
}TreeNode, * BiTree;

Status InitTree(BiTree& T) {
	T = NULL;
	return true;
}

Status SearchBST(BiTree T, KeyType key, BiTree parent, BiTree& p) {
	if (!T) {
		p = parent;
		return false;
	}
	else if (EQ(key, T->val)) {
		return true;
	} 
	else if (LT(key, T->val)) {
		SearchBST(T->left, key, T, p);
	}
	else {
		SearchBST(T->right, key, T, p);
	}
}

Status BuildBST(BiTree& T, KeyType key) {
	BiTree p = T;
	if (!SearchBST(T, key, NULL, p)) {
		BiTree s = (BiTree)malloc(sizeof(TreeNode));
		s->val = key;
		s->left = s->right = NULL;
		if (!p) {
			T = s;
		}
		else if (LT(key, p->val)){
			p->left = s;
		}
		else {
			p->right = s;
		}
		return true;
	}

	return false;
}

int pos = 0;
void PrintAndSaveInOrder(BiTree& T, int arr[]) {
	if (T == NULL) {
		return;
	}
	PrintAndSaveInOrder(T->left, arr);
	if (T->val < 10) {
		cout << "  " << T->val;
	}
	else {
		cout << " " << T->val;
	}
	arr[pos++] = T->val;
	PrintAndSaveInOrder(T->right, arr);
}

int BinarySearch(int arr[], int low, int high, int target) {
	while (low < high) {
		int mid = low + ((high - low) >> 1);
		if (arr[mid] == target) {
			return mid;
		}
		else if (arr[mid] > target) {
			high = mid;
		}
		else {
			low = mid + 1;
		}
	}

	return -1;
}

int main() {
	BiTree T;
	InitTree(T);

	KeyType e;
	for (int i = 0; i < 10; i++) {
		cin >> e;
		BuildBST(T, e);
	}

	int a[10];
	PrintAndSaveInOrder(T, a);
	cout << endl;

	cout << BinarySearch(a, 0, 10, 21) << endl;
}
