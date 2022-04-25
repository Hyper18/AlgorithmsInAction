#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

typedef struct student
{
    int studentId;
    char name[20];
    char sex;
} stu, *p;

int main()
{
    stu s;
    scanf("%d %s %c", &s.studentId, &s.name, &s.sex);
    printf("%d %s %c", s.studentId, s.name, s.sex);

    return 0;
}