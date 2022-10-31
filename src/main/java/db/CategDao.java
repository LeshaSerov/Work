package db;

import domain.Categ;
import domain.Pharm;
import util.ConnectionPool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategDao {

    public static Integer addCateg(String name) {
        String SQL = """
                INSERT INTO categs (categsname) VALUES (?) RETURNING categsid;
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

    public static  Boolean editCateg(Integer id, String name) {
        String SQL = """
                UPDATE categs SET categsname = ? WHERE categsid = ?;
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


    public static Boolean deleteCateg(Integer id) {
        String SQL = """
                 DELETE FROM
                 categs
                WHERE
                 categsid = ?;
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

    public static Categ getCateg(int id) {
        String SQL = """
                SELECT\s
                	*
                FROM
                	categss
                WHERE
                    categsid = ?
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                return new Categ(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        null
                );
            }
        } catch (Exception exception) {
            return null;
        }
    }
    public static  ArrayList<Categ> getAllCategs() {
        ArrayList<Categ> result = new ArrayList<>();
        String SQL = """
                SELECT\s
                	*
                FROM
                	categs
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(new Categ(
                                    resultSet.getInt(1),
                                    resultSet.getString(2),
                                    null
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
