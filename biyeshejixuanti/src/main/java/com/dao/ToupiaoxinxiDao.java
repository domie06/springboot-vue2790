package com.dao;

import com.entity.ToupiaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ToupiaoxinxiView;

/**
 * 投票记录 Dao 接口
 *
 * @author 
 * @since 2021-04-23
 */
public interface ToupiaoxinxiDao extends BaseMapper<ToupiaoxinxiEntity> {

   List<ToupiaoxinxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
