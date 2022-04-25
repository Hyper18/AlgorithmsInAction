#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a;

    scanf("%d", &a);

    int temp = a;

    int num = 0;
    while (a != 0)
    {
        num = num * 10 + a % 10;
        a = a / 10;
    }
    if (num == temp)
    {
        printf("yes");
    }
    else
    {
        printf("no");
    }

    return 0;
}