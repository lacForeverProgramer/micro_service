package com.lacForever.dao;

import com.lacForever.model.LcUser;
import com.lacForever.model.LcUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LcUserMapper {
    int countByExample(LcUserExample example);

    int deleteByExample(LcUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LcUser record);

    int insertSelective(LcUser record);

    List<LcUser> selectByExample(LcUserExample example);

    LcUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LcUser record, @Param("example") LcUserExample example);

    int updateByExample(@Param("record") LcUser record, @Param("example") LcUserExample example);

    int updateByPrimaryKeySelective(LcUser record);

    int updateByPrimaryKey(LcUser record);
}