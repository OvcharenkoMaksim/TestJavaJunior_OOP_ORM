package com.ksk578;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

public class RequestSubmission {
    // цель класса - вывести из созданной карты необходимые поля в нужной последовательности в консоль, для отображения
    // пользоватею
    protected long fied;
    String stend;
    LinkedHashMap <Integer, Responseline> mapResponce = new LinkedHashMap <> ();

    protected void presentingRequestScreen () throws SQLException, IOException, ClassNotFoundException {
        Connect connect = new Connect ();
        stend = connect.databaseSelection ();
        mapResponce.putAll (connect.getMapResponce ());
        FieldsView fieldsView = new FieldsView ();
        fied = fieldsView.view ();

        // вывод сервисной информации о запросе
        System.out.println ("БД стенда: " + stend);
        System.out.println ( "Время запроса: " + new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss").
                format (Calendar.getInstance ().getTime ()) );
        if (fied == 1) {
            System.out.format ("%25s%25s%80s%35s%12s%60s%20s%40s%5s","Дата создания |", "Сист имя |", "Документ |",
                    "Глоб статус |", "СВР |", "Организация |", "Идентификатор БД |", "Глобальный идентификатор |", "\n");
            for (Map.Entry mapRes : mapResponce.entrySet ()) {
                Responseline resp = (Responseline) mapRes.getValue ();
                System.out.format ("%25s%25s%80s%35s%12s%60s%20s%40s%5s",resp.creationDate, resp.systName, resp.document,
                        resp.globStatus, resp.svr, resp.organization, resp.databaseID, resp.globalID, "\n");
            }
        }
        else {
            System.out.format ("%25s%25s%80s%35s%35s%12s%60s%12s%12s%12s%12s%20s%40s%20s%20s%8s", "Дата создания |",
                    "Сист имя |", "Документ |", "Глоб статус |", "Сист имя глоб статуса |", "СВР |", "Организация |",
                    "Глоб стат |", "Лок стат |", "Глоб верс |", "Лок верс |", "Идентификатор БД |",
                    "Глобальный идентификатор |", "ORGID |", "DOCID |", "\n");
            for (Map.Entry mapRes : mapResponce.entrySet ()) {
                Responseline resp = (Responseline) mapRes.getValue ();
                System.out.format ("%25s%25s%80s%35s%35s%12s%60s%12s%12s%12s%12s%20s%40s%20s%20s%8s", resp.creationDate,
                        resp.systName, resp.document, resp.globStatus, resp.systNameGlobStatus,resp.svr, resp.organization,
                        resp.globStat, resp.lokStat, resp.globVersion, resp.lockVersion, resp.databaseID,
                        resp.globalID, resp.orgID, resp.docID, "\n");
            }
        }
    }


}
