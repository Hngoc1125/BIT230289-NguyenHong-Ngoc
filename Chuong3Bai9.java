package Giaithuat;

import java.util.Scanner;

class Student {
    String studentId;
    String fullName;
    double averageScore;

    public Student(String studentId, String fullName, double averageScore) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.averageScore = averageScore;
    }
}
public class Chuong3Bai9 {

    public static void bubbleSort(Student[] array, boolean ascending) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ascending ? array[j].averageScore > array[j + 1].averageScore : array[j].averageScore < array[j + 1].averageScore) {
                    Student temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(Student[] array, boolean ascending) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (ascending ? array[j].averageScore < array[index].averageScore : array[j].averageScore > array[index].averageScore) {
                    index = j;
                }
            }
            Student temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public static void insertionSort(Student[] array, boolean ascending) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            Student key = array[i];
            int j = i - 1;
            while (j >= 0 && (ascending ? array[j].averageScore > key.averageScore : array[j].averageScore < key.averageScore)) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập mã sinh viên: ");
            String studentId = scanner.nextLine();
            System.out.println("Nhập họ và tên: ");
            String fullName = scanner.nextLine();
            System.out.println("Nhập điểm trung bình: ");
            double averageScore = scanner.nextDouble();
            scanner.nextLine();

            students[i] = new Student(studentId, fullName, averageScore);
        }

        System.out.println("Chọn thuật toán sắp xếp:");
        System.out.println("1- Sắp xếp nổi bọt");
        System.out.println("2- Sắp xếp chọn");
        System.out.println("3- Sắp xếp chèn");
        int choice = scanner.nextInt();
        System.out.println("Chọn trật tự sắp xếp:");
        System.out.println("1- Tăng dần");
        System.out.println("2- Giảm dần");
        int order = scanner.nextInt();
        boolean ascending = order == 1;

        switch (choice) {
            case 1:
                bubbleSort(students, ascending);
                break;
            case 2:
                selectionSort(students, ascending);
                break;
            case 3:
                insertionSort(students, ascending);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return;
        }
        System.out.println("Danh sách sinh viên sau khi sắp xếp:");
        for (Student student : students) {
            System.out.println("Mã SV: " + student.studentId + ", Họ và tên: " + student.fullName + ", Điểm trung bình: " + student.averageScore);
        }

        scanner.close();
    }
}