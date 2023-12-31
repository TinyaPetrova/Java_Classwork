package lesson51;

public class Main {

  public static void main(String[] args) {
    // enum - класс-перечисление
    // содержит в себе список значений
    // значения оформляем как константы - ВОТ_ТАК_ВОТ
    // Каждое значение соответствует своему порядковому номеру
    // Каждому экземпляру этого класса можно присвоить одно значение из списка
    // Класс переменная = Класс.ЗНАЧЕНИЕ;

    Month currentMonth = Month.JULY;
    System.out.println(currentMonth);
    System.out.println(currentMonth.ordinal() + 1);

    // У каждого класса enum есть статический метод values(),
    // который возвращает массив значений:
    // public static Класс[] values()
    // Получить порядковый номер можно при помощи метода ordinal()

    for (Month m : Month.values()) {
      System.out.println("Месяц " + m + ", порядковый номер " + m.ordinal());
    }
    // Month[] months = Month.values();
    // Month second = months[1]; // (месяц с индексом 1 - то есть второй по порядку)
    Month second = Month.values()[1];
    System.out.println(second);

    // статический метод Класс.valueOf("ЗНАЧЕНИЕ") превратит строку в соответствующее значение.
    // Значение должно совпадать со строкой посимвольно:
    // либо
    Month.valueOf("March".toUpperCase());
    // либо
    System.out.println(Month.valueOf("MARCH"));

    // enum применяется для объединения констант, список которых не планируется менять.
    // или для изменения списка всё равно потребуется переписывать программу

    // енам очень часто используется в паре со switch
    // идея сама следит за списком значений и предупредит вас, если вы забудете какой-то вариант

    // Примеры из жизни:
    // - дни недели
    // - месяцы
    // - плохой пример: размеры одежды (XS, S, M, L, XL) - плохой пример, можно добавить XXL
    // - режимы работы:
    //    - пункты основного меню
    //    - форматы (например, файлов)
    // - стадия (этап) обработки - состояние процесса (например, доставка)

    // Выбираем мы между енам и сохранением в отдельный файл, откуда будем читать в начале
    // Размеры, список валют, единицы измерения замечательно хранятся в файлах и читаются из них.
    // Всё, что можно изменить, добавить, удалить и е менять при этом программный код, стоит хранить отдельно от программного кода (файлы с настройками и базы данных)

  }
}
