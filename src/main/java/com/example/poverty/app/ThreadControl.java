package com.example.poverty.app;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ccphamy
 */
public interface ThreadControl {


    int QUEUE_MAX = 100;
    int CORE_POOL_SIZE = 10;
    int MAX_POOL_SIZE = 10;

    /**
     * PV操作,默认给100个资源
     */
    AtomicInteger SIGNAL = new AtomicInteger(QUEUE_MAX);

    String READ_EXCEL_PATH = "/home/ccphamy/Desktop/";
}
