#pragma once
#include <cstdlib>
#include "Status.h"

#define MAXSIZE 100
typedef int SElemType;

typedef struct {
	SElemType* base; // 栈底指针
	SElemType* top; // 栈顶指针
	int stacksize; // 栈最大可用容量
}SqStack;

Status InitStack(SqStack& S) {
	S.base = new SElemType[MAXSIZE];
	if (!S.base) {
		exit(OVERFLOW);
	}
	S.top = S.base;
	S.stacksize = MAXSIZE;

	return OK;
}

Status Push(SqStack& S, SElemType e) {
	if (S.top - S.base == S.stacksize) {
		return ERROR;
	}
	*S.top++ = e;

	return OK;
}

Status Pop(SqStack& S, SElemType& e) {
	if (S.top == S.base) {
		return ERROR;
	}
	e = --*S.top;

	return OK;
}

SElemType GetTop(SqStack S) {
	if (S.top != S.base) {
		return *(S.top-1);
	}
}

