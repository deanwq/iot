package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CorpDao;
import com.entity.Corp;
import com.entity.Dept;
import com.entity.Employee;
import com.entity.Resp;

@Service
public class CorpService {
	
	@Autowired
	private CorpDao corpDao;
	
	/**
	 * 获取企业客户列表
	 * @return
	 */
	public List<Corp> getCorpList()
	{
		return corpDao.getCorpList();
	}
	
	/**
	 * 新建客户
	 * @return
	 */
	public int addCorp(Corp corp)
	{
		return corpDao.addCorp(corp);
	}
	
	/**
	 * 修改客户
	 * @return
	 */
	public int modifyCorp(int cid, Corp corp)
	{
		return corpDao.modifyCorp(corp);
	}
	
	/**
	 * 删除客户
	 * @return Resp
	 */
	public int deleteCorp(int cid)
	{
		return corpDao.deleteCorp(cid);
	}

	//--------------组织结构的CRUD------------------
	public List<Dept> getDeptList(int cid)
	{
		return null;
	}
	
	public int addDept(int cid, Dept dept)
	{
		return 0;
	}
	
	public int modifyDept(int cid, int dept_id, Dept dept)
	{
		return 0;
	}
	
	public int deleteDept(int cid, int dept_id)
	{
		return 0;
	}
	
	//--------------员工的CRUD------------------
	public List<Employee> getEmployeeList(int cid, int dept_id)
	{
		return null;
	}
	
	public int addEmployee(int cid, int dept_id, Employee employee)
	{
		return 0;
	}
	
	public int modifyEmployee(int cid,  int dept_id,  int employee_id, Employee employee)
	{
		return 0;
	}
	
	public int deleteEmployee(int cid,  int dept_id,  int employee_id)
	{
		return 0;
	}

}
