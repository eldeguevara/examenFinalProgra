package com.demo.tablas;

import jakarta.persistence.*;

@Entity
public class MessageTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TopicType topicType;

    public  MessageTopic(){}

    public MessageTopic(TopicType topicType) {
        this.topicType = topicType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TopicType getTopicType() {
        return topicType;
    }

    public void setTopicType(TopicType topicType) {
        this.topicType = topicType;
    }
}
