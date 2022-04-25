#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main()
{
    int a;

    scanf("%d", &a);

    printf("%c", toascii(a));

    return 0;
}