package com.redis.lars;

import java.util.Map;

import io.lettuce.core.dynamic.Commands;
import io.lettuce.core.dynamic.annotation.Command;

public interface TimeSeriesCommands extends Commands {

    @Command("TS.CREATE :key RETENTION :retentionTime ")
    void create(String key, long retentionTime);

    void add(String key, double value);

    Map<String, String> range(String key, long from, long to);

}