package school21.spring.service.repositories;


import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository{
    private DataSource dataSource;

    UsersRepositoryJdbcImpl(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> optionalUser = Optional.empty();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User WHERE id = " + id);
            if (resultSet.next())
            {
                String email = resultSet.getString("email");
                User user = new User(id, email);
                optionalUser = Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optionalUser;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");
            while (resultSet.next())
            {
                Long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                User user = new User(id, email);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void save(User entity) {
        String sql = "INSERT INTO user (id, email) VALUES (?, ?)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            stmt.setLong(1, entity.getId());
            stmt.setString(2, entity.getEmail());
            stmt.execute();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next())
            {
                entity.setId(generatedKeys.getLong(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void update(User entity) {
        String sql = "UPDATE user SET id = ?, email = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setLong(1, entity.getId());
            stmt.setString(2, entity.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM user WHERE id = " + id;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> optionalUser = Optional.empty();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement())
        {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User WHERE email = " + email);
            if (resultSet.next())
            {
                Long id = resultSet.getLong("id");
                User user = new User(id, email);
                optionalUser = Optional.of(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optionalUser;
    }
}
