package by.IvanHWtms.Service;

import by.IvanHWtms.DAO.InMemoryUserDao;
import by.IvanHWtms.Entity.User;

import java.util.List;

public class UserService {
    private final InMemoryUserDao userDao = new InMemoryUserDao();

    public boolean add(User user){
        if (userDao.contains(user.getLogin())) {
            return false;
        } else {
            userDao.save(user);
            return true;
        }
    }

    public User getByLogin(String login){
        if (userDao.contains(login)){
            return userDao.getByLogin(login);
        }
        return null;
    }

    public List<User> getAllUsers(){
        return userDao.getUsers();
    }

    public void chengName(String login, String newName){
        userDao.getByLogin(login).setName(newName);
    }
    public void chengPassword(String login, String newPassword){
        userDao.getByLogin(login).setPassword(newPassword);
    }
}
