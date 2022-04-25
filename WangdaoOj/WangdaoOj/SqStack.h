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
	SElemType* base; // ջ��ָ��
	SElemType* top; // ջ��ָ��
	int stacksize; // ջ����������
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


