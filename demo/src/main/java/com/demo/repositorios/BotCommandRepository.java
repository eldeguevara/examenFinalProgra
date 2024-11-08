package com.demo.repositorios;

import com.demo.tablas.BotCommand;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BotCommandRepository extends JpaRepository<BotCommand, Long> {
    Optional<BotCommand> findByCommandName(String commandName);
}
