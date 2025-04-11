package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.ToupiaoxinxiEntity;
import com.entity.XuantishenheEntity;
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

import com.entity.ShejitimuEntity;

import com.entity.view.ShejitimuView;
import com.entity.JiaoshiEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 设计题目
 * 后端接口
 * @author
 * @email
 * @date 2021-04-23
*/
@RestController
@Controller
@RequestMapping("/shejitimu")
public class ShejitimuController {
    private static final Logger logger = LoggerFactory.getLogger(ShejitimuController.class);

    @Autowired
    private ShejitimuService shejitimuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;


    @Autowired
    private XuantishenheService xuantishenheService;

    @Autowired
    private ToupiaoxinxiService toupiaoxinxiService;


    //级联表service
    @Autowired
    private JiaoshiService jiaoshiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
     
        String role = String.valueOf(request.getSession().getAttribute("role"));
        params.put("orderBy","id");
        PageUtils page = shejitimuService.queryPage(params);

        //字典表数据转换
        List<ShejitimuView> list =(List<ShejitimuView>)page.getList();
        for(ShejitimuView c:list){
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
        ShejitimuEntity shejitimu = shejitimuService.selectById(id);
        if(shejitimu !=null){
            //entity转view
            ShejitimuView view = new ShejitimuView();
            BeanUtils.copyProperties( shejitimu , view );//把实体数据重构到view中

            //级联表
            JiaoshiEntity jiaoshi = jiaoshiService.selectById(shejitimu.getJiaoshiId());
            if(jiaoshi != null){
                BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setJiaoshiId(jiaoshi.getId());
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
    public R save(@RequestBody ShejitimuEntity shejitimu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shejitimu:{}",this.getClass().getName(),shejitimu.toString());
        Wrapper<ShejitimuEntity> queryWrapper = new EntityWrapper<ShejitimuEntity>()
            .eq("shejitimu_name", shejitimu.getShejitimuName())
            .eq("jiaoshi_id", shejitimu.getJiaoshiId())
            .eq("shejitimu_types", shejitimu.getShejitimuTypes())
            .eq("shejitimu_zancheng", shejitimu.getShejitimuZancheng())
            .eq("shejitimu_fandui", shejitimu.getShejitimuFandui())
            .eq("zhuangtai_types", shejitimu.getZhuangtaiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShejitimuEntity shejitimuEntity = shejitimuService.selectOne(queryWrapper);
        if(shejitimuEntity==null){
            shejitimu.setInsertTime(new Date());
            shejitimu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      shejitimu.set
        //  }
            shejitimuService.insert(shejitimu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShejitimuEntity shejitimu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shejitimu:{}",this.getClass().getName(),shejitimu.toString());
        //根据字段查询是否有相同数据
        Wrapper<ShejitimuEntity> queryWrapper = new EntityWrapper<ShejitimuEntity>()
            .notIn("id",shejitimu.getId())
            .andNew()
            .eq("shejitimu_name", shejitimu.getShejitimuName())
            .eq("jiaoshi_id", shejitimu.getJiaoshiId())
            .eq("shejitimu_types", shejitimu.getShejitimuTypes())
            .eq("shejitimu_zancheng", shejitimu.getShejitimuZancheng())
            .eq("shejitimu_fandui", shejitimu.getShejitimuFandui())
            .eq("zhuangtai_types", shejitimu.getZhuangtaiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShejitimuEntity shejitimuEntity = shejitimuService.selectOne(queryWrapper);
        if(shejitimuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      shejitimu.set
            //  }
            shejitimuService.updateById(shejitimu);//根据id更新
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
        shejitimuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 投票 zhancheng
    */
    @RequestMapping("/fandui")
    public R fandui(Integer ids, HttpServletRequest request){
        ShejitimuEntity shejitimu = shejitimuService.selectById(ids);
        if(shejitimu == null){
            return R.error();
        }
        shejitimu.setShejitimuFandui(shejitimu.getShejitimuFandui()+1);
        ToupiaoxinxiEntity toupiaoxinxi = new ToupiaoxinxiEntity();
        toupiaoxinxi.setCreateTime(new Date());
        toupiaoxinxi.setInsertTime(new Date());
        toupiaoxinxi.setJiaoshiId((Integer)request.getSession().getAttribute("userId"));
        toupiaoxinxi.setShejitimuId(ids);
        Wrapper<ToupiaoxinxiEntity> queryWrapper = new EntityWrapper<ToupiaoxinxiEntity>()
                .eq("shejitimu_id", toupiaoxinxi.getShejitimuId())
                .eq("jiaoshi_id", toupiaoxinxi.getJiaoshiId())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ToupiaoxinxiEntity toupiaoxinxiEntity = toupiaoxinxiService.selectOne(queryWrapper);
        if(toupiaoxinxiEntity!=null){
            return R.error("你为这个项目，投过一票了");
        }
        boolean insert = toupiaoxinxiService.insert(toupiaoxinxi);
        if(insert){
            shejitimuService.updateById(shejitimu);
            return R.ok();
        }
        return R.error();
    }
    /**
    * 投票
    */
    @RequestMapping("/zhancheng")
    public R zhancheng(Integer ids, HttpServletRequest request){
        ShejitimuEntity shejitimu = shejitimuService.selectById(ids);
        if(shejitimu == null){
            return R.error();
        }
        shejitimu.setShejitimuZancheng(shejitimu.getShejitimuZancheng()+1);
        ToupiaoxinxiEntity toupiaoxinxi = new ToupiaoxinxiEntity();
        toupiaoxinxi.setCreateTime(new Date());
        toupiaoxinxi.setInsertTime(new Date());
        toupiaoxinxi.setJiaoshiId((Integer)request.getSession().getAttribute("userId"));
        toupiaoxinxi.setShejitimuId(ids);
        Wrapper<ToupiaoxinxiEntity> queryWrapper = new EntityWrapper<ToupiaoxinxiEntity>()
                .eq("shejitimu_id", toupiaoxinxi.getShejitimuId())
                .eq("jiaoshi_id", toupiaoxinxi.getJiaoshiId())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ToupiaoxinxiEntity toupiaoxinxiEntity = toupiaoxinxiService.selectOne(queryWrapper);
        if(toupiaoxinxiEntity!=null){
            return R.error("你为这个项目，投过一票了");
        }
        boolean insert = toupiaoxinxiService.insert(toupiaoxinxi);
        if(insert){
            shejitimuService.updateById(shejitimu);
            return R.ok();
        }
        return R.error();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(Integer ids,Integer zhuangtai, HttpServletRequest request){
        ShejitimuEntity shejitimu = shejitimuService.selectById(ids);
        if(shejitimu == null){
            return R.error();
        }
        shejitimu.setZhuangtaiTypes(zhuangtai);
        boolean b = shejitimuService.updateById(shejitimu);
        if(b){
            return R.ok();
        }
        return R.error();
    }

    /**
    * 选择项目
    */
    @RequestMapping("/xuanzhe")
    public R xuanzhe(Integer ids, HttpServletRequest request){
        ShejitimuEntity shejitimu = shejitimuService.selectById(ids);
        if(shejitimu == null){
            return R.error();
        }
        XuantishenheEntity xuantishenhe = new XuantishenheEntity();
        xuantishenhe.setCreateTime(new Date());
        xuantishenhe.setJiaoshiId(shejitimu.getJiaoshiId());
        xuantishenhe.setShejitimuId(shejitimu.getId());
        xuantishenhe.setXuantishenheTypes(1);
        xuantishenhe.setYonghuId((Integer)request.getSession().getAttribute("userId"));
        Wrapper<XuantishenheEntity> queryWrapper = new EntityWrapper<XuantishenheEntity>()
                .eq("yonghu_id", xuantishenhe.getYonghuId())
                .in("xuantishenhe_types", new Integer[]{1,2})
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuantishenheEntity xuantishenheEntity = xuantishenheService.selectOne(queryWrapper);
        if(xuantishenheEntity!=null){
            return R.error("你已经选毕业设计项目了");
        }

        ShejitimuEntity shejitimuEntity = new ShejitimuEntity();
        shejitimuEntity.setId(xuantishenhe.getShejitimuId());
        shejitimuEntity.setZhuangtaiTypes(4);
        shejitimuService.updateById(shejitimuEntity);
        boolean insert = xuantishenheService.insert(xuantishenhe);
        if(insert){
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
        PageUtils page = shejitimuService.queryPage(params);

        //字典表数据转换
        List<ShejitimuView> list =(List<ShejitimuView>)page.getList();
        for(ShejitimuView c:list){
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
        ShejitimuEntity shejitimu = shejitimuService.selectById(id);
            if(shejitimu !=null){
                //entity转view
        ShejitimuView view = new ShejitimuView();
                BeanUtils.copyProperties( shejitimu , view );//把实体数据重构到view中

                //级联表
                    JiaoshiEntity jiaoshi = jiaoshiService.selectById(shejitimu.getJiaoshiId());
                if(jiaoshi != null){
                    BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshiId(jiaoshi.getId());
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
    public R add(@RequestBody ShejitimuEntity shejitimu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shejitimu:{}",this.getClass().getName(),shejitimu.toString());
        Wrapper<ShejitimuEntity> queryWrapper = new EntityWrapper<ShejitimuEntity>()
            .eq("shejitimu_name", shejitimu.getShejitimuName())
            .eq("jiaoshi_id", shejitimu.getJiaoshiId())
            .eq("shejitimu_types", shejitimu.getShejitimuTypes())
            .eq("shejitimu_zancheng", shejitimu.getShejitimuZancheng())
            .eq("shejitimu_fandui", shejitimu.getShejitimuFandui())
            .eq("zhuangtai_types", shejitimu.getZhuangtaiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    ShejitimuEntity shejitimuEntity = shejitimuService.selectOne(queryWrapper);
        if(shejitimuEntity==null){
            shejitimu.setInsertTime(new Date());
            shejitimu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      shejitimu.set
        //  }
        shejitimuService.insert(shejitimu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }





}

