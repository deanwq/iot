package com.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Corp;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CorpDaoTest {
	private static ApplicationContext context;//spring container
	private static CorpDao dao;
	private static Corp corp = new Corp();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		dao = context.getBean(CorpDao.class);
	}
	

	@Test
	public void test_3_GetCorpList() {
		List<Corp> list = dao.getCorpList();
		System.out.println(list);
		assertTrue(list.size() > 0);
	}

	@Test
	public void test_1_AddCorp() {
		corp.setName("丰台区农委");
		corp.setCity("北京市");
		corp.setAddress("111");
		corp.setContact_name("张三");
		corp.setContact_phone("13111111111");
		corp.setProvince("北京");
		corp.setRemark("备注信息...");
		
		int corp1=dao.addCorp(corp);
		System.out.println(corp);
		assertTrue(corp1==1);
	}

	@Test
	public void test_2_ModifyCorp() {
		corp.setContact_phone("13800000000");
		int ret = dao.modifyCorp(corp);
		assertTrue(ret==1);
	}

	@Test
	public void test_4_DeleteCorp() {
		int ret = dao.deleteCorp(corp.getId());
		assertTrue(ret==1);
	}

}
