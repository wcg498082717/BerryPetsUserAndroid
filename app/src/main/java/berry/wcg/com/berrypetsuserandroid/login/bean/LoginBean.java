package berry.wcg.com.berrypetsuserandroid.login.bean;

public class LoginBean {

    /**
     * date : 1545189919306
     * msg : 登录成功
     * code : 0
     * data : {"token":"51f199d45322641d"}
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
         * token : 51f199d45322641d
         */

        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
