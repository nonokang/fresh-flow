package cn.zwr.core.node;

import org.apache.spark.streaming.api.java.JavaDStream;

/**
 * <title>UnboundSink</title>
 * <p>没有边界的Sink父类,所有Sink都要重写write方法</p>
 * @param <T>
 *
 * @author Alex Han
 * @version 1.0
 */
public abstract class UnboundSink<T> extends BaseNode{
    private static final long serialVersionUID = 2609983977122555798L;

    /**
     * 把DStream写数据到Sink
     * @param data
     */
    public abstract void write(JavaDStream<T> data);
}
