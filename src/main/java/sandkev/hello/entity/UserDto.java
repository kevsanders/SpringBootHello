package sandkev.hello.entity;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private Long roleId;
}
