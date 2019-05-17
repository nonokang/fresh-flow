package cn.zwr.nodes.sink;

import cn.zwr.nodes.sink.common.ESSchemaSink;
import cn.zwr.pojo.common.EventCommon;
import cn.zwr.pojo.common.EventCommonDataDetail;
import com.google.common.collect.Maps;
import lombok.NoArgsConstructor;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.elasticsearch.spark.streaming.api.java.JavaEsSparkStreaming;

import java.util.Map;

/**
 * <title>EventESSchemaSink</title>
 * <p>EventCommon存入ES Sink</p>
 *
 * @param <T>
 * @param <D>
 *
 * @author
 * @version 1.0
 */
@NoArgsConstructor
public class EventESSchemaSink<T extends EventCommon, D extends EventCommonDataDetail> extends ESSchemaSink<T> {
    private static final long serialVersionUID = 4174245239264702412L;
    public final String ES_INDEX_AUTO_CREATE = "es.index.auto.create";
    public final String ES_NODES = "es.nodes";
    public final String ES_PORT = "es.port";

    public final String ES_RESOURCE = "es.resource.write";
    public final String ES_TYPE = "es.type";
    public final String ES_MAPPING_DATE_RICH = "es.mapping.date.rich";
    public final String ES_NODES_WAN_ONLY = "es.nodes.wan.only";
    public final String ES_BATCH_WRITE_RETRY_COUNT = "es.batch.write.retry.count";
    public final String ES_BATCH_WRITE_RETRY_WAIT = "es.batch.write.retry.wait";

    @Override
    public void write(JavaDStream<T> data) {
        Map<String,String> cfg = Maps.newConcurrentMap();
        cfg.put(ES_RESOURCE, getOption(ES_RESOURCE) + "/" + getOption(ES_TYPE,"default"));
        cfg.put(ES_MAPPING_DATE_RICH, getOption(ES_MAPPING_DATE_RICH)) ;
        cfg.put(ES_NODES, getOption(ES_NODES)) ;
        cfg.put(ES_PORT, getOption(ES_PORT, "9200")) ;
        cfg.put(ES_INDEX_AUTO_CREATE, getOption(ES_INDEX_AUTO_CREATE,"true")) ;
        cfg.put(ES_NODES_WAN_ONLY, getOption(ES_NODES_WAN_ONLY, "true")) ;
        cfg.put(ES_BATCH_WRITE_RETRY_COUNT, getOption(ES_BATCH_WRITE_RETRY_COUNT,"10")) ;
        cfg.put(ES_BATCH_WRITE_RETRY_WAIT,getOption(ES_BATCH_WRITE_RETRY_WAIT, "10")) ;

        JavaDStream stream = data.map(new Function<T, Map<String, String>>() {

            @Override
            public Map<String, String> call(T t) throws Exception {
                return t.transformMap();
            }
        });
        JavaEsSparkStreaming.saveToEs(stream, cfg);

    }
}
