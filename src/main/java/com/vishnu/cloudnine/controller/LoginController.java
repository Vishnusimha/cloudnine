package com.vishnu.cloudnine.controller;

import com.vishnu.cloudnine.model.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/auth")
public class LoginController {
    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        System.out.println(username + "  " + password);
        // Perform authentication logic here...
        Map<String, Object> response = new HashMap<>();
        List<Admin> admins = new ArrayList<>();
        admins.add(new Admin("vishnu", "v"));
        admins.add(new Admin("admin1", "password1"));
        admins.add(new Admin("admin2", "password2"));
        // Check if the entered credentials match any admin's credentials in the list
        boolean isAdmin = false;
        for (Admin admin : admins) {
            if (Objects.equals(username, admin.getUsername()) && Objects.equals(password, admin.getPassword())) {
                isAdmin = true;
                break;
            }
        }
        if (isAdmin) {
            // If authentication succeeds for an admin, return a success response with the redirect URL for the admin page
            response.put("success", true);
            response.put("redirectUrl", "http://localhost:8081/CloudnineBallloonDecor/eventsdata.html");
            return ResponseEntity.ok().body(response);
        } else {
            // If authentication fails for all admins, return an error response with the redirect URL for the login page
            response.put("Auth failed", true);
            response.put("redirectUrl", "/http://localhost:8081/CloudnineBallloonDecor/login.html");
            return ResponseEntity.badRequest().body(response);
        }
    }

}
