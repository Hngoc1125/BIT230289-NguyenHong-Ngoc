package Giaithuat ;
import java.util.Scanner;
//Bai1
class Node {
    int data; 
    Node next; 
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList {
    private Node head; // Tham chiếu đến nút đầu tiên trong danh sách
    // 1.Thêm một nút với giá trị x vào đầu danh sách
    public void addToHead(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }
    // 2. Thêm một nút với giá trị x vào cuối danh sách
    public void addToTail(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    // 3. Thêm một nút với giá trị x vào sau nút p
    public void addAfter(Node p, int x) {
        if (p == null) {
            throw new IllegalArgumentException("Nút p không tồn tại trong danh sách.");
        }
        Node newNode = new Node(x);
        newNode.next = p.next;
        p.next = newNode;
    }
    // 4. Duyệt từ đầu đến cuối danh sách và hiển thị thông tin của tất cả các nút
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    // 5. Xóa nút đầu và trả về giá trị của nó
    public int deleteFromHead() {
        if (head == null) {
            throw new RuntimeException("Danh sách rỗng, không có nút để xóa.");
        }
        int deletedValue = head.data;
        head = head.next;
        return deletedValue;
    }
    // 6. Xóa nút cuối và trả về giá trị của nó
    public int deleteFromTail() {
        if (head == null) {
            throw new RuntimeException("Danh sách rỗng, không có nút để xóa.");
        }
        if (head.next == null) {
            int deletedValue = head.data;
            head = null;
            return deletedValue;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int deletedValue = current.next.data;
        current.next = null;
        return deletedValue;
    }
    // 7. Xóa nút sau nút p và trả về giá trị của nó
    public int deleteAfter(Node p) {
        if (p == null || p.next == null) {
            throw new IllegalArgumentException("Nút p không tồn tại hoặc không có nút sau để xóa.");
        }
        int deletedValue = p.next.data;
        p.next = p.next.next;
        return deletedValue;
    }
    // 8. Xóa nút đầu tiên có giá trị bằng x
    public void delete(int x) {
        if (head == null) {
            throw new RuntimeException("Danh sách rỗng, không có nút để xóa.");
        }
        if (head.data == x) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != x) {
            current = current.next;
        }
        if (current.next == null) {
            throw new IllegalArgumentException("Không tìm thấy giá trị x để xóa.");
        }
        current.next = current.next.next;
    }
    // 9. Tìm kiếm và trả về tham chiếu đến nút đầu tiên có giá trị x
    public Node search(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    // 10. Đếm và trả về số lượng nút trong danh sách
    public int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    // 12. Sắp xếp danh sách theo thứ tự tăng dần của giá trị
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            Node index = current.next;
            while (index != null) {
                if (current.data > index.data) {
                    int temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
    // 13. Xóa nút p nếu nó tồn tại trong danh sách
    public void delete(Node p) {
        if (p == null) {
            throw new IllegalArgumentException("Nút p không tồn tại trong danh sách.");
        }
        if (head == p) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next != p) {
            current = current.next;
        }
        if (current.next == null) {
            throw new IllegalArgumentException("Nút p không tồn tại trong danh sách.");
        }
        current.next = p.next;
    }

    // 14. Tạo và trả về một mảng chứa thông tin của tất cả các nút trong danh sách
    public int[] toArray() {
        int[] array = new int[count()];
        Node current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }
    // 15. Hợp nhất hai danh sách liên kết đơn đã sắp xếp thành một danh sách đã sắp xếp
    public static LinkedList mergeSortedLists(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;
        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                mergedList.addToTail(current1.data);
                current1 = current1.next;
            } else {
                mergedList.addToTail(current2.data);
                current2 = current2.next;
            }
        }
        while (current1 != null) {
            mergedList.addToTail(current1.data);
            current1 = current1.next;
        }
        while (current2 != null) {
            mergedList.addToTail(current2.data);
            current2 = current2.next;
        }
        return mergedList;
    }
    // 16. Thêm một nút với giá trị x vào trước nút p
    public void addBefore(Node p, int x) {
        if (p == null) {
            throw new IllegalArgumentException("Nút p không tồn tại trong danh sách.");
        }
        if (head == p) {
            addToHead(x);
            return;
        }
        Node newNode = new Node(x);
        Node current = head;
        while (current.next != null && current.next != p) {
            current = current.next;
        }
        if (current.next == null) {
            throw new IllegalArgumentException("Nút p không tồn tại trong danh sách.");
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    // 17. Kết nối một danh sách liên kết đơn vào cuối của danh sách liên kết đơn khác
    public void appendList(LinkedList otherList) {
        if (otherList.head == null) {
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = otherList.head;
    }
    // 18. Tìm và trả về giá trị lớn nhất trong danh sách
    public int max() {
        if (head == null) {
            throw new RuntimeException("Danh sách rỗng, không có giá trị lớn nhất.");
        }
        int max = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }
    // 19. Tìm và trả về giá trị nhỏ nhất trong danh sách
    public int min() {
        if (head == null) {
            throw new RuntimeException("Danh sách rỗng, không có giá trị nhỏ nhất.");
        }
        int min = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }
    // 20. Trả về tổng của tất cả các giá trị trong danh sách
    public int sum() {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }
    // 21. Trả về giá trị trung bình của tất cả các giá trị trong danh sách
    public int avg() {
        if (head == null) {
            throw new RuntimeException("Danh sách rỗng, không có giá trị trung bình.");
        }
        int sum = sum();
        int count = count();
        return sum / count;
    }
    // 22. Kiểm tra và trả về true nếu danh sách đã được sắp xếp, trả về false nếu không
    public boolean sorted() {
        if (head == null || head.next == null) {
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        }
        return true;
    }
    // 23. Chèn một nút có giá trị x vào danh sách đã sắp xếp để danh sách mới vẫn được sắp xếp
    public void insert(int x) {
        Node newNode = new Node(x);
        if (head == null || x <= head.data) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data < x) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    // 24. Đảo ngược một danh sách liên kết đơn chỉ trong một lần duyệt qua danh sách
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    // 25. Kiểm tra xem hai danh sách liên kết đơn có cùng nội dung hay không
    public boolean sameContent(LinkedList otherList) {
        Node current1 = head;
        Node current2 = otherList.head;
        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1 == null && current2 == null;
    }
}
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(); // Khởi tạo một danh sách liên kết mới
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Chọn thao tác (1-25, nhập 0 để thoát):");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập giá trị để thêm vào đầu danh sách:");
                    int valueToAddToHead = scanner.nextInt();
                    list.addToHead(valueToAddToHead);
                    break;
                case 2:
                    System.out.println("Nhập giá trị để thêm vào cuối danh sách:");
                    int valueToAddToTail = scanner.nextInt();
                    list.addToTail(valueToAddToTail);
                    break;
                case 3:
                    System.out.println("Nhập giá trị để thêm vào sau một nút:");
                    int valueToAdd = scanner.nextInt();
                    System.out.println("Nhập giá trị của nút p:");
                    int pNodeValue = scanner.nextInt();
                    Node pNode = list.search(pNodeValue);
                    if (pNode == null) {
                        System.out.println("Không tìm thấy nút p trong danh sách.");
                    } else {
                        list.addAfter(pNode, valueToAdd);
                    }
                    break;
                case 4:
                    System.out.println("Duyệt danh sách và hiển thị:");
                    list.traverse();
                    break;
                case 5:
                    try {
                        int deletedValueFromHead = list.deleteFromHead();
                        System.out.println("Nút đã xóa từ đầu danh sách có giá trị: " + deletedValueFromHead);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        int deletedValueFromTail = list.deleteFromTail();
                        System.out.println("Nút đã xóa từ cuối danh sách có giá trị: " + deletedValueFromTail);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Nhập giá trị của nút p để xóa nút sau:");
                    int pValue = scanner.nextInt();
                    Node nodeP = list.search(pValue);
                    if (nodeP == null) {
                        System.out.println("Không tìm thấy nút p trong danh sách.");
                    } else {
                        try {
                            int deletedValueAfterP = list.deleteAfter(nodeP);
                            System.out.println("Nút đã xóa từ sau nút p có giá trị: " + deletedValueAfterP);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 8:
                    System.out.println("Nhập giá trị của nút cần xóa:");
                    int valueToDelete = scanner.nextInt();
                    try {
                        list.delete(valueToDelete);
                        System.out.println("Đã xóa nút đầu tiên có giá trị " + valueToDelete);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Nhập giá trị cần tìm kiếm:");
                    int valueToSearch = scanner.nextInt();
                    Node foundNode = list.search(valueToSearch);
                    if (foundNode != null) {
                        System.out.println("Đã tìm thấy giá trị " + valueToSearch + " trong danh sách.");
                    } else {
                        System.out.println("Không tìm thấy giá trị " + valueToSearch + " trong danh sách.");
                    }
                    break;
                case 10:
                    int nodeCount = list.count();
                    System.out.println("Số lượng nút trong danh sách là: " + nodeCount);
                    break;
                case 11:
                    System.out.println("Nhập vị trí của nút cần xóa:");
                    int positionToDelete = scanner.nextInt();
                    try {
                        list.delete(positionToDelete);
                        System.out.println("Đã xóa nút thứ " + positionToDelete + " trong danh sách.");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 12:
                    System.out.println("Đang sắp xếp danh sách...");
                    list.sort();
                    System.out.println("Danh sách sau khi sắp xếp:");
                    list.traverse();
                    break;
                case 13:
                    System.out.println("Nhập giá trị của nút p để xóa:");
                    int pValueToDelete = scanner.nextInt();
                    Node nodeToDelete = list.search(pValueToDelete);
                    if (nodeToDelete == null) {
                        System.out.println("Không tìm thấy nút p trong danh sách.");
                    } else {
                        try {
                            list.delete(nodeToDelete);
                            System.out.println("Đã xóa nút p khỏi danh sách.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 14:
                    int[] arrayRepresentation = list.toArray();
                    System.out.println("Mảng chứa thông tin của danh sách:");
                    for (int value : arrayRepresentation) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                    break;
                case 15:
                    LinkedList list1 = new LinkedList();
                    LinkedList list2 = new LinkedList();
                    list1.addToTail(1);
                    list1.addToTail(3);
                    list1.addToTail(5);
                    list2.addToTail(2);
                    list2.addToTail(4);
                    list2.addToTail(6);
                    LinkedList mergedList = LinkedList.mergeSortedLists(list1, list2);
                    System.out.println("Danh sách sau khi hợp nhất:");
                    mergedList.traverse();
                    break;
                case 16:
                    System.out.println("Nhập giá trị để thêm vào trước một nút:");
                    int valueToAddBefore = scanner.nextInt();
                    System.out.println("Nhập giá trị của nút p:");
                    int pValueToAddBefore = scanner.nextInt();
                    Node pNodeToAddBefore = list.search(pValueToAddBefore);
                    if (pNodeToAddBefore == null) {
                        System.out.println("Không tìm thấy nút p trong danh sách.");
                    } else {
                        list.addBefore(pNodeToAddBefore, valueToAddBefore);
                    }
                    break;
                case 17:
                    LinkedList listToAppend = new LinkedList();
                    listToAppend.addToTail(7);
                    listToAppend.addToTail(8);
                    listToAppend.addToTail(9);
                    System.out.println("Kết nối danh sách liên kết đơn vào cuối danh sách khác:");
                    list.appendList(listToAppend);
                    System.out.println("Danh sách sau khi kết nối:");
                    list.traverse();
                    break;
                case 18:
                    int maxValue = list.max();
                    System.out.println("Giá trị lớn nhất trong danh sách là: " + maxValue);
                    break;
                case 19:
                    int minValue = list.min();
                    System.out.println("Giá trị nhỏ nhất trong danh sách là: " + minValue);
                    break;
                case 20:
                    int sum = list.sum();
                    System.out.println("Tổng các giá trị trong danh sách là: " + sum);
                    break;
                case 21:
                    int average = list.avg();
                    System.out.println("Giá trị trung bình của các giá trị trong danh sách là: " + average);
                    break;
                case 22:
                    boolean isSorted = list.sorted();
                    if (isSorted) {
                        System.out.println("Danh sách đã được sắp xếp.");
                    } else {
                        System.out.println("Danh sách chưa được sắp xếp.");
                    }
                    break;
                case 23:
                    System.out.println("Nhập giá trị để chèn vào danh sách đã sắp xếp:");
                    int valueToInsert = scanner.nextInt();
                    list.insert(valueToInsert);
                    System.out.println("Danh sách sau khi chèn:");
                    list.traverse();
                    break;
                case 24:
                    System.out.println("Đang đảo ngược danh sách...");
                    list.reverse();
                    System.out.println("Danh sách sau khi đảo ngược:");
                    list.traverse();
                    break;
                case 25:
                    LinkedList listToCompare = new LinkedList();
                    listToCompare.addToTail(1);
                    listToCompare.addToTail(2);
                    listToCompare.addToTail(3);
                    boolean sameContent = list.sameContent(listToCompare);
                    if (sameContent) {
                        System.out.println("Hai danh sách có cùng nội dung.");
                    } else {
                        System.out.println("Hai danh sách không có cùng nội dung.");
                    }
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }
}
