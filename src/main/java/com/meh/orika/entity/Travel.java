package com.meh.orika.entity;

import java.util.Date;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Travel {

	private String origin;
	private String destiny;
	private Date travelDate;
	private Set<TravelHistoryPoint> historyPoints;
}
