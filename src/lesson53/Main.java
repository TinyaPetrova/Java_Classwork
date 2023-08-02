package lesson53;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Integer> numberList = new ArrayList<>();
    numberList.add(4);
    numberList.add(2);
    numberList.add(7);
    System.out.println("До сортировки: " + numberList);
    Collections.sort(numberList); // сортировка in-place - меняется существующий список
    System.out.println("После сортировки: " + numberList);

    int[] numbersArray = new int[3];
    numbersArray[0] = 4;
    numbersArray[1] = 2;
    numbersArray[2] = 7;
    System.out.println("До сортировки: " + Arrays.toString(numbersArray));
    Arrays.sort(numbersArray);
    System.out.println("После сортировки: " + Arrays.toString(numbersArray));
  }
}
// сортировка может быть стабильной и нестабильной:
// - стабильная (stable) для равных элементов сохраняет порядок добавления
// - нестабильная (unstable) ничего не обещает и может перемешать равные элементы
// Collections.sort() и List.sort() - стабильные, это написано в документации

// Сортировка с использованием компаратора:
// - нужно создать объект компаратора и передать его в :
// - Collections.sort(list, comparator) или
// - list.sort(comparator)