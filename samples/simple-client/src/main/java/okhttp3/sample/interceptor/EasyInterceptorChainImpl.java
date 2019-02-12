package okhttp3.sample.interceptor;

import java.util.List;

public class EasyInterceptorChainImpl implements EasyInterceptor.Chain {
    private final List<EasyInterceptor> interceptors;
    private final Request request;
    private final int index;

    public EasyInterceptorChainImpl(List<EasyInterceptor> interceptors, Request request, int index) {
        this.interceptors = interceptors;
        this.request = request;
        this.index = index;
    }

    @Override
    public Request request() {
        return request;
    }

    @Override
    public Response proceed(Request request) {
        EasyInterceptorChainImpl next = new EasyInterceptorChainImpl(interceptors, request, index + 1);
        EasyInterceptor curInterceptor = interceptors.get(index);
        Response response = curInterceptor.intercept(next);
        return response;
    }
}
