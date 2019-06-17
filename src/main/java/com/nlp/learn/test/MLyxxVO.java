package com.nlp.learn.test;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author 
 * @email 
 * @date 2019-04-24 10:15:22
 */
public class MLyxxVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//储备油粱表
	private String id;
	//企业id
	private String qyid;
	//年份
	private String year;
	//月份
	private String month;
	//品种指标
	private String pzzb;
	//期初库存
	private String cqkc;
	//收入合计-小计
	private String srhjXj;
	//收入合计-从生产者购进-小计
	private String srhjSczXj;
	//收入合计-从生产者购进-省外
	private String srhjSczSw;
	//收入合计-从企业购进-小计
	private String srhjQygjXj;
	//收入合计-从企业购进-省外
	private String srhjQygjSw;
	//收入合计-商品粮油转入
	private String srhjSplyzr;
	//收入合计-进口
	private String srhjJk;
	//收入合计-其他收入
	private String srhjQt;
	//支出合计-小计
	private String zchjXj;
	//支出合计-销售-小计
	private String zchjXsXj;
	//支出合计-销售-省外
	private String zchjXsSw;
	//支出合计-转作商品粮油
	private String zchjZzsply;
	//支出合计-出口
	private String zchjCk;
	//支出合计-其他支出
	private String zchjQt;
	//期末库存-小计
	private String qmkcXj;
	//期末库存-按生产年度-小计
	private String qmkcScndXj;
	//期末库存-按生产年度-年度一
	private String qmkcScndYear;
	//期末库存-按生产年度-年度二
	private String qmkcScndYear1;
	//期末库存-按生产年度-年度三
	private String qmkcScndYear2;
	//期末库存-按生产年度-年度四
	private String qmkcScndYear3;
	//期末库存-按生产年度-年度五
	private String qmkcScndYear4;
	//期末库存-按生产年度-年度六
	private String qmkcScndYear5;
	//期末库存-按生产年度-年度七
	private String qmkcScndYear6;
	//期末库存-小包装
	private String qmkcXbz;
	//期末库存-省外存储
	private String qmkcSwcc;
	//动态储备
	private String dtcb;
	//储备粮油类型：0、地方储备粮油合计_地方储备粮油合计；1、省级储备粮油_省级储备粮油；2、市级储备粮油_市级储备粮油；3、县级储备粮油_县级储备粮油
	private String type;
	//创建人
	private String creater;
	//创建时间
	private Date createtime;
	//更新人
	private String updater;
	//更新时间
	private Date updatetime;
	//删除标识：0：未删除，1：已删除
	private String delFlg;

	/**
	 * 设置：储备油粱表
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：储备油粱表
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：企业id
	 */
	public void setQyid(String qyid) {
		this.qyid = qyid;
	}
	/**
	 * 获取：企业id
	 */
	public String getQyid() {
		return qyid;
	}
	/**
	 * 设置：年份
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 获取：年份
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 设置：月份
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * 获取：月份
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * 设置：品种指标
	 */
	public void setPzzb(String pzzb) {
		this.pzzb = pzzb;
	}
	/**
	 * 获取：品种指标
	 */
	public String getPzzb() {
		return pzzb;
	}
	/**
	 * 设置：期初库存
	 */
	public void setCqkc(String cqkc) {
		this.cqkc = cqkc;
	}
	/**
	 * 获取：期初库存
	 */
	public String getCqkc() {
		return cqkc;
	}
	/**
	 * 设置：收入合计-小计
	 */
	public void setSrhjXj(String srhjXj) {
		this.srhjXj = srhjXj;
	}
	/**
	 * 获取：收入合计-小计
	 */
	public String getSrhjXj() {
		return srhjXj;
	}
	/**
	 * 设置：收入合计-从生产者购进-小计
	 */
	public void setSrhjSczXj(String srhjSczXj) {
		this.srhjSczXj = srhjSczXj;
	}
	/**
	 * 获取：收入合计-从生产者购进-小计
	 */
	public String getSrhjSczXj() {
		return srhjSczXj;
	}
	/**
	 * 设置：收入合计-从生产者购进-省外
	 */
	public void setSrhjSczSw(String srhjSczSw) {
		this.srhjSczSw = srhjSczSw;
	}
	/**
	 * 获取：收入合计-从生产者购进-省外
	 */
	public String getSrhjSczSw() {
		return srhjSczSw;
	}
	/**
	 * 设置：收入合计-从企业购进-小计
	 */
	public void setSrhjQygjXj(String srhjQygjXj) {
		this.srhjQygjXj = srhjQygjXj;
	}
	/**
	 * 获取：收入合计-从企业购进-小计
	 */
	public String getSrhjQygjXj() {
		return srhjQygjXj;
	}
	/**
	 * 设置：收入合计-从企业购进-省外
	 */
	public void setSrhjQygjSw(String srhjQygjSw) {
		this.srhjQygjSw = srhjQygjSw;
	}
	/**
	 * 获取：收入合计-从企业购进-省外
	 */
	public String getSrhjQygjSw() {
		return srhjQygjSw;
	}
	/**
	 * 设置：收入合计-商品粮油转入
	 */
	public void setSrhjSplyzr(String srhjSplyzr) {
		this.srhjSplyzr = srhjSplyzr;
	}
	/**
	 * 获取：收入合计-商品粮油转入
	 */
	public String getSrhjSplyzr() {
		return srhjSplyzr;
	}
	/**
	 * 设置：收入合计-进口
	 */
	public void setSrhjJk(String srhjJk) {
		this.srhjJk = srhjJk;
	}
	/**
	 * 获取：收入合计-进口
	 */
	public String getSrhjJk() {
		return srhjJk;
	}
	/**
	 * 设置：收入合计-其他收入
	 */
	public void setSrhjQt(String srhjQt) {
		this.srhjQt = srhjQt;
	}
	/**
	 * 获取：收入合计-其他收入
	 */
	public String getSrhjQt() {
		return srhjQt;
	}
	/**
	 * 设置：支出合计-小计
	 */
	public void setZchjXj(String zchjXj) {
		this.zchjXj = zchjXj;
	}
	/**
	 * 获取：支出合计-小计
	 */
	public String getZchjXj() {
		return zchjXj;
	}
	/**
	 * 设置：支出合计-销售-小计
	 */
	public void setZchjXsXj(String zchjXsXj) {
		this.zchjXsXj = zchjXsXj;
	}
	/**
	 * 获取：支出合计-销售-小计
	 */
	public String getZchjXsXj() {
		return zchjXsXj;
	}
	/**
	 * 设置：支出合计-销售-省外
	 */
	public void setZchjXsSw(String zchjXsSw) {
		this.zchjXsSw = zchjXsSw;
	}
	/**
	 * 获取：支出合计-销售-省外
	 */
	public String getZchjXsSw() {
		return zchjXsSw;
	}
	/**
	 * 设置：支出合计-转作商品粮油
	 */
	public void setZchjZzsply(String zchjZzsply) {
		this.zchjZzsply = zchjZzsply;
	}
	/**
	 * 获取：支出合计-转作商品粮油
	 */
	public String getZchjZzsply() {
		return zchjZzsply;
	}
	/**
	 * 设置：支出合计-出口
	 */
	public void setZchjCk(String zchjCk) {
		this.zchjCk = zchjCk;
	}
	/**
	 * 获取：支出合计-出口
	 */
	public String getZchjCk() {
		return zchjCk;
	}
	/**
	 * 设置：支出合计-其他支出
	 */
	public void setZchjQt(String zchjQt) {
		this.zchjQt = zchjQt;
	}
	/**
	 * 获取：支出合计-其他支出
	 */
	public String getZchjQt() {
		return zchjQt;
	}
	/**
	 * 设置：期末库存-小计
	 */
	public void setQmkcXj(String qmkcXj) {
		this.qmkcXj = qmkcXj;
	}
	/**
	 * 获取：期末库存-小计
	 */
	public String getQmkcXj() {
		return qmkcXj;
	}
	/**
	 * 设置：期末库存-按生产年度-小计
	 */
	public void setQmkcScndXj(String qmkcScndXj) {
		this.qmkcScndXj = qmkcScndXj;
	}
	/**
	 * 获取：期末库存-按生产年度-小计
	 */
	public String getQmkcScndXj() {
		return qmkcScndXj;
	}
	/**
	 * 设置：期末库存-按生产年度-年度一
	 */
	public void setQmkcScndYear(String qmkcScndYear) {
		this.qmkcScndYear = qmkcScndYear;
	}
	/**
	 * 获取：期末库存-按生产年度-年度一
	 */
	public String getQmkcScndYear() {
		return qmkcScndYear;
	}
	/**
	 * 设置：期末库存-按生产年度-年度二
	 */
	public void setQmkcScndYear1(String qmkcScndYear1) {
		this.qmkcScndYear1 = qmkcScndYear1;
	}
	/**
	 * 获取：期末库存-按生产年度-年度二
	 */
	public String getQmkcScndYear1() {
		return qmkcScndYear1;
	}
	/**
	 * 设置：期末库存-按生产年度-年度三
	 */
	public void setQmkcScndYear2(String qmkcScndYear2) {
		this.qmkcScndYear2 = qmkcScndYear2;
	}
	/**
	 * 获取：期末库存-按生产年度-年度三
	 */
	public String getQmkcScndYear2() {
		return qmkcScndYear2;
	}
	/**
	 * 设置：期末库存-按生产年度-年度四
	 */
	public void setQmkcScndYear3(String qmkcScndYear3) {
		this.qmkcScndYear3 = qmkcScndYear3;
	}
	/**
	 * 获取：期末库存-按生产年度-年度四
	 */
	public String getQmkcScndYear3() {
		return qmkcScndYear3;
	}
	/**
	 * 设置：期末库存-按生产年度-年度五
	 */
	public void setQmkcScndYear4(String qmkcScndYear4) {
		this.qmkcScndYear4 = qmkcScndYear4;
	}
	/**
	 * 获取：期末库存-按生产年度-年度五
	 */
	public String getQmkcScndYear4() {
		return qmkcScndYear4;
	}
	/**
	 * 设置：期末库存-按生产年度-年度六
	 */
	public void setQmkcScndYear5(String qmkcScndYear5) {
		this.qmkcScndYear5 = qmkcScndYear5;
	}
	/**
	 * 获取：期末库存-按生产年度-年度六
	 */
	public String getQmkcScndYear5() {
		return qmkcScndYear5;
	}
	/**
	 * 设置：期末库存-按生产年度-年度七
	 */
	public void setQmkcScndYear6(String qmkcScndYear6) {
		this.qmkcScndYear6 = qmkcScndYear6;
	}
	/**
	 * 获取：期末库存-按生产年度-年度七
	 */
	public String getQmkcScndYear6() {
		return qmkcScndYear6;
	}
	/**
	 * 设置：期末库存-小包装
	 */
	public void setQmkcXbz(String qmkcXbz) {
		this.qmkcXbz = qmkcXbz;
	}
	/**
	 * 获取：期末库存-小包装
	 */
	public String getQmkcXbz() {
		return qmkcXbz;
	}
	/**
	 * 设置：期末库存-省外存储
	 */
	public void setQmkcSwcc(String qmkcSwcc) {
		this.qmkcSwcc = qmkcSwcc;
	}
	/**
	 * 获取：期末库存-省外存储
	 */
	public String getQmkcSwcc() {
		return qmkcSwcc;
	}
	/**
	 * 设置：动态储备
	 */
	public void setDtcb(String dtcb) {
		this.dtcb = dtcb;
	}
	/**
	 * 获取：动态储备
	 */
	public String getDtcb() {
		return dtcb;
	}
	/**
	 * 设置：储备粮油类型：0、地方储备粮油合计_地方储备粮油合计；1、省级储备粮油_省级储备粮油；2、市级储备粮油_市级储备粮油；3、县级储备粮油_县级储备粮油
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：储备粮油类型：0、地方储备粮油合计_地方储备粮油合计；1、省级储备粮油_省级储备粮油；2、市级储备粮油_市级储备粮油；3、县级储备粮油_县级储备粮油
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreater(String creater) {
		this.creater = creater;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreater() {
		return creater;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：更新人
	 */
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	/**
	 * 获取：更新人
	 */
	public String getUpdater() {
		return updater;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置：删除标识：0：未删除，1：已删除
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
	/**
	 * 获取：删除标识：0：未删除，1：已删除
	 */
	public String getDelFlg() {
		return delFlg;
	}
}
