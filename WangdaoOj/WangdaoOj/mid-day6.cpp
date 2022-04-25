using namespace std;
#include <cstdio>
#include <cstdlib>
#include <iostream>

#define MAXSIZE 5
#define OK 0
#define ERROR -1
#define OVERFLOW -2

typedef int Status, SElemType, QElemType;
typedef struct StackNode {
	SElemType data;
	struct StackNode* next;
}StackNode, *LinkStack;
typedef struct {
	QElemType* base;
	int front;
	int rear;
}SqQueue;

Status InitStack(LinkStack& S) {
	S = NULL;

	return OK;
}
Status InitQueue(SqQueue& Q) {
	Q.base = new QElemType[MAXSIZE];
	if (!Q.base) {
		exit(OVERFLOW);
	}
	Q.front = Q.rear = 0;

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

Status EnQueue(SqQueue& Q, QElemType e) {
	if ((Q.rear + 1) % MAXSIZE == Q.front) {
		return ERROR;
	}
	Q.base[Q.rear] = e;
	Q.rear = (Q.rear + 1) % MAXSIZE;

	return OK;
}

Status DeQueue(SqQueue& Q, QElemType& e) {
	if (Q.front == Q.rear) {
		return ERROR;
	}
	e = Q.base[Q.front];
	Q.front = (Q.front + 1) % MAXSIZE;

	return OK;
}

QElemType GetHead(SqQueue Q) {
	if (Q.front != Q.rear) {
		return Q.base[Q.front];
	}
}

int QueueLength(SqQueue Q) {
	return (Q.rear - Q.front + MAXSIZE) % MAXSIZE;
}

int main() {
	LinkStack stk;
	InitStack(stk);
	for (int i = 0; i < 3; i++) {
		int a;
		cin >> a;
		Push(stk, a);
	}

	int e;
	for (int i = 0; i < 3; i++) {
		Pop(stk, e);
		cout << " " << e;
	}
	cout << endl;

	SqQueue queue;
	InitQueue(queue);
	for (int i = 0; i < MAXSIZE; i++) {
		int num;
		cin >> num;
		int res = EnQueue(queue, num);
		if (res == ERROR) {
			cout << "false" << endl;
		}
	}
	
	while (QueueLength(queue) >= 0) {
		DeQueue(queue, e);
		if (QueueLength(queue) == 0) {
			cout << " " << e << endl;
			break;
		}
		cout << " " << e;
	}


	return 0;
}
