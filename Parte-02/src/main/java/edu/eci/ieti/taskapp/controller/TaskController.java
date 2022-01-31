package edu.eci.ieti.taskapp.controller;

import edu.eci.ieti.taskapp.data.Task;
import edu.eci.ieti.taskapp.dto.TaskDto;
import edu.eci.ieti.taskapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 1/31/2022
 * @project taskapp
 */
@RestController
@RequestMapping( value = "/v1/task" )
public class TaskController {
    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService ) {
        this.taskService = taskService;
    }

    @RequestMapping( method = RequestMethod.GET )
    public ResponseEntity<List<Task>> getAll() {
        //TODO implement this method using UserService
        return null;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET )
    public ResponseEntity<Task> findById( @PathVariable String id ) {
        //TODO implement this method using UserService
        return null;
    }


    @RequestMapping( method = RequestMethod.POST )
    public ResponseEntity<Task> create( @RequestBody TaskDto taskDto ) {
        //TODO implement this method using UserService
        return null;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT )
    public ResponseEntity<Task> update( @RequestBody TaskDto taskDto, @PathVariable String id ) {
        //TODO implement this method using UserService
        return null;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        //TODO implement this method using UserService
        return null;
    }
}