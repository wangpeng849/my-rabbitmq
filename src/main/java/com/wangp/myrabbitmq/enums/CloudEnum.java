package com.wangp.myrabbitmq.enums;


/**
 * @author F1336565
 */

public enum CloudEnum {
    E_Cloud("1001", "eCloud"),
    P_Cloud("1002", "pCloud");

    /**
     * 应用id
     */
    private String appId;
    /**
     * 路径
     */
    private String url;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    CloudEnum(String appId, String url) {
        this.appId = appId;
        this.url = url;
    }

    public static String getUrlById(String appId) {
        for (CloudEnum cloud : CloudEnum.values()) {
            if (appId.equals(cloud.getAppId())) {
                return cloud.getUrl();
            }
        }
        return "error";
    }
}
