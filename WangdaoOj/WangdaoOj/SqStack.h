#pragma once
using namespace std;
#include <cstdio>
#include <cstdlib>
#define MAXSIZE 100
#define  SElemType int
#define Status int
#define OK 0
#define ERROR -1
#define OVERFLOW -2

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


