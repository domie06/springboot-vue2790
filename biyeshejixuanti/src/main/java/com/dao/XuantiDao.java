package com.dao;

import com.entity.XuantiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuantiView;

/**
 * 选题信息 Dao 接口
 *
 * @author 
 * @since 2021-04-23
 */
public interface XuantiDao extends BaseMapper<XuantiEntity> {

   List<XuantiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
