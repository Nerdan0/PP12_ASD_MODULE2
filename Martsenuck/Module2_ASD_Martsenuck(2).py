class Node:
    def __init__(self, value):
        self.value = float(value)
        self.next = None
        self.prev = None

    def reverse(self):
        self.next , self.prev = self.prev , self.next


class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def push(self, value):
        new_node = Node(value)
        if self.head is None and self.tail is None:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.prev = self.tail
            self.tail.next = new_node
            self.tail = new_node

    def pop(self):
        if self.tail is None:
            return None
        node = self.tail
        if node.next is None and node.prev is None:
            self.tail = None
            self.head = None
        else:
            self.tail = self.tail.prev
            self.tail.next = None
            return node.value

    def unshift(self, value):
        new_node = Node(value)
        if self.head is None and self.tail is None:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.next = self.head
            self.head.prev = new_node
            self.head = new_node

    def shift(self):
        node = self.head
        if node.next is None and node.prev is None:
            self.head = None
            self.tail = None
        else:
            self.head = self.head.next
            self.head.prev = None
            return node.value

    def insert(self, index, value):
        if index > 0:
            new_node = Node(value)
            node = self.head
            while index != 0:
                if node is self.tail and index!=0:
                    self.push(value)
                    return 0
                index -= 1
                node = node.next
            new_node.next = node
            new_node.prev = node.prev
            node.prev.next = new_node
            node.prev = new_node
        elif index == 0:
            self.unshift(value)
        
            

    def find(self, v):
        node = self.head.next
        while node.value != v:
            node = node.next
            if(node.next == None):
                return None
        return node

    def get(self, index):
        if index >= 0:
            node = self.head.next
            while index != 0:
                index -= 1
                node = node.next
                if(node.next is None):
                    return None
                return node

    def size(self):
        count = 0
        node = self.heaf.next
        while node.next is not None:
            node = node.next
            count += 1
        return count

    def print(self):
        node = self.head
        while node is not None:
            print(node.value, end = " ")
            node = node.next
        print()
    
    def reverse(self):
        node = self.head
        while node is not None:
            node.reverse()
            node = node.prev
        self.head , self.tail = self.tail , self.head



l = LinkedList()

N = int(input())
if(N!=0):
    arr = input().split()
    for i in range(N):
        l.push(int(arr[i]))


M = int(input())

coms ={
    "push" : lambda args: l.push(float(args[0])),
    "pop" : lambda args: l.pop(),
    "unshift": lambda args: l.unshift(float(args[0])),
    "shift" :lambda args: l.shift(),
    "insert": lambda args: l.insert(int (args[0]),float(args[1])),
}

for _ in range(M):
    command, *arg = input().split()
    coms[command](arg)


l.print()