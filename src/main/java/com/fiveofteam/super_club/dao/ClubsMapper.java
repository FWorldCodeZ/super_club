package com.fiveofteam.super_club.dao;

import com.fiveofteam.super_club.pojo.Clubs;

import java.util.List;


public interface ClubsMapper {
    int deleteByPrimaryKey(String uuId);

    int insert(Clubs record);

    int insertSelective(Clubs record);

    Clubs selectByPrimaryKey(String uuId);

    int updateByPrimaryKeySelective(Clubs record);

    int updateByPrimaryKey(Clubs record);

    /**
     * 查询所有社团
     * @return
     */
    List<Clubs> selectAllClub();

    /**
     * 更新社团信息
     * @param clubs
     * @return
     */
    int updateClubInfo(Clubs clubs);

    /**
     * 查询社团Logo路径
     * @param uuId
     * @return
     */
    List<Clubs> selectClubLogoByPrimaryKey(String uuId);


    List<Clubs> selectClubNameByName(String clubName);



}