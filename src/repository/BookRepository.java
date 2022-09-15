package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookRepository {

   public void update(Date duedt,boolean reserv,String name ) throws SQLException {
       Connection connection=MyConnection.getConnection();
       PreparedStatement preparedStatement=connection.prepareStatement("update book_tbl set duedt=?,reserv=? where name=?");
       preparedStatement.setDate(1,duedt);
       preparedStatement.setBoolean(2,reserv);
       preparedStatement.setString(3,name);
       preparedStatement.executeUpdate();
   }
   public boolean isReserve(){
       Connection connection=MyConnection.getConnection();
       PreparedStatement preparedStatement=connection.prepareStatement()
   }
}
