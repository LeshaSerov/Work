package db;

import domain.Pharm;
import util.ConnectionPool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PharmsOfThePreparatDao {

    public static ArrayList<Pharm> getPharmsOfThePreparat(Integer idPreparat) {
        ArrayList<Pharm> result = new ArrayList<>();
        String SQL = """
                SELECT
                    pharms.pharmsid,
                    pharms.pharmsaddress,
                    preparats_pharms.preparatscount
                FROM
                    preparats_pharms
                   \s
                    JOIN pharms
                    ON preparats_pharms.pharmsid = pharms.pharmsid
               \s
                WHERE
                    preparatsid = ?
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, idPreparat);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(new Pharm(
                                    resultSet.getInt(1),
                                    resultSet.getString(2),
                                    resultSet.getInt(3)
                            )
                    );
                }
            }
        } catch (Exception exception) {
            return null;
        }
        return result;
    }

}
