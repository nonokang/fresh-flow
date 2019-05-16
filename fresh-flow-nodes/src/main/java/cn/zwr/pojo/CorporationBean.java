package cn.zwr.pojo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: tide
 * @Description: 主站Redis-组织bean对象
 * @Date: Created in 16:52 2019/4/4
 * @Modified By:
 */
@Data
public class CorporationBean implements Serializable{

	private static final long serialVersionUID = 1390741768658491557L;
	/**
	 * 地域ID
	 */
	private String corpid;

	/**
	 * 地域名称（显示名称）
	 */
	private String corpname;

	/**
	 * 排序编号
	 */
	private Integer sort;

	/**
	 * 平台网省名称（索引名称，含MP）
	 */
	private String platformname;
	/**
	 * 最后更新时间
	 */
	private Timestamp modifytime;

	/**
	 * 公司名称
	 */
	private String orgName;

	/**
	 * 调管单位
	 */
	private String dgCorpName;
	/**
	 * 归属单位
	 */
	private String gsCorpName;
	/**
	 * 单位
	 */
	private String unitAbbreviation;


	@Override
	public String toString() {
		return "CorporationBean{" +
				"corpid='" + corpid + '\'' +
				", corpname='" + corpname + '\'' +
				", sort=" + sort +
				", platformname='" + platformname + '\'' +
				", modifytime=" + modifytime +
				", orgName='" + orgName + '\'' +
				", dgCorpName='" + dgCorpName + '\'' +
				", gsCorpName='" + gsCorpName + '\'' +
				", unitAbbreviation='" + unitAbbreviation + '\'' +
				'}';
	}

}