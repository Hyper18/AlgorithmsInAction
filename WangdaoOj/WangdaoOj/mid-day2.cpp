#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

char *read(char *&p);
int main()
{
    char *p;
    printf("%s", read(p));

    return 0;
}

char *read(char *&p)
{
    p = (char *)malloc(100);

    return fgets(p, 100, stdin);
}