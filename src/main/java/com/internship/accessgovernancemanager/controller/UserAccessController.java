package com.internship.accessgovernancemanager.controller;

import com.internship.accessgovernancemanager.entity.UserAccess;
import com.internship.accessgovernancemanager.service.UserAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/users")
public class UserAccessController {

    @Autowired
    private UserAccessService service;

    @PostMapping
    public UserAccess addUser(@RequestBody UserAccess user) {
        return service.saveUser(user);
    }

    @GetMapping
public List<UserAccess> getAllUsers() {
    return service.getAllUsers();
}

@GetMapping("/{id}")
public UserAccess getUser(@PathVariable Long id) {
    return service.getUserById(id);
}

@PutMapping("/{id}")
public UserAccess updateUser(@PathVariable Long id, @RequestBody UserAccess user) {
    return service.updateUser(id, user);
}

@DeleteMapping("/{id}")
public String deleteUser(@PathVariable Long id) {
    service.deleteUser(id);
    return "User deleted successfully";
}

@GetMapping("/role/{role}")
public List<UserAccess> getByRole(@PathVariable String role) {
    return service.getUsersByRole(role);
}

@GetMapping("/username/{username}")
public List<UserAccess> getByUsername(@PathVariable String username) {
    return service.getUsersByUsername(username);
}
}