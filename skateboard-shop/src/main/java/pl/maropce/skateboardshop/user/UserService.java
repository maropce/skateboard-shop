package pl.maropce.skateboardshop.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.maropce.skateboardshop.exceptions.UserNotFoundException;
import pl.maropce.skateboardshop.user.dto.UserGetDto;
import pl.maropce.skateboardshop.user.dto.UserPostDto;
import pl.maropce.skateboardshop.user.dto.UserPutDto;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserRepository repository;

    List<User> findAll() {
        return repository.findAll();
    }

    //na pewno optional? czy sprawdzac to tutaj
    UserGetDto findById(Integer id) {
        try {
            var user =  repository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException(id));
            return UserGetDto.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .build();
        }
        catch (UserNotFoundException e) {
            log.warn(e.getMessage());
            return null;
        }
    }

    public Integer create(UserPostDto userPostDto) {
        final var user = User.builder()
                .username(userPostDto.getUsername())
                .password(userPostDto.getPassword())
                .email(userPostDto.getEmail())
                .build();

        return repository.save(user).getId();
    }

    public void update(UserPutDto userPutDto) {
        final var userToUpdate = repository.findById(userPutDto.getId())
                .orElseThrow();

        userToUpdate.update(userPutDto);

        repository.save(userToUpdate);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
