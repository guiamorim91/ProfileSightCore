package com.guiamorim91.ProfileSightCore.repositories;

import com.guiamorim91.ProfileSightCore.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
    List<Response> findByTicket_Id(UUID uuid);
}
