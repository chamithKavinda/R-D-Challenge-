package com.example.challenge.Controller;

import com.example.challenge.Model.UserDTO;
import com.example.challenge.Service.WeavyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private WeavyService weavyService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) throws IOException {
        return ResponseEntity.ok(weavyService.createUser(userDTO));
    }
}
