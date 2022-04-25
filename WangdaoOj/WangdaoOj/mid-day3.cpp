#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 10

typedef int ElemType;
typedef struct
{
    ElemType data[MAXSIZE];
    int len;
} SqList, *p;

bool ListInsert(SqList &L, int i, ElemType e)
{
    if (i < 1 || i > L.len + 1)
    {
        return false;
    }
    if (L.len >= MAXSIZE)
    {
        return false;
    }
    for (int j = L.len; j >= i; j--)
    {
        L.data[j] = L.data[j - 1];
    }
    L.data[i - 1] = e;
    L.len++;

    return true;
}

bool ListDelete(SqList &L, int i)
{
    if (i < 1 || i > L.len + 1)
    {
        return false;
    }
    if (L.len >= MAXSIZE)
    {
        return false;
    }
    for (int j = i; j <= L.len; j++)
    {
        L.data[j - 1] = L.data[j];
    }
    L.len--;

    return true;
}

int main()
{
    SqList s = {{1, 2, 3}, 3};

    int elem;
    scanf("%d", &elem);
    bool f1 = ListInsert(s, 2, elem);
    if (f1)
    {
        for (int i = 0; i < s.len; i++)
        {
            printf("  %d", s.data[i]);
        }
    }
    else
    {
        printf("false");
    }
    printf("\n");

    int cnt;
    scanf("%d", &cnt);
    bool f2 = ListDelete(s, cnt);
    if (f2)
    {
        for (int i = 0; i < s.len; i++)
        {
            printf("  %d", s.data[i]);
        }
    }
    else
    {
        printf("false");
    }

    return 0;
}