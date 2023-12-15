package pl.maropce.skateboardshop.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maropce.skateboardshop.user.dto.UserGetDto;
import pl.maropce.skateboardshop.user.dto.UserPostDto;
import pl.maropce.skateboardshop.user.dto.UserPutDto;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    @GetMapping()
    private List<User> getAllUsers() {
        return service.findAll();
    }

    //TODO get User by id with exception
    @GetMapping("/{id}")
    private ResponseEntity<UserGetDto> getUser(@PathVariable Integer id) {
        var user = service.findById(id);
        if (user == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(user);
    }


    @PostMapping()
    private ResponseEntity<Void> createUser(
            @RequestBody UserPostDto userPostDto
    ) {
        final Integer id = service.create(userPostDto);
        return ResponseEntity.created(URI.create("/api/v1/users/" + id)).build();
    }

    @PutMapping("/{id}")
    private void update(
            @PathVariable Integer id,
            @RequestBody UserPutDto userPutDto
    ) {
        userPutDto.setId(id);
        service.update(userPutDto);
    }

    @DeleteMapping("/{id}")
    private void delete(
            @PathVariable Integer id
    ) {
        service.delete(id);
    }

}
