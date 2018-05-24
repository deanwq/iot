package com.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.Employee;

public class EmployeeDaoTest {

	private static ApplicationContext context;//spring container
	private static EmployeeDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		dao = context.getBean(EmployeeDao.class);
	}
	

	@Test
	public void testGetAll() {
		List<Employee> list = dao.getAll();
		System.out.println(list);
		assertTrue(list.size() > 0);
	}

	@Test
	public void testGetByDeptId() {
		List<Employee> list = dao.getByDeptId(1);
		System.out.println(list);
		assertTrue(list.size() > 0);
	}

	@Test
	public void testGetById() {
		Employee employee = dao.getById(1);
		System.out.println(employee);
		assertTrue(employee!=null);
	}

	@Test
	public void testInsert() {
		Employee employee = new Employee();
		employee.setCorp_id(1);
		employee.setDept_id(1);
		employee.setName("王五");
		employee.setPhone("13810000000");
		employee.setTitle("总监");
		employee.setLoginname("wangwu");
		employee.setPwd("123456");
		
//		int ret = dao.insert(employee);
//		assertTrue(ret==1);
		employee.setId(3);
		int ret = dao.insertDeptEmployee(employee.getDept_id(), employee.getId(), employee.getTitle());
		assertTrue(ret==1);
	}

	@Test
	public void testInsertDeptEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateDeptEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
