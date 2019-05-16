package cn.zwr.core.node;

import org.apache.spark.streaming.api.java.JavaDStream;


/**
 * <title>UnboundSource</title>
 * <p>没有边界的Source父类,所有Source都要重写read方法</p>
 *
 * @param <T>
 *
 * @author Alex Han
 * @version 1.0
 */
public abstract class UnboundSource<T> extends BaseNode{
    private static final long serialVersionUID = 8702747072022686313L;

    /**
     * 从Unbound数据中读取处DStream
     */
    public abstract JavaDStream<T> read();
}
