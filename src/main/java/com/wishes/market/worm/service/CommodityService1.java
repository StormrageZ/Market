package com.wishes.market.worm.service;

import java.util.List;

/**
 * @author Lancer
 * @date 2019/12/30 22:33
 **/
public interface CommodityService1 {
    List<String> selectAllUrl();
    List<String> selectAllIcon();
    int changeURL(String srcURL, String dstURL);
}
