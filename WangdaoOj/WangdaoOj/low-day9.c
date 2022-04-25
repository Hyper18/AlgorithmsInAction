#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
    char s[100];
    char s_rev[100];

    scanf("%s", &s);
    int i, len = strlen(s);
    for (i = 0; i < len; i++)
    {
        s_rev[i] = s[len - 1 - i];
    }
    s_rev[len] = '\0';

    int result = strcmp(s, s_rev);
    if (result < 0)
    {
        printf("%d\n", -1);
    }
    else if (result > 0)
    {
        printf("%d\n", 1);
    }
    else
    {
        printf("%d\n", 0);
    }

    return 0;
}