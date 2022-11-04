package db;

import domain.Preparat;
import util.ConnectionPool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreparatsOfTheCategDao {

    public static ArrayList<Preparat> getPreparatsOfTheCateg(Integer idCateg) {
        ArrayList<Preparat> result = new ArrayList<>();
        String SQL = """
                SELECT
                    preparats.preparatsid,
                    preparats.preparatsname
                FROM
                    preparats_categs
                    
                    JOIN preparats
                    ON preparats_categs.preparatsid = preparats.preparatsid
                                
                WHERE
                    categsid = ?
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, idCateg);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(new Preparat(
                                    resultSet.getInt(1),
                                    resultSet.getString(2)
                            )
                    );
                }
            }
        } catch (Exception exception) {
            return null;
        }
        return result;
    }

    public static Boolean addPreparat(Integer idPreparat, Integer idCateg) {
        String SQL = """
                INSERT INTO preparats_categs (preparatsid, categsid) VALUES (?, ?);
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, idPreparat);
            preparedStatement.setInt(2, idCateg);
            try {
                preparedStatement.executeQuery();
                return true;
            } catch (SQLException e) {
                return false;
            }
        } catch (Exception exception) {
            return false;
        }
    }

    public static Boolean deletePreparat(Integer idPreparat, Integer idCateg) {
        String SQL = """
                 DELETE FROM
                 preparats_categs
                WHERE
                 preparatsid = ?
                 and categsid = ?;
                 """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, idPreparat);
            preparedStatement.setInt(2, idCateg);
            try {
                return preparedStatement.executeUpdate() != 0;
            } catch (SQLException e) {
                return false;
            }
        } catch (Exception exception) {
            return false;
        }
    }


}
