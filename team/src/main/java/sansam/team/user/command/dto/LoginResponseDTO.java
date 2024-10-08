package sansam.team.user.command.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sansam.team.user.command.enums.RoleType;

@Getter
@AllArgsConstructor
public class LoginResponseDTO {
    private String id;
    private String name;
    private RoleType auth;
    private JwtToken jwtToken;
}
