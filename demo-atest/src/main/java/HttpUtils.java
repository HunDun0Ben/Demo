import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

import java.io.IOException;

public class HttpUtils {

    private static boolean MOCK = false;
    private static int MAX_TIMEOUT = 60000;
    private static MultiThreadedHttpConnectionManager connMgr;

    static {
        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams connMgrparams = new HttpConnectionManagerParams();
        connMgrparams.setConnectionTimeout(MAX_TIMEOUT);
        connMgrparams.setSoTimeout(MAX_TIMEOUT);
        connectionManager.setParams(connMgrparams);
    }

    public static <T> T doPost(String apiUrl, Object reqObject, Class<T> cls) throws IOException {
        if(MOCK) {
            return doMockPost(apiUrl, reqObject, cls);
        }
        HttpClient client = new HttpClient(connMgr);
        String body = JSONUtil.toJSON(reqObject);
        PostMethod method = new PostMethod(apiUrl);
        RequestEntity params = new StringRequestEntity(body, "application/json", "UTF-8");
        method.setRequestEntity(params);
        method.setRequestHeader("Content-Type", "application/json");
        method.setRequestHeader("Connection", "close");
        client.executeMethod(method);
        String response = method.getResponseBodyAsString();
        return JSONUtil.toObject(response, cls);
    }

    public static <T> T doMockPost(String apiUrl, Object reqObject, Class<T> cls) throws IOException {
        String url = "";
        return null;
    }

    static class JSONUtil {
        final static ObjectMapper mapper = new ObjectMapper();

        public static String toJSON(Object obj) throws JsonProcessingException {
            try {
                return mapper.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                throw e;
            }
        }

        public static <T> T toObject(String str, Class<T> cls) throws IOException {
            try {
                return mapper.readValue(str, cls);
            } catch (IOException e) {
                throw e;
            }
        }
    }
}
