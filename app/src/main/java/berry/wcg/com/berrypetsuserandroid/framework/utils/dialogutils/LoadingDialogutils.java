package berry.wcg.com.berrypetsuserandroid.framework.utils.dialogutils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import berry.wcg.com.berrypetsuserandroid.R;
import berry.wcg.com.berrypetsuserandroid.framework.utils.net.OkHttpUtil;


/**
 * Created by Administrator on 2018/3/13 0013.
 */

public class LoadingDialogutils {
    private static Dialog dialog;
    /**
     * 显示Dialog
     * @param activity  上下文
     * @param msg  显示内容
     * @param isTransBg 是否透明
     * @param isCancelable 是否可以点击取消
     */
    public static void showloadingdialog(final Activity activity, String msg, boolean isTransBg, boolean isCancelable) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View v = inflater.inflate(R.layout.dialog_loading, null);             // 得到加载view
//        RelativeLayout layout = (RelativeLayout) v.findViewById(R.id.dialog_view);// 加载布局
        // main.xml中的ImageView
        ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
        TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);   // 提示文字
        // 加载动画
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(activity, R.anim.rotate_animation);
        // 使用ImageView显示动画
        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
        tipTextView.setText(msg);// 设置加载信息

//        dialog = new Dialog(context, isTransBg ? R.style.TransDialogStyle : R.style.WhiteDialogStyle);    // 创建自定义样式dialog
        dialog = new Dialog(activity);
        dialog.setContentView(v);
        //设置是否取消
//        dialog.setCancelable(isCancelable);
//        设置取消监听
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                OkHttpUtil.cancleRequestByContextAndTag(activity);
            }
        });
        dialog.setCanceledOnTouchOutside(false);
//        Window window = dialog.getWindow();
//        WindowManager.LayoutParams lp = window.getAttributes();
//        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        window.setGravity(Gravity.CENTER);
//        window.setAttributes(lp);
//        window.setWindowAnimations(R.style.PopWindowAnimStyle);
        if(dialog.isShowing()){
            dialog.dismiss();
        }
        dialog.show();
    }


    public static void dismissloadingdialog() {
        if(dialog!=null){
            if(dialog.isShowing()){
                dialog.dismiss();
            }
        }
    }
}
