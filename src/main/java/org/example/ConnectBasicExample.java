package org.example;

import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisClientConfig;

public class ConnectBasicExample {
    public static void main(String[] args) {
        ConnectBasicExample connectBasicExample = new ConnectBasicExample();
        connectBasicExample.run();
    }
    public void run() {
        JedisClientConfig config = DefaultJedisClientConfig.builder()
                .user("default")
                .password("vlFvZe2ZsFpcs7gkKUydFNW2VFQxwBJc")
                .build();

        UnifiedJedis jedis = new UnifiedJedis(
            new HostAndPort("redis-12531.c323.us-east-1-2.ec2.redns.redis-cloud.com", 12531),
            config
        );



        String res1 = jedis.set("foo", "bar");
        System.out.println(res1); // >>> OK

        String res2 = jedis.get("foo");
        System.out.println(res2); // >>> bar

        jedis.close();
    }
}
