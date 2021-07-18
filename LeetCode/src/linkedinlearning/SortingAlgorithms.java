package linkedinlearning;

public class SortingAlgorithms {

    public static void main(String[] args) {
        SortingAlgorithms main = new SortingAlgorithms();
        int size = 5;
        int[] unsortedArray = new int[size];
        int[] sortedArray;

        System.out.println("Input array:");
        main.fillWithRandomValues(unsortedArray);
        printArray(unsortedArray);
        sortedArray = main.bubbleSort(unsortedArray);
        System.out.println("Sorted array:");
        printArray(sortedArray);

        System.out.println("Input array:");
        main.fillWithRandomValues(unsortedArray);
        printArray(unsortedArray);
        sortedArray = main.selectionSort(unsortedArray);
        System.out.println("Sorted array:");
        printArray(sortedArray);

        System.out.println("Input array:");
        main.fillWithRandomValues(unsortedArray);
        printArray(unsortedArray);
        sortedArray = main.insertionSort(unsortedArray);
        System.out.println("Sorted array:");
        printArray(sortedArray);

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int aux;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                System.out.println(i);
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
