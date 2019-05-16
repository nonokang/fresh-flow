package cn.zwr.pojo;

import cn.zwr.pojo.common.EventCommonDataDetail;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class DeviceWarnDetail extends EventCommonDataDetail {
    @JSONField(name = "Desc")
    private String desc;


    @Override
    public String toString() {
        return "DeviceWarnDetail{" +
                "desc='" + desc + '\'' +
                '}';
    }

    @Override
    public Map<String, Object> transformMap() {
        Map<String, Object> result = new HashMap<>();
        result.put("desc",this.desc);
        return result;
    }
}
