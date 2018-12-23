package berry.wcg.com.berrypetsuserandroid.main.bean;

import java.util.List;

public class MainOrderByBean {

    /**
     * date : 1545377234733
     * msg : 获取成功
     * code : 0
     * data : {"shopinfo":[{"id":"7d28e71ad1c5c9cb","name":"天府三街","latitude":30.547261,"longitude":104.062057,"shopImage":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_11bbc005da9d814a7113edd4eaf378a3.jpg","note":"null","detail":"这是描述","phone":"18215642085","enable":"1","isRest":"1","realName":"彭钰与","address":"四川省成都市武侯区天府三街峰汇中心2号楼","enableFailReason":"null","sendstprice":"0","idCardDown":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_974667e552950ec0a8f782e098fcac94.jpg","idCardUp":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_a9affae4ff24e2648368b58a2ca2cfb7.jpg","shopMsg":"null","createTime":"2018-12-10 14:06:13","editTime":"2018-12-12 17:25:12","score":"5.0","countstarOne":"0","countstarTwo":"0","countstarThree":"0","countstarFour":"0","countstarFive":"8","monthSell":"13","distance":"379","addressDetail":"1604","truthImage":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_11bbc005da9d814a7113edd4eaf378a3.jpg","qualification":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_ee491c692e3798490593c92482f06354.jpg"},{"id":"8a6a96dae52da7f4","name":"七月","latitude":30.54607,"longitude":104.067274,"shopImage":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/wx4071b876581406db.o6zAJszNZJi7sHgzhBYijgLTIWNI.0fkD3cqlrrAr62f519bf4004b83f3a7b008116a25644.png","note":"这个公告为什么是null","detail":"啥子鬼","phone":"15183087452","enable":"1","isRest":"1","realName":"曾美琪","address":"四川省成都市武侯区天府三街69号","enableFailReason":"笨蛋","sendstprice":"1","idCardDown":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_ff5c6a6f6846c7f7c0ad7f60f31aca7b.jpg","idCardUp":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_d744bbc81e13e69a67287012e8ec8822.jpg","shopMsg":"null","createTime":"2018-12-10 14:09:50","editTime":"2018-12-20 14:58:58","score":"4.5","countstarOne":"1","countstarTwo":"0","countstarThree":"0","countstarFour":"0","countstarFive":"7","monthSell":"7","distance":"839","addressDetail":"哈哈哈","truthImage":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/wx4071b876581406db.o6zAJszNZJi7sHgzhBYijgLTIWNI.foJFGAQtR4iq48c6b7d11775d8ca672631f7f5308b93.png","qualification":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/wx4071b876581406db.o6zAJszNZJi7sHgzhBYijgLTIWNI.tqfDzE7c0AMUb36a0b364bec5965203ef7c7277ed7c9.png"}],"islastpage":true,"imageInfo":["https://gw.alicdn.com/imgextra/i2/14/TB29R4Mx7KWBuNjy1zjXXcOypXa_!!14-0-lubanu.jpg","https://img11.360buyimg.com/jdphoto/jfs/t7522/297/3195539505/97771/bef10833/59bb5338N8d71ac6e.jpg","https://img11.360buyimg.com/jdphoto/jfs/t7522/297/3195539505/97771/bef10833/59bb5338N8d71ac6e.jpg"]}
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
         * shopinfo : [{"id":"7d28e71ad1c5c9cb","name":"天府三街","latitude":30.547261,"longitude":104.062057,"shopImage":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_11bbc005da9d814a7113edd4eaf378a3.jpg","note":"null","detail":"这是描述","phone":"18215642085","enable":"1","isRest":"1","realName":"彭钰与","address":"四川省成都市武侯区天府三街峰汇中心2号楼","enableFailReason":"null","sendstprice":"0","idCardDown":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_974667e552950ec0a8f782e098fcac94.jpg","idCardUp":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_a9affae4ff24e2648368b58a2ca2cfb7.jpg","shopMsg":"null","createTime":"2018-12-10 14:06:13","editTime":"2018-12-12 17:25:12","score":"5.0","countstarOne":"0","countstarTwo":"0","countstarThree":"0","countstarFour":"0","countstarFive":"8","monthSell":"13","distance":"379","addressDetail":"1604","truthImage":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_11bbc005da9d814a7113edd4eaf378a3.jpg","qualification":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_ee491c692e3798490593c92482f06354.jpg"},{"id":"8a6a96dae52da7f4","name":"七月","latitude":30.54607,"longitude":104.067274,"shopImage":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/wx4071b876581406db.o6zAJszNZJi7sHgzhBYijgLTIWNI.0fkD3cqlrrAr62f519bf4004b83f3a7b008116a25644.png","note":"这个公告为什么是null","detail":"啥子鬼","phone":"15183087452","enable":"1","isRest":"1","realName":"曾美琪","address":"四川省成都市武侯区天府三街69号","enableFailReason":"笨蛋","sendstprice":"1","idCardDown":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_ff5c6a6f6846c7f7c0ad7f60f31aca7b.jpg","idCardUp":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_d744bbc81e13e69a67287012e8ec8822.jpg","shopMsg":"null","createTime":"2018-12-10 14:09:50","editTime":"2018-12-20 14:58:58","score":"4.5","countstarOne":"1","countstarTwo":"0","countstarThree":"0","countstarFour":"0","countstarFive":"7","monthSell":"7","distance":"839","addressDetail":"哈哈哈","truthImage":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/wx4071b876581406db.o6zAJszNZJi7sHgzhBYijgLTIWNI.foJFGAQtR4iq48c6b7d11775d8ca672631f7f5308b93.png","qualification":"http://shop-1256712921.cos.ap-chengdu.myqcloud.com/wx4071b876581406db.o6zAJszNZJi7sHgzhBYijgLTIWNI.tqfDzE7c0AMUb36a0b364bec5965203ef7c7277ed7c9.png"}]
         * islastpage : true
         * imageInfo : ["https://gw.alicdn.com/imgextra/i2/14/TB29R4Mx7KWBuNjy1zjXXcOypXa_!!14-0-lubanu.jpg","https://img11.360buyimg.com/jdphoto/jfs/t7522/297/3195539505/97771/bef10833/59bb5338N8d71ac6e.jpg","https://img11.360buyimg.com/jdphoto/jfs/t7522/297/3195539505/97771/bef10833/59bb5338N8d71ac6e.jpg"]
         */

