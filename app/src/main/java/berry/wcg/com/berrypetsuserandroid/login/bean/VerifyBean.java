package berry.wcg.com.berrypetsuserandroid.login.bean;

public class VerifyBean {

    /**
     * date : 1545100295684
     * msg : 获取手机验证码成功！
     * code : 0
     * data : {"verifycode":822945}
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
         * verifycode : 822945
         */

        private int verifycode;

        public int getVerifycode() {
            return verifycode;
        }

        public void setVerifycode(int verifycode) {
            this.verifycode = verifycode;
        }
    }
}
