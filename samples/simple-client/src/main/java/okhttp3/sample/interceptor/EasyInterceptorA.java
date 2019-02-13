package okhttp3.sample.interceptor;

/**
 * 在每一个Interceptor.intercept方法里，都可以先对request进行修改，将修改后的request
 * 传递给下一个Interceptor处理。同时，也可以将下一个Interceptor返回的response进行修改
 * 并传递给上一个Interceptor。
 */
public class EasyInterceptorA implements EasyInterceptor {
    @Override
    public Response intercept(Chain chain) {
        Request request = chain.request();
        //modify request
        Response response = chain.proceed(request);
        //modify response
        return response;
    }
}
