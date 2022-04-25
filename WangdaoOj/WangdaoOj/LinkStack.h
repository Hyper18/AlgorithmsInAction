#pragma once
using namespace std;
#include <cstdio>
#include <cstdlib>
#include "Status.h"

typedef int SElemType;

typedef struct {
	SElemType data;
	struct StackNode* next;
}StackNode, *LinkStack;

Status InitStack(LinkStack& S) {
	S = NULL;

	return OK;
}

Status Push(LinkStack& S, SElemType e) {

}

Status Pop(LinkStack& S, SElemType& e) {
	StackNode *p = new StackNode;
	p->data = e;
	p->next = S;
	S = p;

	return OK;
}

Status 