#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n, a[100], count = 0;

    scanf("%d", &n);
    for (int i = 0; i < 5; i++)
    {
        scanf("%d", &a[i]);
        if (a[i] == 2)
        {
            count++;
        }
    }

    printf("%d", count);

    return 0;
}