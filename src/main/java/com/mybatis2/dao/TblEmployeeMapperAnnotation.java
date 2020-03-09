package com.mybatis2.dao;

import com.mybatis2.entity.TblEmployee;
import org.apache.ibatis.annotations.Select;


/**
 * 基于注解 但是写在XML文件中便于维护
 */
public interface TblEmployeeMapperAnnotation {
    @Select("select * from tbl_employee where id = #{id}")
    public TblEmployee getEmpById(Integer id);
}
