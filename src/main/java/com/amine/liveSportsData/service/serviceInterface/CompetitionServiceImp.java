package com.amine.liveSportsData.service.serviceInterface;

import com.amine.liveSportsData.dto.CompetitionDto;
import com.amine.liveSportsData.service.CompetitionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class CompetitionServiceImp implements CompetitionService {
    ObjectMapper objectMapper = new ObjectMapper();
@Value("${api.sportradar.url.competitions}")
    private String globalUrl;
    @Value("${api.sportradar.key}")
    private String apiKey;
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<CompetitionDto> getAllCompetitions() throws JsonProcessingException {
        String url = globalUrl + ".json?api_key=" + apiKey;
        String result = restTemplate.getForObject(url, String.class);
        List<CompetitionDto> competitions = objectMapper.readValue(result, new TypeReference<List<CompetitionDto>>(){});
        return competitions;
    }

    @Override
    public List<CompetitionDto>  getCompetitionsByCountry(String country) {
        return null;
    }
}
