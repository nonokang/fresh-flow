package cn.zwr.core.node;

import org.apache.spark.api.java.JavaRDD;

public abstract class BoundSink<T> extends BaseNode {
    public abstract void wirte(JavaRDD<T> rdd);
}
