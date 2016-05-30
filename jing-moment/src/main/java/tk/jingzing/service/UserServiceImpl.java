package tk.jingzing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Louis Wang on 2016/5/30.
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
    }

    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where NAME = ?", name);
    }

    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }
}
