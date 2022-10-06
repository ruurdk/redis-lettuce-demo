package com.redis.lars;

import java.util.HashMap;
import java.util.Map;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisCommandExecutionException;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.dynamic.RedisCommandFactory;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException {

        // Create a connection to Redis
        RedisClient redisClient = RedisClient.create("redis://@localhost:6379");
        StatefulRedisConnection<String, String> connection = redisClient.connect();

        // Get and set a key/string
        System.out.println("Hello string: " + connection.sync().get("hello"));

        // Get and set a key/hash
        System.out.println("Hello hash: " + connection.sync().hgetall("lars:helloWorld"));

        RedisCommandFactory rcf = new RedisCommandFactory(connection);
        //TimeSeriesCommands tsc = rcf.getCommands(TimeSeriesCommands.class);

        // Set and get some timeseries data.

        //System.out.println("Hello TimeSeries: " + tsc.range("myts", System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 7, System.currentTimeMillis()));

        RediSearchCommands rsc = rcf.getCommands(RediSearchCommands.class);
        
    }
}
