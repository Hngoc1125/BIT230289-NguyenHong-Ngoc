class Node:
    def __init__(self, key, info):
        self.key = key
        self.info = info
        self.link = None

def find_student_with_key(L, key_value):
    current = L
    while current is not None:
        if current.key == key_value:
            return current.info
        current = current.link
    return None

L = Node(8, "SV001")
L.link = Node(9, "SV002")
L.link.link = Node(7, "SV003")

student_info = find_student_with_key(L, 9)# Tìm sinh viên có điểm trung bình học tập là 9

if student_info:
    print(f"Sinh viên có điểm trung bình học tập là 9 có mã số: {student_info}")
else:
    print("Không tìm thấy sinh viên nào có điểm trung bình học tập là 9")
