class Node:
    def __init__(self, data, color="R"):
        self.data = data
        self.color = color
        self.left = self.right = self.parent = None


class RedBlackTree:
    def __init__(self):
        self.TNULL = Node(0, "B")
        self.root = self.TNULL

    def search_tree_helper(self, node, key):
        if node == self.TNULL or key == node.data:
            return node

        if key < node.data:
            return self.search_tree_helper(node.left, key)
        return self.search_tree_helper(node.right, key)

    def minimum(self, node):
        while node.left != self.TNULL:
            node = node.left
        return node

    def maximum(self, node):
        while node.right != self.TNULL:
            node = node.right
        return node

    def left_rotate(self, x):
        y = x.right
        x.right = y.left
        if y.left != self.TNULL:
            y.left.parent = x

        y.parent = x.parent
        if x.parent is None:
            self.root = y
        elif x == x.parent.left:
            x.parent.left = y
        else:
            x.parent.right = y
        y.left = x
        x.parent = y

    def right_rotate(self, x):
        y = x.left
        x.left = y.right
        if y.right != self.TNULL:
            y.right.parent = x

        y.parent = x.parent
        if x.parent is None:
            self.root = y
        elif x == x.parent.right:
            x.parent.right = y
        else:
            x.parent.left = y
        y.right = x
        x.parent = y

    def insert_fixup(self, k):
        while k.parent.color == "R":
            if k.parent == k.parent.parent.right:
                u = k.parent.parent.left
                if u.color == "R":
                    u.color = "B"
                    k.parent.color = "B"
                    k.parent.parent.color = "R"
                    k = k.parent.parent
                else:
                    if k == k.parent.left:
                        k = k.parent
                        self.right_rotate(k)
                    k.parent.color = "B"
                    k.parent.parent.color = "R"
                    self.left_rotate(k.parent.parent)
            else:
                u = k.parent.parent.right

                if u.color == "R":
                    u.color = "B"
                    k.parent.color = "B"
                    k.parent.parent.color = "R"
                    k = k.parent.parent
                else:
                    if k == k.parent.right:
                        k = k.parent
                        self.left_rotate(k)
                    k.parent.color = "B"
                    k.parent.parent.color = "R"
                    self.right_rotate(k.parent.parent)
            if k == self.root:
                break
        self.root.color = "B"

    def insert(self, key):
        node = Node(key)
        node.parent = None
        node.data = key
        node.left = self.TNULL
        node.right = self.TNULL
        node.color = "R"

        y = None
        x = self.root

        while x != self.TNULL:
            y = x
            if node.data < x.data:
                x = x.left
            else:
                x = x.right

        node.parent = y
        if y is None:
            self.root = node
        elif node.data < y.data:
            y.left = node
        else:
            y.right = node

        if node.parent is None:
            node.color = "B"
            return

        if node.parent.parent is None:
            return

        self.insert_fixup(node)

    def delete_fixup(self, x):
        while x != self.root and x.color == "B":
            if x == x.parent.left:
                s = x.parent.right
                if s.color == "R":
                    s.color = "B"
                    x.parent.color = "R"
                    self.left_rotate(x.parent)
                    s = x.parent.right

                if s.left.color == "B" and s.right.color == "B":
                    s.color = "R"
                    x = x.parent
                else:
                    if s.right.color == "B":
                        s.left.color = "B"
                        s.color = "R"
                        self.right_rotate(s)
                        s = x.parent.right

                    s.color = x.parent.color
                    x.parent.color = "B"
                    s.right.color = "B"
                    self.left_rotate(x.parent)
                    x = self.root
            else:
                s = x.parent.left
                if s.color == "R":
                    s.color = "B"
                    x.parent.color = "R"
                    self.right_rotate(x.parent)
                    s = x.parent.left

                if s.right.color == "B" and s.right.color == "B":
                    s.color = "R"
                    x = x.parent
                else:
                    if s.left.color == "B":
                        s.right.color = "B"
                        s.color = "R"
                        self.left_rotate(s)
                        s = x.parent.left

                    s.color = x.parent.color
                    x.parent.color = "B"
                    s.left.color = "B"
                    self.right_rotate(x.parent)
                    x = self.root
        x.color = "B"

    def rb_transplant(self, u, v):
        if u.parent is None:
            self.root = v
        elif u == u.parent.left:
            u.parent.left = v
        else:
            u.parent.right = v
        v.parent = u.parent

    def delete_node_helper(self, node, key):
        z = self.TNULL
        while node != self.TNULL:
            if node.data == key:
                z = node

            if node.data <= key:
                node = node.right
            else:
                node = node.left

        if z == self.TNULL:
            print("Không tìm thấy giá trị trong cây.")
            return

        y = z
        y_original_color = y.color
        if z.left == self.TNULL:
            x = z.right
            self.rb_transplant(z, z.right)
        elif z.right == self.TNULL:
            x = z.left
            self.rb_transplant(z, z.left)
        else:
            y = self.minimum(z.right)
            y_original_color = y.color
            x = y.right
            if y.parent == z:
                x.parent = y
            else:
                self.rb_transplant(y, y.right)
                y.right = z.right
                y.right.parent = y

            self.rb_transplant(z, y)
            y.left = z.left
            y.left.parent = y
            y.color = z.color
        if y_original_color == "B":
            self.delete_fixup(x)

    def delete_node(self, data):
        self.delete_node_helper(self.root, data)

    def print_tree(self, node, indent, last):
        if node != self.TNULL:
            print(indent, end='')
            if last:
                print("R----", end='')
                indent += "     "
            else:
                print("L----", end='')
                indent += "|    "

            s_color = "ĐỎ" if node.color == "R" else "ĐEN"
            print(str(node.data) + "(" + s_color + ")")
            self.print_tree(node.left, indent, False)
            self.print_tree(node.right, indent, True)

    def get_root(self):
        return self.root


def main():
    bst = RedBlackTree()
    while True:
        print("\nChọn chức năng:")
        print("1. Chèn phần tử")
        print("2. Xóa phần tử")
        print("3. Tìm kiếm phần tử")
        print("4. Tìm phần tử nhỏ nhất")
        print("5. Tìm phần tử lớn nhất")
        print("6. In cây")
        print("7. Thoát")

        choice = input("Lựa chọn: ")

        if choice == "1":
            value = int(input("Nhập giá trị cần chèn: "))
            bst.insert(value)
            print(f"Đã chèn giá trị {value}")

        elif choice == "2":
            value = int(input("Nhập giá trị cần xóa: "))
            bst.delete_node(value)
            print(f"Đã xóa giá trị {value}")

        elif choice == "3":
            value = int(input("Nhập giá trị cần tìm: "))
            node = bst.search_tree_helper(bst.get_root(), value)
            if node != bst.TNULL:
                print(f"Đã tìm thấy giá trị {value}")
            else:
                print("Không tìm thấy giá trị.")

        elif choice == "4":
            node = bst.minimum(bst.get_root())
            print(f"Giá trị nhỏ nhất là {node.data}")

        elif choice == "5":
            node = bst.maximum(bst.get_root())
            print(f"Giá trị lớn nhất là {node.data}")

        elif choice == "6":
            bst.print_tree(bst.get_root(), "", True)

        elif choice == "7":
            print("Thoát chương trình.")
            break

        else:
            print("Lựa chọn không hợp lệ.")


if __name__ == "__main__":
    main()
