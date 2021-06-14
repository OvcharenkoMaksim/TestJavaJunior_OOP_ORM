package com.ksk578;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

public class ConnectDemo extends ConnectStendFath {
    // цель метода - вынести все данные о подключении в отдельный сервисный класс-наследник для того, что бы упростить
    // масштабирование подключений - для подключения к новой площадке необходимо лишь добавить новый класс-наследник и
    // прописать его вызов в классе Connect

    final String url;
    final  String username;
    final String password;
    RequestStructure requestStructure;

    // сеттеры ввода значений переменных подключения из  ConnectStend.properties
    public ConnectDemo(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void setRequestStructure (RequestStructure requestStructure) {
        this.requestStructure = requestStructure;
    }

    //проксируем вызов метода к родительскому классу, дополняя его требуемыми аргументами
    public LinkedHashMap <Integer, Responseline> connectBdUfos () throws SQLException, ClassNotFoundException, IOException {
        LinkedHashMap <Integer,Responseline> mapResponce = new LinkedHashMap <> (super.connectBdUfos(url, username, password, requestStructure));
        return mapResponce;
    }
}
