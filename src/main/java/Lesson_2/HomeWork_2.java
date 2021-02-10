package Lesson_2;

import java.util.Arrays;

public class HomeWork_2 {

    public static void main(String[] args) {

        System.out.println("Задание №1");

        int[] arrTaskOne = {1, 0, 1, 1, 1, 0, 0, 1, 1};
        System.out.println(Arrays.toString(arrTaskOne));

        for (int i = 0; i < arrTaskOne.length; i++) {
            if (arrTaskOne[i] == 1) {
                arrTaskOne[i] = 0;
            } else arrTaskOne[i] = 1;
        }
        System.out.println(Arrays.toString(arrTaskOne));


        System.out.println("Задание №2");

        int[] arrTaskTwo = new int[8];

        for (int i = 0; i < arrTaskTwo.length; i++) {
            arrTaskTwo[i] = i * 3;
        }
        System.out.println(Arrays.toString(arrTaskTwo));


        System.out.println("Задание №3");

        int[] arrTaskThree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arrTaskThree.length; i++) {
            if (arrTaskThree[i] < 6) arrTaskThree[i] *= 2;
        }
        System.out.println(Arrays.toString(arrTaskThree));


        System.out.println("Задание №4");

        int size = (int) (Math.random() * 10);
        int[][] arrTaskFour = new int[size][size];

        for (int i = 0; i < arrTaskFour.length; i++) {
            for (int j = 0; j < arrTaskFour[i].length; j++) {
                if (i == j) arrTaskFour[i][j] = 1;
                if (i + j == arrTaskFour.length - 1) arrTaskFour[i][j] = 1;
                System.out.printf("%2d", arrTaskFour[i][j]);
            }
            System.out.println();
        }


        System.out.println("Задание №5");

        int[] arrTaskFive = new int[(int) (Math.random() * 10) + 3];

        for (int i = 0; i < arrTaskFive.length; i++) {
            arrTaskFive[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arrTaskFive));

        int min = arrTaskFive[0], max = arrTaskFive[0];
        for (int i = 0; i < arrTaskFive.length; i++) {
            if (arrTaskFive[i] < min) min = arrTaskFive[i];
            if (arrTaskFive[i] > max) max = arrTaskFive[i];
        }
        System.out.println("Минимальный элемент массива: " + min);
        System.out.println("Максимальный элемент массива: " + max);


        System.out.println("Задание №6");

        int[] arrTaskSix = new int[]{1, 2, 3, 2, 1, 3, 4, 5, 6, 2, 3};

        System.out.println(Arrays.toString(arrTaskSix));

         if (arrayBalance(arrTaskSix)) {
            System.out.println("В массиве найден баланс");
        } else System.out.println("Баланс не найден");


        System.out.println("Задание №7");

        int shift = -3;
        int[] arrTaskSeven = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("Исходный массив: " + Arrays.toString(arrTaskSeven));
        System.out.println("Массив после сдвига: " + Arrays.toString(arrayShift(arrTaskSeven, shift)));


        System.out.println("Задание №8 (заполнение массива по спирали)");

        int sizeA = 7, sizeB = 11, count = 1, j = 0, i = 0, k = 1, iterations;
        int[][] arrTaskEit = new int[sizeA][sizeB];

        if (sizeA < sizeB) iterations = sizeA * 2;
        else iterations = sizeB * 2;

        if (sizeA <= 0 || sizeB <= 0) System.out.println("Укажите положительный размер массива");
        else {

            for (; iterations > 0; iterations -= 4) {
                for (; i < arrTaskEit.length; i++) {
                    if (arrTaskEit[i][j] != 0) continue;
                    arrTaskEit[i][j] = count++;
                }
                i -= k;

                for (; j < arrTaskEit[i].length; j++) {
                    if (arrTaskEit[i][j] != 0) continue;
                    arrTaskEit[i][j] = count++;
                }
                j -= k;

                for (; i >= 0; i--) {
                    if (arrTaskEit[i][j] != 0) continue;
                    arrTaskEit[i][j] = count++;
                }
                i += k;

                for (; j >= 0; j--) {
                    if (arrTaskEit[i][j] != 0) continue;
                    arrTaskEit[i][j] = count++;
                }
                j += k + 1;
                k++;
            }
            for (i = 0; i < arrTaskEit.length; i++) {
                for (j = 0; j < arrTaskEit[i].length; j++) {
                    System.out.printf("%3d", arrTaskEit[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static boolean arrayBalance(int[] arrTaskSix) {
        int i = 0, sumLeft = 0, sumRight = 0;
        for (i = 0; i < arrTaskSix.length; i++) {
            sumLeft = 0;
            sumRight = 0;
            for (int j = 0; j <= i; j++) {
                sumLeft += arrTaskSix[j];
            }
            for (int k = arrTaskSix.length - 1; k > i; k--) {
                sumRight += arrTaskSix[k];
            } if (sumLeft == sumRight) break;
        }
    return  (sumLeft == sumRight);
    }

    private static int[] arrayShift(int[] arrTaskSeven, int shifting) {
        int tempElements;
        while (shifting > arrTaskSeven.length) {
            shifting -= arrTaskSeven.length;
        }

        if (shifting > 0) {
            for (int i = 0; i < shifting; i++) {
                tempElements = arrTaskSeven[arrTaskSeven.length - 1];
                for (int j = arrTaskSeven.length - 1; j > 0; j--) {
                    arrTaskSeven[j] = arrTaskSeven[j - 1];
                }
                arrTaskSeven[0] = tempElements;
            }
        } else {
            for (int i = 0; i < Math.abs(shifting); i++) {
                tempElements = arrTaskSeven[0];
                for (int j = 0; j < arrTaskSeven.length - 1; j++) {
                    arrTaskSeven[j] = arrTaskSeven[j + 1];
                }
                arrTaskSeven[arrTaskSeven.length - 1] = tempElements;
            }
        } return  arrTaskSeven;
    }

}
