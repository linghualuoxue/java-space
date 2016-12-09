package com.bj.sxt;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IBasicBolt;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2016/12/9.
 */
public class MyBoltTwo extends BaseRichBolt {

    OutputCollector collector;
    Map<String,Integer> map = new HashMap<String, Integer>();
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
    this.collector = collector;
    }

    public void execute(Tuple tuple) {
        String word = tuple.getString(0);
        Integer num = Integer.valueOf(tuple.getString(1));
        Integer count = map.get(word);
        System.out.println("ThreadName:"+Thread.currentThread().getId()+"->word:"+word);
        if(count!=null){
         count+=num;
       }else{
            count = num;
        }
       map.put(word,count);
    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }
}
