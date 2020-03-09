package com.mybatis2.dao;

import com.mybatis2.entity.TblEmployee;
import com.mybatis2.entity.TblEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblEmployeeMapper {
    int countByExample(TblEmployeeExample example);

    int deleteByExample(TblEmployeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblEmployee record);

    int insertSelective(TblEmployee record);

    List<TblEmployee> selectByExample(TblEmployeeExample example);

    TblEmployee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblEmployee record, @Param("example") TblEmployeeExample example);

    int updateByExample(@Param("record") TblEmployee record, @Param("example") TblEmployeeExample example);

    int updateByPrimaryKeySelective(TblEmployee record);

    int updateByPrimaryKey(TblEmployee record);
}