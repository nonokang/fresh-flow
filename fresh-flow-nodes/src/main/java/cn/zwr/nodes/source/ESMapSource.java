package cn.zwr.nodes.source;

import cn.zwr.nodes.source.common.ESSource;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;

import java.util.Map;

public class ESMapSource extends ESSource<Map> {

    public ESMapSource(SparkConf conf) {
        super(conf);
    }

    @Override
    public JavaRDD read() {

        return before().values();
    }
}
