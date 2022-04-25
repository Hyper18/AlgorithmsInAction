using namespace std;
#include <cstdio>
#include <cstdlib>
#include <iostream>

#define OK 0
#define ERROR -1
#define OVERFLOW -2

typedef int Status;
typedef int SElemType;
typedef struct StackNode {
	SElemType data;
	struct StackNode* next;
}StackNode, *LinkStack;

Status InitStack(LinkStack& S) {
	S = NULL;

	return OK;
}

Status Push(LinkStack& S, SElemType e) {
	StackNode* p = new StackNode;
	p->data = e;
	p->next = S;
	S = p;
	
	return OK;
}

Status Pop(LinkStack& S, SElemType& e) {
	if (S == NULL) {
		return ERROR;
	}
	e = S->data;
	StackNode* p = S;
	S = S->next;
	delete(p);

	return OK;
}

SElemType GetTop(LinkStack& S) {
	if (S != NULL) {
		return S->data;
	}
}

int main() {
	LinkStack stk;
	InitStack(stk);
	int a, b, c;
	cin >> a >> b >> c;  

	Push(stk, a);
	Push(stk, b);
	Push(stk, c);

	int e;
	Pop(stk, e);
	cout << e << endl;
	Pop(stk, e);
	cout << e << endl;
	Pop(stk, e);
	cout << e << endl;

	return 0;
}
