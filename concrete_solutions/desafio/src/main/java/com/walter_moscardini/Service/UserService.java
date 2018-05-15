package com.walter_moscardini.Service;

import com.walter_moscardini.Dao.UserDao;
import com.walter_moscardini.Exceptions.SimpleCustomException;
import com.walter_moscardini.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public User getUserById(long id){
        this.validateUserExists(id);
        return this.userDao.getUserById(id);
    }

    public User createUser(User user) {
        this.validateUser(user);
        return this.userDao.createUser(user);
    }

    public User updateUser(User user){
        if (Objects.isNull(user.getId())){
            throw new SimpleCustomException(messageSource.getMessage("user.id.NotNull", null, Locale.getDefault()));
        }
        this.validateUserExists(user.getId());
        this.validateUser(user);
        return this.userDao.updateUser(user);
    }

    public void deleteUserById(long id) {
        this.validateUserExists(id);
        this.userDao.deleteUserById(id);
    }

    private void validateUserExists(long id) {
        if (!this.userDao.userExists(id)){
            throw new SimpleCustomException(messageSource.getMessage("user.nonexistent", null, Locale.getDefault()));
        }
    }

    private void validateUser(User user) {
        if (Objects.nonNull(user.getEmail()) && Objects.nonNull(this.userDao.getUserByEmail(user.getEmail()))){
            throw new SimpleCustomException(messageSource.getMessage("user.email.duplicated", null, Locale.getDefault()));
        }
    }

}
