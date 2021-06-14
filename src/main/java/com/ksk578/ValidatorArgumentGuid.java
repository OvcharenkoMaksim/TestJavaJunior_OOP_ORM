package com.ksk578;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ValidatorArgumentGuid extends ValidatorArgumentFath {
    //цель класса - принять guid в качестве параметра запроса, выполнить валидацию вводимых значений и удалить возможные
    // дубли

    @Override
    //ввод гуидов
    protected ArrayList <String> populatingArgumentList () throws IOException {
        ArrayList <String> list = new ArrayList <> ();
        System.out.println ("Введите guid в произвольном порядке:");
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        String guid;
        while (true) {
            guid = reader.readLine ();
            if (guid.length () == 0) break;
            if (guid.length () == 36) {
                list.add (guid);
            } else {
                System.out.println ("Введите корректный guid");
            }
        }
        if (list.size () == 0) {
            System.out.println ("Guid не введен \nРабота программы завершена досрочно");
            System.exit (1);
        }
        return list;
    }
}
