package cn.zwr.nodes.process;


import cn.zwr.nodes.process.common.UnboundEventProcess;
import cn.zwr.pojo.common.EventCommon;
import cn.zwr.pojo.common.EventCommonDataDetail;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.api.java.JavaDStream;

/**
 * <title>EventJsonParser</title>
 * <p>把Json转化为Event Object</p>
 * @param <T> in
 * @param <E> out
 * @param <D> detail
 *
 * @author Alex Han
 * @version 1.0
 */
public class EventJsonParser<T, E extends EventCommon, D extends EventCommonDataDetail>
        extends UnboundEventProcess<String, EventCommon> {

    private static final long serialVersionUID = 3144659467434172488L;

    @Override
    public JavaDStream<EventCommon> process(JavaDStream<String> in) {
        return in.map(new Function<String, EventCommon>() {
            @Override
            public EventCommon call(String line) throws Exception {
                return JSON.parseObject(line,new TypeReference<EventCommon<D>>(){});
            }
        });
    }
}
