#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a;

    scanf("%d", &a);

    int sum = 1;
    while (a > 1)
    {
        sum *= a;
        a--;
    }

    printf("%d", sum);

    return 0;
}