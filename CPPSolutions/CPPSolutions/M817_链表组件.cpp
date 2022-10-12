#include <cstdio>
#include <unordered_set>

using namespace std;

class Solution {
public:
    int numComponents(ListNode* head, vector<int>& nums) {
		unordered_set<int> set;
		for (int num : nums)
			set.emplace(num);

		ListNode* node = head;
		int ans = 0;
		bool flag = false;
		while (node != nullptr) {
			if (set.count(node->val)) {
				if (!flag) {
					flag = true;
					ans++;
				} 
			}
			else {
				flag = false;
			}
			node = node->next;
		}

		return ans;
	}
};

struct ListNode {
	int val;
	ListNode* next;
	ListNode() : val(0), next(nullptr) {}
	ListNode(int x) : val(x), next(nullptr) {}
	ListNode(int x, ListNode* next) : val(x), next(next) {}
};