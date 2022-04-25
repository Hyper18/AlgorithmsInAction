#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i;
    char j;
    float k;

    scanf("%d %c %f", &i, &j, &k);
    printf("%.2f", i + j + k);

    return 0;
}