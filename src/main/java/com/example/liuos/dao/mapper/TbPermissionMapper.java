package com.example.liuos.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
* @author Jay
* @description 针对表【tb_permission】的数据库操作Mapper
* @createDate 2022-05-15 14:51:46
* @Entity generator.domain.TbPermission
*/
@Mapper
public interface TbPermissionMapper {
    public List<HashMap> searchAllPermission();

}
