import java.util.Stack;

public class ImplementQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public ImplementQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        while (s1.empty() == false) {
            s2.push(s1.peek());
            s1.pop();
        }
        s1.push(x);
        while (s2.empty() == false) {
            s1.push(s2.peek());
            s2.pop();
        }
    }

    public int pop() {
        if (s1.empty()) {
            return -1;
        }
        int val = s1.peek();
        s1.pop();
        return val;
    }

    public int peek() {
        if (s1.empty() == true) {
            return -1;
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.empty();
    }
}
