package com.bj.sxt;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;

/**
 * Created by user on 2016/12/9.
 */
public class StromWordCount {
    public static void main(String[] args) {

        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("mySpout",new MySpout(),2);
        builder.setBolt("bolt1",new MyBoltOne(),2).shuffleGrouping("mySpout");
        builder.setBolt("bolt2",new MyBoltTwo(),4).fieldsGrouping("bolt1",new Fields("word"));

        Config config = new Config();
        config.setNumWorkers(2);

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("stormCount",config,builder.createTopology());
    }
}
