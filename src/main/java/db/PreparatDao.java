package db;

import domain.Pharm;
import domain.Preparat;
import util.ConnectionPool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreparatDao {

    public static Integer addPreparat(String name) {
        String SQL = """
                INSERT INTO preparats (preparatsname) VALUES (?) RETURNING preparatsid;
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                return resultSet.getInt(1);
            } catch (SQLException e) {
                return -1;
            }
        } catch (Exception exception) {
            return -1;
        }
    }


    public static Boolean editPreparat(Integer id, String name) {
        String SQL = """
                   UPDATE preparats SET preparatname = ? WHERE preparatsid = ?;
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            try {
                return preparedStatement.executeUpdate() != 0;
            } catch (SQLException e) {
                return false;
            }
        } catch (Exception exception) {
            return null;
        }
    }

    public static Boolean deletePreparat(Integer id) {
        String SQL = """
                 DELETE FROM
                 preparats
                WHERE
                 preparatsid = ?;
                 """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);
            try {
                return preparedStatement.executeUpdate() != 0;
            } catch (SQLException e) {
                return false;
            }
        } catch (Exception exception) {
            return null;
        }
    }

    public static Preparat getPreparat(int id) {
        String SQL = """
                SELECT\s
                	*
                FROM
                	preparats
                WHERE
                    preparatsid = ?
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                return new Preparat(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
            }
        } catch (Exception exception) {
            return null;
        }
    }

    public static ArrayList<Preparat> getAllPreparats() {
        ArrayList<Preparat> result = new ArrayList<>();
        String SQL = """
                SELECT\s
                	*
                FROM
                	preparats
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
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
}
