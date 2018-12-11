package berry.wcg.com.berrypetsuserandroid.framework.utils.imgutils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import org.xutils.common.Callback;
import org.xutils.image.ImageOptions;
import org.xutils.x;


/**
 * Created by Administrator on 2017/7/17.
 */

public class XUtils3Utils {
    public static ImageOptions options;
    public static ImageOptions headoptions;

    private static ImageOptions getImageOptions() {
        if (options != null) {
            return options;
        } else {
//            return options = new ImageOptions.Builder()
//                    .setIgnoreGif(false).setUseMemCache(true).setLoadingDrawableId(R.drawable.man1)
//                    .setFailureDrawableId(R.drawable.man1).build();
            return null;
        }
    }

    private static ImageOptions getHeadOptions() {
        if (headoptions != null) {
            return headoptions;
        } else {
//            return headoptions = new ImageOptions.Builder().setCircular(true)
//                    .setIgnoreGif(false).setLoadingDrawableId(R.drawable.man1)
//                    .setFailureDrawableId(R.drawable.man1).build();
            return null;
        }
    }

    public static void displayHead(String imgUrl, final ImageView iv) {
        ImageOptions op = getHeadOptions();
        x.image().bind(iv, imgUrl, op);
    }

    public static void display(String imgUrl, final ImageView iv) {
        x.image().bind(iv, imgUrl, getImageOptions());

//        x.image().bind(iv, imgUrl);
    }

    public static void display(String imgUrl, final ImageView iv, Callback.CommonCallback<Drawable> callback) {
//        x.image().bind(iv, imgUrl, getImageOptions());

        x.image().bind(iv, imgUrl, getImageOptions(), callback);
    }


    public static void displayCache(String imgUrl, final ImageView iv, Callback.CacheCallback<Drawable> callback) {
        x.image().bind(iv, imgUrl, callback);
    }
}
