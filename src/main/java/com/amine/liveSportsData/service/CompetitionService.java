package com.amine.liveSportsData.service;

import com.amine.liveSportsData.dto.CompetitionDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CompetitionService  {
    List<CompetitionDto> getAllCompetitions() throws JsonProcessingException;
    List<CompetitionDto>  getCompetitionsByCountry(String country);


}
