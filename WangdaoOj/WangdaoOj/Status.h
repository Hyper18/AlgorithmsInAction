#pragma once // 用于保证本头文件只被编译一次
typedef int Status;

#define OK 1
#define ERROR -1
#define OVERFLOW -2

#define EQ(a, b) ((a) == (b))
#define GT(a, b) ((a) > (b))
#define LT(a, b) ((a) < (b))