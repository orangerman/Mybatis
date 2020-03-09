package com.mybatis2.dao;

import com.mybatis2.entity.TblEmployee;

import com.mybatis2.entity.TblEmployeeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblEmployeeMapper {

    TblEmployee selectEmpById(Integer id);

    Boolean  addEmp(TblEmployee employee);

    void updateEmp(TblEmployee employee);

    void deleteEmpById(Integer id);



}