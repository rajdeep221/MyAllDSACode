package LinkedList;

public class SimplyLinkedList {

    private Node head;
    private Node tail;

    private int size;

    public SimplyLinkedList() {
        this.size = 0;
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node() {
        };
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("END\n");
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }

    public int deletFirst() {
        int val = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast() {
        if (size == 1) {
            return deletFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.val;
        tail = secondLast;
        tail.next = null;
        return val;

    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int delete(int index) {
        if (index == 0) {
            return deletFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.val;
        prev.next = prev.next.next;
        return val;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return node;
    }

    // insert using recursion
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, --index, node.next);
        return node;
    }

    // Remove dublicate from sorted list
    public Node deleteDuplecates(Node node) {
        Node head = node;
        if (node == null) {
            return node;
        }
        while (node.next != null) {
            if (node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    public void dublicates() {
        Node node = head;
        while (node.next != null) {
            if (node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    // Merge two sorted list

    public static SimplyLinkedList merge(SimplyLinkedList first, SimplyLinkedList second) {
        Node f = first.head;
        Node s = second.head;

        SimplyLinkedList ans = new SimplyLinkedList();

        while (f != null && s != null) {
            if (f.val < s.val) {
                ans.insertLast(f.val);
                f = f.next;
            } else {
                ans.insertLast(s.val);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.val);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.val);
            s = s.next;
        }

        return ans;
    }

    public Node mergeTwoLists(Node list1, Node list2) {
        Node ans = new Node();
        Node tail = ans;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return ans.next;
    }

    // LinkedList cycle exist -> Fast and slow pointer method

    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // Find the lenhth of the cycle

    public int lengthCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // calculate the length
                Node temp = slow;
                int lenght = 0;
                do {
                    temp = temp.next;
                    lenght++;
                } while (temp != slow);
                return lenght;
            }
        }
        return 0;
    }

    // Tell me where the cycle is starting

    public Node detectCycle(Node head) {
        int length = 0;

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                Node temp = slow;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        // find the start node
        Node f = head;
        Node s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        // keep moving both forward and thehy will meet at cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    // Find happy no

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquart(slow);
            fast = findSquart(findSquart(fast));
        } while (fast != slow);

        if (slow == 1) {
            return true;
        }
        return false;
    }

    private int findSquart(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans += rem * rem;
            n /= 10;
        }
        return ans;
    }

    // Find the middle of the LikedList

    public Node middleNode(Node head) {
        Node s = head;
        Node f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    // Merge sort in LinkedList

    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = middleNode(head);
        Node left = sortList(head);
        Node right = sortList(mid);

        return mergeTwoLists(left, right);
    }

    // Bubble sort in LinkedList Q-09

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.val > second.val) {
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }

    // Reverse a LinkedList using Recursion

    public void reverse(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }

        reverse(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public Node reverse1(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node pres = head;
        Node prev = null;
        Node next = pres.next;

        while (pres != null) {
            pres.next = prev;
            prev = pres;
            pres = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    // Reverse a LinkedList II

    public Node reverseBetween(Node head, int left, int right) {
        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        Node curr = head;
        Node prev = null;
        for (int i = 0; curr != null && i < left - 1; i++) {
            prev = curr;
            curr = curr.next;
        }

        Node last = prev;
        Node newEnd = curr;

        // reverse between left and right

        Node next = curr.next;
        for (int i = 0; i < (right - left + 1); i++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = curr;
        return head;
    }

    // Check Palindrtom

    public boolean isPalindrome(Node head) {
        Node mid = middleNode(head);
        Node headSecond = reverse1(mid);
        Node reverseHead = headSecond;
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverse(reverseHead);

        return head == null || headSecond == null;
    }

    // Reorder List

    public void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node mid = middleNode(head);

        Node hs = reverse1(mid);
        Node hf = head;
        while (hs != null && hf != null) {
            Node temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        // next of tail to null
        if (hf != null) {
            hf.next = null;
        }
    }

    // Reverse every k-Group -> google, amazon, facebook, microsoft
    // its also reversing the < k end times -> modify it accordingly

    public Node revereKGroup(Node head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;

        while (true) {

            Node last = prev;
            Node newEnd = curr;

            // reverse between left and right

            Node next = curr.next;
            for (int i = 0; i < k; i++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = curr;

            if (curr == null) {
                break;
            }

            prev = newEnd;
        }
        return head;
    }

    // Reverse k-group alternately

    public Node revereAlternateKGroup(Node head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;

        while (curr != null) {

            Node last = prev;
            Node newEnd = curr;

            // reverse between left and right

            Node next = curr.next;
            for (int i = 0; i < k; i++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = curr;

            // skip the k nodes
            for (int i = 0; curr != null && i < k; i++) {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    // Rotate List k-times -> FaceBook, Twitter, Google

    public Node rotateRight(Node head, int k) {

        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        Node last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }

        last.next = head;
        int rot = k % length;
        int skip = length - rot;
        Node newLast = head;

        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;

        }

        head = newLast.next;
        newLast.next = null;

        return head;
    }
}