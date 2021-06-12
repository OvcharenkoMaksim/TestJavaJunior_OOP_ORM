package com.ksk578;

import java.io.IOException;
import java.sql.SQLException;

public class Start {
    // стартовый класс приложения

    // Приветствие и запуск программы
    public static void main ( String[] args ) throws IOException, SQLException, ClassNotFoundException {
        System.out.println ("Добрый день! \nВы делаете комбинированный запрос-select к БД УФОС, таблицам: Routecontext, " +
                "Org, Doc, Doctype, Docstate. \nЭто основной запрос при разборе ошибок, связанных с ПОИБом\n");
        RequestSubmission requestSubmission = new RequestSubmission ();
        requestSubmission.presentingRequestScreen ();
        System.out.println ( "\nРабота программы завершена успешно." );
    }

}
