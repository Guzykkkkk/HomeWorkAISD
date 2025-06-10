package HomeWorks;
import java.util.Scanner;

    public class PeakFind {

        public static int findPeakIndex(int[] array) {
            int left = 0;
            int right = array.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (array[mid] < array[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите количество элементов: ");
            int size = scanner.nextInt();

            if (size == 0) {
                System.out.println("Массив пуст.");
                scanner.close();
                return;
            }

            int[] array = new int[size];
            System.out.println("Введите элементы массива:");

            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }

            scanner.close();

            int peak = findPeakIndex(array);
            System.out.println("Индекс вершины: " + peak);
            System.out.println("Значение в вершине: " + array[peak]);
        }
    }


