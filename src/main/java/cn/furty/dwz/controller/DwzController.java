package cn.furty.dwz.controller;

import cn.furty.dwz.mapper.DwzMapper;
import cn.furty.dwz.other.StaticData;
import cn.furty.dwz.other.Utils;
import cn.furty.dwz.pojo.Dwz;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dwz")
public class DwzController {

    @Autowired
    DwzMapper dwzMapper;

    /**
     * 创建 短网址
     * @param dwz
     * @return
     */
    @RequestMapping("/createDwz")
    public JSONObject createDwz(Dwz dwz) {
        JSONObject obj = new JSONObject();

        System.out.println(dwz);

        if (dwz.getDwz() != null && !dwz.getDwz().isEmpty()) {
            //用户自定义短网址
            if (StaticData.dwzForbiddenList.contains(dwz.getDwz())) {
                //该短网址被禁止使用
                obj.put("msg", "该短网址是官方使用的，换一个吧");
                obj.put("state", false);
                return obj;
            }

            int count = dwzMapper.getCount(dwz.getDwz());
            if (count > 0) {
                //该短网址已存在
                obj.put("msg", "该短网址已存在，可能已被别人用过了，换一个吧");
                obj.put("state", false);
                return obj;
            }

        } else {
            //系统生成短网址
            String dwzStr = Utils.getDwz(dwz.getYwz());
            dwz.setDwz(dwzStr);

            int count = dwzMapper.getCount(dwz.getDwz());
            if (count > 0) {
                //该系统生成短网址已存在
                obj.put("msg", "短网址设置成功");
                obj.put("dwz", dwz.getDwz());
                obj.put("state", true);
                return obj;
            }
        }


        //短网址有效且不存在于数据库
        int res = dwzMapper.addDwz(dwz);
        if (res > 0) {
            obj.put("msg", "短网址设置成功");
            obj.put("dwz", dwz.getDwz());
            obj.put("state", true);
            return obj;
        } else {
            obj.put("msg", "短网址设置失败");
            obj.put("state", false);
            return obj;
        }
    }

}
