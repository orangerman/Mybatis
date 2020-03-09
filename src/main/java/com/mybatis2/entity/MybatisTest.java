package com.mybatis2.entity;

import com.mybatis2.dao.TblEmployeeMapperAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test01() throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        System.out.println(sqlSession);
        try {
            TblEmployee employee = sqlSession.selectOne("com.mybatis.dao.TblEmployeeMapper.selectByPrimaryKey", 1);
            System.out.println(employee);
        } finally {

            sqlSession.close();
        }
    }

    @Test
    public void test02() throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        System.out.println(sqlSession);
        try {
            int delete = sqlSession.delete("com.mybatis.dao.TblEmployeeMapper.deleteByPrimaryKey", 1);
            System.out.println(delete);

        } finally {

            sqlSession.close();
        }
    }


    @Test
    public void testAnnotation() throws IOException {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        System.out.println(sqlSession);
        try {
            TblEmployeeMapperAnnotation tblEmployeeMapperAnnotation = sqlSession.getMapper(TblEmployeeMapperAnnotation.class);
            TblEmployee emp = tblEmployeeMapperAnnotation.getEmpById(1);
            System.out.println(emp);

        } finally {
            sqlSession.close();
        }


    }
}
