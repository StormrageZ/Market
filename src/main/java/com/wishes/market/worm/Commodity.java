package com.wishes.market.worm;

import com.wishes.market.worm.service.CommodityService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * @author Lancer
 * @date 2019/12/30 22:27
 **/
@Controller
@RequestMapping("/worm")
public class Commodity {
    @Autowired
    CommodityService1 commodityService;
    @RequestMapping("/commodity")
    public void wormCommodity() throws IOException {
        List<String> urls = commodityService.selectAllUrl();
        for(String url : urls){
            URL realUrl = new URL(url);
            String filepath = url.substring(url.indexOf("commodity"));
            HttpURLConnection uc = (HttpURLConnection) realUrl.openConnection();
            if(uc.getResponseCode() == 404) continue;
            InputStream inputStream = uc.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("E:"+ File.separator + filepath);
            int w = 0;
            while( (w = inputStream.read()) != -1){
                fileOutputStream.write(w);
            }
            inputStream.close();
            fileOutputStream.close();
        }
    }
    @RequestMapping("icon")
    public void wormIcon() throws IOException {
        List<String> urls = commodityService.selectAllIcon();
        for(String url : urls){
            URL realUrl = new URL(url);
            String filepath = url.substring(url.indexOf("icon"));
            HttpURLConnection uc = (HttpURLConnection) realUrl.openConnection();
            if(uc.getResponseCode() == 404) continue;
            InputStream inputStream = uc.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("E:"+ File.separator + filepath);
            int w = 0;
            while( (w = inputStream.read()) != -1){
                fileOutputStream.write(w);
            }
            inputStream.close();
            fileOutputStream.close();
        }
    }
    public void changeURL(){
        List<String> urls = commodityService.selectAllUrl();
        for(String url : urls){
            String filepath = url.substring(url.indexOf("commodity"));
            String dst = "http://47.102.135.226/" + filepath;
            commodityService.changeURL(url,dst);
        }
    }
}
