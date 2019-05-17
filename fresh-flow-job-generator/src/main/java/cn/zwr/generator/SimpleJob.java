package cn.zwr.generator;

import cn.zwr.core.node.NodeOptions;
import cn.zwr.nodes.sink.CsvLocalFileSink;
import com.google.common.collect.Lists;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.List;

public class SimpleJob {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf();
        conf.setAppName(SimpleJob.class.getName()).setMaster("local[1]").set("appName",SimpleJob.class.getName());

        System.out.println(conf.get("appName"));

        Hello hello1 = Hello.builder().a("tom").b(100).build();
        Hello hello2 = Hello.builder().a("Marry").b(20).build();
        Hello hello3 = Hello.builder().a("Jim").b(102).build();

        List<Hello> list = Lists.newArrayList(hello1,hello2,hello3);
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<Hello> helloJavaRDD = sc.parallelize(list);

        CsvLocalFileSink<Hello> helloCsvLocalFileSink = new CsvLocalFileSink<>();
        NodeOptions options = new NodeOptions();
        options.setOption(helloCsvLocalFileSink.FILE_SPLIT_BY,",");
        options.setOption(helloCsvLocalFileSink.FILE_NUM, "1");
        options.setOption(helloCsvLocalFileSink.LOCAL_PATH, "/Users/hanwenlong/Downloads/");
        options.setOption(helloCsvLocalFileSink.FILE_NAME, "test.csv");

        helloCsvLocalFileSink.setNodeOptions(options);
        System.out.println(helloCsvLocalFileSink.getNodeOptions());
        helloCsvLocalFileSink.wirte(helloJavaRDD);

    }
}
