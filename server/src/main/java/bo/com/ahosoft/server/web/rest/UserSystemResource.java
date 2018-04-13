package bo.com.ahosoft.server.web.rest;

import bo.com.ahosoft.server.domain.UserSystem;
import bo.com.ahosoft.server.service.UserSystemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by    : Arturo Herrera o.
 * Date          : 13-04-18 - 05:03 PM
 * Project       : sprint-boot-angular-jboss-maven-starter
 * Package       : bo.com.ahosoft.server.web.rest
 **/
@RestController
public class UserSystemResource {
    private final UserSystemService userSystemService;

    public UserSystemResource(UserSystemService userSystemService) {
        this.userSystemService = userSystemService;
    }

    @PostMapping("/users")
    public void saveUserSystem(@RequestBody UserSystem userSystem) {
        userSystemService.save(userSystem);
    }

    @GetMapping("/users/")
    public List<UserSystem> getAllUserSystem() {
        return userSystemService.findAll();
    }

    @GetMapping("/users/{username}")
    public UserSystem getUserSystem(@PathVariable String username) {
        return userSystemService.findByUsername(username);
    }
}
