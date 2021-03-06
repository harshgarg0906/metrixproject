package com.metrix.rules.config;


import com.metrix.libs.model.RuleActivityData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    private static final Logger LOG = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, RuleActivityData> kafkaTemplate;

    @Value("${app.topic.producer}")
    private String topic;

    public void send(RuleActivityData ruleActivityData){
//        System.out.println(kafkaTemplate);
        LOG.info("sending message='{}' to topic='{}'", ruleActivityData, topic);
        kafkaTemplate.send(topic, ruleActivityData);
    }
}
