package HomeWorks;

import java.util.Scanner;

public class Queue<T> {

        private static class Element<T> {
            T value;
            Element<T> next;

            Element(T value) {
                this.value = value;
            }
        }

        private Element<T> front;
        private Element<T> rear;
        private int count;

        public Queue() {
            front = null;
            rear = null;
            count = 0;
        }

        public void enqueue(T value) {
            Element<T> node = new Element<>(value);
            if (rear == null) {
                front = rear = node;
            } else {
                rear.next = node;
                rear = node;
            }
            count++;
        }

        public T dequeue() {
            if (front == null) {
                throw new IllegalStateException("Очередь пуста");
            }
            T result = front.value;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            count--;
            return result;
        }

        public T peek() {
            if (front == null) {
                throw new IllegalStateException("Очередь пуста");
            }
            return front.value;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public int size() {
            return count;
        }

        public void clear() {
            front = null;
            rear = null;
            count = 0;
        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder("{");
            Element<T> current = front;
            while (current != null) {
                output.append(current.value);
                if (current.next != null) {
                    output.append(", ");
                }
                current = current.next;
            }
            output.append("}");
            return output.toString();
        }

            public static void main(String[] args) {
                Queue<Integer> intQueue = new Queue<>();
                Scanner input = new Scanner(System.in);

                System.out.println("Добро пожаловать!");

                while (true) {
                    System.out.println("\nВыберите действие:");
                    System.out.println("1 - Добавить элемент (enqueue)");
                    System.out.println("2 - Удалить первый элемент (dequeue)");
                    System.out.println("3 - Посмотреть первый элемент (peek)");
                    System.out.println("4 - Проверить, пуста ли очередь");
                    System.out.println("5 - Получить размер очереди");
                    System.out.println("6 - Очистить очередь");
                    System.out.println("7 - Показать все элементы");
                    System.out.println("0 - Выход");
                    System.out.print("Введите номер команды: ");

                    int command = input.hasNextInt() ? input.nextInt() : -1;
                    input.nextLine();

                    switch (command) {
                        case 0:
                            System.out.println("Завершение программы.");
                            input.close();
                            return;

                        case 1:
                            System.out.print("Введите число для добавления: ");
                            if (input.hasNextInt()) {
                                int valueToAdd = input.nextInt();
                                intQueue.enqueue(valueToAdd);
                                System.out.println("Элемент " + valueToAdd + " добавлен в очередь.");
                            } else {
                                System.out.println("Некорректный ввод. Ожидалось целое число.");
                                input.nextLine();
                            }
                            break;

                        case 2:
                            try {
                                int removed = intQueue.dequeue();
                                System.out.println("Удалён элемент: " + removed);
                            } catch (RuntimeException e) {
                                System.out.println("Очередь пуста. Удаление невозможно.");
                            }
                            break;

                        case 3:
                            try {
                                int frontValue = intQueue.peek();
                                System.out.println("Первый элемент в очереди: " + frontValue);
                            } catch (RuntimeException e) {
                                System.out.println("Очередь пуста.");
                            }
                            break;

                        case 4:
                            System.out.println(intQueue.isEmpty() ? "Очередь пуста." : "Очередь не пуста.");
                            break;

                        case 5:
                            System.out.println("Текущий размер очереди: " + intQueue.size());
                            break;

                        case 6:
                            intQueue.clear();
                            System.out.println("Очередь успешно очищена.");
                            break;

                        case 7:
                            System.out.println("Содержимое очереди: " + intQueue.toString());
                            break;

                        default:
                            System.out.println("Неизвестная команда. Попробуйте снова.");
                    }
                }
            }
        }
        


