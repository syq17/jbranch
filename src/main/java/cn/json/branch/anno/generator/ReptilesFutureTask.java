package cn.json.branch.anno.generator;

import cn.json.branch.adapter.JsonAdapter;
import cn.json.branch.anno.Types;

import java.lang.reflect.Array;
import java.util.concurrent.Callable;

/**
 * Created by syq on 2016/7/25.
 */
public class ReptilesFutureTask implements Callable<JsonNodeContainer> {


    private Object rootValue;

    private JsonAdapter jsonAdapter;

    private String[] allNodeKeys;

    private Types[] allNodeTypes;


    public ReptilesFutureTask(Object rootNodeContainer, String[] keyList, Types[] typeList, JsonAdapter jsonAdapter) {
        this.rootValue = rootNodeContainer;
        this.jsonAdapter = jsonAdapter;
        this.allNodeKeys = keyList;
        this.allNodeTypes = typeList;
    }

    @Override
    public JsonNodeContainer call() throws Exception {
        JsonNodeContainer rootNodeContainer = new JsonNodeContainer();
        rootNodeContainer.setValue(this.rootValue);
        rootNodeContainer.setNodeType(Types.JSON_OBJECT);/*root节点应该都为json对象类型*/
        return searchForTheTargetNode(rootNodeContainer);
    }

    /**
     * 改成循环获取
     * @param rootNodeContainer
     * @return
     */
    private JsonNodeContainer searchForTheTargetNode(JsonNodeContainer rootNodeContainer){
        JsonNodeContainer parentNodeContainer = rootNodeContainer;
        int index = 0;
        while(index < allNodeKeys.length){
            String key = allNodeKeys[index];
            Types type = allNodeTypes[index];
            JsonNodeContainer currentContainer = new JsonNodeContainer();

            if (parentNodeContainer.getNodeType().equals(Types.JSON_OBJECT_ARRAY)) {
                Object[] nodeArrays = (Object[]) parentNodeContainer.getValue();
                currentContainer.setKey(key);
                currentContainer.setNodeType(type);
                Object[] currentNodeArrays = (Object[]) Array.newInstance(type.getTypeClass(), nodeArrays.length);
                for (int i = 0; i < nodeArrays.length; i++) {
                    Object currentNodeValue = matchType(nodeArrays[i], type, key);
                    currentNodeArrays[i] = currentNodeValue;
                }
                currentContainer.setValue(currentNodeArrays);
                parentNodeContainer = currentContainer;
            }else{
                currentContainer.setKey(key);
                currentContainer.setNodeType(type);
                if (!parentNodeContainer.getValue().getClass().isArray()) {
                    Object currentNodeValue = matchType(parentNodeContainer.getValue(), type, key);
                    currentContainer.setValue(currentNodeValue);
                }else{
                    Object[] parentValues = (Object[]) parentNodeContainer.getValue();
                    Object[] primitiveValues = (Object[]) Array.newInstance(type.getTypeClass(), parentValues.length);
                    for (int i = 0; i < parentValues.length; i++) {
                        Object currentNodeValue = matchType(parentValues[i], type, key);
                        primitiveValues[i] = currentNodeValue;
                    }
                    currentContainer.setValue(primitiveValues);
                }
                parentNodeContainer = currentContainer;
            }
            index ++;
        }
        return parentNodeContainer;
    }

    /**
     * 递归解析函数
     * 如果有任意一个节点是数组类型，则解析结果肯定也是数组类型
     *
     * @param parentContainer 父节点的信息包裹实例
     * @return
     */
//    private JsonNodeContainer searchForTheTargetNode(JsonNodeContainer parentContainer) {
//        if (allNodeKeys.peek() == null) {
//            return parentContainer;
//        }
//        String key = allNodeKeys.poll();
//        Types type = allNodeTypes.poll();
//        JsonNodeContainer currentContainer = new JsonNodeContainer();
//        if (parentContainer.getNodeType().equals(Types.JSON_OBJECT_ARRAY)) {/*如果前一个节点是jsonobject数组类型*/
//            Object[] nodeArrays = (Object[]) parentContainer.getValue();
//            currentContainer.setKey(key);
//            currentContainer.setNodeType(type);
//            Object[] currentNodeArrays = (Object[]) Array.newInstance(type.getTypeClass(), nodeArrays.length);
//            for (int i = 0; i < nodeArrays.length; i++) {
//                Object currentNodeValue = matchType(nodeArrays[i], type, key);
//                currentNodeArrays[i] = currentNodeValue;
//            }
//            currentContainer.setValue(currentNodeArrays);
//            return searchForTheTargetNode(currentContainer);
//        } else {/*如果前节点不是数组类型*/
//            currentContainer.setKey(key);
//            currentContainer.setNodeType(type);
//            if (!parentContainer.getValue().getClass().isArray()) {/*如果父节点的值类型不为数组，则一定为对象或者基本类型*/
//                Object currentNodeValue = matchType(parentContainer.getValue(), type, key);
//                currentContainer.setValue(currentNodeValue);
//            } else {/*如果父节点的值类型为数组，需要组装数组作为当前节点的值*/
//                Object[] parentValues = (Object[]) parentContainer.getValue();
//                Object[] primitiveValues = (Object[]) Array.newInstance(type.getTypeClass(), parentValues.length);
//                for (int i = 0; i < parentValues.length; i++) {
//                    Object currentNodeValue = matchType(parentValues[i], type, key);
//                    primitiveValues[i] = currentNodeValue;
//                }
//                currentContainer.setValue(primitiveValues);
//            }
//            return searchForTheTargetNode(currentContainer);
//        }
//    }


    /**
     * 根据传入的类型来获取节点值
     *
     * @param json
     * @param fieldType
     * @param key
     * @return
     */
    @SuppressWarnings("ALL")
    private Object matchType(Object json, Types fieldType, String key) {
        Object value = null;
        switch (fieldType) {
            case INT:
                value = jsonAdapter.getInt(json, key);
                break;
            case INT_ARRAY:
                /*可以直接强制转类型*/
                value = jsonAdapter.getIntArray(json, key);
                break;
            case LONG:
                value = jsonAdapter.getLong(json, key);
                break;
            case LONG_ARRAY:
                value = jsonAdapter.getLongArray(json, key);
            case DOUBLE:
                value = jsonAdapter.getDouble(json, key);
                break;
            case DOUBLE_ARRAY:
                value = jsonAdapter.getDoubleArray(json, key);
                break;
            case STRING:
                value = jsonAdapter.getString(json, key);
                break;
            case STRING_ARRAY:
                value = jsonAdapter.getStringArray(json, key);
                break;
            case JSON_OBJECT:
                value = jsonAdapter.getJsonObj(json, key);
                break;
            case JSON_OBJECT_ARRAY:
                value = jsonAdapter.getJsonObjArray(json, key);
                break;
            case DECIMAL:
                value = jsonAdapter.getDecimal(json, key);
                break;
            case DECIMAL_ARRAY:
                value = jsonAdapter.getDecimalArray(json, key);
                break;
            case FLOAT:
                value = jsonAdapter.getFloat(json, key);
                break;
            case FLOAT_ARRAY:
                value = jsonAdapter.getFloatArray(json, key);
                break;
            default:
                value = jsonAdapter.getJsonObj(json, key);
                break;
        }
        return value;
    }


}
