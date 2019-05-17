package cn.zwr.pojo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: tide
 * @Description: 主站Redis-资产临时表bean对象
 * @Date: Created in 16:52 2019/4/4
 * @Modified By:
 */
@Data
public class DbDeviceTmpBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 资产临时lid
	 */
	private String lid;
	
	/**
	 * 主机名
	 */
	private String hostname;
	/**
	 * 设备管理IP
	 */
	private String ip;
	
	/**
	 * 设备名
	 */
	private String devicename;
	/**
	 * 调度分区
	 */
	private String partition;
	
	/**
	 * 设备类型
	 */
	private String devicecode;
	
	/**
	 * 物理位置
	 */
	private String position;
	
	/**
	 * 厂商信息
	 */
	private String factory;
	
	/**
	 * 厂商信息ID
	 */
	private String factoryid;
	
	/**
	 * 型号
	 */
	private String model;
	
	/**
	 * 软件版本
	 */
	private String softversion;
	
	/**
	 * 所属业务系统
	 */
	private String businesssystem;
	
	/**
	 * 所属业务系统ID
	 */
	private String businesssystemid;
	
	/**
	 * 设备用途
	 */
	private String deviceuses;
	
	/**
	 * 负责人
	 */
	private String principle;
	
	/**
	 * 联系电话
	 */
	private String telephone;
	
	/**
	 * 状态
	 */
	private String status;
	
	/**
	 * 数据来源
	 */
	private String resource;
	
	/**
	 * 是否检修
	 */
	private String isservice;
	
	/**
	 * 是否关联
	 */
	private String isref;
	
	
	/**
	 * 内部名称
	 */
	private String innername;
	
	/**
	 * 电压等级
	 */
	private String voltagecalss;
	
	/**
	 * 地域组织机构id
	 */
	private String corpid;
	
	/**
	 * 站点类型
	 */
	private String sitetype;
	
	/**
	 * 添加时间
	 */
	private Timestamp addtime;
	
	/**
	 * 修改时间
	 */
	private Timestamp updatetime;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 采集机id
	 */
	private String agent_id;
	
	/**
	 * 采集机ip
	 */
	private String agent_ip;
	/**
	 * 1、主属；2、副属类型
	 */
	private int stationType;
	
	/**
	 * 操作状态  0 没操作 1：已注册 2：已删除
	 */
	private int operatestatus;
	
	/**
	 * 在离线
	 */
	private String  state;
	
	/**
	 * 操作系统版本
	 */
	private String systemVersion;
	
	/**
	 * 归属专业
	 */
	private String belongedMajor;
	
	/**
     * nmap扫描系统名
     */
    private String nmapSystem;
    
    private String deviceRegisterGuid;

	@Override
	public String toString() {
		return "DbDeviceTmpBean{" +
				"lid='" + lid + '\'' +
				", hostname='" + hostname + '\'' +
				", ip='" + ip + '\'' +
				", devicename='" + devicename + '\'' +
				", partition='" + partition + '\'' +
				", devicecode='" + devicecode + '\'' +
				", position='" + position + '\'' +
				", factory='" + factory + '\'' +
				", factoryid='" + factoryid + '\'' +
				", model='" + model + '\'' +
				", softversion='" + softversion + '\'' +
				", businesssystem='" + businesssystem + '\'' +
				", businesssystemid='" + businesssystemid + '\'' +
				", deviceuses='" + deviceuses + '\'' +
				", principle='" + principle + '\'' +
				", telephone='" + telephone + '\'' +
				", status='" + status + '\'' +
				", resource='" + resource + '\'' +
				", isservice='" + isservice + '\'' +
				", isref='" + isref + '\'' +
				", innername='" + innername + '\'' +
				", voltagecalss='" + voltagecalss + '\'' +
				", corpid='" + corpid + '\'' +
				", sitetype='" + sitetype + '\'' +
				", addtime=" + addtime +
				", updatetime=" + updatetime +
				", remark='" + remark + '\'' +
				", agent_id='" + agent_id + '\'' +
				", agent_ip='" + agent_ip + '\'' +
				", stationType=" + stationType +
				", operatestatus=" + operatestatus +
				", state='" + state + '\'' +
				", systemVersion='" + systemVersion + '\'' +
				", belongedMajor='" + belongedMajor + '\'' +
				", nmapSystem='" + nmapSystem + '\'' +
				", deviceRegisterGuid='" + deviceRegisterGuid + '\'' +
				'}';
	}


	
	
}
