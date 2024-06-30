package Giaithuat;

import java.util.Scanner;

public class Chuong3Bai8 {

    // Sắp xếp nổi bọt
    public static void bubbleSort(int[] array, boolean ascending) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ascending ? array[j] > array[j + 1] : array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    // Sắp xếp chọn
    public static void selectionSort(int[] array, boolean ascending) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (ascending ? array[j] < array[index] : array[j] > array[index]) {
                    index = j;
                }
            }
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    // Sắp xếp chèn
    public static void insertionSort(int[] array, boolean ascending) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && (ascending ? array[j] > key : array[j] < key)) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
    // Sắp xếp trộn
    public static void mergeSort(int[] array, boolean ascending) {
        if (array.length <= 1) {
            return;
        }
        mergeSort(array, 0, array.length - 1, ascending);
    }
    private static void mergeSort(int[] array, int left, int right, boolean ascending) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid, ascending);
            mergeSort(array, mid + 1, right, ascending);
            merge(array, left, mid, right, ascending);
        }
    }
    private static void merge(int[] array, int left, int mid, int right, boolean ascending) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (ascending ? leftArray[i] <= rightArray[j] : leftArray[i] >= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
    // Sắp xếp nhanh
    public static void quickSort(int[] array, boolean ascending) {
        quickSort(array, 0, array.length - 1, ascending);
    }
    private static void quickSort(int[] array, int low, int high, boolean ascending) {
        if (low < high) {
            int pi = partition(array, low, high, ascending);
            quickSort(array, low, pi - 1, ascending);
            quickSort(array, pi + 1, high, ascending);
        }
    }

    private static int partition(int[] array, int low, int high, boolean ascending) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (ascending ? array[j] <= pivot : array[j] >= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Nhập số lượng phần tử trong dãy: ");
            int n = scanner.nextInt();
            int[] array = new int[n];

            System.out.println("Nhập các phần tử của dãy: ");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println("Chọn thuật toán sắp xếp:");
            System.out.println("1- Sắp xếp nổi bọt");
            System.out.println("2- Sắp xếp chọn");
            System.out.println("3- Sắp xếp chèn");
            System.out.println("4- Sắp xếp trộn");
            System.out.println("5- Sắp xếp nhanh");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= 5) {
                System.out.println("Chọn trật tự sắp xếp: ");
                System.out.println("1. Tăng dần");
                System.out.println("2. Giảm dần");
                int order = scanner.nextInt();
                boolean ascending = order == 1;
                // Sắp xếp và in dãy đã sắp xếp
                switch (choice) {
                    case 1:
                        bubbleSort(array, ascending);
                        break;
                    case 2:
                        selectionSort(array, ascending);
                        break;
                    case 3:
                        insertionSort(array, ascending);
                        break;
                    case 4:
                        mergeSort(array, ascending);
                        break;
                    case 5:
                        quickSort(array, ascending);
                        break;
                }
                System.out.println("Dãy sau khi sắp xếp: ");
                for (int num : array) {
                    System.out.print(num + " ");
                }
                System.out.println();
            } else {
                exit = true;
            }
        }
        scanner.close();
    }
}
