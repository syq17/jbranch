package cn.json.branch.adapter;

import java.math.BigDecimal;

/**
 * 待适配接口
 * 泛型T 表示为JsonObject类型
 * Created by syq on 2016/7/23.
 */
public abstract class JsonAdapter<T> implements Adapter<T> {



    /**
     * 待适配方法
     * 将json的字符串转化为json对象，这里的T类型指各个json组件的jsonObject类型
     *
     * @param jsonStr
     * @return
     */
    public abstract T parseJsonToObj(String jsonStr);


    /**
     * 待适配方法
     * 将jsonObj类型转化为string
     * @param t
     * @return
     */
    public abstract String jsonObjToStr(T t);


    /**
     * 将key对应的值转为jsonObj数组
     * @param t
     * @param key
     * @return
     */
    public abstract T[] getJsonObjArray(T t, String key);

    /**
     * 待适配方法
     * 根据key获取json数组，请自行转化数组类型
     *
     * @param key
     * @return
     */
    public abstract Integer[] getIntArray(T t, String key);

    /**
     * 将key对应的值转为Long数组
     * @param t
     * @param key
     * @return
     */
    public abstract Long[] getLongArray(T t, String key);


    /**
     * 将key对应的值转为Double数组
     * @param t
     * @param key
     * @return
     */
    public abstract Double[] getDoubleArray(T t, String key);

    /**
     * 将key对应的值转为Float数组
     * @param t
     * @param key
     * @return
     */
    public abstract Float[] getFloatArray(T t, String key);


    /**
     * 将key对应的值转为String数组
     * @param t
     * @param key
     * @return
     */
    public abstract String[] getStringArray(T t, String key);


    /**
     * 将key对应的值转为BigDecimal数组
     * @param t
     * @param key
     * @return
     */
    public abstract BigDecimal[] getDecimalArray(T t, String key);


    /**
     * 待适配方法
     * 根据key获取json对象
     *
     * @param key
     * @return
     */
    public abstract Object getJsonObj(T t, String key);

    /**
     * 待适配方法
     * 根据key获取对应的json的long值类型
     *
     * @param key
     * @return
     */
    public abstract Long getLong(T t, String key);


    /**
     * 待适配方法
     * 根据key获取对应的json的int值类型
     *
     * @param key
     * @return
     */
    public abstract Integer getInt(T t, String key);

    /**
     * 待适配方法
     * 根据key获取对应的json的double值类型
     *
     * @param key
     * @return
     */
    public abstract Double getDouble(T t, String key);

    /**
     * 待适配方法
     * 根据key获取对应的json的float值类型
     *
     * @param key
     * @return
     */
    public abstract Float getFloat(T t, String key);

    /**
     * 待适配方法
     * 根据key获取对应的json的String值类型
     *
     * @param key
     * @return
     */
    public abstract String getString(T t, String key);

    /**
     * 待适配方法
     * 根据key获取对应的json的Decimal值类型
     *
     * @param key
     * @return
     */
    public abstract BigDecimal getDecimal(T t, String key);

}
