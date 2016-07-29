#if 0
#include<iostream>
#include <algorithm>
using namespace std;

void heapify(int *arr, int n, int i)
{
	int large = i;
	int l = 2 * i + 1;
	int r = 2 * i + 2;

	if (l<n && arr[l] > arr[large])
		large = l;
	if (r<n && arr[r] > arr[large])
		large = r;
	if (i != large)
	{
		swap(arr[i], arr[large]);
		heapify(arr, n, large);
	}
}

void heapSort(int *arr, int n)
{
	for (int i = n / 2 - 1; i >= 0; i--)
		heapify(arr, n, i);

	for (int i = n-1; i >0; i--)
	{
		swap(arr[0], arr[i]);
		heapify(arr, i, 0);
	}
}

void printArray(int arr[], int n)
{
	for (int i = 0; i<n; ++i)
		cout << arr[i] << " ";
	cout << "\n";
}

// Driver program
int main()
{
	int arr[] = { 12, 11, 13, 5, 6, 7 };
	int n = sizeof(arr) / sizeof(arr[0]);

	heapSort(arr, n);

	cout << "Sorted array is \n";
	printArray(arr, n);
	getchar();
}


#endif