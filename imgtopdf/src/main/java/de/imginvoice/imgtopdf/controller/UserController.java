package de.imginvoice.imgtopdf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.imginvoice.imgtopdf.exception.ResourceNotFoundException;
import de.imginvoice.imgtopdf.model.User;
import de.imginvoice.imgtopdf.repository.UserRepository;
import de.imginvoice.imgtopdf.security.CurrentUser;
import de.imginvoice.imgtopdf.security.UserPrincipal;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
