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

LinkList List_HeadInsert(LinkList &L)
{
    L = (LinkList)malloc(sizeof(LNode));
    L->next = NULL;

    LNode *s;
    int x;
    scanf("%d", &x);
    while (x != 9999)
    {
        s = (LNode *)malloc(sizeof(LNode));
        s->data = x;
        s->next = L->next;
        L->next = s;

        scanf("%d", &x);
    }

    return L;
}

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

void PrintList(LinkList L)
{
    L = L->next;

    while (L != NULL)
    {
        printf("%d", L->data);
        L = L->next;
        if (L != NULL)
        {
            printf(" ");
        }
    }
    printf("\n");
}

int main()
{
    LinkList L1, L2;

    L1 = List_HeadInsert(L1);
    PrintList(L1);

    L2 = List_TailInsert(L2);
    PrintList(L2);

    return 0;
}
