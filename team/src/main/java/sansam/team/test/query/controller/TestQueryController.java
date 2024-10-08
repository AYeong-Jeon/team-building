package sansam.team.test.query.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.test.command.dto.TestDTO;
import sansam.team.test.query.service.TestQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestQueryController {

    private final TestQueryService testQueryService;

    // 모든 Test 데이터를 조회
    @GetMapping
    public ResponseEntity<List<TestDTO>> getAllTests() {
        List<TestDTO> tests = testQueryService.getAllTests();
        return ResponseEntity.ok(tests);
    }

    // 특정 ID로 Test 데이터를 조회
    @GetMapping("/{id}")
    public ResponseEntity<TestDTO> getTestById(@PathVariable Long id) {
        TestDTO test = testQueryService.getTestById(id);
        return ResponseEntity.ok(test);
    }
}
