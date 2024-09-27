package sansam.team.user.query.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import sansam.team.common.jwt.JWTUtil;
import sansam.team.common.jwt.JwtToken;
import sansam.team.config.SecurityConfig;
import sansam.team.exception.CustomNotFoundException;
import sansam.team.exception.ErrorCodeType;
import sansam.team.user.command.domain.aggregate.entity.User;
import sansam.team.user.query.dto.UserQueryDTO;
import sansam.team.user.query.mapper.UserQueryMapper;


@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserQueryMapper userMapper;
    private final SecurityConfig securityConfig;
    private final ModelMapper modelMapper;
    private final JWTUtil jwtUtil;

    public UserQueryDTO.LoginResponseDTO loginProcess(UserQueryDTO.LoginRequestDTO loginRequestDTO) throws CustomNotFoundException, JsonProcessingException {
        UserQueryDTO.LoginResponseDTO userDTO = findById(loginRequestDTO);

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        JwtToken token = jwtUtil.createToken(modelMapper.map(userDTO, User.class));
        userDTO.setJwtToken(token);

        return userDTO;
    }

    public UserQueryDTO.LoginResponseDTO findById(UserQueryDTO.LoginRequestDTO loginRequestDTO) throws CustomNotFoundException {
        return userMapper.findByUserId(loginRequestDTO.getId())
                .filter(member -> securityConfig.bCryptPasswordEncoder().matches(loginRequestDTO.getPw(), member.getUserPassword()))
                .orElseThrow(() -> new CustomNotFoundException(ErrorCodeType.USER_LOGIN_NOT_FOUND));
    }
}
