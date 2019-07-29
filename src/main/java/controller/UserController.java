package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="mvdb1.database.windows.net", allowedHeaders="*", methods = { GET, POST, PUT, DELETE, OPTIONS})
public class UserController {

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return true;
    }

    @PutMapping("/user/update")
    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/user/create")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @RequestMapping(value = "/user/add")
    public String addUser(){
        User testUser = new User("UnitTestUser", "password", 123456789, "0000000000000000");
        userRepository.save(testUser);
        return "Test User Saved to the Database.";
    }
}
