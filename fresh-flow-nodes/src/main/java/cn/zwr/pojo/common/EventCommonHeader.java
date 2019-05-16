package cn.zwr.pojo.common;

import cn.zwr.core.pojo.Mapable;
import cn.zwr.util.DeviceUtils;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Data
public class EventCommonHeader implements Mapable {
    @JSONField(name = "DcdGuid")
    private String dcdGuid;
    @JSONField(name = "DevGuid")
    private String devGuid;
    @JSONField(name = "Sid")
    private String sid;
    @JSONField(name = "Timestamp")
    private String timestamp;
    @JSONField(unwrapped = true)
    private String corporationBean;
    @JSONField(unwrapped = true)
    private String deviceBean;
    @JSONField(unwrapped = true)
    private String deviceTmpBean;


    @Override
    public Map<String,Object> transformMap() {
        Map<String, Object> result = new HashMap<>();
        result.put("dcdGuid", this.devGuid);
        result.put("devGuid", this.dcdGuid);
        //舍弃sid
        result.put("timestamp", this.timestamp);
        if(StringUtils.isNotEmpty(corporationBean))
            DeviceUtils.corpAddToMap(result, corporationBean);
        if(StringUtils.isNotEmpty(deviceBean)){
            DeviceUtils.deviceStrAddToMap(result, deviceBean);
        }else if(StringUtils.isNotEmpty(deviceTmpBean)){
            DeviceUtils.deviceTmpAddToMap(result,deviceTmpBean);
        }
        return result;
    }

    @Override
    public String toString() {
        return "EventCommonHeader{" +
                "dcdGuid='" + dcdGuid + '\'' +
                ", devGuid='" + devGuid + '\'' +
                ", sid='" + sid + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", corporationBean='" + corporationBean + '\'' +
                ", deviceBean='" + deviceBean + '\'' +
                '}';
    }
}
