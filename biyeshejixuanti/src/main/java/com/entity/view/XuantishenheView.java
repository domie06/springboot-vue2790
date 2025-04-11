package com.entity.view;

import com.entity.XuantishenheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 选题审核
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("xuantishenhe")
public class XuantishenheView extends XuantishenheEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 审核状态的值
		*/
		private String xuantishenheValue;



		//级联表 jiaoshi
			/**
			* 教师姓名
			*/
			private String jiaoshiName;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 身份证号
			*/
			private String jiaoshiIdNumber;
			/**
			* 手机号
			*/
			private String jiaoshiPhone;
			/**
			* 照片
			*/
			private String jiaoshiPhoto;

		//级联表 shejitimu
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
				* 项目类型的值
				*/
				private String shejitimuValue;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 发布时间
			*/
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
				* 审核状态的值
				*/
				private String zhuangtaiValue;
			/**
			* 项目内容
			*/
			private String shejitimuContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 照片
			*/
			private String yonghuPhoto;

	public XuantishenheView() {

	}

	public XuantishenheView(XuantishenheEntity xuantishenheEntity) {
		try {
			BeanUtils.copyProperties(this, xuantishenheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 审核状态的值
			*/
			public String getXuantishenheValue() {
				return xuantishenheValue;
			}
			/**
			* 设置： 审核状态的值
			*/
			public void setXuantishenheValue(String xuantishenheValue) {
				this.xuantishenheValue = xuantishenheValue;
			}









				//级联表的get和set jiaoshi
					/**
					* 获取： 教师姓名
					*/
					public String getJiaoshiName() {
						return jiaoshiName;
					}
					/**
					* 设置： 教师姓名
					*/
					public void setJiaoshiName(String jiaoshiName) {
						this.jiaoshiName = jiaoshiName;
					}
					/**
					* 获取： 身份证号
					*/
					public String getJiaoshiIdNumber() {
						return jiaoshiIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setJiaoshiIdNumber(String jiaoshiIdNumber) {
						this.jiaoshiIdNumber = jiaoshiIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getJiaoshiPhone() {
						return jiaoshiPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setJiaoshiPhone(String jiaoshiPhone) {
						this.jiaoshiPhone = jiaoshiPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getJiaoshiPhoto() {
						return jiaoshiPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setJiaoshiPhoto(String jiaoshiPhoto) {
						this.jiaoshiPhoto = jiaoshiPhoto;
					}









				//级联表的get和set shejitimu
					/**
					* 获取： 题目名称
					*/
					public String getShejitimuName() {
						return shejitimuName;
					}
					/**
					* 设置： 题目名称
					*/
					public void setShejitimuName(String shejitimuName) {
						this.shejitimuName = shejitimuName;
					}
					/**
					* 获取： 发布教师
					*/
					public Integer getJiaoshiId() {
						return jiaoshiId;
					}
					/**
					* 设置： 发布教师
					*/
					public void setJiaoshiId(Integer jiaoshiId) {
						this.jiaoshiId = jiaoshiId;
					}
					/**
					* 获取： 项目类型
					*/
					public Integer getShejitimuTypes() {
						return shejitimuTypes;
					}
					/**
					* 设置： 项目类型
					*/
					public void setShejitimuTypes(Integer shejitimuTypes) {
						this.shejitimuTypes = shejitimuTypes;
					}


						/**
						* 获取： 项目类型的值
						*/
						public String getShejitimuValue() {
							return shejitimuValue;
						}
						/**
						* 设置： 项目类型的值
						*/
						public void setShejitimuValue(String shejitimuValue) {
							this.shejitimuValue = shejitimuValue;
						}
					/**
					* 获取： 发布时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 发布时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}
					/**
					* 获取： 赞成票
					*/
					public Integer getShejitimuZancheng() {
						return shejitimuZancheng;
					}
					/**
					* 设置： 赞成票
					*/
					public void setShejitimuZancheng(Integer shejitimuZancheng) {
						this.shejitimuZancheng = shejitimuZancheng;
					}
					/**
					* 获取： 反对票
					*/
					public Integer getShejitimuFandui() {
						return shejitimuFandui;
					}
					/**
					* 设置： 反对票
					*/
					public void setShejitimuFandui(Integer shejitimuFandui) {
						this.shejitimuFandui = shejitimuFandui;
					}
					/**
					* 获取： 审核状态
					*/
					public Integer getZhuangtaiTypes() {
						return zhuangtaiTypes;
					}
					/**
					* 设置： 审核状态
					*/
					public void setZhuangtaiTypes(Integer zhuangtaiTypes) {
						this.zhuangtaiTypes = zhuangtaiTypes;
					}


						/**
						* 获取： 审核状态的值
						*/
						public String getZhuangtaiValue() {
							return zhuangtaiValue;
						}
						/**
						* 设置： 审核状态的值
						*/
						public void setZhuangtaiValue(String zhuangtaiValue) {
							this.zhuangtaiValue = zhuangtaiValue;
						}
					/**
					* 获取： 项目内容
					*/
					public String getShejitimuContent() {
						return shejitimuContent;
					}
					/**
					* 设置： 项目内容
					*/
					public void setShejitimuContent(String shejitimuContent) {
						this.shejitimuContent = shejitimuContent;
					}














				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}






}
