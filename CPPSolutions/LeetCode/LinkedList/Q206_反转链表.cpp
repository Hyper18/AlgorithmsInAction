using namespace std;

#include <cstdio>
#include "../../Headers/LinkedList/ListNode.h"

class Solution {
public:
    ListNode *reverseList(ListNode *head) {
        ListNode *newHead = NULL;
        for (ListNode *node = head; node != NULL; node = node->next) {
            newHead = new ListNode(node->val, newHead);
        }
        return newHead;
    }

    ListNode *reverseList2(ListNode *head) {
        if (head == NULL || head->next == NULL) {
            return head;
        }
        ListNode *newHead = reverseList2(head->next);
        head->next->next = head;
        head->next = NULL;
        return newHead;
    }
};