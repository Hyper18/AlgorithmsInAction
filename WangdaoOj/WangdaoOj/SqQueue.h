#pragma once
#include <cstdlib>
#include "Status.h"

#define MAXSIZE 100 // ע�����ﲻ�ӣ���Ӧ��line 15

typedef int QElemType;
typedef struct {
	QElemType* base; // �洢�ռ�Ļ���ַ
	int front;
	int rear;
}SqQueue;

Status InitQueue(SqQueue& Q) {
	Q.base = new QElemType[MAXSIZE];
	if (!Q.base) {
		exit(OVERFLOW);
	}
	Q.front = Q.rear = 0;
	
	return OK;
}

int QueueLength(SqQueue Q) {
	return (Q.rear - Q.front + MAXSIZE) % MAXSIZE; // ע������MAXSIZE��Ϊ�˷�ֹѭ�����У�����Ĳ�ֵΪ����
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