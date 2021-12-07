package com.rooney.james.sdjpaintro.domain.dao.impl;

import com.rooney.james.sdjpaintro.domain.Author;
import com.rooney.james.sdjpaintro.domain.dao.AuthorDAO;
import com.rooney.james.sdjpaintro.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RequiredArgsConstructor
@Component
public class AuthorDaoImpl implements AuthorDAO {

    private final DataSource dataSource;

    @Override
    public Author getById(Long id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM author WHERE id = " + id);

            if (resultSet.next()) {
                Author author = new Author();

                author.setId(id);
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));

                return author;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }
}
