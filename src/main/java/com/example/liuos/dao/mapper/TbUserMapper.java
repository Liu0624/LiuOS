package com.example.liuos.dao.mapper;

import com.example.liuos.dao.pojo.TbUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
* @author Jay
* @description 针对表【tb_user(用户表)】的数据库操作Mapper
* @createDate 2022-05-15 14:51:46
* @Entity generator.domain.TbUser
*/
@Mapper
public interface TbUserMapper {
    public Integer login(HashMap param);

    public Set<String> searchUserPermissions(int userId);

    public TbUser searchUserById(int userId);

    public int updatePassword(HashMap param);

    public HashMap searchNameAndPhotoById(int userId);

    /**
     * HashMap代表一个用户的各种信息
     * @param param
     * @return
     */
    public List<HashMap> searchUserByPage(HashMap param);

    public long searchUserCount(HashMap param);

    public int insert(TbUser user);

    public int update(HashMap param);

    public HashMap searchById(int userId);

    public int deleteUserByIds(Integer[] ids);
}
