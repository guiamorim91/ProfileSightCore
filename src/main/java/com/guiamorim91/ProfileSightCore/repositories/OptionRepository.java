package com.guiamorim91.ProfileSightCore.repositories;

import com.guiamorim91.ProfileSightCore.entities.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
}
