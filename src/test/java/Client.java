import cn.json.branch.client.AutoJsonSetterGenerator;
import cn.json.branch.cust.FastJsonAdapterStrategy;
import cn.json.branch.cust.MyResponse;
import org.junit.Test;

/**
 * Created by syq on 2016/7/23.
 */
public class Client {

    @Test
    public void testAdatper() {
        String srcJson = " {\"resCode\":1,\"resData\":{\"data\":{\"list\":[{\"addIp\":\"60.190.230.35\",\"addTime\":1459323588000,\"articleType\":\"\",\"clicks\":27,\"content\":\"<p>网站公告网站公告网站公告网站公告网站公告网站公告网站公告4444<img src=\\\"http://hpjrstatic.rdjry.com/data/img/editor/article20160330/1603300443957813.jpg\\\" _src=\\\"http://hpjrstatic.rdjry.com/data/img/editor/article20160330/1603300443957813.jpg\\\"/></p>\",\"id\":8,\"introduction\":\"网站公告网站公告4444\",\"isRecommend\":0,\"isTop\":0,\"name\":\"\",\"nextId\":0,\"nid\":\"notice\",\"page\":0,\"picPath\":\"/data/img/article/20160330/1603301022435789.jpg\",\"picUrl\":\"http://hpjrstatic.rdjry.com\",\"prevId\":0,\"searchName\":\"\",\"site\":{\"addIp\":\"127.0.0.1\",\"addTime\":1444812680000,\"description\":\"\",\"id\":28,\"leaf\":0,\"level\":2,\"name\":\"网站公告\",\"nid\":\"notice\",\"pid\":40,\"size\":1,\"sort\":10,\"status\":1,\"type\":1,\"url\":\"/article/detail.html?nid=notice\"},\"siteId\":\"\",\"siteName\":\"\",\"size\":10,\"sort\":3,\"status\":1,\"title\":\"网站公告网站公告3\"},{\"addIp\":\"60.190.230.45\",\"addTime\":1459323588000,\"articleType\":\"\",\"clicks\":27,\"content\":\"<p>网站公告网站公告网站公告网站公告网站公告网站公告网站公告4444<img src=\\\"http://hpjrstatic.rdjry.com/data/img/editor/article20160330/1603300443957813.jpg\\\" _src=\\\"http://hpjrstatic.rdjry.com/data/img/editor/article20160330/1603300443957813.jpg\\\"/></p>\",\"id\":8,\"introduction\":\"网站公告网站公告4444\",\"isRecommend\":0,\"isTop\":0,\"name\":\"\",\"nextId\":0,\"nid\":\"notice\",\"page\":0,\"picPath\":\"/data/img/article/20160330/1603301022435789.jpg\",\"picUrl\":\"http://hpjrstatic.rdjry.com\",\"prevId\":0,\"searchName\":\"\",\"site\":{\"addIp\":\"192.168.1.1\",\"addTime\":1444812680000,\"description\":\"\",\"id\":28,\"leaf\":0,\"level\":2,\"name\":\"网站公告\",\"nid\":\"notice\",\"pid\":40,\"size\":1,\"sort\":10,\"status\":1,\"type\":1,\"url\":\"/article/detail.html?nid=notice\"},\"siteId\":\"\",\"siteName\":\"\",\"size\":10,\"sort\":3,\"status\":1,\"title\":\"网站公告网站公告3\"}],\"page\":{\"currentPage\":1,\"end\":1,\"pages\":3,\"pernum\":1,\"start\":0,\"total\":3},\"type\":0,\"array\":[12,23,45,656,234]}},\"resMsg\":\"SUCCESS\"}";
        try {
            long start = System.currentTimeMillis();
            int i = 0;
//            JsonParser jsonParser = new JsonParser();
            while (true){
//                jsonParser.parse(srcJson).getAsJsonObject();
//                long start1 = System.nanoTime();
//                Class clazz = MyResponse.class;
//                MyResponse response = (MyResponse) clazz.newInstance();
//                Field[] fields = clazz.getDeclaredFields();
//                for (Field field : fields) {
//                    field.setAccessible(true);
//                }
//                long start2 = System.nanoTime();
//                System.out.println("反射耗时：" + (start2-start1) / 1000000.00);
//                JSONObject jsonObject = JSONObject.parseObject(srcJson);
//                JSONArray array = jsonObject.getJSONObject("resData").getJSONObject("data").getJSONArray("list");
//                String[] strs = new String[array.size()];
//                for (int j = 0; j < array.size(); j++) {
//                    strs[j] = array.getString(j);
//                }
//                fields[0].set(response,strs);
                MyResponse response = AutoJsonSetterGenerator.autoSetter(srcJson, MyResponse.class, FastJsonAdapterStrategy.class);
//                System.out.println(response.getPage());
//                System.out.println(response.getResMsg());
//
//                System.out.println(response.getArry()[0]);
//                System.out.println(response.getList()[0]);
//
//                System.out.println(response.getAddip()[1]);
//
//                System.out.println(response.getInnerAddip()[1]);
                i++;
                long end = System.currentTimeMillis();
//                System.out.println(end-start);
                if((end - start) > 1000){
                    break;
                }
            }
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
