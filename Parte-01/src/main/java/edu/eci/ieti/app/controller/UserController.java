package edu.eci.ieti.app.controller;

import edu.eci.ieti.app.data.User;
import edu.eci.ieti.app.dto.UserDto;
import edu.eci.ieti.app.service.UserService;
import edu.eci.ieti.app.service.UserServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 1/31/2022
 * @project app
 */
@RestController
@RequestMapping( "/v1/user" )
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService ) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        try {
            return new ResponseEntity<>(userService.getAll(), HttpStatus.ACCEPTED);
        } catch ( UserServiceException ex ) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<?> findById(@PathVariable String id ) {
        try {
            return new ResponseEntity<>(userService.findById(id), HttpStatus.ACCEPTED);
        } catch ( UserServiceException ex ) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto ) {
        ModelMapper modelMapper = new ModelMapper();
        try {
            User user = modelMapper.map(userDto, User.class);
            userService.create(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UserServiceException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<?> update( @RequestBody UserDto userDto, @PathVariable String id ) {
        ModelMapper modelMapper = new ModelMapper();
        try {
            User user = modelMapper.map(userDto, User.class);
            userService.update(user, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserServiceException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<?> delete( @PathVariable String id ) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        } catch (UserServiceException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    }
}