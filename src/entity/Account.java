package entity;

import java.util.List;

public class Account {
    private String userName;
    private String password;
    private List<Book> no_borrowed_books;
    private List<Book> no_reserved_books;
    private List<Book> no_returned_books;
    private List<Book> no_lost_books_fine_amount;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
