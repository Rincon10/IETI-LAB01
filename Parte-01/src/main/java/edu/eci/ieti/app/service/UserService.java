package edu.eci.ieti.app.service;

import edu.eci.ieti.app.data.User;

import java.util.List;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 1/31/2022
 * @project app
 */
public interface UserService
{
    User create(User user ) throws UserServiceException ;

    User findById( String id ) throws UserServiceException;

    List<User> getAll() throws UserServiceException;

    void deleteById( String id ) throws UserServiceException;

    User update( User user, String userId ) throws UserServiceException;
}
