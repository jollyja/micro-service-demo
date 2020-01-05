package com.nightpower.demo.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
class SeqUtilTest {

	@Test
	void testGenSeql() {
		assertEquals(36, SeqUtil.genSeq().length());
		System.out.println(SeqUtil.genSeq());
	}

}
