package cn.zwr.nodes.sink;

import cn.zwr.core.node.BoundSink;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;

import java.lang.reflect.Method;
import java.util.StringJoiner;

public class CsvLocalFileSink<T> extends BoundSink<T> {
    public final String LOCAL_PATH = "local.path";
    public final String FILE_NAME = "file.name";
    public final String FILE_NUM = "file.num";
    public final String FILE_SPLIT_BY = "file.split.by";

    @Override
    public void wirte(JavaRDD<T> rdd) {
        int filenum = rdd.getNumPartitions();
        if(filenum != getOptionAsInt(FILE_NUM, filenum))
            rdd = rdd.repartition(getOptionAsInt(FILE_NUM, filenum));
        String splite = getOption(FILE_SPLIT_BY,",");
        JavaRDD<String> strRdd = rdd.map(new Function<T, String>() {
            @Override
            public String call(T t) throws Exception {
                if(t == null){
                    return null;
                }
                StringJoiner stringJoiner = new StringJoiner(splite);
                for(Method method : t.getClass().getMethods()){
                    if (method.getName().startsWith("get") &&
                    !method.getName().endsWith("Class")) {
                        stringJoiner.add("\"" + method.invoke(t).toString() + "\"");
                    }
                }
                return stringJoiner.toString();
            }
        });
        strRdd.saveAsTextFile(getOption(LOCAL_PATH,"./") + getOption(FILE_NAME, "test.csv"));

    }
}
