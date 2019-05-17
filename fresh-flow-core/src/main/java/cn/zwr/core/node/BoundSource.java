package cn.zwr.core.node;

import org.apache.spark.api.java.JavaRDD;

/**
 * <title>BoundSource</title>
 * <p>有边界的Source父类,所有Source都要重写read方法</p>
 *
 * @param <T>
 *
 * @author Alex Han
 * @version 1.0
 */
public abstract class BoundSource<T> extends BaseNode{
    public abstract JavaRDD<T> read();
}
