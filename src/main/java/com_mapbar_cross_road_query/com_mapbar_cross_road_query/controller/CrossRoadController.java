package com_mapbar_cross_road_query.com_mapbar_cross_road_query.controller;

import com_mapbar_cross_road_query.com_mapbar_cross_road_query.common.BaseAction;
import com_mapbar_cross_road_query.com_mapbar_cross_road_query.common.EnumResultCode;
import com_mapbar_cross_road_query.com_mapbar_cross_road_query.common.ResultBean;
import com_mapbar_cross_road_query.com_mapbar_cross_road_query.service.CrossRoad;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/cross")
public class CrossRoadController extends BaseAction {

    Logger logger= LoggerFactory.getLogger(CrossRoadController.class);

    @Autowired
    private CrossRoad crossRoad;

    @RequestMapping(value="/gettime", method = RequestMethod.GET)
    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultBean resultBean=new ResultBean();

        logger.info("业务处理---------------------------------");

        String roadOne = request.getParameter("roadOne");
        String roadTwo = request.getParameter("roadTwo");

        JSONArray data = crossRoad.getDatadiffByRoadId(Integer.parseInt(roadOne), Integer.parseInt(roadTwo));

        resultBean.setData(data);
        resultBean.fillResult(EnumResultCode.SUCCESS);
        this.sendJson(response, resultBean);
    }
}
