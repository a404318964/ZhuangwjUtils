package com.zwj.zwjutils.net.callback;


import com.zwj.zwjutils.LogUtils;
import com.zwj.zwjutils.net.bean.ResponseBean;

/**
 * 简单的网络请求回调类
 */
public abstract class SimpleCallBack implements RequestCallBack2 {

    public static final String TAG = "SimpleCallBack";

    @Override
    public void onCancelled(ResponseBean responseBean) {
        LogUtils.e(TAG, "执行onCancelled");
    }

    @Override
    public void onError(ResponseBean responseBean) {
        if (responseBean.isShowToast() && responseBean.getThrowable() != null) {
//            responseBean.getThrowable().printStackTrace();

            // 连接超时，重连
//            if(responseBean.isShowToast() && !UrlConstant.GET_VERSION.equals(responseBean.getUrl()) && !UrlConstant.GET_OPEN_CITY_INFOS.equals(responseBean.getUrl())) {
//                if (responseBean.getThrowable() instanceof SocketTimeoutException) {
//                    String errorMsg = "网络连接超时 url --> "+responseBean.getUrl();
//                    ToastUtil.toast(MyApplication.getGlobalContext(), errorMsg);
//                    // TODO
////                    FileUtils.saveFile(MyApplication.getGlobalContext(), "timeout_error.txt", errorMsg.getBytes());
//                } else {
//                    ToastUtil.toast(MyApplication.getGlobalContext(), responseBean.getMessage());
//                }
//            }
        }

    }

    @Override
    public void onFinished(ResponseBean responseBean) {
        LogUtils.e(TAG, "执行onFinished");
    }

    @Override
    public void onUnlogin(String msg) {

    }
}
