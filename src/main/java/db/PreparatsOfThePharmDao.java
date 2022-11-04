package db;

import domain.Preparat;
import util.ConnectionPool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreparatsOfThePharmDao {

    public static ArrayList<Preparat> getPreparatsOfThePharm(Integer idPharm) {
        ArrayList<Preparat> result = new ArrayList<>();
        String SQL = """
                SELECT
                    preparats.preparatsid,
                    preparats.preparatsname,
                    preparats_pharms.preparatscount
                FROM
                    preparats_pharms
                    
                    JOIN preparats
                    ON preparats_pharms.preparatsid = preparats.preparatsid
                
                WHERE
                    pharmsid = ?
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, idPharm);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(new Preparat(
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

    public static Boolean addPreparat(Integer idPharm, Integer idPreparat, Integer value) {
        String SQL = """
                INSERT INTO preparats_pharms (pharmsid, preparatsid, preparatscount) VALUES (?, ?, ?);
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, idPharm);
            preparedStatement.setInt(2, idPreparat);
            preparedStatement.setInt(3, value);
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

    public static Boolean editPreparat(Integer idPharm, Integer idPreparat, Integer value) {
        String SQL = """
                   UPDATE preparats_pharms SET preparatscount = ? WHERE preparatsid = ? and pharmsid = ?;
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, value);
            preparedStatement.setInt(2, idPreparat);
            preparedStatement.setInt(3, idPharm);
            try {
                return preparedStatement.executeUpdate() != 0;
            } catch (SQLException e) {
                return false;
            }
        } catch (Exception exception) {
            return false;
        }
    }

    public static Boolean deletePreparat(Integer idPharm, Integer idPreparat) {
        String SQL = """
                 DELETE FROM
                 preparats_pharms
                WHERE
                 pharmsid = ?
                 and preparatsid = ?
                 """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, idPharm);
            preparedStatement.setInt(2, idPreparat);
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
