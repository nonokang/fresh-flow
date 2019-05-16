package cn.zwr.core.node;

/**
 *
 * @param <T>
 */
public abstract class ProcessBeforeAnonymousFun<T> implements NodeInterAnonymousFun{
    private static final long serialVersionUID = -6453981733889888902L;

    public abstract T before();
}
