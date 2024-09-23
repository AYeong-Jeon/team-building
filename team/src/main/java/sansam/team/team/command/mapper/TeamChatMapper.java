package sansam.team.team.command.mapper;

import sansam.team.team.command.application.dto.TeamChatCreateRequestDTO;
import sansam.team.team.command.domain.aggregate.entity.TeamChat;

public class TeamChatMapper {
    public static TeamChat toEntity(TeamChatCreateRequestDTO teamChatDTO) {
        return TeamChat.builder()
                .teamSeq(teamChatDTO.getTeamSeq())
                .teamChatName(teamChatDTO.getTeamChatName())
                .teamChatComment(teamChatDTO.getTeamChatComment())
                .teamChatActive(teamChatDTO.getTeamChatActive())
                .build();
    }
}