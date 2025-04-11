package com.entity.model;

import com.entity.XuantishenheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 选题审核
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-23
 */
public class XuantishenheModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 选择学生
     */
    private Integer yonghuId;


    /**
     * 选择题目
     */
    private Integer jiaoshiId;


    /**
     * 发布教师
     */
    private Integer shejitimuId;


    /**
     * 审核状态
     */
    private Integer xuantishenheTypes;


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
	 * 获取：选择学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：选择学生
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：选择题目
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：选择题目
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：发布教师
	 */
    public Integer getShejitimuId() {
        return shejitimuId;
    }


    /**
	 * 设置：发布教师
	 */
    public void setShejitimuId(Integer shejitimuId) {
        this.shejitimuId = shejitimuId;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getXuantishenheTypes() {
        return xuantishenheTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setXuantishenheTypes(Integer xuantishenheTypes) {
        this.xuantishenheTypes = xuantishenheTypes;
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
