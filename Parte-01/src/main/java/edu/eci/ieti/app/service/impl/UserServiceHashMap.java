package edu.eci.ieti.app.service.impl;

import edu.eci.ieti.app.data.User;
import edu.eci.ieti.app.service.UserService;
import edu.eci.ieti.app.service.UserServiceException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 1/31/2022
 * @project app
 */

@Service
public class UserServiceHashMap implements UserService {

    private final ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    @Override
    public User create(User user) {
        user.setCreatedAt( java.time.LocalDate.now().toString());
        users.putIfAbsent(user.getId(), user);
        return user;
    }

    @Override
    public User findById(String id) throws UserServiceException {
        Optional<User> optionalUser = Optional.ofNullable( users.get(id));
        optionalUser.orElseThrow( ()-> new UserServiceException(UserServiceException.NOT_EXISTS));
        return optionalUser.get();
    }

    @Override
    public List<User> getAll() {
        List<User> allUsers = new ArrayList<>();
        for( String key : users.keySet()){
            allUsers.add( users.get(key));
        }
        return allUsers;
    }

    @Override
    public void deleteById(String id) throws UserServiceException {
        if ( !users.containsKey(id)) throw new UserServiceException(UserServiceException.NOT_EXISTS);
        users.remove(id);
    }

    @Override
    public User update(User newUser, String userId) throws UserServiceException {
        if ( !users.containsKey(userId)) throw new UserServiceException(UserServiceException.NOT_EXISTS);
        return users.replace(userId, newUser);
    }
}
