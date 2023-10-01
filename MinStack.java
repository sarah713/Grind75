import java.util.Stack;

public class MinStack {
    Stack<Integer> st;
    int min = Integer.MIN_VALUE;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int x) {
        if (st.isEmpty()) {
            st.push(x);
            min = x;
        } else {
            if (x < min) {
                st.push(2 * x - min);
                min = x;
            } else {
                st.push(x);
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) {
            return;
        } else {
            int x = st.pop();

            if (x < min) {
                min = 2 * min - x;
            }
        }
    }

    public int top() {
        int x = st.peek();
        if (x < min) {
            return min;
        }
        return x;
    }

    public int getMin() {
        return min;
    }
}
