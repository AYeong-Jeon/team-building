package sansam.team.team.command.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.exception.CustomException;
import sansam.team.exception.ErrorCodeType;
import sansam.team.team.command.application.dto.TeamMemberUpdateRequest;
import sansam.team.team.command.domain.aggregate.entity.TeamMember;
import sansam.team.team.command.domain.repository.TeamMemberRepository;

@Service
@RequiredArgsConstructor
public class TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;

    @Transactional
    public TeamMember getTeamMemberByUserSeq(Long memberSeq) throws CustomException {
        return teamMemberRepository.findByUserSeq(memberSeq)
                .orElseThrow(() -> new CustomException(ErrorCodeType.MEMBER_NOT_FOUND));
    }

    @Transactional
    public void deleteTeamMember(Long teamMemberSeq) {
        teamMemberRepository.deleteById(teamMemberSeq);
    }

    @Transactional
    public TeamMember updateTeamMember(Long teamMemberSeq, TeamMemberUpdateRequest request) {
        TeamMember teamMember = teamMemberRepository.findById(teamMemberSeq)
                .orElseThrow(() -> new CustomException(ErrorCodeType.MEMBER_NOT_FOUND));
        teamMember.modifyTeamMember(request.getTeamSeq());
        return teamMember;
    }
}
