package cn.zwr.nodes.sink;

import cn.csg.stream.core.UnboundDataBaseSink;
import org.apache.spark.streaming.api.java.JavaDStream;

/**
 * <title>HdfsSink</title>
 * <p>EventCommon存入ES Sink</p>
 *
 *
 *
 * @author
 * @version 1.0
 */
public class UnboundHdfsSink extends UnboundDataBaseSink<String> {
    //todo 定义hdfs的配置
    @Override
    public void write(JavaDStream<String> data) {
        //todo 把数据写入hdfs目录
    }
}
