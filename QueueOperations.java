package Giaithuat;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//Bai8
public class QueueOperations {
    private Queue<Integer> hangDoi;

    public QueueOperations() {
        hangDoi = new LinkedList<>();
    }
    public static void main(String[] args) {
        QueueOperations queueOps = new QueueOperations();
        Scanner scanner = new Scanner(System.in);
        int luaChon;
        do {
            System.out.print("Nhập lựa chọn của bạn(1-7 hoặc 8 để thoát): ");
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.println("Hàng đợi có rỗng không: " + queueOps.isEmpty());
                    break;
                case 2:
                    queueOps.clear();
                    System.out.println("Đã xóa sạch hàng đợi.");
                    break;
                case 3:
                    System.out.print("Nhập phần tử muốn thêm vào hàng đợi: ");
                    int phanTu = scanner.nextInt();
                    queueOps.enqueue(phanTu);
                    break;
                case 4:
                    try {
                        int phanTuXoa = queueOps.dequeue();
                        System.out.println("Phần tử xóa ra khỏi hàng đợi: " + phanTuXoa);
                    } catch (Exception e) {
                        System.out.println("Ngoại lệ: " + e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        int phanTuDau = queueOps.first();
                        System.out.println("Phần tử đầu tiên trong hàng đợi: " + phanTuDau);
                    } catch (Exception e) {
                        System.out.println("Ngoại lệ: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Các phần tử trong hàng đợi:");
                    queueOps.traverse();
                    break;
                case 7:
                    System.out.print("Nhập số thập phân nhỏ hơn 1: ");
                    double soThapPhan = scanner.nextDouble();
                    queueOps.convertDecimalToBinary(soThapPhan);
                    break;
                case 8:
                    System.out.println("Đang thoát khỏi chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                    break;
            }
        } while (luaChon != 8);

        scanner.close();
    }
    // 1. Kiểm tra hàng đợi có rỗng không.
    public boolean isEmpty() {
        return hangDoi.isEmpty();
    }
    // 2. Xóa sạch hàng đợi.
    public void clear() {
        hangDoi.clear();
    }
    // 3. Thêm phần tử vào cuối hàng đợi.
    public void enqueue(int x) {
        hangDoi.add(x);
    }
    // 4. Xóa phần tử đầu hàng đợi và trả về giá trị của nó.
    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Hàng đợi đang trống");
        }
        return hangDoi.poll();
    }
    // 5. Xem giá trị của phần tử đầu tiên trong hàng đợi.
    public int first() throws Exception {
        if (isEmpty()) {
            throw new Exception("Hàng đợi đang trống");
        }
        return hangDoi.peek();
    }
    // 6. Duyệt và hiển thị tất cả các phần tử trong hàng đợi từ trước đến sau.
    public void traverse() {
        if (isEmpty()) {
            System.out.println("Hàng đợi đang trống");
            return;
        }
        for (int phanTu : hangDoi) {
            System.out.print(phanTu + " ");
        }
        System.out.println();
    }
    // 7. Chuyển đổi số thập phân nhỏ hơn 1 sang biểu diễn nhị phân.
    public void convertDecimalToBinary(double decimalNumber) {
        Queue<Integer> hangDoiNhiPhan = new LinkedList<>();
        int phanNguyen = (int) decimalNumber;
        double phanThapPhan = decimalNumber - phanNguyen;
        while (phanNguyen > 0) {
            int du = phanNguyen % 2; // Chuyển đổi phần nguyên sang nhị phân
            hangDoiNhiPhan.add(du);
            phanNguyen /= 2;
        }
        System.out.print("Biểu diễn nhị phân của phần nguyên: ");
        while (!hangDoiNhiPhan.isEmpty()) {
            System.out.print(hangDoiNhiPhan.poll());       // In ngược và hiển thị biểu diễn nhị phân của phần nguyên
        }
        System.out.println();
        System.out.print("Biểu diễn nhị phân của phần thập phân: ");
        int dem = 0;
        while (phanThapPhan > 0 && dem < 10) { // Giới hạn 10 chữ số sau dấu phẩy
            phanThapPhan *= 2;
            int bit = (int) phanThapPhan;
            System.out.print(bit);
            phanThapPhan -= bit;        // Chuyển đổi phần thập phân sang nhị phân
            dem++;
        }
        System.out.println();
    }
}
