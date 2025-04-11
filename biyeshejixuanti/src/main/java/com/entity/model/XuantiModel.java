package com.entity.model;

import com.entity.XuantiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 选题信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-23
 */
public class XuantiModel implements Serializable {
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
     * 开题报告
     */
    private String kaitibaogaoFile;


    /**
     * 修改意见
     */
    private String kaitibaogaoContent;


    /**
     * 中期报告
     */
    private String zhongqiFile;


    /**
     * 修改意见
     */
    private String zhongqiContent;


    /**
     * 论文
     */
    private String luenwenFile;


    /**
     * 修改意见
     */
    private String luenwenContent;


    /**
     * 审核状态
     */
    private Integer xuantiTypes;


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
	 * 获取：开题报告
	 */
    public String getKaitibaogaoFile() {
        return kaitibaogaoFile;
    }


    /**
	 * 设置：开题报告
	 */
    public void setKaitibaogaoFile(String kaitibaogaoFile) {
        this.kaitibaogaoFile = kaitibaogaoFile;
    }
    /**
	 * 获取：修改意见
	 */
    public String getKaitibaogaoContent() {
        return kaitibaogaoContent;
    }


    /**
	 * 设置：修改意见
	 */
    public void setKaitibaogaoContent(String kaitibaogaoContent) {
        this.kaitibaogaoContent = kaitibaogaoContent;
    }
    /**
	 * 获取：中期报告
	 */
    public String getZhongqiFile() {
        return zhongqiFile;
    }


    /**
	 * 设置：中期报告
	 */
    public void setZhongqiFile(String zhongqiFile) {
        this.zhongqiFile = zhongqiFile;
    }
    /**
	 * 获取：修改意见
	 */
    public String getZhongqiContent() {
        return zhongqiContent;
    }


    /**
	 * 设置：修改意见
	 */
    public void setZhongqiContent(String zhongqiContent) {
        this.zhongqiContent = zhongqiContent;
    }
    /**
	 * 获取：论文
	 */
    public String getLuenwenFile() {
        return luenwenFile;
    }


    /**
	 * 设置：论文
	 */
    public void setLuenwenFile(String luenwenFile) {
        this.luenwenFile = luenwenFile;
    }
    /**
	 * 获取：修改意见
	 */
    public String getLuenwenContent() {
        return luenwenContent;
    }


    /**
	 * 设置：修改意见
	 */
    public void setLuenwenContent(String luenwenContent) {
        this.luenwenContent = luenwenContent;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getXuantiTypes() {
        return xuantiTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setXuantiTypes(Integer xuantiTypes) {
        this.xuantiTypes = xuantiTypes;
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
