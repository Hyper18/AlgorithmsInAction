#pragma once
#include <cstdlib>
#include "Status.h"

#define MAXSIZE 100 // 注：这里不加；对应：line 15

typedef int QElemType;
typedef struct {
	QElemType* base; // 存储空间的基地址
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
	return (Q.rear - Q.front + MAXSIZE) % MAXSIZE; // 注：加上MAXSIZE是为了防止循环队列，相减的差值为负数
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