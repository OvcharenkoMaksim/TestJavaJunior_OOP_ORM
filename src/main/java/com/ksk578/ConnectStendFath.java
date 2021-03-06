package com.ksk578;

import java.io.IOException;
import java.sql.*;
import java.util.LinkedHashMap;

public class ConnectStendFath {
    // цель класса - вынести процесс подключения в отдельный севисный объект, выполнить подключение по подданым в метод
// аргументам, полученный запрос сохранить в Map и вернуть мапу.
// !!! Важно ссылку на бин объекта RequestStructure
// необходимо подавать из объекта дочернего класса, т.к. иначе все ссылки нулевые.

    // подключаемся к БД выбранной площадки по поданным аргументам
    public LinkedHashMap<Integer, Responseline> connectBdUfos (String url, String username, String password, RequestStructure requestStructure)
            throws SQLException, IOException {
        LinkedHashMap <Integer,Responseline> mapResponce = new LinkedHashMap <> ();

        // загрузка драйвера и выполнение подключения к БД
        //Class.forName ("org.postgresql.Driver");
        //Class.forName("oracle.jdbc.OracleDriver");
        Connection con= DriverManager.getConnection (url, username, password);
        Statement stmt=con.createStatement ();

        //контроль подключения к БД
        if (stmt != null){
            System.out.println("Выполнено подключение к БД");
        }

        //получаем итоговый запрос к БД и выполняем его
        ResultSet res = stmt.executeQuery (requestStructure.quest ());

        // полученный ответ сохраняем в мапу
        Integer a = 1;
        while(res.next ()){
            Responseline responseline = new Responseline(res.getString(1), res.getString(2),
                    res.getString(3), res.getString(4), res.getString(5),
                    res.getString(6), res.getString(7), res.getString(8),
                    res.getString(9), res.getString(10), res.getString(11),
                    res.getString(12), res.getString(13), res.getString(14),
                    res.getString(15));
            mapResponce.put(a,responseline);
            a++;
        }
        // закрываем соединение
        con.close ();
        return mapResponce;
    }
}
