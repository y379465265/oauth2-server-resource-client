package com.izejin.entity;

import com.izejin.bean.BaseModel;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * <p>
 * 企业用户表
 * </p>
 *
 * @author Auto Generator
 * @since 2023-02-23
 */
@TableName("sys_user")
public class SysUser extends BaseModel {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 企业ID（外键） 参照表主键：SYS_ENTERPRISE.id
     */
    @TableField("ent_id")
    private Long entId;

    /**
     * 企业名称
     */
    @TableField("ent_name")
    private String entName;

    /**
     * 企业代码
     */
    @TableField("ent_code")
    private String entCode;

    /**
     * 用户登录名（不可重复）
     */
    @TableField("login_name")
    private String loginName;

    /**
     * 用户姓名（不用于登录），可重复
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户登录密码 MD5加密
     */
    @TableField("login_password")
    private String loginPassword;

    /**
     * 用户状态 0-待审核  1-正常 2-注销
     */
    @TableField("state")
    private String state;

    /**
     * 用户手机号
     */
    @TableField("mobile_no")
    private String mobileNo;

    /**
     * 办公电话
     */
    @TableField("office_no")
    private String officeNo;

    /**
     * 用户邮箱地址
     */
    @TableField("email")
    private String email;

    /**
     * 审核后登录标志 0-未登录过，1-已登录过
     */
    @TableField("logged_state")
    private String loggedState;

    /**
     * 冻结标志 0-未冻结，1-已冻结
     */
    @TableField("frozen_state")
    private String frozenState;

    /**
     * 发证状态：0-待发证 1-已发证
     */
    @TableField("issue_cert_state")
    private String issueCertState;

    /**
     * 证件号码
     */
    @TableField("cert_no")
    private String certNo;

    /**
     * 证件类型：01-身份证、02-护照、04-港澳居民来往内地通行证(香港) 、05-台湾同胞来往内地通行证、  06-港澳居民来往内地通行证(澳门) 99-其他
     */
    @TableField("cert_type")
    private String certType;

    /**
     * 证件有效期起始日
     */
    @TableField("cert_start_date")
    private LocalDate certStartDate;

    /**
     * 证件截止日
     */
    @TableField("cert_end_date")
    private LocalDate certEndDate;

    /**
     * 连续登陆错误次数
     */
    @TableField("count")
    private Long count;

    /**
     * 身份核查标记：0-未核查 1-已核查 2-核查失败
     */
    @TableField("id_check_state")
    private String idCheckState;

    /**
     * 人脸识别：0-未识别 1-识别成功 2-识别失败
     */
    @TableField("face_check_state")
    private String faceCheckState;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField("create_datetime")
    private LocalDateTime createDatetime;

    /**
     * 记录创建人ID
     */
    @TableField("creator_id")
    private Long creatorId;

    /**
     * 创建人姓名
     */
    @TableField("creator")
    private String creator;

    /**
     * 修改时间
     */
    @TableField("modify_datetime")
    private LocalDateTime modifyDatetime;

    /**
     * 记录修改人ID
     */
    @TableField("modifier_id")
    private Long modifierId;

    /**
     * 修改人姓名
     */
    @TableField("modifier")
    private String modifier;

    /**
     * 修改版本号
     */
    @TableField("modify_version")
    private Long modifyVersion;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntId() {
        return entId;
    }

    public void setEntId(Long entId) {
        this.entId = entId;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getEntCode() {
        return entCode;
    }

    public void setEntCode(String entCode) {
        this.entCode = entCode;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getOfficeNo() {
        return officeNo;
    }

    public void setOfficeNo(String officeNo) {
        this.officeNo = officeNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoggedState() {
        return loggedState;
    }

    public void setLoggedState(String loggedState) {
        this.loggedState = loggedState;
    }

    public String getFrozenState() {
        return frozenState;
    }

    public void setFrozenState(String frozenState) {
        this.frozenState = frozenState;
    }

    public String getIssueCertState() {
        return issueCertState;
    }

    public void setIssueCertState(String issueCertState) {
        this.issueCertState = issueCertState;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public LocalDate getCertStartDate() {
        return certStartDate;
    }

    public void setCertStartDate(LocalDate certStartDate) {
        this.certStartDate = certStartDate;
    }

    public LocalDate getCertEndDate() {
        return certEndDate;
    }

    public void setCertEndDate(LocalDate certEndDate) {
        this.certEndDate = certEndDate;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getIdCheckState() {
        return idCheckState;
    }

    public void setIdCheckState(String idCheckState) {
        this.idCheckState = idCheckState;
    }

    public String getFaceCheckState() {
        return faceCheckState;
    }

    public void setFaceCheckState(String faceCheckState) {
        this.faceCheckState = faceCheckState;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getModifyDatetime() {
        return modifyDatetime;
    }

    public void setModifyDatetime(LocalDateTime modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }

    public Long getModifierId() {
        return modifierId;
    }

    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Long getModifyVersion() {
        return modifyVersion;
    }

    public void setModifyVersion(Long modifyVersion) {
        this.modifyVersion = modifyVersion;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        "id=" + id +
        ", entId=" + entId +
        ", entName=" + entName +
        ", entCode=" + entCode +
        ", loginName=" + loginName +
        ", userName=" + userName +
        ", loginPassword=" + loginPassword +
        ", state=" + state +
        ", mobileNo=" + mobileNo +
        ", officeNo=" + officeNo +
        ", email=" + email +
        ", loggedState=" + loggedState +
        ", frozenState=" + frozenState +
        ", issueCertState=" + issueCertState +
        ", certNo=" + certNo +
        ", certType=" + certType +
        ", certStartDate=" + certStartDate +
        ", certEndDate=" + certEndDate +
        ", count=" + count +
        ", idCheckState=" + idCheckState +
        ", faceCheckState=" + faceCheckState +
        ", remark=" + remark +
        ", createDatetime=" + createDatetime +
        ", creatorId=" + creatorId +
        ", creator=" + creator +
        ", modifyDatetime=" + modifyDatetime +
        ", modifierId=" + modifierId +
        ", modifier=" + modifier +
        ", modifyVersion=" + modifyVersion +
        "}";
    }
}
