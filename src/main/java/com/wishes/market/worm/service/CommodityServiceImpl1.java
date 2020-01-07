package com.wishes.market.worm.service;

import com.wishes.market.worm.dao.CommodityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lancer
 * @date 2019/12/30 22:34
 **/
@Service("CommodityService")
public class CommodityServiceImpl1 implements CommodityService1 {
    @Autowired
    CommodityDao commodityDao;
    @Override
    public List<String> selectAllUrl() {
        return commodityDao.selectAllUrl();
    }

    @Override
    public List<String> selectAllIcon() {
        return commodityDao.selectAllIcon();
    }

    @Override
    public int changeURL(String srcURL, String dstURL) {
       return commodityDao.changeURL(srcURL, dstURL);
    }
}
