package com.guiamorim91.ProfileSightCore.services;

import com.guiamorim91.ProfileSightCore.dtos.*;
import com.guiamorim91.ProfileSightCore.entities.*;
import com.guiamorim91.ProfileSightCore.exceptions.InvalidResponseException;
import com.guiamorim91.ProfileSightCore.repositories.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ResponseService {
    private final ResponseRepository responseRepository;

    private final QuestionRepository questionRepository;

    private final ProfileRepository profileRepository;

    private final TicketService ticketService;

    public ResponseService(
            ResponseRepository responseRepository,
            QuestionRepository questionRepository,
            ProfileRepository profileRepository,
            TicketService ticketService
    ) {
        this.responseRepository = responseRepository;
        this.questionRepository = questionRepository;
        this.profileRepository = profileRepository;
        this.ticketService = ticketService;
    }

    public Profile findByUUID(UUID uuid) {
        List<Response> responses = responseRepository.findByTicket_Id(uuid);
        return consolidateProfile(responses);
    }

    public Profile consolidateProfile(List<Response> responses) {
        List<Map.Entry<Profile, Integer>> sortedList = aggregateProfile(responses);
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        Map.Entry<Profile, Integer> highestEntry = sortedList.get(0);
        return highestEntry.getKey();
    }

    @Transactional
    public UUID saveAll(List<ResponseDTO> responseDTOS) {
        try {
            Ticket ticket = ticketService.create();

            for (ResponseDTO responseDTO : responseDTOS) {
                Question question = questionRepository.findById(responseDTO.getQuestion()).orElseThrow();
                Option option = question.getOptions().stream()
                        .filter(item -> responseDTO.getOption().equals(item.getId()))
                        .findFirst()
                        .orElseThrow();

                Response response = new Response();

                response.setTicket(ticket);
                response.setQuestion(question);
                response.setOption(option);

                responseRepository.save(response);
            }

            return ticket.getId();
        } catch (Exception e) {
            throw new InvalidResponseException();
        }
    }

    private Map<Profile, Integer> getProfileCounter() {
        List<Profile> profiles = profileRepository.findAll();
        Map<Profile, Integer> profileCounter = new HashMap<>();
        for (Profile profile: profiles) {
            profileCounter.put(profile, 0);
        }

        return profileCounter;
    }

    private List<Map.Entry<Profile, Integer>> aggregateProfile(List<Response> responses) {
        Map<Profile, Integer> profileCounter = getProfileCounter();

        for (Response response : responses) {
            Profile profile = response.getOption().getProfile();
            profileCounter.put(profile, profileCounter.get(profile) + 1);
        }

        return new ArrayList<>(profileCounter.entrySet());
    }
}
