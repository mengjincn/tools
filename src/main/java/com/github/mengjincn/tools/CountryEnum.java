package com.github.mengjincn.tools;

public enum CountryEnum {
    // ordinal start from 0 (Zero)
    ONE("宋国"),TWO("赵国");

    private String message;

    CountryEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static CountryEnum getByName(String name){
        return CountryEnum.valueOf(name);
    }

    public static CountryEnum getByOrdinal(int i){
        for(CountryEnum countryEnum: CountryEnum.values()){
            if(countryEnum.ordinal()==i){
                return countryEnum;
            }
        }
        return null;
    }
}
