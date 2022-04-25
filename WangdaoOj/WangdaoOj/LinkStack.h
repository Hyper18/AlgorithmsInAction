#pragma once
#include <cstdlib>
#include "Status.h"

typedef int SElemType;

typedef struct StackNode { // ע������Ҫ���ṹ��ָ�����ƣ���Ӧ��line 24/35
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
	delete(p); // �ͷ�ԭջ��Ԫ��ռ�ݵĿռ�

	return OK;
}

SElemType GetTop(LinkStack S) {
	if (S != NULL) {
		return S->data;
	}
}