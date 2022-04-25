#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int size;
    scanf("%d", &size);

    char *s;
    s = (char *)malloc(size);

    char c;
    scanf("%c", &c);

    gets(s);
    puts(s);

    return 0;
}