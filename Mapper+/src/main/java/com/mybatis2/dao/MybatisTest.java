package com.mybatis2.dao;

import com.mybatis2.entity.TblEmployee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config2.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test01() throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        System.out.println(sqlSession);
        try {
            TblEmployeeMapper tblEmployeeMapper = sqlSession.getMapper(TblEmployeeMapper.class);
            TblEmployee employee = tblEmployeeMapper.selectEmpById(1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void test02() throws IOException {
        //获取到的session不会自动提交
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        System.out.println(sqlSession);
        try {
            TblEmployee employee = new TblEmployee(null, "Mike", "1", "Mike@163.com");
            TblEmployeeMapper employeeMapper = sqlSession.getMapper(TblEmployeeMapper.class);
            Boolean successOrFalse = employeeMapper.addEmp(employee);
            System.out.println(employee.getId());
            if (successOrFalse) {
                System.out.println("Success!");
            }else {
                System.out.println("False!");
            }

            sqlSession.commit();
        }finally {
            sqlSession.close();
        }

    }
    @Test
    public void test03() throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        System.out.println(sqlSession);
        try {
            TblEmployeeMapper mapper = sqlSession.getMapper(TblEmployeeMapper.class);
            mapper.updateEmp(new TblEmployee(1,"Mike", "1", "Mike@163.com"));
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    /**
     * 1.Mybatis允许增删改查指定定义以下类型返回值
     *    Integer long Boolean void
     *    直接在接口定义方法时候直接定义其中四个返回值
     * @throws IOException
     */
    @Test
    public void test04() throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        System.out.println(sqlSession);
        try {
            TblEmployeeMapper mapper = sqlSession.getMapper(TblEmployeeMapper.class);
            mapper.deleteEmpById(1);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }


}
