package Managers;

import db.tables.Organisation;
import org.jetbrains.annotations.NotNull;
import org.jooq.*;
import org.jooq.impl.DSL;
import static db.tables.Nomenclature.*;
import static db.tables.Organisation.*;
import static db.tables.Waybill.*;
import static db.tables.Waybillcontent.*;
import static org.jooq.impl.DSL.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Managers {

    /*Выбрать первые 10 поставщиков по количеству поставленного товара*/
    public void showFirstTenProviders() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        Result<Record2<Integer, String>> result = create.select(WAYBILLCONTENT.QUANTITY,WAYBILL.ORGANISATION).
                from(WAYBILL.join(WAYBILLCONTENT).
                on(WAYBILL.ID.eq(WAYBILLCONTENT.ID))).
                orderBy(WAYBILLCONTENT.QUANTITY.desc()).
                limit(10).
                fetch();
        System.out.println(result);
    }

    /*Выбрать поставщиков с суммой поставленного товара выше указанного количества (товар и его количество должны допускать множественное указание).*/
    public void showProvidersWithSumHigherThen(int limit) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        Result<Record2<String, Integer>> result = create.select(WAYBILL.ORGANISATION,WAYBILLCONTENT.QUANTITY.mul(WAYBILLCONTENT.PRICE).as("totalSum")).
                from(WAYBILL.join(WAYBILLCONTENT).on(WAYBILL.ID.eq(WAYBILLCONTENT.ID))).where(WAYBILLCONTENT.QUANTITY.mul(WAYBILLCONTENT.PRICE).greaterThan(limit)).fetch();

        System.out.println(result);
    }

    /*рассчитать количество и сумму полученного товара в указанном периоде, посчитать итоги за период*/
    public void sumAndQuantityForEveryDay(String dateFrom, String dateTo) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        @NotNull Result<Record2<Integer, Integer>> result = create.select(WAYBILLCONTENT.QUANTITY,WAYBILLCONTENT.QUANTITY.mul(WAYBILLCONTENT.PRICE).as("sum")).from(WAYBILL.join(WAYBILLCONTENT).
                on(WAYBILL.ID.eq(WAYBILLCONTENT.ID))).where(WAYBILL.DATE.between(dateFrom).and(dateTo)).fetch();
        System.out.println(result);
    }

    /*Рассчитать среднюю цену полученного товара за период*/
    public void averagePriceForAPeriod(String dateFrom, String dateTo) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        Result<Record1<BigDecimal>> result = create.select(avg(WAYBILLCONTENT.PRICE)).from(WAYBILL.join(WAYBILLCONTENT).
                on(WAYBILL.ID.eq(WAYBILLCONTENT.ID))).where(WAYBILL.DATE.between(dateFrom).and(dateTo)).fetch();
        System.out.println(result);
    }

    /*Вывести список товаров, поставленных организациями за период*/
    public void listProductsProvidedForAPeriod(String dateFrom, String dateTo) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/someShop_db", "postgres", "qwerty");
        DSLContext create = DSL.using(connection, SQLDialect.POSTGRES);
        @NotNull Result<Record2<Integer, String>> result = create.select(WAYBILLCONTENT.ID,WAYBILLCONTENT.NOMENCLATURE).from(WAYBILL.join(WAYBILLCONTENT).
                on(WAYBILL.ID.eq(WAYBILLCONTENT.ID))).where(WAYBILL.DATE.between(dateFrom).and(dateTo)).fetch();
        System.out.println(result);

    }
}
