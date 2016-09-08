package cn.json.branch.cust;

import cn.json.branch.adapter.JsonAdapter;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.math.BigDecimal;

/**
 * Created by syq on 2016/7/23.
 */
public class GsonAdapter extends JsonAdapter<JsonObject> {


    @Override
    public JsonObject parseJsonToObj(String jsonStr) {
        JsonParser jsonParser = new JsonParser();
        return (JsonObject) jsonParser.parse(jsonStr);
    }

    @Override
    public String jsonObjToStr(JsonObject jsonObject) {
        return jsonObject.getAsString();
    }

    @Override
    public JsonObject[] getJsonObjArray(JsonObject jsonObject, String key) {
        JsonArray array = jsonObject.get(key).getAsJsonArray();
        JsonObject[] jsonObjs = new JsonObject[array.size()];
        for (int i = 0; i < array.size(); i++) {
            jsonObjs[i] = array.get(i).getAsJsonObject();
        }
        return jsonObjs;
    }

    @Override
    public Integer[] getIntArray(JsonObject jsonObject, String key) {
        JsonArray array = jsonObject.get(key).getAsJsonArray();
        Integer[] intArray = new Integer[array.size()];
        for (int i = 0; i < array.size(); i++) {
            intArray[i] = array.get(i).getAsInt();
        }
        return intArray;
    }

    @Override
    public Long[] getLongArray(JsonObject jsonObject, String key) {
        JsonArray array = jsonObject.get(key).getAsJsonArray();
        Long[] longArray = new Long[array.size()];
        for (int i = 0; i < array.size(); i++) {
            longArray[i] = array.get(i).getAsLong();
        }
        return longArray;
    }

    @Override
    public Double[] getDoubleArray(JsonObject jsonObject, String key) {
        JsonArray array = jsonObject.get(key).getAsJsonArray();
        Double[] doubleArray = new Double[array.size()];
        for (int i = 0; i < array.size(); i++) {
            doubleArray[i] = array.get(i).getAsDouble();
        }
        return doubleArray;
    }

    @Override
    public Float[] getFloatArray(JsonObject jsonObject, String key) {
        JsonArray array = jsonObject.get(key).getAsJsonArray();
        Float[] floatArray = new Float[array.size()];
        for (int i = 0; i < array.size(); i++) {
            floatArray[i] = array.get(i).getAsFloat();
        }
        return floatArray;
    }

    @Override
    public String[] getStringArray(JsonObject jsonObject, String key) {
        JsonArray array = jsonObject.get(key).getAsJsonArray();
        String[] strArray = new String[array.size()];
        for (int i = 0; i < array.size(); i++) {
            strArray[i] = array.get(i).getAsString();
        }
        return strArray;
    }

    @Override
     public BigDecimal[] getDecimalArray(JsonObject jsonObject, String key) {
        JsonArray array = jsonObject.get(key).getAsJsonArray();
        BigDecimal[] bigDecimalArray = new BigDecimal[array.size()];
        for (int i = 0; i < array.size(); i++) {
            bigDecimalArray[i] = array.get(i).getAsBigDecimal();
        }
        return bigDecimalArray;
    }


    @Override
    public JsonObject getJsonObj(JsonObject jsonObject, String key) {
        return jsonObject.get(key).getAsJsonObject();
    }

    @Override
    public Long getLong(JsonObject jsonObject, String key) {
        return jsonObject.get(key).getAsLong();
    }

    @Override
    public Integer getInt(JsonObject jsonObject, String key) {
        return jsonObject.get(key).getAsInt();
    }

    @Override
    public Double getDouble(JsonObject jsonObject, String key) {
        return jsonObject.get(key).getAsDouble();
    }

    @Override
    public Float getFloat(JsonObject jsonObject, String key) {
        return jsonObject.get(key).getAsFloat();
    }

    @Override
    public String getString(JsonObject jsonObject, String key) {
        return jsonObject.get(key).getAsString();
    }

    @Override
    public BigDecimal getDecimal(JsonObject jsonObject, String key) {
        return jsonObject.get(key).getAsBigDecimal();
    }

}
