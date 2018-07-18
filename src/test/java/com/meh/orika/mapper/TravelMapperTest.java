package com.meh.orika.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.meh.orika.dto.HistoryPointDto;
import com.meh.orika.dto.TravelDto;
import com.meh.orika.entity.Travel;

@RunWith(SpringRunner.class)
public class TravelMapperTest {

	@Autowired
	private Mapper mapper;
	
	@Test
	public void shouldMapTravelDtoToTravel() {
		TravelDto travelDto = mockTravelDto();
		Travel travel = mapper.map(travelDto, Travel.class);
		assertThat(travelDto.getFrom()).isEqualTo(travel.getOrigin());
		assertThat(travelDto.getTo()).isEqualTo(travel.getDestiny());
		assertNotNull(travel.getTravelDate());
		assertThat(travel.getHistoryPoints().contains(travelDto.getTravelHistoryPoints().get(0).getLocation()));
	}
	
	private TravelDto mockTravelDto() {
		TravelDto travelDto = new TravelDto();
		travelDto.setFrom("Madrid");
		travelDto.setTo("Barcelona");
		travelDto.setTravelDate("01/12/1984");
		travelDto.setTravelHistoryPoints(Arrays.asList(new HistoryPointDto("Meridiano de Greenwich","AP-2  Km. 82")));
		return travelDto;
	}
	
	@TestConfiguration
    static class TravelMapperTestContextConfig {
        @Bean
        public Mapper mapper() {
            return new Mapper();
        }
    }
}
