package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieUnit;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PosterManager {
    private MovieUnit[] units = new MovieUnit[0];

    public void add(MovieUnit unit) {               // Менеджер добавляет новый фильм в ленту (ЗАДАЧА 1)
        int length = units.length + 1;              // создаем длину массива размером на единицу больше
        MovieUnit[] tmp = new MovieUnit[length];    // создаем новый временный массив tmp с новой длиной
        for (int i = 0; i < units.length; i++) {    // перебираем все элементы массива
            tmp[i] = units[i];                      // каждый элемент станет элементом временного массива tmp
        }
        int lastIndex = tmp.length - 1;             // заводим переменную последнего элемента массива
        tmp[lastIndex] = unit;                      // присваиваем переменной значение добавленного элемента unit
        units = tmp;                                // все элементы начального массива становятся элементами массива tmp
    }

    public MovieUnit[] getLast7() {                 // Менеджер выбирает последние 7 добавленных фильмов в обратном порядке (ЗАДАЧА 2)
        int resultLength;                           // заводим переменную новой длины массива
        if (units.length > 7) {                     // условие отборки. если длина начального массива больше 7
            resultLength = 7;                       // новая длина массива - последние 7 элементов
        } else {                                    // в ином случае
            resultLength = units.length;            // длина нового массива = длине начального
        }
        MovieUnit[] result = new MovieUnit[resultLength];   // создаем новый массив с новой длиной по отборке
        for (int i = 0; i < result.length; i++) {           // перебираем все элементы нового массива
            result[i] = units[i];                           // присваиваем значения элементам нового массива
        }
        return result;
    }

    public MovieUnit[] getAll() {
        MovieUnit[] result = new MovieUnit[units.length];
        for (int i = 0; i < result.length; i++) {
            int index = units.length - i - 1;
            result[i] = units[index];
        }
        return result;
    }

    public void removeById(int id) {
        int length = units.length - 1;
        MovieUnit[] tmp = new MovieUnit[length];
        int index = 0;
        for (MovieUnit unit : units) {
            if (unit.getId() != id) {
                tmp[index] = unit;
            }
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = unit;
            units = tmp;
        }
    }
}



