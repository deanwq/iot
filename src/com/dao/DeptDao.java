package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.entity.Dept;

@Repository
public interface DeptDao {
	@Select("select * from tb_dept")
    @Results({
        @Result(column="id",property="id",id=true),
        @Result(column="name",property="name"),
        @Result(column="pid",property="pid")
    })
	List<Dept> getAll();
	
	@Select("select * from tb_dept where corp_id=#{corp_id}")
	List<Dept> getByCorpId(int corp_id);
	
	@Select("select * from tb_dept where id=#{id}")
	Dept getById(int id);
	
	@Insert("insert into tb_dept(name,pid,corp_id,ctime) values(#{name},#{pid},#{corp_id},now())")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(Dept dept);
	
	//utime db auto-updated
	@Update("update tb_dept set name=#{name},pid=#{pid} where id=#{id}")
	int update(Dept dept);
	
	@Delete("delete from tb_dept where id=#{id}")
	int delete(int id);
}
