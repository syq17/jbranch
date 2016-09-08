package cn.json.branch.cust;

import cn.json.branch.anno.AutoJsonSetter;
import cn.json.branch.anno.Types;
import com.alibaba.fastjson.JSONObject;


/**
 * Created by syq on 2016/7/25.
 */
public class MyResponse {


    @AutoJsonSetter(value = {"resData", "data", "list", "addIp"},
            type = {Types.JSON_OBJECT, Types.JSON_OBJECT, Types.JSON_OBJECT_ARRAY, Types.STRING})
    private String[] addip;

    @AutoJsonSetter(value = {"resData", "data", "page"}, type = {Types.JSON_OBJECT, Types.JSON_OBJECT, Types.JSON_OBJECT})
    private JSONObject page;

    @AutoJsonSetter(value = {"resMsg"}, type = {Types.STRING})
    private String resMsg;

    @AutoJsonSetter(value = {"resData", "data", "array"}, type = {Types.JSON_OBJECT, Types.JSON_OBJECT, Types.INT_ARRAY})
    private Integer[] arry;
//
    @AutoJsonSetter(value = {"resData", "data", "list"}, type = {Types.JSON_OBJECT, Types.JSON_OBJECT, Types.JSON_OBJECT_ARRAY})
    private JSONObject[] list;
////
    @AutoJsonSetter(value = {"resData", "data", "list", "site", "addIp"},
            type = {Types.JSON_OBJECT, Types.JSON_OBJECT, Types.JSON_OBJECT_ARRAY, Types.JSON_OBJECT, Types.STRING})
    private String[] innerAddip;



    public String[] getAddip() {
        return addip;
    }

    public void setAddip(String[] addip) {
        this.addip = addip;
    }



//    public String getResMsg() {
//        return resMsg;
//    }
//
//    public void setResMsg(String resMsg) {
//        this.resMsg = resMsg;
//    }
//
//    public Integer[] getArry() {
//        return arry;
//    }
//
//    public void setArry(Integer[] arry) {
//        this.arry = arry;
//    }
//////
//////
//////
//    public String[] getInnerAddip() {
//        return innerAddip;
//    }
//
//    public void setInnerAddip(String[] innerAddip) {
//        this.innerAddip = innerAddip;
//    }
//////
//    public JSONObject[] getList() {
//        return list;
//    }
//
//    public void setList(JSONObject[] list) {
//        this.list = list;
//    }
//
//    public JSONObject getPage() {
//        return page;
//    }
//
//    public void setPage(JSONObject page) {
//        this.page = page;
//    }
}
