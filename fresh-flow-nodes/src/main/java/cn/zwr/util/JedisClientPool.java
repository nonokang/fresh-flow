package cn.zwr.util;

import cn.csg.stream.core.BaseClass;
import io.codis.jodis.RoundRobinJedisPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

import java.io.Serializable;

/**
 * <title>JedisClientPool</title>
 * <p>jedis链接资源池</p>
 *
 * @author Alex Han
 * @version 1.0
 */
public class JedisClientPool extends BaseClass implements Serializable {
    private static final long serialVersionUID = 1594585693993302393L;
    private static final Logger logger = LoggerFactory.getLogger(JedisClientPool.class);

    public static final String JEDIS_ZK_CONNECT_HOST = "jedis.zk.connect.host";
    public static final String JEDIS_ZK_SESSION_TIMEOUT = "jedis.zk.session.timeout";
    public static final String JEDIS_ZK_PROXY_DIR = "jedis.zk.proxy.dir";
    public static final String JEDIS_SESSION_AUTH = "jedis.session.auth";
    public static final String JEDIS_DATABASE = "jedis.database";
    public static final String JEDIS_CONNECTION_TIMEOUT = "jedis.connection.timeout";
    public static final String JEDIS_SOTIMEOUT = "jedis.sotimeout";

    //config
    public static final String JEDIS_MAXTOTAL = "jedis.maxTotal";
    public static final String JEDIS_MAXIDLE = "jedis.maxIdle";
    public static final String JEDIS_MINIDLE = "jedis.minIdle";
    public static final String JEDIS_MAXWAITMILLIS = "jedis.maxWaitMillis";
    public static final String JEDIS_SOFTMINEVICTABLEIDLETIMEMILLIS = "jedis.softMinEvictableIdleTimeMillis";
    private transient static JedisClientPool jedisClientPool;

    private static RoundRobinJedisPool jedisPool = null;

    private void init(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(getOptionAsInt(JEDIS_MAXTOTAL,1000));
        jedisPoolConfig.setMaxIdle(getOptionAsInt(JEDIS_MAXIDLE,10));
        jedisPoolConfig.setMinIdle(getOptionAsInt(JEDIS_MINIDLE,3));
        jedisPoolConfig.setMaxWaitMillis(getOptionAsInt(JEDIS_MAXWAITMILLIS,10000));
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(getOptionAsInt(JEDIS_SOFTMINEVICTABLEIDLETIMEMILLIS,5000));
        try {
            jedisPool = RoundRobinJedisPool.create()
                    .curatorClient(getOption(JEDIS_ZK_CONNECT_HOST), getOptionAsInt(JEDIS_ZK_SESSION_TIMEOUT, 5000))
                    .zkProxyDir(getOption(JEDIS_ZK_PROXY_DIR))
                    .poolConfig(jedisPoolConfig)
                    .connectionTimeoutMs(getOptionAsInt(JEDIS_CONNECTION_TIMEOUT, 5000))
                    .timeoutMs(getOptionAsInt(JEDIS_SOTIMEOUT, 2000))
                    .password(getOption(JEDIS_SESSION_AUTH))
                    .database(getOptionAsInt(JEDIS_DATABASE, 0))
                    .build();
        }catch (Exception e){
            logger.error("jedis Pool init failed! \n{}",e);
        }

        logger.info("jedis Pool init sucess!");
    }
    /**
     * 获取Jedis实例
     * @return
     */
    public Jedis getJedis() {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
        } catch (Exception e) {
            logger.error("JedisConnectionPool异常："+e.getMessage());
            logger.error("JedisConnectionPool连接池断开，尝试进行重连！！！");
            try {
                init();
                jedis = jedisPool.getResource();
            } catch (Exception e2){
                logger.error("JedisConnectionPool尝试进行重连失败！！！");
                e2.printStackTrace();
            }
        }
        return jedis;
    }

    public JedisClientPool() {

    }
}
