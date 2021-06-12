package com.ksk578;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Introducer {
    // цель класса - определить вид аргумента для отбора записей БД в запрос, получить данные для запроса,
    // удалить дубли и выполнить проверки на корректность вводимых данных
    // выбор параметра запроса
    protected int ident;
    protected String selectionParameter;
    ArrayList <String> list;

    protected String inputer () throws IOException {
        //выбор параметра отбора записей в БД
        System.out.println ("\nВыберите параметр поиска:\nguid - введите 1,\tИдентификатор БД - введите 2");
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        ident = Integer.parseInt (reader.readLine ());
        if (ident != 1 && ident != 2) {
            int a = 0;
            while (ident != 1 && ident != 2) {
                if (a < 1) {
                    System.out.println ("Введите правильный код выбора параметра");
                    ident = Integer.parseInt (reader.readLine ());
                } else {
                    System.out.println ("Да сколько уже можно издеваться надо мной! \nВведите корректный код выбора:");
                    ident = Integer.parseInt (reader.readLine ());
                }
                a++;
            }
        }
        // получение значений выбранного парметра, валидация значений и удаление дублей.
        if (ident == 1) {
            selectionParameter = " w.GLOBALDOCID in ('";
            ValidatorArgumentGuid validatorArgumentGuid = new ValidatorArgumentGuid ();
            list = new ArrayList <> (validatorArgumentGuid.eliminationOfDuplicates (validatorArgumentGuid.populatingArgumentList ()));
        } else {
            selectionParameter = " r.ROUTECONTEXTID in ('";
            ValidatorArgumentIdDB validatorArgumentIdDB = new ValidatorArgumentIdDB ();
            list = new ArrayList <> (validatorArgumentIdDB.eliminationOfDuplicates (validatorArgumentIdDB.populatingArgumentList ()));
        }
        return selectionParameter;
        //return ident;
    }
    protected ArrayList <String> getList () {
        return list;
    }

}
