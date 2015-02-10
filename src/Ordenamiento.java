/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author introduccion02
 */
public class Ordenamiento<T extends Comparable<T>> {

    /**
     * @param args the command line arguments
     */
    public void selectionSort(T[] arr, int n) {
        int min;

        for (int i = 0; i < n - 1; i++) {
            min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            swap(arr, i, min);

        }
    }

    public void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void swap(T[] arr, int x, int y) {
        T auxX = arr[x], auxY = arr[y];

        arr[x] = auxY;
        arr[y] = auxX;
    }

    public static void main(String[] args) {
        Integer[] arr = {9, 4, 2, 5, 6, 10, -1, 60, 0};
        Ordenamiento<Integer> ord = new Ordenamiento<Integer>();

        ord.bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
