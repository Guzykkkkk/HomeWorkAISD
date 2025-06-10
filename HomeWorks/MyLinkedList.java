package HomeWorks;

import java.util.LinkedList;
import java.util.Scanner;

public class MyLinkedList {
    public class LinkedList<T> {

        private static class Node<T> {
            T value;
            Node<T> next;

            Node(T value) {
                this.value = value;
            }
        }

        private Node<T> head;
        private Node<T> tail;
        private int length;

        public LinkedList() {
            head = null;
            tail = null;
            length = 0;
        }


        public void addFirst(T value) {
            Node<T> newNode = new Node<>(value);
            newNode.next = head;
            head = newNode;

            if (tail == null) {
                tail = newNode;
            }

            length++;
        }

        public void addLast(T value) {
            Node<T> newNode = new Node<>(value);

            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            length++;
        }

        public T removeFirst() {
            if (head == null) {
                throw new IllegalStateException("Список пуст");
            }

            T removedValue = head.value;
            head = head.next;

            if (head == null) {
                tail = null;
            }

            length--;
            return removedValue;
        }

        public boolean remove(T value) {
            Node<T> current = head;
            Node<T> previous = null;

            while (current != null) {
                if (current.value.equals(value)) {
                    if (previous == null) {
                        // Удаление головы
                        head = current.next;
                        if (head == null) {
                            tail = null;
                        }
                    } else {
                        previous.next = current.next;
                        if (current.next == null) {
                            tail = previous;
                        }
                    }

                    length--;
                    return true;
                }

                previous = current;
                current = current.next;
            }

            return false;
        }

        public boolean contains(T value) {
            Node<T> current = head;

            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }

            return false;
        }

        public int size() {
            return length;
        }

        public void clear() {
            head = null;
            tail = null;
            length = 0;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append("[");

            Node<T> current = head;

            while (current != null) {
                result.append(current.value);
                if (current.next != null) {
                    result.append(", ");
                }
                current = current.next;
            }

            result.append("]");
            return result.toString();
        }
    }

    public void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Программа работы с LinkedList");
        while (true) {
            System.out.println();
            System.out.println("Доступные команды:");
            System.out.println("1: addFirst X — добавить X в начало");
            System.out.println("2: addLast X — добавить X в конец");
            System.out.println("3: removeFirst — удалить первый элемент");
            System.out.println("4: remove X — удалить первое вхождение X");
            System.out.println("5: contains X — проверить наличие X");
            System.out.println("6: size — размер списка");
            System.out.println("7: clear — очистить список");
            System.out.println("8: print — вывести список");
            System.out.println("0: exit — выйти из программы");
            System.out.print("Введите команду: ");
            int cmd = sc.nextInt();
            switch (cmd) {
                case 0:
                    System.out.println("Выход");
                    sc.close();
                    return;
                case 1:
                    System.out.print("Введите число для addFirst: ");
                    list.addFirst(sc.nextInt());
                    break;
                case 2:
                    System.out.print("Введите число для addLast: ");
                    list.addLast(sc.nextInt());
                    break;
                case 3:
                    try {
                        int removed = list.removeFirst();
                        System.out.println("Удалён первый элемент: " + removed);
                    } catch (RuntimeException e) {
                        System.out.println("Список пуст");
                    }
                    break;
                case 4:
                    System.out.print("Введите число для remove: ");
                    boolean removed = list.remove(sc.nextInt());
                    System.out.println(removed ? "Элемент удалён" : "Элемент не найден");
                    break;
                case 5:
                    System.out.print("Введите число для contains: ");
                    boolean found = list.contains(sc.nextInt());
                    System.out.println(found ? "Список содержит элемент" : "Список не содержит элемент");
                    break;
                case 6:
                    System.out.println("Размер списка: " + list.size());
                    break;
                case 7:
                    list.clear();
                    System.out.println("Список очищен");
                    break;
                case 8:
                    System.out.println("Содержимое списка: " + list);
                    break;
                default:
                    System.out.println("Неверная команда");
            }
        }
    }
}
