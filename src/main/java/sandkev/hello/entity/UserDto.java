package sandkev.hello.entity;

import lombok.Data;

@Data
public class UserDto {
    Long id;
    String firstName;
    String lastName;
    Long roleId;
}
