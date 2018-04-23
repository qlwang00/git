package example.service;


import example.dao.UserDao;
import example.entiy.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    public List<User> getUsers(){
        return dao.getUsers();
    }

    public int Add(User us){
        return dao.addUser(us);
    }

    public void Delete(String id){
        dao.deleteUser(id);
    }

    public List<User> findUser(String id){
        return dao.findUserById(id);
    }

    public void update(User us){
        dao.updateUser(us);
    }

}
