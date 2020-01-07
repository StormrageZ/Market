package com.wishes.market.worm.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lancer
 * @date 2019/12/30 22:36
 **/
@Repository
@Mapper
public interface CommodityDao {
   List<String> selectAllUrl();
   List<String> selectAllIcon();
   int changeURL(String srcURL, String dstURL);
}
