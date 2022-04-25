#pragma once
#include <cstdlib>
#include "Status.h"

typedef int QElemType;
typedef struct QNode {
	QElemType data;
	struct QNode* next;
}QNode, *QueuePtr;
typedef struct {
	QueuePtr front;
	QueuePtr rear;
}LinkQueue;

Status InitQueue(LinkQueue& Q) {
	Q.front = Q.rear = new QNode;
	Q.front->next = NULL; // ע���ǵý�ͷ����ָ�����ÿ�

	return OK;
}

Status EnQueue(LinkQueue& Q, QElemType e) {
	QNode* p = new QNode;
	p->data = e;
	p->next = NULL;
	Q.rear->next = p;
	Q.rear = p;

	return OK;
}

Status DeQueue(LinkQueue& Q, QElemType& e) {
	if (Q.front == Q.rear) {
		return ERROR;
	}
	QNode* p = Q.front->next;
	e = p->data;
	Q.front->next = p->next;
	if (Q.rear == p) { // �������һ��Ԫ�ر�ɾ���������ʹ��βָ��ָ��ͷ���
		Q.rear = Q.front;
	}
	delete(p);
	
	return OK;
}

QElemType GetHead(LinkQueue Q) {
	if (Q.front != Q.rear) {
		return Q.front->next->data;
	}
}