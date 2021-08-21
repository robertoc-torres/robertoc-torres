package linkedinlearning;

public class SortingAlgorithms {

    public static void main(String[] args) {
        SortingAlgorithms main = new SortingAlgorithms();
        int size = 5;
        int[] unsortedArray = new int[size];
        int[] sortedArray;

        System.out.println("*** BUBBLE SORT ***");
        System.out.println("Input array:");
        main.fillWithRandomValues(unsortedArray);
        printArray(unsortedArray);
        sortedArray = main.bubbleSort(unsortedArray);
        System.out.println("Sorted array:");
        printArray(sortedArray);

        System.out.println("*** SELECTION SORT ***");
        System.out.println("Input array:");
        main.fillWithRandomValues(unsortedArray);
        printArray(unsortedArray);
        sortedArray = main.selectionSort(unsortedArray);
        System.out.println("Sorted array:");
        printArray(sortedArray);

        System.out.println("*** INSERTION SORT ***");
        System.out.println("Input array:");
        main.fillWithRandomValues(unsortedArray);
        printArray(unsortedArray);
        sortedArray = main.insertionSort(unsortedArray);
        System.out.println("Sorted array:");
        printArray(sortedArray);

        System.out.println("*** MERGE SORT ***");
        System.out.println("Input array:");
        main.fillWithRandomValues(unsortedArray);
        printArray(unsortedArray);
        main.mergeSort(unsortedArray);
        System.out.println("Sorted array:");
        printArray(unsortedArray);

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public void mergeSort(int[] arr) {
        mergeSort(arr, arr.length);
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int aux;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
        return arr;
    }

    public int[] selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int aux;
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            aux = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = aux;
        }
        return arr;
    }

    public int[] insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int current;
        for (int i = 1; i < arr.length; i++) {
            current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = current;
        }
        return arr;
    }

    public void fillWithRandomValues(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
        }
    }

}
