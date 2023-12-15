package pl.maropce.skateboardshop.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserPutDto {
    @JsonIgnore
    private Integer id;
    private String email;
    private String username;
    private String password;
}
