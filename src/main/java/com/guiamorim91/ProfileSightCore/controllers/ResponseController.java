package com.guiamorim91.ProfileSightCore.controllers;

import com.guiamorim91.ProfileSightCore.dtos.ResponseDTO;
import com.guiamorim91.ProfileSightCore.entities.Profile;
import com.guiamorim91.ProfileSightCore.services.ResponseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Response", description = "Respostas do questionário.")
@RestController
@RequestMapping("api/response")
public class ResponseController {
    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Profile> findByUUID(@PathVariable UUID uuid)
    {
        Profile profile = responseService.findByUUID(uuid);
        return ResponseEntity.ok(profile);
    }

    @PostMapping(
            value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UUID> saveAll(@RequestBody List<ResponseDTO> responseDTOS) {
        UUID uuid = responseService.saveAll(responseDTOS);
        return ResponseEntity.ok(uuid);
    }
}
