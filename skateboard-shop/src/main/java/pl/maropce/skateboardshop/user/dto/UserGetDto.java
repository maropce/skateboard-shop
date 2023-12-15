package pl.maropce.skateboardshop.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class UserGetDto {
    @JsonIgnore
    private Integer id;
    private String email;
    private String username;
    @JsonIgnore
    private String password;
}
