package com.meh.orika.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TravelDto {
	
	private String from;
	private String to;
	private String travelDate;
	private List<HistoryPointDto> travelHistoryPoints;

}
