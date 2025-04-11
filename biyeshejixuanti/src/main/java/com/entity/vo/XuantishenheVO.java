package com.entity.vo;

import com.entity.XuantishenheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 选题审核
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("xuantishenhe")
public class XuantishenheVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 选择学生
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 选择题目
     */

    @TableField(value = "jiaoshi_id")
    private Integer jiaoshiId;


    /**
     * 发布教师
     */

    @TableField(value = "shejitimu_id")
    private Integer shejitimuId;


    /**
     * 审核状态
     */

    @TableField(value = "xuantishenhe_types")
    private Integer xuantishenheTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：选择学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：选择学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：选择题目
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：选择题目
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 设置：发布教师
	 */
    public Integer getShejitimuId() {
        return shejitimuId;
    }


    /**
	 * 获取：发布教师
	 */

    public void setShejitimuId(Integer shejitimuId) {
        this.shejitimuId = shejitimuId;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getXuantishenheTypes() {
        return xuantishenheTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setXuantishenheTypes(Integer xuantishenheTypes) {
        this.xuantishenheTypes = xuantishenheTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
