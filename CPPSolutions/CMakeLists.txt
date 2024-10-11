cmake_minimum_required(VERSION 3.28)
project(CPPSolutions)

set(CMAKE_CXX_STANDARD 14)

add_compile_options("$<$<C_COMPILER_ID:MSVC>:/utf-8>")
add_compile_options("$<$<CXX_COMPILER_ID:MSVC>:/utf-8>")

add_executable(CPPSolutions
        Headers/LinkedList/ListNode.h
        Headers/Tree/Employee.h
        Headers/Tree/TreeNode.h
        Headers/M1快速排序.h
        Headers/M2归并排序.h
        Headers/M3整数二分.h
        Headers/M4浮点数二分.h
        Headers/M5一维前缀和.h
        Headers/M6二维前缀和.h
        Headers/M7一维差分.h
        Headers/M8二维差分.h
        LeetCode/Array/M3164_优质数对的总数II.cpp
)
