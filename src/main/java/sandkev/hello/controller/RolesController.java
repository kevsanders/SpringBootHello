package sandkev.hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sandkev.hello.entity.Role;
import sandkev.hello.repo.RoleRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class RolesController {

    private final RoleRepository roleRepository;

    public RolesController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;

        Role role = new Role();
        role.setName("ADMIN");
        roleRepository.save(role);
    }

    @GetMapping("roles")
    public List<Role> list() {
        return roleRepository.findAll();
    }

    @PostMapping("roles")
    public ResponseEntity<Role> save(@RequestBody Role role) {
        Role saved = roleRepository.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("roles/{id}")
    public void delete(@PathVariable Long id) {
        roleRepository.deleteById(id);
    }

    @GetMapping("roles/{id}")
    public ResponseEntity<Role> get(@PathVariable Long id) {
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(role.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}