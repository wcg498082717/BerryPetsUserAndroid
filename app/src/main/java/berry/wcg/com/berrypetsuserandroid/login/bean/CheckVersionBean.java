package berry.wcg.com.berrypetsuserandroid.login.bean;

public class CheckVersionBean {

    /**
     * date : 1544771577505
     * msg : 获取成功
     * code : 0
     * data : {"packageurl":"\thttps://installpackage-1256712921.cos.ap-chengdu.myqcloud.com/app-debug.apk","version":"1.0"}
     */

    private long date;
    private String msg;
    private int code;
    private DataBean data;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * packageurl : 	https://installpackage-1256712921.cos.ap-chengdu.myqcloud.com/app-debug.apk
         * version : 1.0
         */

        private String packageurl;
        private String version;

        public String getPackageurl() {
            return packageurl;
        }

        public void setPackageurl(String packageurl) {
            this.packageurl = packageurl;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
