package com.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.controller.CorpController;
import com.entity.Dept;

public class DeptDaoTest {
	
	private static ApplicationContext context;//spring container
	private static DeptDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		dao = context.getBean(DeptDao.class);
	}
	
	@Test
	public void testGetAll() {
		List<Dept> list = dao.getAll();
		assertTrue(list.size() > 0);
	}

	@Test
	public void testGetById() {
		Dept dept = dao.getById(1);
		assertTrue(dept.getId()==1);
	}
//
//	@Test
//	public void testInsert() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}

}
