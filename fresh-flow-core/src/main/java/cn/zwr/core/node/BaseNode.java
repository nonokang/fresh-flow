package cn.zwr.core.node;

import cn.zwr.core.BaseClass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <title>Node基础父类</title>
 * <p>
 *     Node基础父类，所有Node继承自此类
 * </p>
 *
 * @author Alex Han
 * @version 1.0
 */
@Getter
@Setter
public abstract class BaseNode extends BaseClass implements Serializable {

    private static final long serialVersionUID = 2866405317526430399L;

}
