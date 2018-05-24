package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Repository;

import com.entity.Dept;
import com.entity.Employee;

@Repository
public interface EmployeeDao {
	@Select("select * from tb_employee")
	List<Employee> getAll();
	
	@Select("select * from tb_employee A, tb_dept_employee B where A.id=B.employee_id and B.dept_id=#{dept_id}")
	List<Employee> getByDeptId(int dept_id);
	
	@Select("select * from tb_employee where id=#{id}")
	Employee getById(int id);
	
	@Insert("insert into tb_employee(corp_id,name,loginname,pwd,phone,idcard,address,ext,remark,ctime) values(#{corp_id},#{name},#{loginname},#{pwd},#{phone},#{idcard},#{address},#{ext},#{remark},now())")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(Employee employee);
	
	@Insert("insert into tb_dept_employee(dept_id,employee_id,title) values(#{dept_id},#{employee_id},#{title})")
	int insertDeptEmployee(@Param("dept_id") int dept_id, @Param("employee_id" )int employee_id, @Param("title" )String title);
	
	@Update("update tb_dept_employee set dept_id=#{dept_id},title=#{title} where employee_id=#{employee_id})")
	int updateDeptEmployee(@Param("dept_id") int dept_id, @Param("employee_id" )int employee_id, @Param("title" )String title);

	@Update("update tb_employee set name=#{name},loginname=#{loginname},pwd=#{pwd},phone=#{phone},idcard=#{idcard},address=#{address},ext=#{ext} ,remark=#{remark} where id=#{id}")
	int update(Employee dept);
	
	@Delete("delete from tb_employee where id=#{id}")
	int delete(int id);
}
