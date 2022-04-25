#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i, j, k, count = 0;

    for (i = 1; i < 100 / 10; i++)
    {
        for (j = 1; j < 100 / 5; j++)
        {
            for (k = 1; k < 40; k++)
            {
                int l = 40 - i - j - k;
                if (l > 0 && i * 10 + j * 5 + k * 2 + l == 100)
                {
                    count++;
                }
            }
        }
    }

    printf("%d", count);

    return 0;
}