package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.XuantishenheDao;
import com.entity.XuantishenheEntity;
import com.service.XuantishenheService;
import com.entity.view.XuantishenheView;

/**
 * 选题审核 服务实现类
 * @author 
 * @since 2021-04-23
 */
@Service("xuantishenheService")
@Transactional
public class XuantishenheServiceImpl extends ServiceImpl<XuantishenheDao, XuantishenheEntity> implements XuantishenheService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<XuantishenheView> page =new Query<XuantishenheView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
