package HomeWorks;

public class IntStack {
    private int[] stackArray;
    private int top;
    private int capacity;

    public IntStack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер < 0 ");
        }
        this.capacity = size;
        this.stackArray = new int[capacity];
        this.top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("Стек переполнен");
        }
        stackArray[++top] = value;
    }
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return stackArray[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return stackArray[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        IntStack stack = new IntStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Верхний элемент: " + stack.peek());
        System.out.println("Размер стека: " + stack.size());
        System.out.println("Извлечённый элемент: " + stack.pop());
        System.out.println("Новый верхний элемент: " + stack.peek());
    }
}
