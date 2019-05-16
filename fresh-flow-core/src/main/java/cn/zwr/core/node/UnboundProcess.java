package cn.zwr.core.node;


import org.apache.spark.streaming.api.java.JavaDStream;

/**
 * <title>UnboundProcess</title>
 * <p>处理输入DStream得到输出DStream</p>
 *
 * @param <In>
 * @param <Out>
 *
 * @author Alex Han
 * @version 1.0
 */
public abstract class UnboundProcess<In,Out> extends BaseNode{
    private static final long serialVersionUID = -6240240717413846015L;

    /**
     * 根据输入得到输出
     * @param in
     * @return
     */
    public abstract JavaDStream<Out> process(JavaDStream<In> in);
}
