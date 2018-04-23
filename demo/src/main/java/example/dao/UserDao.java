package example.dao;


import example.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getUsers(){
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    public int addUser(User us){
        String sql="insert into user values('"+us.getId()+"','"+us.getName()+"')";
        return jdbcTemplate.update(sql);
    }

    public void deleteUser(String id){
        String sql="delete from user where id="+id;
        jdbcTemplate.update(sql);
    }

    public List<User> findUserById(String id){
        String sql="select * from user where id="+id;
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
    }

    public void updateUser(User us){
        String sql="update user set name='"+us.getName()+"' where id="+us.getId();
        jdbcTemplate.update(sql);
    }
}
