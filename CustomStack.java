import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
//BAI2

public class CustomStack {
    private Stack<Integer> stack;

    public CustomStack() {
        stack = new Stack<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void clear() {
        stack.clear();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.pop();
    }

    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.peek();
    }

    public void traverse() {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    public static String decimalToBinary(int number) {
        CustomStack stack = new CustomStack();
        StringBuilder binary = new StringBuilder();

        while (number > 0) {
            stack.push(number % 2);
            number = number / 2;
        }

        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }

    public static String reverseString(String input) {
        CustomStack stack = new CustomStack();
        for (char ch : input.toCharArray()) {
            stack.push((int) ch);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append((char) (int) stack.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            switch (choice) {
                case 1:
                    System.out.println("Ngăn xếp rỗng: " + stack.isEmpty());
                    break;
                case 2:
                    stack.clear();
                    System.out.println("Ngăn xếp đã được xóa sạch.");
                    break;
                case 3:
                    System.out.print("Nhập giá trị cần thêm: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    System.out.println("Đã thêm " + value + " vào đỉnh ngăn xếp.");
                    break;
                case 4:
                    try {
                        int poppedValue = stack.pop();
                        System.out.println("Phần tử bị loại bỏ: " + poppedValue);
                    } catch (EmptyStackException e) {
                        System.out.println("Ngăn xếp rỗng, không thể loại bỏ phần tử.");
                    }
                    break;
                case 5:
                    try {
                        int topValue = stack.top();
                        System.out.println("Phần tử ở đỉnh ngăn xếp: " + topValue);
                    } catch (EmptyStackException e) {
                        System.out.println("Ngăn xếp rỗng, không có phần tử nào ở đỉnh.");
                    }
                    break;
                case 6:
                    System.out.println("Các phần tử trong ngăn xếp từ đỉnh đến đáy:");
                    stack.traverse();
                    break;
                case 7:
                    System.out.print("Nhập số thập phân cần chuyển đổi: ");
                    int number = scanner.nextInt();
                    System.out.println("Số " + number + " trong hệ nhị phân là: " + CustomStack.decimalToBinary(number));
                    break;
                case 8:
                    System.out.print("Nhập chuỗi cần đảo ngược: ");
                    String input = scanner.nextLine();
                    System.out.println("Chuỗi '" + input + "' sau khi đảo ngược là: '" + CustomStack.reverseString(input) + "'");
                    break;
                case 9:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
            System.out.println();
        }
    }
}
