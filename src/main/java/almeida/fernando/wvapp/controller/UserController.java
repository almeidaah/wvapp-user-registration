package almeida.fernando.wvapp.controller;

import almeida.fernando.wvapp.model.User;
import almeida.fernando.wvapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*") //Already added in WebSecurity - keeping just in case :)
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable  String id){
        Optional<User> dbUser = userService.findUser(id);
        if(dbUser.isPresent()){
            return new ResponseEntity<>(dbUser.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(dbUser.get(), HttpStatus.NOT_FOUND);
    }
}
