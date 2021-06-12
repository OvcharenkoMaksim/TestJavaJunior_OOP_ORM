package com.ksk578;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ValidatorArgumentFath {
    //цель класса - вынести общие метод в родительский класс, при этом метод eliminationOfDuplicates не
    // переопределяется в наследниках,метод populatingArgumentList требует переопределения в наследниках, т.к. разные
    //принципы валидации значений.

    //ввод аргумента в запрос к БД, метод требует переопределения в наследниках, приводится некоторая базовая часть реализации
    protected ArrayList <String> populatingArgumentList () throws IOException {
        ArrayList <String> list = new ArrayList <> ();
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String argument = reader.readLine ();
        list.add (argument);
        if (list.size () == 0) {
            System.out.println ("Аргумент не введен \nРабота программы завершена досрочно\nДо новых встреч!");
            System.exit (1);
        }
        return list;
    }

    //удаление возможных дублей, метод наследуется полностью
    protected ArrayList <String> eliminationOfDuplicates (ArrayList<String> list) {
        ArrayList <String> list1;
        Set <String> set = new LinkedHashSet <> (list);
        list1 = new ArrayList <> (set);
        return list1;
    }
}
