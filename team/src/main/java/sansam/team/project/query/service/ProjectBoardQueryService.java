package sansam.team.project.query.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.project.query.dto.projectboard.ProjectApplyMemberQueryDTO;
import sansam.team.project.query.dto.projectboard.ProjectBoardAllQueryDTO;
import sansam.team.project.query.dto.projectboard.ProjectBoardAdminDTO;
import sansam.team.project.query.dto.projectboard.ProjectBoardUserDTO;
import sansam.team.project.query.mapper.ProjectBoardMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectBoardQueryService {

    private final ProjectBoardMapper projectBoardMapper;

    /* 프로젝트 게시물 전체 조회 */
    public List<ProjectBoardAllQueryDTO> getAllProjectBoards(){
        return projectBoardMapper.findAll();
    }

    /* 프로젝트 게시물 상세 조회 (관리자) */
    public ProjectBoardAdminDTO getProjectBoardByIdForAdmin(Long projectBoardSeq) {
        return projectBoardMapper.findByIdForAdmin(projectBoardSeq);
    }

    /* 프로젝트 게시물 상세 조회 (사용자) */
    public ProjectBoardUserDTO getProjectBoardByIdForUser(Long projectBoardSeq){
        return projectBoardMapper.findByIdForUser(projectBoardSeq);
    }

    /* 프로젝트 신청 회원 리스트 조회 */
    public List<ProjectApplyMemberQueryDTO> findApplyMembersByProjectBoardSeq(Long projectBoardSeq) {
        return projectBoardMapper.findApplyMembersByProjectBoardSeq(projectBoardSeq);
    }

}
