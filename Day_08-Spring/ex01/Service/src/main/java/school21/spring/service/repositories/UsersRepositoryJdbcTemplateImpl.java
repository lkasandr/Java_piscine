package school21.spring.service.repositories;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    UsersRepositoryJdbcTemplateImpl(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findById(Long id)
    {
        Optional<User> optionalUser = Optional.empty();
        List<User> userList = jdbcTemplate.query("SELECT * FROM User WHERE userID = " + id,
                                                        new BeanPropertyRowMapper<>(User.class));
        if (!userList.isEmpty())
            optionalUser = Optional.of(userList.get(0));
        return optionalUser;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM User", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM user WHERE id = ?", id);
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE user SET id = ?, email = ?",
                                entity.getId(),
                                entity.getEmail());
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("INSERT INTO user (id, email) VALUES (?, ?)",
                                entity.getId(),
                                entity.getEmail());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> optionalUser = Optional.empty();
        List<User> userList = jdbcTemplate.query("SELECT * FROM User WHERE email = " + email,
                                                        new BeanPropertyRowMapper<>(User.class));
        if (!userList.isEmpty())
            optionalUser = Optional.of(userList.get(0));
        return optionalUser;
    }
}
