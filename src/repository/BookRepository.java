package repository;

import java.sql.*;

public class BookRepository {

    public void update(Date duedt, boolean reserv, String name) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update book_tbl set duedt=?,reserv=? where name=?");
        preparedStatement.setDate(1, duedt);
        preparedStatement.setBoolean(2, reserv);
        preparedStatement.setString(3, name);
        preparedStatement.executeUpdate();
    }

    public boolean isReserve(String name, String uniqId) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select reserve from book_tbl where name=? && uniqId=? ");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, uniqId);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean flage = false;
        while (resultSet.next()) {
            if (resultSet.getBoolean(1) == true) ;
            flage = true;
        }
        return flage;
    }

    public Date getDuedt(String name, String uniqId) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select duedt from book_tbl where name=? && uniqId=? ");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, uniqId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Date duedt = null;
        while (resultSet.next()) {
            duedt = resultSet.getDate(1);
        }
        return duedt;

    }
    public void
}
