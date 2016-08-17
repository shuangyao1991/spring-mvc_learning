package ys.springmvc.test.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with by shuangyao on 2016/8/17.
 */
public enum DataSourceTypeEnum {

    MASTER("master"),
    SLAVER("slaver");

    private String name;

    private static final Map<String, DataSourceTypeEnum> map =
            new HashMap<String, DataSourceTypeEnum>();

    static {
        for (DataSourceTypeEnum dataSourceTypeEnum : DataSourceTypeEnum.values()){
            map.put(dataSourceTypeEnum.getName(), dataSourceTypeEnum);
        }
    }

    DataSourceTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static DataSourceTypeEnum getByName(String name){
        return map.get(name);
    }
}
