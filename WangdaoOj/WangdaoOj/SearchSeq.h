#pragma once
typedef int ElemType;
typedef struct {
	ElemType* elem; // base
	int tableLen;   // length
} SSTable;

int searchSeq(SSTable ST, ElemType key) {
	ST.elem[0] = key; // set sentinel at index 0
	int i;
	for (i = ST.tableLen; ST.elem[i] != key; i--);

	return i;
}
