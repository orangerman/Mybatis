package com.mybatis2.dao;

import com.mybatis2.entity.TblDep;
import com.mybatis2.entity.TblDepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblDepMapper {
    int countByExample(TblDepExample example);

    int deleteByExample(TblDepExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblDep record);

    int insertSelective(TblDep record);

    List<TblDep> selectByExample(TblDepExample example);

    TblDep selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblDep record, @Param("example") TblDepExample example);

    int updateByExample(@Param("record") TblDep record, @Param("example") TblDepExample example);

    int updateByPrimaryKeySelective(TblDep record);

    int updateByPrimaryKey(TblDep record);
}