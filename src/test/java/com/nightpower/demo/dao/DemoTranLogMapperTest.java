package com.nightpower.demo.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nightpower.demo.model.db.DemoTranLog;
import com.nightpower.demo.util.DateUtil;
import com.nightpower.demo.util.SeqUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTranLogMapperTest {

	@Autowired
	private DemoTranLogMapper demoTranLogMapper;

	@Test
	public void testDemoTranLogDao() {
		DemoTranLog insertDemoTranLog = new DemoTranLog();
		insertDemoTranLog.setTranSeq(SeqUtil.genSeq());
		insertDemoTranLog.setTranAmount(new BigDecimal("1.00"));
		insertDemoTranLog.setTranCode("code1");
		insertDemoTranLog.setTranDate("20200202");
		insertDemoTranLog.setTranName("tran name1");
		insertDemoTranLog.setTranDesc("this is desc");
		insertDemoTranLog.setTranTime(DateUtil.now());
		
		int cnt = demoTranLogMapper.insert(insertDemoTranLog);
		assertEquals(1, cnt);
		
		DemoTranLog queryDemoTranLog = demoTranLogMapper.selectByPrimaryKey(insertDemoTranLog.getTranSeq());
		assertNotNull(queryDemoTranLog);
		assertEquals(insertDemoTranLog, queryDemoTranLog);
		
		queryDemoTranLog.setTranAmount(new BigDecimal("10.00"));
		int updcnt1 = demoTranLogMapper.updateByPrimaryKey(queryDemoTranLog);
		assertEquals(1, updcnt1);

		DemoTranLog updateDemoTranLog = demoTranLogMapper.selectByPrimaryKey(insertDemoTranLog.getTranSeq());
		assertNotNull(updateDemoTranLog);
		assertEquals(queryDemoTranLog, updateDemoTranLog);
		
		DemoTranLog updateSelectiveDemoTranLog = new DemoTranLog();
		updateSelectiveDemoTranLog.setTranSeq(insertDemoTranLog.getTranSeq());
		updateSelectiveDemoTranLog.setTranAmount(new BigDecimal("1.00"));
		
		int updcnt2 = demoTranLogMapper.updateByPrimaryKeySelective(updateSelectiveDemoTranLog);
		assertEquals(1, updcnt2);

		DemoTranLog updatedSelectiveDemoTranLog = demoTranLogMapper.selectByPrimaryKey(insertDemoTranLog.getTranSeq());
		assertNotNull(updatedSelectiveDemoTranLog);
		assertEquals(insertDemoTranLog, updatedSelectiveDemoTranLog);
		
		int delcnt = demoTranLogMapper.deleteByPrimaryKey(insertDemoTranLog.getTranSeq());
		assertEquals(1, delcnt);
		
		queryDemoTranLog = demoTranLogMapper.selectByPrimaryKey(insertDemoTranLog.getTranSeq());
		assertNull(queryDemoTranLog);
	}
	
}
