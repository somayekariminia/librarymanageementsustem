package repository;

import entity.Account;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {

    public int logIn(String username, String password) throws SQLException {
        Connection connection=MyConnection.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("select id from account_tbl" +
                " where userName=? , password=? ");
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);

        ResultSet resultSet=preparedStatement.executeQuery();
        int id=0;
        while(resultSet.next()){
             id=resultSet.getInt("id");
        }
        return id;
    }

    public void register(Account account) throws SQLException {
        Connection connection=MyConnection.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("insert into account_tbl" +
                " (userName,password) values (?,?)");
        preparedStatement.setString(1,account.getUserName());
        preparedStatement.setString(2,account.getPassword());
        preparedStatement.executeUpdate();
    }
    public void deleteAccount(Account account ) throws SQLException {
        Connection connection=MyConnection.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement("delete account+tbl " +
                "where userName=? and password=?");
        preparedStatement.setString(1, account.getUserName());
        preparedStatement.setString(2, account.getPassword());
        preparedStatement.executeUpdate();
    }
}
