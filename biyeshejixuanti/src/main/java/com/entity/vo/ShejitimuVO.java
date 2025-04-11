package com.entity.vo;

import com.entity.ShejitimuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 设计题目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("shejitimu")
public class ShejitimuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 题目名称
     */

    @TableField(value = "shejitimu_name")
    private String shejitimuName;


    /**
     * 发布教师
     */

    @TableField(value = "jiaoshi_id")
    private Integer jiaoshiId;


    /**
     * 项目类型
     */

    @TableField(value = "shejitimu_types")
    private Integer shejitimuTypes;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 赞成票
     */

    @TableField(value = "shejitimu_zancheng")
    private Integer shejitimuZancheng;


    /**
     * 反对票
     */

    @TableField(value = "shejitimu_fandui")
    private Integer shejitimuFandui;


    /**
     * 审核状态
     */

    @TableField(value = "zhuangtai_types")
    private Integer zhuangtaiTypes;


    /**
     * 项目内容
     */

    @TableField(value = "shejitimu_content")
    private String shejitimuContent;


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
	 * 设置：题目名称
	 */
    public String getShejitimuName() {
        return shejitimuName;
    }


    /**
	 * 获取：题目名称
	 */

    public void setShejitimuName(String shejitimuName) {
        this.shejitimuName = shejitimuName;
    }
    /**
	 * 设置：发布教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：发布教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 设置：项目类型
	 */
    public Integer getShejitimuTypes() {
        return shejitimuTypes;
    }


    /**
	 * 获取：项目类型
	 */

    public void setShejitimuTypes(Integer shejitimuTypes) {
        this.shejitimuTypes = shejitimuTypes;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：赞成票
	 */
    public Integer getShejitimuZancheng() {
        return shejitimuZancheng;
    }


    /**
	 * 获取：赞成票
	 */

    public void setShejitimuZancheng(Integer shejitimuZancheng) {
        this.shejitimuZancheng = shejitimuZancheng;
    }
    /**
	 * 设置：反对票
	 */
    public Integer getShejitimuFandui() {
        return shejitimuFandui;
    }


    /**
	 * 获取：反对票
	 */

    public void setShejitimuFandui(Integer shejitimuFandui) {
        this.shejitimuFandui = shejitimuFandui;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getZhuangtaiTypes() {
        return zhuangtaiTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setZhuangtaiTypes(Integer zhuangtaiTypes) {
        this.zhuangtaiTypes = zhuangtaiTypes;
    }
    /**
	 * 设置：项目内容
	 */
    public String getShejitimuContent() {
        return shejitimuContent;
    }


    /**
	 * 获取：项目内容
	 */

    public void setShejitimuContent(String shejitimuContent) {
        this.shejitimuContent = shejitimuContent;
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
