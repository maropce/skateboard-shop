package pl.maropce.skateboardshop.exceptions;

import lombok.Getter;

@Getter
public class UserNotFoundException
        extends RuntimeException {

    private final Integer id;

    public UserNotFoundException(final Integer id) {
        super("User not found, id= " + id);
        this.id = id;
    }

}
