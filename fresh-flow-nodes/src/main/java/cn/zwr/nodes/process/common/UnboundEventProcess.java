package cn.zwr.nodes.process.common;


import cn.zwr.core.node.UnboundProcess;
import org.apache.spark.streaming.api.java.JavaDStream;

/**
 * <title>UnboundEventProcess</title>
 * <p>处理输入DStream得到输出DStream</p>
 *
 * @param <In>
 * @param <Out>
 *
 * @author Alex Han
 * @version 1.0
 *
 */
public abstract class UnboundEventProcess<In,Out> extends UnboundProcess<In,Out> {
    private static final long serialVersionUID = -811490177735955561L;

    public abstract JavaDStream<Out> process(JavaDStream<In> in);
}
