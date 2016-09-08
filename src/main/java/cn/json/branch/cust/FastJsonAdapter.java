package cn.json.branch.cust;

import cn.json.branch.adapter.JsonAdapter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;

/**
 * Created by syq on 2016/7/27.
 */
public class FastJsonAdapter extends JsonAdapter<JSONObject>{
    @Override
    public JSONObject parseJsonToObj(String jsonStr) {
        return JSON.parseObject(jsonStr);
    }

    @Override
    public String jsonObjToStr(JSONObject jsonObject) {
        return jsonObject.toJSONString();
    }

    @Override
    public JSONObject[] getJsonObjArray(JSONObject jsonObject, String key) {
        JSONArray array = jsonObject.getJSONArray(key);
        JSONObject[] jsonObjects = new JSONObject[array.size()];
        for (int i = 0; i < array.size(); i++) {
            jsonObjects[i] = array.getJSONObject(i);
        }
        return jsonObjects;
    }

    @Override
    public Integer[] getIntArray(JSONObject jsonObject, String key) {
        JSONArray array = jsonObject.getJSONArray(key);
        return array.toArray(new Integer[array.size()]);
    }

    @Override
    public Long[] getLongArray(JSONObject jsonObject, String key) {
        JSONArray array = jsonObject.getJSONArray(key);
        return array.toArray(new Long[array.size()]);
    }

    @Override
    public Double[] getDoubleArray(JSONObject jsonObject, String key) {
        JSONArray array = jsonObject.getJSONArray(key);
        return array.toArray(new Double[array.size()]);
    }

    @Override
    public Float[] getFloatArray(JSONObject jsonObject, String key) {
        JSONArray array = jsonObject.getJSONArray(key);
        return array.toArray(new Float[array.size()]);
    }

    @Override
    public String[] getStringArray(JSONObject jsonObject, String key) {
        JSONArray array = jsonObject.getJSONArray(key);
        return array.toArray(new String[array.size()]);
    }

    @Override
    public BigDecimal[] getDecimalArray(JSONObject jsonObject, String key) {
        JSONArray array = jsonObject.getJSONArray(key);
        return array.toArray(new BigDecimal[array.size()]);
    }

    @Override
    public Object getJsonObj(JSONObject jsonObject, String key) {
        return jsonObject.getJSONObject(key);
    }

    @Override
    public Long getLong(JSONObject jsonObject, String key) {
        return jsonObject.getLong(key);
    }

    @Override
    public Integer getInt(JSONObject jsonObject, String key) {
        return jsonObject.getInteger(key);
    }

    @Override
    public Double getDouble(JSONObject jsonObject, String key) {
        return jsonObject.getDouble(key);
    }

    @Override
    public Float getFloat(JSONObject jsonObject, String key) {
        return jsonObject.getFloat(key);
    }

    @Override
    public String getString(JSONObject jsonObject, String key) {
        return jsonObject.getString(key);
    }

    @Override
    public BigDecimal getDecimal(JSONObject jsonObject, String key) {
        return jsonObject.getBigDecimal(key);
    }
}
