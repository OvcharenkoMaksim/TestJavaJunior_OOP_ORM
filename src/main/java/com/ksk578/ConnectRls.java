package com.ksk578;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;

public class ConnectRls extends  ConnectStendFath {
    // цель метода - вынести все данные о подключении в отдельный сервисный класс-наследник для того, что бы упростить
    // масштабирование подключений - для подключения к новой площадке необходимо лишь добавить новый класс-наследник и
    // прописать его вызов в классе Connect

    public LinkedHashMap <Integer, Responseline> connectBdUfos () throws SQLException, ClassNotFoundException, IOException {
        final String url = "jdbc:postgresql://eb-tse-rls-poi-db.otr.ru:5432/tse_ufos_wl";
        final  String username = "ufos";
        final String password = "Postgres55";
        LinkedHashMap <Integer,Responseline> mapResponce = new LinkedHashMap <> ();
        mapResponce.putAll (super.connectBdUfos(url, username, password));
        return mapResponce;

    }

}