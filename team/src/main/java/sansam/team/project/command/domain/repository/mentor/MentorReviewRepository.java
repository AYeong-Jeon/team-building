package sansam.team.project.command.domain.repository.mentor;

import sansam.team.project.command.domain.aggregate.entity.MentorReview;

import java.util.Optional;

public interface MentorReviewRepository {

    MentorReview save(MentorReview mentorReview);

    Optional<MentorReview> findByProjectMemberSeq(Long projectMemberSeq);

    void delete(MentorReview mentorReview);
}