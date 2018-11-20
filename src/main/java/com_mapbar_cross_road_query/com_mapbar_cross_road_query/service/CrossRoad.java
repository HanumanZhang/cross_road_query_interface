package com_mapbar_cross_road_query.com_mapbar_cross_road_query.service;

import net.sf.json.JSONArray;

public interface CrossRoad {
    public JSONArray getDatadiffByRoadId(int roadIdOne, int roadIdTwo);
}
