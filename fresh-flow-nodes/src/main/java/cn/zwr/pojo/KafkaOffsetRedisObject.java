package cn.zwr.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class KafkaOffsetRedisObject {
    @JSONField(name = "topic")
    private String topic;
    @JSONField(name = "untilOffset")
    private Long untilOffset;
    @JSONField(name = "partition")
    private Integer partition;
}
