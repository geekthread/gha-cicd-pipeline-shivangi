package org.example;

import redis.clients.jedis.json.Path;

import redis.clients.jedis.JedisPooled;

public class RedisJsonExampleOld {
    public static void main(String[] args) {
        // Use JedisPooled for Redis connection
        //redis-12531.c323.us-east-1-2.ec2.redns.redis-cloud.com:12531
        try (JedisPooled jedis = new JedisPooled("redis-12531.c323.us-east-1-2.ec2.redns.redis-cloud.com", 12531)) {
            System.out.println("Connected to Redis");

            // Define the JSON key and value
            String jsonKey = "user:55623";
            String jsonValue = "{\"name\":\"Tathya\",\"age\":7,\"city\":\"Japan\"}";

            // Set JSON data into Redis
            jedis.jsonSet(jsonKey, Path.ROOT_PATH, jsonValue);
            System.out.println("JSON data set successfully!");

            // Retrieve JSON data from Redis
            String retrievedJson = (String) jedis.jsonGet(jsonKey);
            System.out.println("Retrieved JSON: " + retrievedJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


