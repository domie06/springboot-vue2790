package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 选题信息
 *
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("xuanti")
public class XuantiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuantiEntity() {

	}

	public XuantiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
     * 开题报告
     */
    @TableField(value = "kaitibaogao_file")

    private String kaitibaogaoFile;


    /**
     * 修改意见
     */
    @TableField(value = "kaitibaogao_content")

    private String kaitibaogaoContent;


    /**
     * 中期报告
     */
    @TableField(value = "zhongqi_file")

    private String zhongqiFile;


    /**
     * 修改意见
     */
    @TableField(value = "zhongqi_content")

    private String zhongqiContent;


    /**
     * 论文
     */
    @TableField(value = "luenwen_file")

    private String luenwenFile;


    /**
     * 修改意见
     */
    @TableField(value = "luenwen_content")

    private String luenwenContent;


    /**
     * 审核状态
     */
    @TableField(value = "xuanti_types")

    private Integer xuantiTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：开题报告
	 */
    public String getKaitibaogaoFile() {
        return kaitibaogaoFile;
    }


    /**
	 * 获取：开题报告
	 */

    public void setKaitibaogaoFile(String kaitibaogaoFile) {
        this.kaitibaogaoFile = kaitibaogaoFile;
    }
    /**
	 * 设置：修改意见
	 */
    public String getKaitibaogaoContent() {
        return kaitibaogaoContent;
    }


    /**
	 * 获取：修改意见
	 */

    public void setKaitibaogaoContent(String kaitibaogaoContent) {
        this.kaitibaogaoContent = kaitibaogaoContent;
    }
    /**
	 * 设置：中期报告
	 */
    public String getZhongqiFile() {
        return zhongqiFile;
    }


    /**
	 * 获取：中期报告
	 */

    public void setZhongqiFile(String zhongqiFile) {
        this.zhongqiFile = zhongqiFile;
    }
    /**
	 * 设置：修改意见
	 */
    public String getZhongqiContent() {
        return zhongqiContent;
    }


    /**
	 * 获取：修改意见
	 */

    public void setZhongqiContent(String zhongqiContent) {
        this.zhongqiContent = zhongqiContent;
    }
    /**
	 * 设置：论文
	 */
    public String getLuenwenFile() {
        return luenwenFile;
    }


    /**
	 * 获取：论文
	 */

    public void setLuenwenFile(String luenwenFile) {
        this.luenwenFile = luenwenFile;
    }
    /**
	 * 设置：修改意见
	 */
    public String getLuenwenContent() {
        return luenwenContent;
    }


    /**
	 * 获取：修改意见
	 */

    public void setLuenwenContent(String luenwenContent) {
        this.luenwenContent = luenwenContent;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getXuantiTypes() {
        return xuantiTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setXuantiTypes(Integer xuantiTypes) {
        this.xuantiTypes = xuantiTypes;
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

    @Override
    public String toString() {
        return "Xuanti{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", jiaoshiId=" + jiaoshiId +
            ", shejitimuId=" + shejitimuId +
            ", kaitibaogaoFile=" + kaitibaogaoFile +
            ", kaitibaogaoContent=" + kaitibaogaoContent +
            ", zhongqiFile=" + zhongqiFile +
            ", zhongqiContent=" + zhongqiContent +
            ", luenwenFile=" + luenwenFile +
            ", luenwenContent=" + luenwenContent +
            ", xuantiTypes=" + xuantiTypes +
            ", createTime=" + createTime +
        "}";
    }
}
