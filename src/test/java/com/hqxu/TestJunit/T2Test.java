package com.hqxu.TestJunit;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
public class T2Test {

	@Test
	public void testGetName() {
		String name = new T2().getName();
		assertThat(name, is("hqxu"));
	
	}

}
