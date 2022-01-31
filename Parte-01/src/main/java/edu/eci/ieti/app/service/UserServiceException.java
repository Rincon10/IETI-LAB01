package edu.eci.ieti.app.service;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 1/31/2022
 * @project app
 */
public class UserServiceException extends Exception{
    public static final  String NOT_EXISTS = "The user doesn't exists";

    public UserServiceException(String message,Exception exception){
        super(message,exception);
    }
    public UserServiceException(){
        super();
    }
    public UserServiceException(String message){
        super(message);
    }
}
