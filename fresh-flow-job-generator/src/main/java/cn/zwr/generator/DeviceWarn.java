package cn.zwr.generator;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeviceWarn implements Serializable {
    private String eventCode;
    private String appName;
    private String discoverTime;
    private String devGuid;
    private String tag;
    private String dcdGuid;
    private String timestamp;
}
