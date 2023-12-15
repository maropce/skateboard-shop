package pl.maropce.skateboardshop.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserPostDto {
    private String email;
    private String username;
    private String password;
}
