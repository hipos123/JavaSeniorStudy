package com.yaoxj.myenum;

public enum TopicEnum implements ValueEnum<String> {

    ORDER("order", "新运单"),
    TAKE("order_take", "接单"),
    LOADED("order_loaded", "确认装车"),
    TOPAY("order_topay", "去支付"),
    ARRIVED("order_arrived", "确认到达"),
    PAID("order_paid", "成功支付"),
    FINISH("order_finish", "完成运单"),
    CONSIGNOR_CANCEL("order_cancel_consignor", "货主取消运单"),
    DRIVER_CANCEL("order_cancel_driver", "司机取消运单"),
    EVALUATE("order_evaluate", "运单评价"),
    COMPLAIN("order_complain", "运单投诉"),
    REFERRAL("ad_referral", "邀请活动"),
    PREPARE("ad_prepare", "预注册活动"),
    CHANGE_PAYTYPE("change_paytype", "修改支付方式"),
    CONSIGNOR_ADVERT("consignor_advert", "货主广告"),
    DRIVER_ADVERT("driver_advert", "司机广告"),
    DRIVER_PUNISH("driver_punish", "司机处罚"),
    UPDATE_RCODE("update_rcode", "更新邀请关系"),
    REFREAH_TOKEN("refresh_token", "刷新token保存登入信息"),
    REFERRAL_MONEY("referral_money", "邀请奖励金")
    ;

    private final String value;
    private final String name;

    TopicEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    /////////////////////////////////////////////
    public String value() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

//    public static TopicEnum forValue(String value) {
//        return EnumKit.forValue(value, TopicEnum.class);
//    }
//
//    public static class Converter extends ValueEnumConverter<TopicEnum, String> {
//    }
}
