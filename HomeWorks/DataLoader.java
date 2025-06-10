package HomeWorks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    public class DataLoader {

        public static List<int[]> loadDataSets(String filePath) {
            List<int[]> dataSetList = new ArrayList<>();

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
                String sizeString;

                while ((sizeString = bufferedReader.readLine()) != null) {
                    sizeString = sizeString.trim();
                    if (sizeString.isEmpty()) continue;

                    int arraySize;
                    try {
                        arraySize = Integer.parseInt(sizeString);
                    } catch (NumberFormatException e) {
                        System.err.println("Ошибка: некорректное значение размера массива: " + sizeString);
                        continue;
                    }

                    String numbersLine = bufferedReader.readLine();
                    if (numbersLine == null) {
                        System.err.println("Ошибка: ожидалась строка с числами, но достигнут конец файла.");
                        break;
                    }

                    String[] numberStrings = numbersLine.trim().split("\\s+");
                    if (numberStrings.length != arraySize) {
                        System.err.println("Ошибка: ожидается " + arraySize + " чисел, но получено " + numberStrings.length + ". Пропуск набора.");
                        continue;
                    }

                    int[] numbers = new int[arraySize];
                    try {
                        for (int index = 0; index < arraySize; index++) {
                            numbers[index] = Integer.parseInt(numberStrings[index]);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Ошибка при преобразовании строки в число: " + e.getMessage());
                        continue;
                    }

                    dataSetList.add(numbers);
                }

            } catch (IOException e) {
                System.err.println("Ошибка при открытии или чтении файла: " + e.getMessage());
            }

            return dataSetList;
        }

    }


