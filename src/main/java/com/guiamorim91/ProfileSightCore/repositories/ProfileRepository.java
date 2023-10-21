package com.guiamorim91.ProfileSightCore.repositories;

import com.guiamorim91.ProfileSightCore.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
