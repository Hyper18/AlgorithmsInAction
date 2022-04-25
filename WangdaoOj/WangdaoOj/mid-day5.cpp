#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 10;

typedef int ElemType;
typedef struct LNode
{
	ElemType data;
	struct LNode *next;
} LNode, *LinkList;

LinkList List_TailInsert(LinkList &L)
{
	L = (LinkList)malloc(sizeof(LNode));
	L->next = NULL;

	LNode *s, *r = L;
	int x;
	scanf("%d", &x);
	while (x != 9999)
	{
		s = (LNode *)malloc(sizeof(LNode));
		s->data = x;
		r->next = s;
		r = s;

		scanf("%d", &x);
	}
	r->next = NULL;

	return L;
}

LNode *GetElem(LinkList L, int i)
{
	int cnt = 1;
	LNode *p = L->next;
	if (i == 0)
	{
		return L;
	}
	if (i < 1)
	{
		return NULL;
	}
	while (cnt < i)
	{
		p = p->next;
		cnt++;
	}

	return p;
}

bool ListInsert(LinkList &L, int i, ElemType e)
{
	LNode *s, *p = GetElem(L, i - 1);
	s = (LinkList)malloc(sizeof(LNode));

	s->data = e;
	s->next = p->next;
	p->next = s;

	return true;
}

bool ListDelete(LinkList &L, int i)
{
	LNode *p = GetElem(L, i - 1);
	LNode *q = p->next;
	p->next = q->next;
	free(q);

	return true;
}

void PrintList(LinkList L)
{
	L = L->next;

	while (L != NULL)
	{
		printf("%3d", L->data);
		L = L->next;
	}
	printf("\n");
}

int main()
{
	LinkList L;

	L = List_TailInsert(L);
	printf("%d\n", GetElem(L, 2)->data);
	ListInsert(L, 2, 99);
	PrintList(L);
	ListDelete(L, 4);
	PrintList(L);

	return 0;
}
