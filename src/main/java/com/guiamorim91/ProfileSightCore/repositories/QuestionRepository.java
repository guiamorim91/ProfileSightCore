package com.guiamorim91.ProfileSightCore.repositories;

import com.guiamorim91.ProfileSightCore.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
