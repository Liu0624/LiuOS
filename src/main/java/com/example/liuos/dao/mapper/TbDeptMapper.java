package com.example.liuos.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
* @author Jay
* @description 针对表【tb_dept】的数据库操作Mapper
* @createDate 2022-05-15 14:51:45
* @Entity generator.domain.TbDept
*/
@Mapper
public interface TbDeptMapper {

    public List<HashMap> searchAllDept();
}