        private boolean islastpage;
        private List<ShopinfoBean> shopinfo;
        private List<String> imageInfo;

        public boolean isIslastpage() {
            return islastpage;
        }

        public void setIslastpage(boolean islastpage) {
            this.islastpage = islastpage;
        }

        public List<ShopinfoBean> getShopinfo() {
            return shopinfo;
        }

        public void setShopinfo(List<ShopinfoBean> shopinfo) {
            this.shopinfo = shopinfo;
        }

        public List<String> getImageInfo() {
            return imageInfo;
        }

        public void setImageInfo(List<String> imageInfo) {
            this.imageInfo = imageInfo;
        }

        public static class ShopinfoBean {
            /**
             * id : 7d28e71ad1c5c9cb
             * name : 天府三街
             * latitude : 30.547261
             * longitude : 104.062057
             * shopImage : http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_11bbc005da9d814a7113edd4eaf378a3.jpg
             * note : null
             * detail : 这是描述
             * phone : 18215642085
             * enable : 1
             * isRest : 1
             * realName : 彭钰与
             * address : 四川省成都市武侯区天府三街峰汇中心2号楼
             * enableFailReason : null
             * sendstprice : 0
             * idCardDown : http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_974667e552950ec0a8f782e098fcac94.jpg
             * idCardUp : http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_a9affae4ff24e2648368b58a2ca2cfb7.jpg
             * shopMsg : null
             * createTime : 2018-12-10 14:06:13
             * editTime : 2018-12-12 17:25:12
             * score : 5.0
             * countstarOne : 0
             * countstarTwo : 0
             * countstarThree : 0
             * countstarFour : 0
             * countstarFive : 8
             * monthSell : 13
             * distance : 379
             * addressDetail : 1604
             * truthImage : http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_11bbc005da9d814a7113edd4eaf378a3.jpg
             * qualification : http://shop-1256712921.cos.ap-chengdu.myqcloud.com/tmp_ee491c692e3798490593c92482f06354.jpg
             */

