package sansam.team.team.query.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.team.query.dto.TeamReceiveReviewRequest;
import sansam.team.team.query.dto.TeamUserReviewAllQueryDTO;
import sansam.team.team.query.dto.TeamUserReviewQueryDTO;
import sansam.team.team.query.mapper.TeamUserReviewQueryMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamUserReviewQueryService {

    private final TeamUserReviewQueryMapper teamUserReviewQueryMapper;

    /* 회원 평가 전체 조회*/
    public List<TeamUserReviewAllQueryDTO> getUserAllReview(long teamSeq){
        return teamUserReviewQueryMapper.findUserAllReview(teamSeq);
    }

    /* 회원 평가 상세 조회 */
    public TeamUserReviewQueryDTO getUserReview(TeamReceiveReviewRequest request){
        return teamUserReviewQueryMapper.findUserReview(request);
    }
}
