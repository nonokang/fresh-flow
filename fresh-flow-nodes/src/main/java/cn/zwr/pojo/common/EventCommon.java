package cn.zwr.pojo.common;

import cn.zwr.core.pojo.Mapable;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class EventCommon<T extends EventCommonDataDetail> implements Mapable {
    @JSONField(name = "Header")
    private EventCommonHeader eventCommonHeader;
    @JSONField(name = "Data")
    private EventCommonData<T> eventCommonData;

    public Map transformMap(){
        Map result = new HashMap();
        if(eventCommonHeader != null)
            result.putAll(this.eventCommonHeader.transformMap());
        if(eventCommonData != null)
            result.putAll(this.eventCommonData.transformMap());
        return result;
    }

    @Override
    public String toString() {
        return "EventCommon{" +
                "eventCommonHeader=" + eventCommonHeader +
                ", eventCommonData=" + eventCommonData +
                '}';
    }
}
