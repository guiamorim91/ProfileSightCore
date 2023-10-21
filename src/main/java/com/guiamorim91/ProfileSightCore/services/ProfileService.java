package com.guiamorim91.ProfileSightCore.services;

import com.guiamorim91.ProfileSightCore.entities.Profile;
import com.guiamorim91.ProfileSightCore.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }
}
