package cn.zwr.nodes.sink.common;

import cn.zwr.core.node.UnboundDataBaseSink;

/**
 * <title>ESSchemaSink</title>
 * <p>把没有边界的数据存入ES父类</p>
 *
 * @param <T>
 *
 * @author Alex Han
 * @version 1.0
 */
public abstract class ESSchemaSink<T> extends UnboundDataBaseSink<T> {
    private static final long serialVersionUID = -3476067168544969723L;
}
