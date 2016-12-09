package com.bj.sxt;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IBasicBolt;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

import java.util.Map;

/**
 * Created by user on 2016/12/9.
 */
public class MyBoltOne extends BaseRichBolt {

    OutputCollector collector;
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        this.collector = collector;
    }

    public void execute(Tuple tuple) {
        String strs = tuple.getString(0);
        String[] strArr = strs.split(" ");
        for (String s : strArr) {
            collector.emit(new Values(s,1));
        }
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
       declarer.declare(new Fields("word","num"));
    }
}
