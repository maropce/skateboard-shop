package pl.maropce.skateboardshop.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.maropce.skateboardshop.user.dto.UserPutDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_user")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    
    private String email;
    private String username;
    private String password;

    void update(UserPutDto userPutDto) {
        this.email = userPutDto.getEmail();
        this.username = userPutDto.getUsername();
        this.password = userPutDto.getPassword();
    }
}
