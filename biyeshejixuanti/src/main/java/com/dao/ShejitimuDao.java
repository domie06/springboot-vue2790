package com.dao;

import com.entity.ShejitimuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShejitimuView;

/**
 * 设计题目 Dao 接口
 *
 * @author 
 * @since 2021-04-23
 */
public interface ShejitimuDao extends BaseMapper<ShejitimuEntity> {

   List<ShejitimuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
