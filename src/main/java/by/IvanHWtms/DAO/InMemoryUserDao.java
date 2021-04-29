package by.IvanHWtms.DAO;


import by.IvanHWtms.Entity.User;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data

public class InMemoryUserDao {
    private static final List<User> users = new ArrayList<>();
    private static int incId = 1;

    public void save(User user){
        user.setId(incId++);
        users.add(user);
    }

    public User getByLogin(String login){
        for (User user : users) {
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

    public boolean contains(String login){
        for (User user : users) {
            if (user.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    public static List<User> getUsers() {
        return users;
    }

    private User userByLogin(String login){
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public void ChengName(String login, String newName){
        userByLogin(login).setName(newName);
    }
    public void ChengPassword(String login, String newPassword){
        userByLogin(login).setPassword(newPassword);
    }
}
