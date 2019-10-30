package com.meh.orika.mapper;

import org.springframework.stereotype.Component;

import com.meh.orika.dto.TravelDto;
import com.meh.orika.entity.Travel;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.converter.builtin.DateToStringConverter;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class Mapper extends ConfigurableMapper{
	
	protected void configure(MapperFactory factory) {
		ConverterFactory converterFactory = factory.getConverterFactory();
		converterFactory.registerConverter("dateConverter1", new DateToStringConverter("dd/MM/yyyy"));
		converterFactory.registerConverter(new StringToIntegerMapper());
		factory.classMap(Travel.class, TravelDto.class)
			.field("origin", "from")
			.field("destiny", "to")
			.field("historyPoints", "travelHistoryPoints").mapNulls(false)
			.fieldMap("travelDate").converter("dateConverter1").add()
			.register();
	}
}
