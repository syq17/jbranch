package cn.json.branch.client;

import cn.json.branch.adapter.JsonAdapter;
import cn.json.branch.adapter.JsonAdapterFactory;
import cn.json.branch.adapter.JsonAdapterStrategy;
import cn.json.branch.anno.AutoJsonSetter;
import cn.json.branch.anno.generator.JsonNodeContainer;
import cn.json.branch.anno.generator.ReptilesFutureTask;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @AutoJsonSetter注解解析类 Created by syq on 2016/7/23.
 */
public class AutoJsonSetterGenerator {


    /**
     * 新的设计思路，对获取到的路径进行规划，找出最短的路径去通向所有目标
     *
     * @param jsonStr       需要解析的原始json串
     * @param targetClazz   需要被自动设置的目标类型
     * @param strategyClazz json解析适配器的生成策略类型
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T autoSetter(final String jsonStr, Class<T> targetClazz, Class<? extends JsonAdapterStrategy> strategyClazz) throws Exception {
        T rsp = targetClazz.newInstance();
        /*获取用户设定的JsonAdapter*/
        JsonAdapter jsonAdapter = JsonAdapterFactory.getInstance().createAdapter(strategyClazz);
        assert jsonAdapter != null : "class type " + strategyClazz.getName() + " newInstance fail!";
        /*序列化原始json字符串为json对象*/
        final Object rootJsonObj = jsonAdapter.parseJsonToObj(jsonStr);

        /*开始反射clazz对象，获取对象中的所有属性*/
        Field[] fields = targetClazz.getDeclaredFields();
        List<ReptilesFutureTask> reptilesFutureTasks = new ArrayList<>(fields.length);
//        long for1 = System.nanoTime();
        for (Field field : fields) {
            AutoJsonSetter autoJsonSetter = field.getAnnotation(AutoJsonSetter.class);
            if (autoJsonSetter != null) {/*先过滤需要自动设值的属性*/
                ReptilesFutureTask reptilesFutureTask = new ReptilesFutureTask(rootJsonObj, autoJsonSetter.value(), autoJsonSetter.type(), jsonAdapter);
                reptilesFutureTasks.add(reptilesFutureTask);
            }
        }
//        long for2 = System.nanoTime();
//        System.out.println("初始化耗时：" + (for2 - for1) / 1000000.00);
        /*并行解析所有需要自动设置的属性  Runtime.getRuntime().availableProcessors() */
        ExecutorService executor = Executors.newSingleThreadExecutor();
//        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<JsonNodeContainer>> results = executor.invokeAll(reptilesFutureTasks);


        for (int i = 0; i < results.size(); i++) {
            JsonNodeContainer container = results.get(i).get();
            fields[i].setAccessible(true);
            fields[i].set(rsp, container.getValue());
        }
        executor.shutdown();
//        long end2 = System.nanoTime();
//        System.out.println("递归过程耗时：" + (end2 - for2) / 1000000.00);
        return rsp;
    }


}
