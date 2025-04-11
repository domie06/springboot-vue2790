package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.XuantiEntity;

import com.service.XuantiService;
import com.entity.view.XuantiView;
import com.service.JiaoshiService;
import com.entity.JiaoshiEntity;
import com.service.ShejitimuService;
import com.entity.ShejitimuEntity;
import com.service.YonghuService;
import com.entity.YonghuEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 选题信息
 * 后端接口
 * @author
 * @email
 * @date 2021-04-23
*/
@RestController
@Controller
@RequestMapping("/xuanti")
public class XuantiController {
    private static final Logger logger = LoggerFactory.getLogger(XuantiController.class);

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
        PageUtils page = xuantiService.queryPage(params);

        //字典表数据转换
        List<XuantiView> list =(List<XuantiView>)page.getList();
        for(XuantiView c:list){
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
        XuantiEntity xuanti = xuantiService.selectById(id);
        if(xuanti !=null){
            //entity转view
            XuantiView view = new XuantiView();
            BeanUtils.copyProperties( xuanti , view );//把实体数据重构到view中

            //级联表
            JiaoshiEntity jiaoshi = jiaoshiService.selectById(xuanti.getJiaoshiId());
            if(jiaoshi != null){
                BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setJiaoshiId(jiaoshi.getId());
            }
            //级联表
            ShejitimuEntity shejitimu = shejitimuService.selectById(xuanti.getShejitimuId());
            if(shejitimu != null){
                BeanUtils.copyProperties( shejitimu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setShejitimuId(shejitimu.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xuanti.getYonghuId());
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
    public R save(@RequestBody XuantiEntity xuanti, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuanti:{}",this.getClass().getName(),xuanti.toString());
        Wrapper<XuantiEntity> queryWrapper = new EntityWrapper<XuantiEntity>()
            .eq("yonghu_id", xuanti.getYonghuId())
            .eq("jiaoshi_id", xuanti.getJiaoshiId())
            .eq("shejitimu_id", xuanti.getShejitimuId())
            .eq("xuanti_types", xuanti.getXuantiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuantiEntity xuantiEntity = xuantiService.selectOne(queryWrapper);
        if(xuantiEntity==null){
            xuanti.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      xuanti.set
        //  }
            xuantiService.insert(xuanti);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuantiEntity xuanti, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xuanti:{}",this.getClass().getName(),xuanti.toString());
        //根据字段查询是否有相同数据
        Wrapper<XuantiEntity> queryWrapper = new EntityWrapper<XuantiEntity>()
            .notIn("id",xuanti.getId())
            .andNew()
            .eq("yonghu_id", xuanti.getYonghuId())
            .eq("jiaoshi_id", xuanti.getJiaoshiId())
            .eq("shejitimu_id", xuanti.getShejitimuId())
            .eq("xuanti_types", xuanti.getXuantiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuantiEntity xuantiEntity = xuantiService.selectOne(queryWrapper);
        if("".equals(xuanti.getKaitibaogaoFile()) || "null".equals(xuanti.getKaitibaogaoFile())){
                xuanti.setKaitibaogaoFile(null);
        }
        if("".equals(xuanti.getZhongqiFile()) || "null".equals(xuanti.getZhongqiFile())){
                xuanti.setZhongqiFile(null);
        }
        if("".equals(xuanti.getLuenwenFile()) || "null".equals(xuanti.getLuenwenFile())){
                xuanti.setLuenwenFile(null);
        }
        if(xuantiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      xuanti.set
            //  }
            xuantiService.updateById(xuanti);//根据id更新
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
        xuantiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shenhe")
    public R shenhe(Integer ids,Integer zhuangtai, String neirong, HttpServletRequest request){
        XuantiEntity xuanti = xuantiService.selectById(ids);
        if(xuanti == null){
            return R.error();
        }
        if(xuanti.getXuantiTypes() == 1 || xuanti.getXuantiTypes() == 3){
            if(StringUtils.isBlank(neirong)){
                xuanti.setKaitibaogaoContent("审核通过");
            }else{
                xuanti.setKaitibaogaoContent(neirong);
            }
        }else if(xuanti.getXuantiTypes() == 2 || xuanti.getXuantiTypes() == 5){
            if(StringUtils.isBlank(neirong)){
                xuanti.setZhongqiContent("审核通过");
            }else{
                xuanti.setZhongqiContent(neirong);
            }
        }else if(xuanti.getXuantiTypes() == 4 || xuanti.getXuantiTypes() == 6){
            if(StringUtils.isBlank(neirong)){
                xuanti.setLuenwenContent("审核通过");
            }else{
                xuanti.setLuenwenContent(neirong);
            }
        }
        xuanti.setXuantiTypes(zhuangtai);
        boolean b = xuantiService.updateById(xuanti);
        if(b){
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
        PageUtils page = xuantiService.queryPage(params);

        //字典表数据转换
        List<XuantiView> list =(List<XuantiView>)page.getList();
        for(XuantiView c:list){
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
        XuantiEntity xuanti = xuantiService.selectById(id);
            if(xuanti !=null){
                //entity转view
        XuantiView view = new XuantiView();
                BeanUtils.copyProperties( xuanti , view );//把实体数据重构到view中

                //级联表
                    JiaoshiEntity jiaoshi = jiaoshiService.selectById(xuanti.getJiaoshiId());
                if(jiaoshi != null){
                    BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshiId(jiaoshi.getId());
                }
                //级联表
                    ShejitimuEntity shejitimu = shejitimuService.selectById(xuanti.getShejitimuId());
                if(shejitimu != null){
                    BeanUtils.copyProperties( shejitimu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShejitimuId(shejitimu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xuanti.getYonghuId());
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
    public R add(@RequestBody XuantiEntity xuanti, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xuanti:{}",this.getClass().getName(),xuanti.toString());
        Wrapper<XuantiEntity> queryWrapper = new EntityWrapper<XuantiEntity>()
            .eq("yonghu_id", xuanti.getYonghuId())
            .eq("jiaoshi_id", xuanti.getJiaoshiId())
            .eq("shejitimu_id", xuanti.getShejitimuId())
            .eq("xuanti_types", xuanti.getXuantiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    XuantiEntity xuantiEntity = xuantiService.selectOne(queryWrapper);
        if(xuantiEntity==null){
            xuanti.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      xuanti.set
        //  }
        xuantiService.insert(xuanti);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }





}

