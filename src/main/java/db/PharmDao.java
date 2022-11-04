package db;

import domain.Pharm;
import util.ConnectionPool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PharmDao {

    public static Integer addPharm(String address) {
        String SQL = """
                INSERT INTO pharms (pharmsaddress) VALUES (?) RETURNING pharmsid;
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, address);

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

    public static  Boolean editPharm(Integer idPharm, String address) {
        String SQL = """
                UPDATE pharms SET pharmsaddress = ? WHERE pharmsid = ?;
                 """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setString(1, address);
            preparedStatement.setInt(2, idPharm);
            try {
                return preparedStatement.executeUpdate() != 0;
            } catch (SQLException e) {
                return false;
            }
        } catch (Exception exception) {
            return false;
        }
    }

    public static Boolean deletePharm(Integer idPharm) {
        String SQL = """
                 DELETE FROM
                 pharms
                WHERE
                 pharmsid = ?;
                 """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, idPharm);
            try {
                return preparedStatement.executeUpdate() != 0;
            } catch (SQLException e) {
                return false;
            }
        } catch (Exception exception) {
            return false;
        }
    }

    public static Pharm getPharm(int id) {
        String SQL = """
                SELECT\s
                	*
                FROM
                	pharms
                WHERE
                    pharmsid = ?
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                return new Pharm(
                        resultSet.getInt(1),
                        resultSet.getString(2)
                );
            }
        } catch (Exception exception) {
            return null;
        }
    }
    public static  ArrayList<Pharm> getAllPharms() {
        ArrayList<Pharm> result = new ArrayList<>();
        String SQL = """
                SELECT\s
                	*
                FROM
                	pharms
                """;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(new Pharm(
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
