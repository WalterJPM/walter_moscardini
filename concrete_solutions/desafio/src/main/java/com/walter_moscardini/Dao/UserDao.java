package com.walter_moscardini.Dao;

import com.walter_moscardini.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class UserDao {

    @Autowired
    private UserGenericDao dao;

    public List<User> getAllUsers() {
        return this.dao.findAll();
    }

    public boolean userExists(long id) {
        if (Objects.nonNull(this.dao.userExists(id))){
            return true;
        } else return false;
    }

    public User getUserById(long id) {
        return this.dao.findById(id).get();
    }

    public User getUserByEmail(String email) {
        return this.dao.getUserByEmail(email);
    }

    public User createUser(User user) {
        return this.dao.save(user);
    }

    public User updateUser(User user) {
        return this.dao.save(user);
    }

    public void deleteUserById(long id) {
        this.dao.deleteById(id);
    }

}

interface UserGenericDao extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User getUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User userExists(@Param("id") long id);

}