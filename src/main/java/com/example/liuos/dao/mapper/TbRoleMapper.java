package com.example.liuos.dao.mapper;

import com.example.liuos.dao.pojo.TbRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.crypto.hash.Hash;

import java.util.HashMap;
import java.util.List;

/**
* @author Jay
* @description 针对表【tb_role(角色表)】的数据库操作Mapper
* @createDate 2022-05-15 14:51:46
* @Entity generator.domain.TbRole
*/
@Mapper
public interface TbRoleMapper {

    public List<HashMap> searchAllRole();

    public List<HashMap> searchRoleByPage(HashMap params);

    public long searchRoleCount(HashMap params);

    public int insert(TbRole role);
}
