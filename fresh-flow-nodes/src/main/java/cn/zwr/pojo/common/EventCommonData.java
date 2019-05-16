package cn.zwr.pojo.common;

import cn.zwr.core.pojo.Mapable;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class EventCommonData<T extends EventCommonDataDetail>  implements Mapable {
    @JSONField(name = "AppName")
    private String appName;
    @JSONField(name = "EventType")
    private String eventType;
    @JSONField(name = "FunClassTag")
    private String funClassTag;
    @JSONField(name = "DiscoverTime")
    private String discoverTime;
    @JSONField(name = "Details")
    private T eventCommonDataDetail;

    @Override
    public Map<String,Object> transformMap() {
        Map<String,Object> result = new HashMap<>();
        result.put("appName", this.appName);
        result.put("eventCode", this.eventType);
        result.put("discoverTime", this.discoverTime);
        result.put("tag", this.funClassTag);
        if(eventCommonDataDetail != null)
            result.putAll(eventCommonDataDetail.transformMap());
        return result;
    }

    @Override
    public String toString() {
        return "EventCommonData{" +
                "appName='" + appName + '\'' +
                ", eventType='" + eventType + '\'' +
                ", funClassTag='" + funClassTag + '\'' +
                ", discoverTime='" + discoverTime + '\'' +
                ", eventCommonDataDetail=" + eventCommonDataDetail +
                '}';
    }
}
