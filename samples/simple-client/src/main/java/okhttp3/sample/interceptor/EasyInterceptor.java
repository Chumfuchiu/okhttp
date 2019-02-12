package okhttp3.sample.interceptor;

public interface EasyInterceptor {
    Response intercept(Chain chain);

    interface Chain {
        Request request();

        Response proceed(Request request);
    }
}
