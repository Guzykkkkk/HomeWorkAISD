package HomeWorks;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

    public class DataGeneration {

        public static void generateAndSaveDataSets(String filename, int numOfSets, int minSize, int maxSize) {
            Random random = new Random();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (int i = 0; i < numOfSets; i++) {
                    int size = random.nextInt(maxSize - minSize + 1) + minSize;
                    writer.write(Integer.toString(size));
                    writer.newLine();

                    StringBuilder dataLine = new StringBuilder();
                    for (int j = 0; j < size; j++) {
                        int number = random.nextInt(10000);
                        dataLine.append(number);
                        if (j < size - 1) {
                            dataLine.append(" ");
                        }
                    }

                    writer.write(dataLine.toString());
                    writer.newLine();
                }

                System.out.println("Успешно создано " + numOfSets + " наборов данных в файле: " + filename);
            } catch (IOException e) {
                System.err.println(" Ошибка при записи в файл: " + e.getMessage());
            }
        }
    }


