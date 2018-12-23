package berry.wcg.com.berrypetsuserandroid.framework.utils.net;

import android.app.Activity;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import berry.wcg.com.berrypetsuserandroid.R;
import berry.wcg.com.berrypetsuserandroid.framework.MyApplication;
import berry.wcg.com.berrypetsuserandroid.framework.baseactivity.BaseActivity;
import berry.wcg.com.berrypetsuserandroid.framework.utils.dialogutils.LoadingDialogutils;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * wcg 2018-12-10
 */
public class OkHttpUtil {
    /**
     * 懒汉 安全 加同步
     * 私有的静态成员变量 只声明不创建
     * 私有的构造方法
     * 提供返回实例的静态方法
     */
    private static OkHttpClient okHttpClient = null;
    private static Handler handler = new Handler(MyApplication.getInstance().getApplicationContext().getMainLooper());

    private OkHttpUtil() {
    }
//封装我的回调
   public interface WcgCallBack{
       void onCancle(Call call, IOException e);
       void onFailure(Call call, IOException e);
       void onSuccess(String response) ;
   }

    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            //加同步安全
            synchronized (OkHttpUtil.class) {
                if (okHttpClient == null) {
                    //okhttp可以缓存数据....指定缓存路径
                    File sdcache = new File(Environment.getExternalStorageDirectory(), "cache");
                    //指定缓存大小
                    int cacheSize = 10 * 1024 * 1024;

                    okHttpClient = new OkHttpClient.Builder()//构建器
                            .connectTimeout(5000, TimeUnit.SECONDS)//连接超时
                            .writeTimeout(5000, TimeUnit.SECONDS)//写入超时
                            .readTimeout(5000, TimeUnit.SECONDS)//读取超时

                            .addInterceptor(new CommonParamsInterceptor())//添加的是应用拦截器...公共参数
                            //.addNetworkInterceptor(new CacheInterceptor())//添加的网络拦截器

                            .cache(new Cache(sdcache.getAbsoluteFile(), cacheSize))//设置缓存
                            .build();
                }
            }
        }
        return okHttpClient;
    }

    /**
     * get请求
     * 参数1 url
     * 参数2 回调Callback
     */

    public static void doGet(Activity activity, String url, Map<String, String> params, Boolean showdialog, final WcgCallBack wcgCallBack) {
        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getInstance();
        FormBody.Builder builder = new FormBody.Builder();
        //遍历集合
        for (String key : params.keySet()) {
            builder.add(key, params.get(key));

        }
        //创建Request
        Request request = new Request.Builder().url(url).build();
        //得到Call对象
        Call call = okHttpClient.newCall(request);
        //执行异步请求
        call.enqueue(new Callback(){
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("wcgneterror",e.toString());
                if(e.toString().contains("closed")) {
                    //如果是主动取消的情况下
                    wcgCallBack.onCancle(call,e);
                }else {
                    //其他情况下
                    wcgCallBack.onFailure(call,e);
                }
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                wcgCallBack.onSuccess(response.body().string());
            }
        });
    }


    /**
     * @param activity 传入上下文
     * @param url 传输地址
     * @param params HashMap形式封装
     * @param showdialog true 显示加载动画
     * @param wcgCallBack 事件回调
     */
    public static void doPost(final BaseActivity activity, String url, Map<String, String> params, Boolean showdialog, final WcgCallBack wcgCallBack) {

        if (showdialog) {
            LoadingDialogutils.dismissloadingdialog();
            LoadingDialogutils.showloadingdialog(activity,activity.getResources().getString(R.string.wait_please), false, false);
        }
        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getInstance();
        //3.x版本post请求换成FormBody 封装键值对参数
        FormBody.Builder builder = new FormBody.Builder();
        StringBuffer requestlog=new StringBuffer();
        requestlog.append(url+"?");
        //遍历集合
        for (String key : params.keySet()) {
            builder.add(key, params.get(key));
            requestlog.append(key+"="+params.get(key)+"&&");
        }

        //创建Request
        Request request = new Request.Builder().url(url).post(builder.build()).tag(activity.getLocalClassName()).build();
        Log.i(activity.getIntance().getTag(),"请求数据为："+requestlog);

        Call call = okHttpClient.newCall(request);
        //包装原生回调
        call.enqueue(new Callback(){
            @Override
            public void onFailure(final Call call, final IOException e) {
                Log.i("okhttputils","收到数据为："+e.toString());
                if(e.toString().contains("closed")) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            LoadingDialogutils.dismissloadingdialog();
                            //如果是主动取消的情况下
                            wcgCallBack.onCancle(call,e);
                        }
                    });
                }else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            LoadingDialogutils.dismissloadingdialog();
                            //其他情况下
                            wcgCallBack.onFailure(call,e);
                        }
                    });
                }
            }
            @Override
            public void onResponse(final Call call, final Response response)  {
               handler.post(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           LoadingDialogutils.dismissloadingdialog();
                           String result=response.body().string();
                           Log.i(activity.getIntance().getTag(),"收到数据为："+result);
                           wcgCallBack.onSuccess(result);
                       } catch (Exception e) {
                           e.printStackTrace();
                       }
                   }
               });
            }
        });

    }

    /**
     * 公共参数拦截器
     */
    private static class CommonParamsInterceptor implements Interceptor{

        //拦截的方法
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {

            //获取到请求
            Request request = chain.request();
            //获取请求的方式
            String method = request.method();
            //获取请求的路径
            String oldUrl = request.url().toString();

//            Log.e("---拦截器",request.url()+"---"+request.method()+"--"+request.header("User-agent"));

            //要添加的公共参数...map
            Map<String,String> map = new HashMap<>();
            map.put("source","android");

            if ("GET".equals(method)){
                // 1.http://www.baoidu.com/login                --------。 key=value&key=value
                // 2.http://www.baoidu.com/login?               --------- key=value&key=value
                // 3.http://www.baoidu.com/login?mobile=11111    -----&key=value&key=value

                StringBuilder stringBuilder = new StringBuilder();//创建一个stringBuilder

                stringBuilder.append(oldUrl);

                if (oldUrl.contains("?")){
                    //?在最后面....2类型
                    if (oldUrl.indexOf("?") == oldUrl.length()-1){


                    }else {
                        //3类型...拼接上&
                        stringBuilder.append("&");
                    }
                }else {
                    //不包含? 属于1类型,,,先拼接上?号
                    stringBuilder.append("?");
                }

                //添加公共参数....
                for (Map.Entry<String,String> entry: map.entrySet()) {
                    //拼接
                    stringBuilder.append(entry.getKey())
                            .append("=")
                            .append(entry.getValue())
                            .append("&");
                }

                //删掉最后一个&符号
                if (stringBuilder.indexOf("&") != -1){
                    stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("&"));
                }

                String newUrl = stringBuilder.toString();//新的路径

                //拿着新的路径重新构建请求
                request = request.newBuilder()
                        .url(newUrl)
                        .build();

            }else if ("POST".equals(method)){
                //先获取到老的请求的实体内容
                RequestBody oldRequestBody = request.body();//....之前的请求参数,,,需要放到新的请求实体内容中去

                //如果请求调用的是上面doPost方法
                if (oldRequestBody instanceof FormBody){
                    FormBody oldBody = (FormBody) oldRequestBody;

                    //构建一个新的请求实体内容
                    FormBody.Builder builder = new FormBody.Builder();
                    //1.添加老的参数
                    for (int i=0;i<oldBody.size();i++){
                        builder.add(oldBody.name(i),oldBody.value(i));
                    }
                    //2.添加公共参数
                    for (Map.Entry<String,String> entry:map.entrySet()) {

                        builder.add(entry.getKey(),entry.getValue());
                    }

                    FormBody newBody = builder.build();//新的请求实体内容

                    //构建一个新的请求
                    request = request.newBuilder()
                            .url(oldUrl)
                            .post(newBody)
                            .build();
                }

            }

            Response response = chain.proceed(request);

            return response;
        }
    }

    public static void cancleRequestByContextAndTag(Activity activity){
        if(okHttpClient!=null){
            for (Call call : okHttpClient.dispatcher().queuedCalls()) {
                if (activity.getLocalClassName().equals(call.request().tag())) {
                    call.cancel();
                }
            }
            for(Call call : okHttpClient.dispatcher().runningCalls()) {
                if(activity.getLocalClassName().equals(call.request().tag())){
                    call.cancel();
                }
            }
        }
    }
}
