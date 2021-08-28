import Managers.Managers;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
       Managers managers = new Managers();
       managers.sumAndQuantityForEveryDay("2020-01-01","2020-06-06");
    }
}
