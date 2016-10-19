import com.alibaba.fastjson.JSONObject;
import com.nnk.coupon.common.Base64Util;
import com.nnk.coupon.entity.CouponCallbackRequest;
import nnk.msgsrv.server.MsgSrvShortConnector;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: y
 * Date: 2016/7/7
 * Time: 9:53
 * email: xxydliuy@163.com
 * To change this template use File | Settings | File Templates.
 */
public class NotifyTest {
    @Test
    public void testNotify() throws Exception {
        CouponCallbackRequest request = new CouponCallbackRequest();
        request.setReqID("122313213");
        request.setMerUserID("12132313254");
        request.setState("1");
        request.setDeadLine("20160717");
        request.setCardAmt("500");
        request.setMerID("1200000232");
        request.setCardNo("12223333xxxx");
        request.setUrl("socket://localhost:8888");
        String json = JSONObject.toJSONString(request);
        String basestr = Base64Util.encode(json);
        MsgSrvShortConnector connector = new MsgSrvShortConnector("config/msgsrv.xml");
        connector.send("AisidiRecharge notify "+ basestr);
    }
}
