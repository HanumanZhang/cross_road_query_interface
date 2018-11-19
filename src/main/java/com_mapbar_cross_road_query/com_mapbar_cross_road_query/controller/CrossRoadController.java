package com_mapbar_cross_road_query.com_mapbar_cross_road_query.controller;

import com_mapbar_cross_road_query.com_mapbar_cross_road_query.common.BaseAction;
import com_mapbar_cross_road_query.com_mapbar_cross_road_query.common.EnumResultCode;
import com_mapbar_cross_road_query.com_mapbar_cross_road_query.common.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CrossRoadController extends BaseAction {
    Logger logger= LoggerFactory.getLogger(CrossRoadController.class);
    @RequestMapping(value="/test")
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultBean resultBean=new ResultBean();
        logger.info("业务处理---------------------------------");
        resultBean.setData("测试");
        resultBean.fillResult(EnumResultCode.SUCCESS);
        this.sendJson(response, resultBean);
    }
}
