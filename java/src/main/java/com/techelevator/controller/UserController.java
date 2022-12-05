package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class UserController {
    private UserDao userDao;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public void updateUser(@Valid @RequestBody String role, @PathVariable int id) {
        try {
            User currentUser = userDao.getUserById(id);
            userDao.updateRole(id, role);
        } catch (ResponseStatusException e) {
            throw e;
        }
    }
}
