package cn.zwr.generator;

import lombok.Data;

import java.io.Serializable;

@Data
public class SecurityPolicy implements Serializable {
    private String destIp;
    private String severity;
    private String deviceType;
    private String srcIp;
    private String corpId;
    private String srcDeviceGUID;
    private String sessionStartTime;
    private String sessionEndTime;
    private String srcPort;
    private String source;
    private String keepTime;
    private String processTime;
    private String protocol;
    private String alarmType;
    private String destPort;
    private String destCorpId;
    private String srcMac;
    private String id;
    private String destMac;
    private String destDeviceGUID;
    private String status;
}
