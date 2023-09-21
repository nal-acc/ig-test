package igym.api;

import lombok.SneakyThrows;
import okhttp3.Response;

public class DatabaseApi extends BaseApi {
    @SneakyThrows
    public static void cleanDb()
    {
        request = requestJsonBuilder()
                .url(fullUrl("/test-clean-db"))
                .post(requestBody(""))
                .build();

        Response response = null;
        try {
            response = call(request);
        } catch (Exception e) {
        } finally {
            if (response != null){
                response.close();
            }
        }
    }

    @SneakyThrows
    public static void prepareDb()
    {
        request = requestJsonBuilder()
                .url(fullUrl("/test-prepare-db"))
                .post(requestBody(""))
                .build();


        Response response = null;
        try {
            response = call(request);
        } catch (Exception e) {
        } finally {
            if (response != null){
                response.close();
            }
        }
    }
}
