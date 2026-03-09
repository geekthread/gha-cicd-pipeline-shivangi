package org.example;

import redis.clients.jedis.*;
import redis.clients.jedis.json.Path;

public class RedisJsonExample {
    public static void main(String[] args) {
        // Create a JedisPoolConfig for the connection pool
        JedisPoolConfig poolConfig = new JedisPoolConfig();

        // Initialize the JedisPool with authentication details
        try {
            JedisClientConfig config = DefaultJedisClientConfig.builder()
                    .user("default")
                    .password("vlFvZe2ZsFpcs7gkKUydFNW2VFQxwBJc")
                    .build();

            UnifiedJedis jedis = new UnifiedJedis(
                    new HostAndPort("redis-12531.c323.us-east-1-2.ec2.redns.redis-cloud.com", 12531),
                    config
            );

            System.out.println("Connected to Redis");

            // Define the JSON key and value
            String jsonKey = "user:445345";
            String jsonValue = "{\"name\":\"Tathya\",\"age\":7,\"city\":\"Japan\"}";  // Note: fixed age value

            // Set JSON data into Redis
            jedis.jsonSet(jsonKey, Path.of("$"), jsonValue);  // Correct Path usage
            System.out.println("JSON data set successfully!");

            // Retrieve JSON data from Redis
            String retrievedJson = (String) jedis.jsonGet(jsonKey);
            System.out.println("Retrieved JSON: " + retrievedJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
