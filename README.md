# Fresh Flow v1.0

## fresh-flow-core

用于定义开发的规范，包含父类和接口等。

## fresh-flow-job-generator

用于生成job项目的工具包。

## fresh-flow-manager

用于调用fresh-flow-job-generator的微服务。

## fresh-flow-nodes

根据fresh-flow-core的规范，编写通用的Node。

分类 | 类型 | 名字 | 解释 | 作用
---|---|---|---|---
Source | Bounded | ESSource | 处理ES的通用父类 |
Source | Bounded | ESMapSource | 从Es读取数据生成Object |
Source | Unbounded | KafkaSource | 读取Kafka数据 |
Source | Unbounded | OutOffsetFromRedisKafkaSource | 根据redis存储的offset读取Kafka数据 |
Process | Unbounded | EventJsonParser | 根据逻辑把Json数据转化为Event类型的数据 |
Sink | Bounded | CsvLocalFileSink | 把数据存储到本地csv文件，仅支持local模式 |
Sink | Unbounded| EventESSchemaSink | 把数据存储到ES |
Sink | Unbounded | UnboundHdfsSink | 把数据存储到Hdfs,暂未实现 |