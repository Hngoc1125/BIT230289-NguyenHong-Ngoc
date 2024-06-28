package Giaithuat;

import java.util.Scanner;

public class Chuong3Bai6 {
    public static void mergeSort(int[] array, boolean ascending) {
        if (array.length > 1) {
            int mid = array.length / 2;
            // Tạo hai mảng con
            int[] left = new int[mid];
            int[] right = new int[array.length - mid];
            // Chia mảng chính thành hai mảng con
            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, array.length - mid);
            // Đệ quy sắp xếp hai mảng con
            mergeSort(left, ascending);
            mergeSort(right, ascending);
            // Trộn hai mảng con đã sắp xếp
            merge(array, left, right, ascending);
        }
    }
    
    public static void merge(int[] array, int[] left, int[] right, boolean ascending) {
        int i = 0, j = 0, k = 0;
        // Trộn các phần tử vào mảng chính
        while (i < left.length && j < right.length) {
            if (ascending ? left[i] <= right[j] : left[i] >= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        // Sao chép các phần tử còn lại
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
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
            System.out.println("Chọn trật tự sắp xếp: ");
            System.out.println("1. Tăng dần");
            System.out.println("2. Giảm dần");
            int order = scanner.nextInt();
            boolean ascending = order == 1;
        
            mergeSort(array, ascending);// Sử dụng Merge Sort để sắp xếp

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
