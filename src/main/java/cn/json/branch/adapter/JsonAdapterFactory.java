package cn.json.branch.adapter;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 考虑为每个adapter类实现缓存
 * Created by syq on 2016/7/23.
 */
public class JsonAdapterFactory {


    public static final JsonAdapterFactory instance = new JsonAdapterFactory();
    private static final ConcurrentHashMap<String, JsonAdapterStrategy> CACHEADAPTERSTRATEGY = new ConcurrentHashMap<>();

    public static JsonAdapterFactory getInstance() {
        return instance;
    }

    public JsonAdapter createAdapter(Class<? extends JsonAdapterStrategy> clazz) {
        try {
            JsonAdapterStrategy strategyInMap = CACHEADAPTERSTRATEGY.get(clazz.getName());
            if(strategyInMap == null){
                strategyInMap = clazz.newInstance();
                JsonAdapterStrategy strategyReutrn = CACHEADAPTERSTRATEGY.putIfAbsent(clazz.getName(),strategyInMap);
                if(strategyReutrn != null){
                    strategyInMap = strategyReutrn;
                }
            }
            return strategyInMap.getAdapter();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


}
