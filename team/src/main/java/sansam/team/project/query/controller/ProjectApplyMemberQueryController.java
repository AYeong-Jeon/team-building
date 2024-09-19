package sansam.team.project.query.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.project.command.service.ProjectApplyMemberService;
import sansam.team.project.query.dto.projectboard.ApplyMemberQueryDTO;
import sansam.team.project.query.dto.projectboard.ProjectApplyMemberQueryDTO;
import sansam.team.project.query.service.ProjectApplyMemberQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project/apply")
@RequiredArgsConstructor
@Tag(name = "Project Board Apply Member API", description = "프로젝트 게시물 신청 회원 API")
public class ProjectApplyMemberQueryController {
    private final ProjectApplyMemberQueryService projectApplyMemberQueryService;

    // 특정 회원이 신청한 프로젝트 목록 조회 API
    @GetMapping("/my-projects")
    public ResponseEntity<List<ApplyMemberQueryDTO>> getMyProjects() {
        List<ApplyMemberQueryDTO> projects = projectApplyMemberQueryService.findProjectsByCurrentUser();
        return ResponseEntity.ok(projects);
    }
}
