package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.*;
import com.service.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.view.XuantishenheView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 选题审核
 * 后端接口
 * @author
 * @email
 * @date 2021-04-23
*/
@RestController
@Controller
@RequestMapping("/xuantishenhe")
public class XuantishenheController {
    private static final Logger logger = LoggerFactory.getLogger(XuantishenheController.class);

    @Autowired
    private XuantishenheService xuantishenheService;


    @Autowired
    private XuantiService xuantiService;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private JiaoshiService jiaoshiService;
    @Autowired
    private ShejitimuService shejitimuService;
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
     
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }else if(StringUtil.isNotEmpty(role) && "教师".equals(role)){
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = xuantishenheService.queryPage(params);

        //字典表数据转换
        List<XuantishenheView> list =(List<XuantishenheView>)page.getList();
        for(XuantishenheView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuantishenheEntity xuantishenhe = xuantishenheService.selectById(id);
        if(xuantishenhe !=null){
            //entity转view
            XuantishenheView view = new XuantishenheView();
            BeanUtils.copyProperties( xuantishenhe , view );//把实体数据重构到view中

            //级联表
            JiaoshiEntity jiaoshi = jiaoshiService.selectById(xuantishenhe.getJiaoshiId());
            if(jiaoshi != null){
                BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setJiaoshiId(jiaoshi.getId());
            }
            //级联表
            ShejitimuEntity shejitimu = shejitimuService.selectById(xuantishenhe.getShejitimuId());
            if(shejitimu != null){
                BeanUtils.copyProperties( shejitimu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setShejitimuId(shejitimu.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xuantishenhe.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XuantishenheEntity xuantishenhe, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuantishenhe:{}",this.getClass().getName(),xuantishenhe.toString());
        Wrapper<XuantishenheEntity> queryWrapper = new EntityWrapper<XuantishenheEntity>()
            .eq("yonghu_id", xuantishenhe.getYonghuId())
            .in("xuantishenhe_types", new Integer[]{1,2})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuantishenheEntity xuantishenheEntity = xuantishenheService.selectOne(queryWrapper);
        if(xuantishenheEntity==null){
            xuantishenhe.setCreateTime(new Date());
            xuantishenheService.insert(xuantishenhe);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuantishenheEntity xuantishenhe, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xuantishenhe:{}",this.getClass().getName(),xuantishenhe.toString());
        //根据字段查询是否有相同数据
        Wrapper<XuantishenheEntity> queryWrapper = new EntityWrapper<XuantishenheEntity>()
            .notIn("id",xuantishenhe.getId())
            .andNew()
            .eq("yonghu_id", xuantishenhe.getYonghuId())
            .eq("jiaoshi_id", xuantishenhe.getJiaoshiId())
            .eq("shejitimu_id", xuantishenhe.getShejitimuId())
            .eq("xuantishenhe_types", xuantishenhe.getXuantishenheTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuantishenheEntity xuantishenheEntity = xuantishenheService.selectOne(queryWrapper);
        if(xuantishenheEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      xuantishenhe.set
            //  }
            xuantishenheService.updateById(xuantishenhe);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xuantishenheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 审核
     */
    @RequestMapping("/shenhe")
    public R shenhe(Integer ids,Integer zhuangtai, HttpServletRequest request){
        //shejitimuService.selectById(ids);
        XuantishenheEntity xuantishenhe = xuantishenheService.selectById(ids);
        if(xuantishenhe == null){
            return R.error();
        }
        xuantishenhe.setXuantishenheTypes(zhuangtai);
        boolean b = xuantishenheService.updateById(xuantishenhe);
        ShejitimuEntity shejitimuEntity = new ShejitimuEntity();
        if(b){
            if(zhuangtai == 2){
                XuantiEntity xuanti = new XuantiEntity();
                xuanti.setCreateTime(new Date());
                xuanti.setJiaoshiId(xuantishenhe.getJiaoshiId());
                xuanti.setShejitimuId(xuantishenhe.getShejitimuId());
                xuanti.setYonghuId(xuantishenhe.getYonghuId());
                xuanti.setXuantiTypes(1);
                boolean insert = xuantiService.insert(xuanti);
                shejitimuEntity.setId(xuantishenhe.getShejitimuId());
                shejitimuEntity.setZhuangtaiTypes(4);
                if(!insert){
                    return R.error();
                }
            }else{
                shejitimuEntity.setId(xuantishenhe.getShejitimuId());
                shejitimuEntity.setZhuangtaiTypes(2);
            }
            shejitimuService.updateById(shejitimuEntity);
            return R.ok();
        }
        return R.error();
    }
    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }else if(StringUtil.isNotEmpty(role) && "教师".equals(role)){
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = xuantishenheService.queryPage(params);

        //字典表数据转换
        List<XuantishenheView> list =(List<XuantishenheView>)page.getList();
        for(XuantishenheView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuantishenheEntity xuantishenhe = xuantishenheService.selectById(id);
            if(xuantishenhe !=null){
                //entity转view
        XuantishenheView view = new XuantishenheView();
                BeanUtils.copyProperties( xuantishenhe , view );//把实体数据重构到view中

                //级联表
                    JiaoshiEntity jiaoshi = jiaoshiService.selectById(xuantishenhe.getJiaoshiId());
                if(jiaoshi != null){
                    BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshiId(jiaoshi.getId());
                }
                //级联表
                    ShejitimuEntity shejitimu = shejitimuService.selectById(xuantishenhe.getShejitimuId());
                if(shejitimu != null){
                    BeanUtils.copyProperties( shejitimu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShejitimuId(shejitimu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xuantishenhe.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XuantishenheEntity xuantishenhe, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xuantishenhe:{}",this.getClass().getName(),xuantishenhe.toString());
        Wrapper<XuantishenheEntity> queryWrapper = new EntityWrapper<XuantishenheEntity>()
            .eq("yonghu_id", xuantishenhe.getYonghuId())
            .eq("jiaoshi_id", xuantishenhe.getJiaoshiId())
            .eq("shejitimu_id", xuantishenhe.getShejitimuId())
            .eq("xuantishenhe_types", xuantishenhe.getXuantishenheTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    XuantishenheEntity xuantishenheEntity = xuantishenheService.selectOne(queryWrapper);
        if(xuantishenheEntity==null){
            xuantishenhe.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      xuantishenhe.set
        //  }
        xuantishenheService.insert(xuantishenhe);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }





}

