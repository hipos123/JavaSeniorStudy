package com.yaoxj.myenum;

public enum TopicEnum implements ValueEnum<String> {

    ORDER("order", "���˵�"),
    TAKE("order_take", "�ӵ�"),
    LOADED("order_loaded", "ȷ��װ��"),
    TOPAY("order_topay", "ȥ֧��"),
    ARRIVED("order_arrived", "ȷ�ϵ���"),
    PAID("order_paid", "�ɹ�֧��"),
    FINISH("order_finish", "����˵�"),
    CONSIGNOR_CANCEL("order_cancel_consignor", "����ȡ���˵�"),
    DRIVER_CANCEL("order_cancel_driver", "˾��ȡ���˵�"),
    EVALUATE("order_evaluate", "�˵�����"),
    COMPLAIN("order_complain", "�˵�Ͷ��"),
    REFERRAL("ad_referral", "����"),
    PREPARE("ad_prepare", "Ԥע��"),
    CHANGE_PAYTYPE("change_paytype", "�޸�֧����ʽ"),
    CONSIGNOR_ADVERT("consignor_advert", "�������"),
    DRIVER_ADVERT("driver_advert", "˾�����"),
    DRIVER_PUNISH("driver_punish", "˾������"),
    UPDATE_RCODE("update_rcode", "���������ϵ"),
    REFREAH_TOKEN("refresh_token", "ˢ��token���������Ϣ"),
    REFERRAL_MONEY("referral_money", "���뽱����")
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
