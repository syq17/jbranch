package cn.json.branch.cust;

import cn.json.branch.adapter.JsonAdapter;
import cn.json.branch.adapter.JsonAdapterStrategy;

/**
 * Created by syq on 2016/7/23.
 */
public class MyGsonAdapterStrategy implements JsonAdapterStrategy{

    @Override
    public JsonAdapter getAdapter() {
        return new GsonAdapter();
    }
}
