package cn.json.branch.anno.generator;

import cn.json.branch.anno.Types;

/**
 * json节点信息收集类
 * Created by syq on 2016/7/25.
 */
public class JsonNodeContainer {


    /**
     * 节点名称
     */
    private String key;


    /**
     * 节点值
     */
    private Object value;


    /**
     * 节点类型
     */
    private Types nodeType;




    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }


    public Types getNodeType() {
        return nodeType;
    }

    public void setNodeType(Types nodeType) {
        this.nodeType = nodeType;
    }
}
