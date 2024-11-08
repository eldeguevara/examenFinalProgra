package com.demo.repositorios;

import com.demo.tablas.MessageTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageTopicRepository extends JpaRepository<MessageTopic, Long> {
}
