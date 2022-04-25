#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n;
    scanf("%d", &n);

    printf("%d", climb(n));

    return 0;
}

int climb(int n)
{
    if (n == 1)
        return 1;
    if (n == 2)
        return 2;
    return climb(n - 1) + climb(n - 2);
}