using namespace std;
#include <cstdio>

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
		ListNode* newHead = NULL;
		for (ListNode* node = head; node != NULL; node = node->next) {
			newHead = new ListNode(node->val, newHead);
		}
		return newHead;
    }

	ListNode* reverseList2(ListNode* head) {
		if (head == NULL || head->next == NULL) {
			return head;
		}
		ListNode* newHead = reverseList2(head->next);
		head->next->next = head;
		head->next = NULL;
		return newHead;
	}
};

struct ListNode {
	int val;
	ListNode* next;
	ListNode() : val(0), next(nullptr) {}
	ListNode(int x) : val(x), next(nullptr) {}
	ListNode(int x, ListNode* next) : val(x), next(next) {}
};