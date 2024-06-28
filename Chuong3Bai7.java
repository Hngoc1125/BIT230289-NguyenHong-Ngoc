package Giaithuat;

import java.util.Scanner;

public class Chuong3Bai7 {

    public static void quickSort(int[] array, int low, int high, boolean ascending) {
        if (low < high) {
            int pi = partition(array, low, high, ascending);
            quickSort(array, low, pi - 1, ascending);
            quickSort(array, pi + 1, high, ascending);
        }
    }
    public static int partition(int[] array, int low, int high, boolean ascending) {
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
            System.out.println("Chọn trật tự sắp xếp: ");
            System.out.println("1. Tăng dần");
            System.out.println("2. Giảm dần");
            int order = scanner.nextInt();
            boolean ascending = order == 1;

            quickSort(array, 0, array.length - 1, ascending);   //sắp xếp

            System.out.println("Dãy sau khi sắp xếp: ");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();

            // Hỏi người dùng có muốn tiếp tục hay không
            System.out.println("Bạn có muốn tiếp tục? (y/n)");
            char continueChoice = scanner.next().charAt(0);
            if (continueChoice != 'y' && continueChoice != 'Y') {
                exit = true;
            }
        }
        scanner.close();
    }
}

