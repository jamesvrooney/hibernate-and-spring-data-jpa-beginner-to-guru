package com.rooney.james.sdjpaintro.domain.dao.impl;

import com.rooney.james.sdjpaintro.domain.Book;
import com.rooney.james.sdjpaintro.domain.dao.AuthorDAO;
import com.rooney.james.sdjpaintro.domain.dao.BookDAO;
import com.rooney.james.sdjpaintro.domain.dao.BookDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@RequiredArgsConstructor
@Component
public class BookDaoImpl implements BookDAO {

    private final DataSource dataSource;
    private final AuthorDAO authorDAO;

    @Override
    public Book getById(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM book WHERE id = ?");
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return getBookFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeAll(resultSet, preparedStatement, connection);
        }

        return null;
    }

    private Book getBookFromResultSet(ResultSet resultSet) throws SQLException {
        Book book = new Book();

        book.setId(resultSet.getLong("id"));
        book.setTitle(resultSet.getString("title"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setPublisher(resultSet.getString("publisher"));
        book.setAuthor(authorDAO.getById(resultSet.getLong("author_id")));

        return book;
    }

    @Override
    public Book getByTitle(String title) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM book WHERE title = ?");
            preparedStatement.setString(1, title);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return getBookFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeAll(resultSet, preparedStatement, connection);
        }

        return null;
    }

    @Override
    public Book saveNewBook(Book newBook) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();

            preparedStatement = connection.prepareStatement("INSERT INTO book (title, publisher, author_id, isbn) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, newBook.getTitle());
            preparedStatement.setString(2, newBook.getPublisher());
            preparedStatement.setString(4, newBook.getIsbn());

            if (newBook.getAuthor().getId() != null) {
                preparedStatement.setLong(3, newBook.getAuthor().getId());
            } else {
                preparedStatement.setNull(3, -5);
            }

            preparedStatement.execute();

            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT LAST_INSERT_ID()");

            if (resultSet.next()) {
                Long savedId = resultSet.getLong(1);

                statement.close();

                return getById(savedId);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeAll(resultSet, preparedStatement, connection);
        }

        return null;
    }

    @Override
    public Book updateBook(Book bookToUpdate) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();

            preparedStatement = connection.prepareStatement("UPDATE book SET title = ?, publisher = ?, isbn = ?, author_id = ? WHERE id = ?");
            preparedStatement.setString(1, bookToUpdate.getTitle());
            preparedStatement.setString(2, bookToUpdate.getPublisher());
            preparedStatement.setString(3, bookToUpdate.getIsbn());
            preparedStatement.setLong(5, bookToUpdate.getId());

            if (bookToUpdate.getAuthor() != null) {
                preparedStatement.setLong(4, bookToUpdate.getAuthor().getId());
            } else {
                preparedStatement.setNull(4, -5);
            }

            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeAll(resultSet, preparedStatement, connection);
        }

        return getById(bookToUpdate.getId());
    }

    @Override
    public void deleteBook(Long bookId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();

            preparedStatement = connection.prepareStatement("DELETE FROM book WHERE id = ?");
            preparedStatement.setLong(1, bookId);

            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeAll(resultSet, preparedStatement, connection);
        }
    }

    private void closeAll(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
