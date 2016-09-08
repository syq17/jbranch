package cn.json.branch.err;

/**
 * Created by syq on 2016/7/25.
 */
public class PropertyTypeExcepton extends RuntimeException{

    private int code = 500;

    public PropertyTypeExcepton(String message) {
        super(message);
    }

    public PropertyTypeExcepton(String message,int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
