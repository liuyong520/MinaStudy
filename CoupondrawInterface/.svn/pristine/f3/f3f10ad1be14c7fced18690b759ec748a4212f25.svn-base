import com.alibaba.fastjson.JSONObject;
import com.nnk.coupon.common.Des3Utils;
import com.nnk.coupon.common.PostFormUtils;
import com.nnk.coupon.common.SignSecurityUtlis;
import com.nnk.coupon.entity.CouponQueryByUserIdResponse;
import com.nnk.utils.http.interfaces.HttpData;
import com.nnk.utils.http.utils.HttpClientUtils;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/7/1
 * Time: 8:31
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class HttpParametersGenerators {
    private HttpEntity httpEntity;
    @Test
    public void testGenarateParamenters() throws Exception {
        TreeMap<String,String> parametersMap = new TreeMap();
        parametersMap.put("InterfaceName","007KA_COUPON");
        parametersMap.put("InterfaceVersion","1.0.0.1");
        parametersMap.put("Command","001");
        parametersMap.put("ReqID","dearerfkereea");
        parametersMap.put("MerID","1200000232");
        parametersMap.put("MerUserID","liuy");
        parametersMap.put("MerUserPhone","13267191379");
        parametersMap.put("Type","1");
        parametersMap.put("CardAmt","500");
//        parametersMap.put("useType","9");
        parametersMap.put("ReqTime","20160711083900");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,String> entry:parametersMap.entrySet()){
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        sb.append("Key").append("=");
        System.out.println(sb.toString());
        parametersMap.put("Sign", SignSecurityUtlis.sign(sb.toString(),"lk839u45lqzf"));
        String ret = EntityUtils.toString(PostFormUtils.buildEntity(parametersMap, false, "utf-8")) ;
        System.out.println(ret);
        httpEntity = PostFormUtils.buildEntity(parametersMap, false, "utf-8");
    }

    @Test
    public void testGenarateParamenters1() throws Exception {
        TreeMap<String,String> parametersMap = new TreeMap();
        parametersMap.put("InterfaceName","007KA_COUPON");
        parametersMap.put("InterfaceVersion","1.0.0.1");
        parametersMap.put("Command","002");
        parametersMap.put("ReqID","xx5555555555");
        parametersMap.put("MerID","1200000232");
        parametersMap.put("MerUserID","liuy");
        parametersMap.put("ReqTime","20160711083900");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,String> entry:parametersMap.entrySet()){
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        sb.append("Key").append("=");
        System.out.println(sb.toString());
        parametersMap.put("Sign", SignSecurityUtlis.sign(sb.toString(),"lk839u45lqzf"));
        String ret = EntityUtils.toString(PostFormUtils.buildEntity(parametersMap, false, "utf-8")) ;
        System.out.println(ret);
        httpEntity = new StringEntity(ret);
    }


    @Test
    public void testGenarateParamenters2() throws Exception {
        TreeMap<String,String> parametersMap = new TreeMap();
        parametersMap.put("InterfaceName","007KA_COUPON");
        parametersMap.put("InterfaceVersion","1.0.0.1");
        parametersMap.put("Command","003");
        parametersMap.put("ReqID","xxxxdds4232323");
        parametersMap.put("MerID","1200000232");
        String encode = Des3Utils.des3EncodeECBtoString("111111111111111111111111","HongChuangSrvPwd");
        parametersMap.put("CardNo",encode);
        parametersMap.put("ReqTime","20160711083900");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,String> entry:parametersMap.entrySet()){
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }

        sb.append("Key").append("=");
        System.out.println(sb.toString());
        parametersMap.put("Sign", SignSecurityUtlis.sign(sb.toString(),"lk839u45lqzf"));
        String ret = EntityUtils.toString(PostFormUtils.buildEntity(parametersMap, false, "utf-8")) ;
        System.out.println(ret);
        httpEntity = PostFormUtils.buildEntity(parametersMap, false, "utf-8");
    }

    @Test
    public void testLength() throws Exception {
        String str = "怎么样";
        System.out.println(str.getBytes().length);

    }
    @Test
    public void testPost1() throws Exception {
        testGenarateParamenters();
        testGenarateParamenters1();
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        httpClientUtils.doPost("http://112.95.172.89:2381/coupon/getCoupon",new HttpData() {
            @Override
            public HttpEntity getPostdata() {
                try {
                    return httpEntity;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            public String getGetdata() {
                return null;
            }
        });

    }

    @Test
    public void testJson() throws Exception {
        String json = "{\"CardAmtList\":\"500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500,500\",\"CardNoList\":\"f911ee893ecc8dfdada37c6eda78eb416b01012b48f97884,dd8fc205ec9af0a36a6d4f55b8eea5a7de4240616006f012,91c51a4d5c548c13e605d342030ee2e285817b5e8a74a970,8d6b4a2f2b0ec3e1c3be08c91a8ac9d692016aa5daf51ce8,0b0c7029106f3a3604e0600dfa9f52345c0812a044d5dbe5,d9514b604d0147b065b56bbe8a4758468073d3ead53cfa21,302bb676dd5eea8b0b3322a213b8d3a6831fc22d9b0941d6,acea23d3e8ff53f68e394e06e622ce36339323a64ba7e1fd,995b8b0c27fe0c6f0818289c093e6219ef244ff0ea9d686e,da012805e0afa1f56c2002579fc060f660629e0c840a0677,f56841aa0bc5174489de78836b790f1455c0aabaace27b0b,74a2ea6cdbaabf76165c3106bbd7bfe68073d3ead53cfa21,6eb6e8b6d1d5bc8245de842ba1828f06dea6ed5a6559c06e,15f40e423ad4ed85b7e03c064e821646b20acb43a133b26d,057b84f50e29b026eb4273c1e27c213ca5848194ecb3d4ab,9f087cecbb8c413bb332a5a2493cde71d7e31b75f7a59ab1,ed04205f605ffcc3cf635085f6c6cc148073d3ead53cfa21,a121a7ce3ce8a1d2038de1e30df55d88831fc22d9b0941d6,7c79664a08a4e93f611317a43c21fa12a6be2b9bde4bc45f,2479c33de0dc06664f308dea0ff67afad7e31b75f7a59ab1\",\"Command\":\"002\",\"DeadLineList\":\"20161231,20161231,20161231,20161231,20161231,20161231,20161231,20161231,20161231,20161231,20161231,20161231,20161231,20161231,20161231,20161231,20161231,20161231,20161231,20161231\",\"InerfaceVersion\":\"1.0.0.1\",\"InterfaceName\":\"007KA_COUPON\",\"ReMsg\":\"请求成功\",\"ReqID\":\"PON1607250003580\",\"ReqTime\":\"20160725084020\",\"Result\":\"1001\",\"Sign\":\"\",\"StateList\":\"1,1,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,1,1\",\"TypeList\":\"2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2\"}";
        CouponQueryByUserIdResponse response = JSONObject.parseObject(json,CouponQueryByUserIdResponse.class);
        System.out.println(response.toString());
        System.out.println(response.toSocketString());
        System.out.println(response.getCardAmtList());

    }
}
