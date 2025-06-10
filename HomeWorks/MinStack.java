package HomeWorks;

public class MinStack {
    private int[] mainStack;
    private int[] minStack;
    private int top;
    private int capacity;

    public MinStack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        this.capacity = size;
        this.mainStack = new int[capacity];
        this.minStack = new int[capacity];
        this.top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }

        mainStack[++top] = x;

        if (top == 0 || x <= minStack[top - 1]) {
            minStack[top] = x;
        } else {
            minStack[top] = minStack[top - 1];
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return mainStack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return mainStack[top];
    }

    public int getMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack(5);

        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(1);

        System.out.println("Минимум: " + stack.getMin());
        System.out.println("Верхний элемент: " + stack.peek());

        stack.pop();
        System.out.println("Новый минимум: " + stack.getMin());
    }
}