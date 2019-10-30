package com.meh.orika.mapper;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class StringToIntegerMapper extends BidirectionalConverter<String, Integer> {

	@Override
	public Integer convertTo(String source, Type<Integer> destinationType, MappingContext mappingContext) {
		try {
			return Integer.valueOf(source);
		}catch (Exception e) {
			return 0;
		}
	}

	@Override
	public String convertFrom(Integer source, Type<String> destinationType, MappingContext mappingContext) {
		return String.valueOf(source);
	}

	
}
