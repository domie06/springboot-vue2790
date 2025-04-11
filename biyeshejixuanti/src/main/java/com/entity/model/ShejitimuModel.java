package com.entity.model;

import com.entity.ShejitimuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 设计题目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-23
 */
public class ShejitimuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 题目名称
     */
    private String shejitimuName;


    /**
     * 发布教师
     */
    private Integer jiaoshiId;


    /**
     * 项目类型
     */
    private Integer shejitimuTypes;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 赞成票
     */
    private Integer shejitimuZancheng;


    /**
     * 反对票
     */
    private Integer shejitimuFandui;


    /**
     * 审核状态
     */
    private Integer zhuangtaiTypes;


    /**
     * 项目内容
     */
    private String shejitimuContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：题目名称
	 */
    public String getShejitimuName() {
        return shejitimuName;
    }


    /**
	 * 设置：题目名称
	 */
    public void setShejitimuName(String shejitimuName) {
        this.shejitimuName = shejitimuName;
    }
    /**
	 * 获取：发布教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：发布教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：项目类型
	 */
    public Integer getShejitimuTypes() {
        return shejitimuTypes;
    }


    /**
	 * 设置：项目类型
	 */
    public void setShejitimuTypes(Integer shejitimuTypes) {
        this.shejitimuTypes = shejitimuTypes;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发布时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：赞成票
	 */
    public Integer getShejitimuZancheng() {
        return shejitimuZancheng;
    }


    /**
	 * 设置：赞成票
	 */
    public void setShejitimuZancheng(Integer shejitimuZancheng) {
        this.shejitimuZancheng = shejitimuZancheng;
    }
    /**
	 * 获取：反对票
	 */
    public Integer getShejitimuFandui() {
        return shejitimuFandui;
    }


    /**
	 * 设置：反对票
	 */
    public void setShejitimuFandui(Integer shejitimuFandui) {
        this.shejitimuFandui = shejitimuFandui;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getZhuangtaiTypes() {
        return zhuangtaiTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setZhuangtaiTypes(Integer zhuangtaiTypes) {
        this.zhuangtaiTypes = zhuangtaiTypes;
    }
    /**
	 * 获取：项目内容
	 */
    public String getShejitimuContent() {
        return shejitimuContent;
    }


    /**
	 * 设置：项目内容
	 */
    public void setShejitimuContent(String shejitimuContent) {
        this.shejitimuContent = shejitimuContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
