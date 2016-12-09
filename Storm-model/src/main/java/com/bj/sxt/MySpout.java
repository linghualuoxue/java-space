package com.bj.sxt;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import org.apache.storm.guava.io.Files;

import java.util.Map;

/**
 * Created by user on 2016/12/9.
 */
public class MySpout extends BaseRichSpout{

    SpoutOutputCollector collector;
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector collector) {

        this.collector = collector;
    }

    public void nextTuple() {

        collector.emit(new Values("xiao meng zi shi ge zhu lao lao"));
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
         declarer.declare(new Fields("haha"));
    }
}
