package cn.zwr.nodes.source;

import cn.zwr.core.node.BoundSource;
import lombok.Getter;
import lombok.Setter;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.elasticsearch.spark.rdd.api.java.JavaEsSpark;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * <title>ESSchemaSource</title>
 * <p>从Es读取数据生成Object</p>
 *
 * @param <T>
 *
 * @author Alex Han
 * @version 1.0
 */
public class ESSchemaSource<T> extends BoundSource<T> {
    public final String CLUSTER_NAME = "cluster.name";
    public final String ES_NODES = "es.nodes";
    public final String ES_PORT = "es.port";
    public final String ES_INDEX_READ_MISSING_AS_EMPTY = "es.index.read.missing.as.empty";
    public final String ES_NODES_WAN_ONLY = "es.nodes.wan.only";
    public final String ES_SCROLL_SIZE = "es.scroll.size";
    public final String ES_RESOURCE = "es.resource.read";
    public final String ES_TYPE = "es.type";
    public final String QUERY = "query";

    public ESSchemaSource(SparkConf conf) {
        this.conf = conf;
    }

    @Getter
    @Setter
    private transient SparkConf conf;
    @Getter
    @Setter
    private T t;

    @Override
    public JavaRDD<T> read() {
        conf.set(CLUSTER_NAME , getOption(CLUSTER_NAME));
        conf.set(ES_NODES, getOption(ES_NODES));
        conf.set(ES_PORT, getOption(ES_PORT, "9200"));
        conf.set(ES_INDEX_READ_MISSING_AS_EMPTY, getOption(ES_INDEX_READ_MISSING_AS_EMPTY));
        conf.set(ES_NODES_WAN_ONLY, getOption(ES_NODES_WAN_ONLY, "true"));
        conf.set(ES_SCROLL_SIZE, getOption(ES_SCROLL_SIZE, "10000"));


        JavaPairRDD<String, Map<String, Object>> esRdd = JavaEsSpark.esRDD(new JavaSparkContext(conf),
                getOption(ES_RESOURCE) + "/" + getOption(ES_TYPE,"default") ,
                getOption(QUERY));

        JavaRDD<T> tRdd = esRdd.mapValues(new Function<Map<String, Object>, T>() {
            @Override
            public T call(Map<String, Object> map) throws Exception {
                Class clazz = t.getClass();
                T t1 = (T) clazz.newInstance();
                for(Method method : clazz.getMethods()){
                    if (method.getName().startsWith("set")) {
                        String field = method.getName();
                        field = field.substring(field.indexOf("set") + 3);
                        field = field.toLowerCase().charAt(0) + field.substring(1);
                        if (map.containsKey(field)) {
                            method.invoke(t1, map.get(field).toString());
                        }
                    }
                }

                return t1;
            }}).values();

        return tRdd;
    }
}
