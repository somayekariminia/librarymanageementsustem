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

    public Date getDuedt(String name, int id) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select duedt from book_tbl where name=? and id=? ");
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Date duedt = null;
        while (resultSet.next()) {
            duedt = resultSet.getDate(1);
        }
        return duedt;

    }

    public int getRequest(String name) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select id from book_tbl where name=?");
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        int id = 0;
        while (resultSet.next()) {
            {
                id = resultSet.getInt("id");
            }
        }
        return id;
    }

    public void getReserve(int accauntId, int bookId) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into no_reserved" +
                " (accaunt_id,book_id)" + "values (?,?)");
        preparedStatement.setInt(1, accauntId);
        preparedStatement.setInt(2, bookId);
        preparedStatement.executeUpdate();
    }

    public void getBorrow(int bookId, int accauntId) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into no_borrow" +
                " (accaunt_id,book_id)" + "values (?,?)");
        preparedStatement.setInt(1, accauntId);
        preparedStatement.setInt(2, bookId);
        preparedStatement.executeUpdate();
    }

    public void getReturned(int bookId, int accauntId) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into no_returne" +
                " (accaunt_id,book_id)" + "values (?,?)");
        preparedStatement.setInt(1, accauntId);
        preparedStatement.setInt(2, bookId);
        preparedStatement.executeUpdate();
    }

    public boolean isReturned(int id) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from no_returne where id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean flage = false;
        while (resultSet.next()) {
            {
                int idReturn = resultSet.getInt(1);
                if (idReturn != 0)
                    flage = true;
            }
        }
        return flage;
    }
    public void getLost(int bookId, int accauntId) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into no_lose" +
                " (accaunt_id,book_id)" + "values (?,?)");
        preparedStatement.setInt(1, accauntId);
        preparedStatement.setInt(2, bookId);
        preparedStatement.executeUpdate();
    }
}
