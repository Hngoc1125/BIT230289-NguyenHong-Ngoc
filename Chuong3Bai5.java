package Giaithuat;

import java.util.Scanner;

public class Chuong3Bai5 {
    
    public static void insertionSort(int[] array, boolean ascending) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && (ascending ? array[j] > key : array[j] < key)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
    
    public static void selectionSort(int[] array, boolean ascending) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (ascending ? array[j] < array[index] : array[j] > array[index]) {
                    index = j;
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
    }
    
    public static void bubbleSort(int[] array, boolean ascending) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (ascending ? array[i] > array[i + 1] : array[i] < array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            // Nhập dãy số
            System.out.println("Nhập số lượng phần tử trong dãy: ");
            int n = scanner.nextInt();
            int[] array = new int[n];
            
            System.out.println("Nhập các phần tử của dãy: ");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            
            // Chọn thuật toán sắp xếp
            System.out.println("Chọn thuật toán sắp xếp: ");
            System.out.println("1. Sắp xếp chèn");
            System.out.println("2. Sắp xếp chọn");
            System.out.println("3. Sắp xếp nổi bọt");
            int choice = scanner.nextInt();
            
            // Chọn trật tự sắp xếp
            System.out.println("Chọn trật tự sắp xếp: ");
            System.out.println("1. Tăng dần");
            System.out.println("2. Giảm dần");
            int order = scanner.nextInt();
            boolean ascending = order == 1;

            switch (choice) {
                case 1:
                    insertionSort(array, ascending);
                    break;
                case 2:
                    selectionSort(array, ascending);
                    break;
                case 3:
                    bubbleSort(array, ascending);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    continue;
            }
            // In dãy đã sắp xếp
            System.out.println("Dãy sau khi sắp xếp: ");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("Bạn có muốn tiếp tục? (y/n)");
            char continueChoice = scanner.next().charAt(0);
            if (continueChoice != 'y' && continueChoice != 'Y') {
                exit = true;
            }
        }
        
        scanner.close();
    }
}
