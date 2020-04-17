package sandkev.hello.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sandkev.hello.entity.Role;
import sandkev.hello.entity.User;
import sandkev.hello.entity.UserDto;
import sandkev.hello.repo.RoleRepository;
import sandkev.hello.repo.UserRepository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UsersController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UsersController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;

        Role role = new Role();
        role.setName("OWNER");
        roleRepository.save(role);

        User user = new User();
        user.setFirstName("Kevin");
        user.setLastName("Sanders");
        user.setRole(role);

        userRepository.save(user);

    }

    @GetMapping("/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User save(@RequestBody @NotNull UserDto userDto) {
        Optional<Role> role = roleRepository.findById(userDto.getRoleId());

        if (role.isPresent()) {
            User user = new User();
            if (userDto.getId() != null) user.setId(userDto.getId());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setRole(role.get());

            return userRepository.save(user);
        }

        return null;
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
