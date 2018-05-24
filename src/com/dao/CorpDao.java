package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.entity.Corp;

public interface CorpDao {
	
	@Select("select * from tb_corp")
	public List<Corp> getCorpList();
	
	@Insert("insert into tb_corp(name,contact_name,contact_phone,province,city,district,address,ctime) values(#{name},#{contact_name},#{contact_phone},#{province},#{city},#{district},#{address},now())")
	@Options(useGeneratedKeys=true,keyProperty="id")
	public int addCorp(Corp corp);
	
	@Update("update tb_corp set name=#{name},contact_name=#{contact_name},contact_phone=#{contact_phone},province=#{province},city=#{city},district=#{district},address=#{name} where id=#{id}")
	public int modifyCorp(Corp corp);
	
	@Delete("delete from tb_corp where id=#{corp_id}")
	public int deleteCorp(int corp_id);
}
