package com.meh.orika.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class StringToIntegerMapperTest {

	
	@Test
	public void alphabeticTypeToInType() {
		final Mapper mapper = new Mapper();
		final String alphabeticId = "1ddhs";
		final int resultMapper = mapper.map(alphabeticId, Integer.class);
		assertThat(0).isEqualTo(resultMapper);
	}

	
}
