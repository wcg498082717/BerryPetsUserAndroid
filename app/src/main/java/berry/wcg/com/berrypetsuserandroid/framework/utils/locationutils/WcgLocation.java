package berry.wcg.com.berrypetsuserandroid.framework.utils.locationutils;

public class WcgLocation {

    //经度
    private String longitude;
    //纬度
    private String latitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @param longitude 经度
     * @param latitude 纬度
     */
    public WcgLocation(String longitude , String latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public WcgLocation() {
    }
}
