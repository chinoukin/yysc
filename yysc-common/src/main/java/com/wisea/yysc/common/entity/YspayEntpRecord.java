package com.wisea.yysc.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * yspay_entp_record 表实体
 * 子商户入驻记录
 * 2021/01/26 16:30:07
 */
public class YspayEntpRecord extends DataLongEntity<YspayEntpRecord> {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String usercode;

    /**
     * 客户名
     */
    private String custname;

    /**
     * 客户ID
     */
    private String custid;

    /**
     * 用户状态
     */
    private String userStatus;

    /**
     * 创建时间1
     */
    private String createtime;

    /**
     * 客户状态
     */
    private String custStatue;

    /**
     * 子商户是否需要电子合同
     */
    private String isNeedContract;

    /**
     * 平台商唯一标识
     */
    private String merchantNo;

    /**
     * 备注1
     */
    private String note;

    /**
     * 电子合同预览地址
     */
    private String onlineUrl;

    /**
     * 电子合同下载地址
     */
    private String offlineUrl;

    /**
     * 通知类型
     */
    private String notifyType;

    /**
     * 发送请求的时间
     */
    private String notifyTime;

    /**
     * 异步通知状态
     */
    private String notifyStatus;

    /**
     * 审核状态
     */
    private String approvalStatus;

    /**
     * 审核信息
     */
    private String approvalMsg;

    /**
     * 获取用户名
     */
    public String getUsercode() {
        return usercode;
    }

    /**
     * 设置用户名
     */
    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    /**
     * 获取客户名
     */
    public String getCustname() {
        return custname;
    }

    /**
     * 设置客户名
     */
    public void setCustname(String custname) {
        this.custname = custname == null ? null : custname.trim();
    }

    /**
     * 获取客户ID
     */
    public String getCustid() {
        return custid;
    }

    /**
     * 设置客户ID
     */
    public void setCustid(String custid) {
        this.custid = custid == null ? null : custid.trim();
    }

    /**
     * 获取用户状态
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户状态
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    /**
     * 获取创建时间1
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间1
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    /**
     * 获取客户状态
     */
    public String getCustStatue() {
        return custStatue;
    }

    /**
     * 设置客户状态
     */
    public void setCustStatue(String custStatue) {
        this.custStatue = custStatue == null ? null : custStatue.trim();
    }

    /**
     * 获取子商户是否需要电子合同
     */
    public String getIsNeedContract() {
        return isNeedContract;
    }

    /**
     * 设置子商户是否需要电子合同
     */
    public void setIsNeedContract(String isNeedContract) {
        this.isNeedContract = isNeedContract == null ? null : isNeedContract.trim();
    }

    /**
     * 获取平台商唯一标识
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 设置平台商唯一标识
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 获取备注1
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置备注1
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * 获取电子合同预览地址
     */
    public String getOnlineUrl() {
        return onlineUrl;
    }

    /**
     * 设置电子合同预览地址
     */
    public void setOnlineUrl(String onlineUrl) {
        this.onlineUrl = onlineUrl == null ? null : onlineUrl.trim();
    }

    /**
     * 获取电子合同下载地址
     */
    public String getOfflineUrl() {
        return offlineUrl;
    }

    /**
     * 设置电子合同下载地址
     */
    public void setOfflineUrl(String offlineUrl) {
        this.offlineUrl = offlineUrl == null ? null : offlineUrl.trim();
    }

    /**
     * 获取通知类型
     */
    public String getNotifyType() {
        return notifyType;
    }

    /**
     * 设置通知类型
     */
    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType == null ? null : notifyType.trim();
    }

    /**
     * 获取发送请求的时间
     */
    public String getNotifyTime() {
        return notifyTime;
    }

    /**
     * 设置发送请求的时间
     */
    public void setNotifyTime(String notifyTime) {
        this.notifyTime = notifyTime == null ? null : notifyTime.trim();
    }

    /**
     * 获取异步通知状态
     */
    public String getNotifyStatus() {
        return notifyStatus;
    }

    /**
     * 设置异步通知状态
     */
    public void setNotifyStatus(String notifyStatus) {
        this.notifyStatus = notifyStatus == null ? null : notifyStatus.trim();
    }

    /**
     * 获取审核状态
     */
    public String getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * 设置审核状态
     */
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus == null ? null : approvalStatus.trim();
    }

    /**
     * 获取审核信息
     */
    public String getApprovalMsg() {
        return approvalMsg;
    }

    /**
     * 设置审核信息
     */
    public void setApprovalMsg(String approvalMsg) {
        this.approvalMsg = approvalMsg == null ? null : approvalMsg.trim();
    }
}