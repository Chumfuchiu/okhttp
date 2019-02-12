package okhttp3.sample.interceptor;

public class EasyInterceptorA implements EasyInterceptor {
    @Override
    public Response intercept(Chain chain) {
        Request request = chain.request();
        return chain.proceed(request);
    }
}
