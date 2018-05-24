package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Corp;
import com.entity.Dept;
import com.entity.Employee;
import com.entity.Resp;
import com.entity.User;
import com.service.CorpService;

@RestController
@RequestMapping("/corp")
public class CorpController {

	@Autowired
	private CorpService corpService;
	
	/**
	 * 获取企业客户列表
	 * @return
	 */
	@GetMapping
	public List<Corp> getCorpList()
	{
		return corpService.getCorpList();
	}
	
	/**
	 * 新建客户
	 * @return
	 */
	@PostMapping
	public Resp addCorp(Corp corp)
	{
		int ret = corpService.addCorp(corp);
		Resp resp = new  Resp(ret, ret==1?"ok":"err", corp);
		return resp;
	}
	
	/**
	 * 修改客户
	 * @return
	 */
	@PutMapping("/{cid}")
	public Resp modifyCorp(@PathVariable int cid, Corp corp)
	{
		int ret = corpService.modifyCorp(cid,corp);
		Resp resp = new  Resp(ret, ret==1?"ok":"err", corp);
		return resp;
	}
	
	/**
	 * 删除客户
	 * @return Resp
	 */
	@DeleteMapping("/{cid}")
	public Resp deleteCorp(@PathVariable int cid)
	{
		int ret = corpService.deleteCorp(cid);
		Resp resp = new  Resp(ret, ret==1?"ok":"err", null);
		return resp;
	}

	//--------------组织结构的CRUD------------------
	@GetMapping("/{cid}/dept")
	public List<Dept> getDeptList(@PathVariable int cid)
	{
		return null;
	}
	
	@PostMapping("/{cid}/dept")
	public Resp addDept(@PathVariable int cid, Dept dept)
	{
		return null;
	}
	
	@PutMapping("/{cid}/dept/{dept_id}")
	public Resp modifyDept(@PathVariable int cid, @PathVariable int dept_id, Dept dept)
	{
		return null;
	}
	
	@DeleteMapping("/{cid}/dept/{dept_id}")
	public Resp deleteDept(@PathVariable int cid, @PathVariable int dept_id)
	{
		return null;
	}
	
	//--------------员工的CRUD------------------
	@GetMapping("/{cid}/dept/{dept_id}/employee")
	public List<Employee> getEmployeeList(@PathVariable int cid, @PathVariable int dept_id)
	{
		return null;
	}
	
	@PostMapping("/{cid}/dept/{dept_id}/employee")
	public Resp addEmployee(@PathVariable int cid, @PathVariable int dept_id, Employee employee)
	{
		return null;
	}
	
	@PutMapping("/{cid}/dept/{dept_id}/employee/{employee_id}")
	public Resp modifyEmployee(@PathVariable int cid, @PathVariable int dept_id, @PathVariable int employee_id, Employee employee)
	{
		return null;
	}
	
	@DeleteMapping("/{cid}/dept/{dept_id}/employee/{employee_id}")
	public Resp deleteEmployee(@PathVariable int cid, @PathVariable int dept_id, @PathVariable int employee_id)
	{
		return null;
	}
}