            private String id;
            private String name;
            private double latitude;
            private double longitude;
            private String shopImage;
            private String note;
            private String detail;
            private String phone;
            private String enable;
            private String isRest;
            private String realName;
            private String address;
            private String enableFailReason;
            private String sendstprice;
            private String idCardDown;
            private String idCardUp;
            private String shopMsg;
            private String createTime;
            private String editTime;
            private String score;
            private String countstarOne;
            private String countstarTwo;
            private String countstarThree;
            private String countstarFour;
            private String countstarFive;
            private String monthSell;
            private String distance;
            private String addressDetail;
            private String truthImage;
            private String qualification;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public String getShopImage() {
                return shopImage;
            }

            public void setShopImage(String shopImage) {
                this.shopImage = shopImage;
            }

            public String getNote() {
                return note;
            }

            public void setNote(String note) {
                this.note = note;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getEnable() {
                return enable;
            }

            public void setEnable(String enable) {
                this.enable = enable;
            }

            public String getIsRest() {
                return isRest;
            }

            public void setIsRest(String isRest) {
                this.isRest = isRest;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getEnableFailReason() {
                return enableFailReason;
            }

            public void setEnableFailReason(String enableFailReason) {
                this.enableFailReason = enableFailReason;
            }

            public String getSendstprice() {
                return sendstprice;
            }

            public void setSendstprice(String sendstprice) {
                this.sendstprice = sendstprice;
            }

            public String getIdCardDown() {
                return idCardDown;
            }

            public void setIdCardDown(String idCardDown) {
                this.idCardDown = idCardDown;
            }

            public String getIdCardUp() {
                return idCardUp;
            }

            public void setIdCardUp(String idCardUp) {
                this.idCardUp = idCardUp;
            }

            public String getShopMsg() {
                return shopMsg;
            }

            public void setShopMsg(String shopMsg) {
                this.shopMsg = shopMsg;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getEditTime() {
                return editTime;
            }

            public void setEditTime(String editTime) {
                this.editTime = editTime;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getCountstarOne() {
                return countstarOne;
            }

            public void setCountstarOne(String countstarOne) {
                this.countstarOne = countstarOne;
            }

            public String getCountstarTwo() {
                return countstarTwo;
            }

            public void setCountstarTwo(String countstarTwo) {
                this.countstarTwo = countstarTwo;
            }

            public String getCountstarThree() {
                return countstarThree;
            }

            public void setCountstarThree(String countstarThree) {
                this.countstarThree = countstarThree;
            }

            public String getCountstarFour() {
                return countstarFour;
            }

            public void setCountstarFour(String countstarFour) {
                this.countstarFour = countstarFour;
            }

            public String getCountstarFive() {
                return countstarFive;
            }

            public void setCountstarFive(String countstarFive) {
                this.countstarFive = countstarFive;
            }

            public String getMonthSell() {
                return monthSell;
            }

            public void setMonthSell(String monthSell) {
                this.monthSell = monthSell;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public String getAddressDetail() {
                return addressDetail;
            }

            public void setAddressDetail(String addressDetail) {
                this.addressDetail = addressDetail;
            }

            public String getTruthImage() {
                return truthImage;
            }

            public void setTruthImage(String truthImage) {
                this.truthImage = truthImage;
            }

            public String getQualification() {
                return qualification;
            }

            public void setQualification(String qualification) {
                this.qualification = qualification;
            }
        }
    }
}
