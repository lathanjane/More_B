package com.more.wechat.publish.survey.model;

public class TCode {
    private Long id;

    private String codeType;

    private String codeValue;

    private String codeName;

    private String standByFlag1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType == null ? null : codeType.trim();
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue == null ? null : codeValue.trim();
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName == null ? null : codeName.trim();
    }

    public String getStandByFlag1() {
        return standByFlag1;
    }

    public void setStandByFlag1(String standByFlag1) {
        this.standByFlag1 = standByFlag1 == null ? null : standByFlag1.trim();
    }
}