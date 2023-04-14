package com.vishnu.cloudnine.controller;

import com.vishnu.cloudnine.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/auth")
public class LoginController {
    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> login(@RequestBody User credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();
        System.out.println(username + "  " + password);
        // Perform authentication logic here...

        Map<String, Object> response = new HashMap<>();
        List<User> admins = new ArrayList<>();
        admins.add(new User("vishnu", "vishnu", User.UserRole.ADMIN));
        admins.add(new User("admin1", "admin1", User.UserRole.ADMIN));
        admins.add(new User("admin2", "admin2", User.UserRole.ADMIN));

        List<User> users = new ArrayList<>();
        users.add(new User("user1", "user1", User.UserRole.GENERAL_USER));
        users.add(new User("user2", "user2", User.UserRole.GENERAL_USER));

        // Check if the entered credentials match any admin's credentials in the list
        User.UserRole role = null;
        for (User user : admins) {
            if (Objects.equals(username, user.getUsername()) && Objects.equals(password, user.getPassword())) {
                role = User.UserRole.ADMIN;
                break;
            }
        }
        for (User user : users) {
            if (Objects.equals(username, user.getUsername()) && Objects.equals(password, user.getPassword())) {
                role = User.UserRole.GENERAL_USER;
                break;
            }
        }
        if (role == User.UserRole.ADMIN) {
            // If authentication succeeds for an admin, return a success response with the redirect URL for the admin page
            response.put("success", true);
            response.put("redirectUrl", "http://localhost:8081/CloudnineBallloonDecor/eventsdata.html");
            return ResponseEntity.ok().body(response);
        } else if (role == User.UserRole.GENERAL_USER) {
            response.put("success", true);
            response.put("redirectUrl", "http://localhost:8081/CloudnineBallloonDecor/events.html");
            return ResponseEntity.ok().body(response);
        } else {
            // If authentication fails for all admins, return an error response with the redirect URL for the login page
            response.put("failed", true);
            response.put("redirectUrl", "/http://localhost:8081/CloudnineBallloonDecor/login.html");
            return ResponseEntity.badRequest().body(response);
        }
    }

}
