package cn.zwr.core.node;

import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;

/**
 * <title>NodeOptions</title>
 * <p>Node中的属性，用于配置这个Node</p>
 *
 * @author Alex Han
 * @version 1.0
 */
public class NodeOptions implements Serializable {
    private static final long serialVersionUID = -6714103315452225699L;

    private Map<String,String> options;
    public NodeOptions(){
        options = Maps.newHashMap();
    }

    public String getOption(String name) {
        return options.get(name);
    }

    public void setOption(String name, String val) {
        options.put(name,  val);
    }

    public String[] getOptionNameAsArray(){
        return options.keySet().toArray(new String[0]);
    }
}
