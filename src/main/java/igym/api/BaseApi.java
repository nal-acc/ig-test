package igym.api;

import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BaseApi {
    protected static Request request;
    protected static final OkHttpClient client = new OkHttpClient();

    protected static String fullUrl(String url) {
        return "http://app.igym.test/api" + url;
    }

    protected static Request.Builder requestJsonBuilder() {
        return new Request.Builder().header("Content-Type", "application/json");
    }

    protected static RequestBody requestBody(String jsonString) {
        return RequestBody.create(jsonString.getBytes(StandardCharsets.UTF_8));
    }

    protected static Response call(Request request) throws IOException {
        Call call = client.newCall(request);
        return call.execute();
    }
}
