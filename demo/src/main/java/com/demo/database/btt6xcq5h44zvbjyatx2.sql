-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: btt6xcq5h44zvbjyatx2-mysql.services.clever-cloud.com:3306
-- Tiempo de generación: 08-11-2024 a las 05:39:33
-- Versión del servidor: 8.0.15-5
-- Versión de PHP: 8.2.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `btt6xcq5h44zvbjyatx2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bot_command`
--

CREATE TABLE `bot_command` (
  `id` bigint(20) NOT NULL,
  `command_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bot_response`
--

CREATE TABLE `bot_response` (
  `id` bigint(20) NOT NULL,
  `response_content` varchar(255) DEFAULT NULL,
  `timestamp` varchar(255) DEFAULT NULL,
  `chat_message_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `chat_message`
--

CREATE TABLE `chat_message` (
  `id` bigint(20) NOT NULL,
  `message_content` varchar(255) DEFAULT NULL,
  `timestamp` varchar(255) DEFAULT NULL,
  `usuarios_id` bigint(20) DEFAULT NULL,
  `topic_id` bigint(20) DEFAULT NULL,
  `bot_command_id` bigint(20) DEFAULT NULL,
  `conversation_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `chat_message`
--

INSERT INTO `chat_message` (`id`, `message_content`, `timestamp`, `usuarios_id`, `topic_id`, `bot_command_id`, `conversation_id`) VALUES
(1, 'Este es un mensaje de prueba.', '1731040356661', 1, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conversation`
--

CREATE TABLE `conversation` (
  `id` bigint(20) NOT NULL,
  `end_time` datetime(6) DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `error_log`
--

CREATE TABLE `error_log` (
  `id` bigint(20) NOT NULL,
  `error_message` varchar(255) DEFAULT NULL,
  `stack_trace` varchar(255) DEFAULT NULL,
  `timestamp` datetime(6) DEFAULT NULL,
  `chat_message_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `message_topic`
--

CREATE TABLE `message_topic` (
  `id` bigint(20) NOT NULL,
  `topic_type` enum('CONSULTA','ENTRETENIMIENTO','SOPORTE') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `message_topic`
--

INSERT INTO `message_topic` (`id`, `topic_type`) VALUES
(1, 'CONSULTA'),
(2, 'ENTRETENIMIENTO'),
(3, 'SOPORTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `relevance`
--

CREATE TABLE `relevance` (
  `id` bigint(20) NOT NULL,
  `level` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_preference`
--

CREATE TABLE `user_preference` (
  `id` bigint(20) NOT NULL,
  `language` varchar(255) DEFAULT NULL,
  `message_frequency` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `user_preference`
--

INSERT INTO `user_preference` (`id`, `language`, `message_frequency`) VALUES
(1, 'es', 'DAILY');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_session`
--

CREATE TABLE `user_session` (
  `id` bigint(20) NOT NULL,
  `end_time` datetime(6) DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `chat_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `preference_id` bigint(20) DEFAULT NULL,
  `conversation_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `chat_id`, `name`, `username`, `preference_id`, `conversation_id`) VALUES
(1, '123456789', 'Juan Perez', 'juan123', 1, NULL),
(2, '123456789', 'Diegog gfd', '656546', NULL, NULL),
(3, '123456789', 'Diegog 654', '656546', NULL, NULL),
(4, '123456789', 'Diegog 6656', '656546', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `webhook_config`
--

CREATE TABLE `webhook_config` (
  `id` bigint(20) NOT NULL,
  `endpoint_url` varchar(255) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `secret_token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bot_command`
--
ALTER TABLE `bot_command`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `bot_response`
--
ALTER TABLE `bot_response`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKpl55q8g9ilgu36gwbfudm1cuw` (`chat_message_id`);

--
-- Indices de la tabla `chat_message`
--
ALTER TABLE `chat_message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3qae6h0bvf2twrpueb4b2isya` (`usuarios_id`),
  ADD KEY `FK45mikere1xx3dsdrhn28fmaiw` (`topic_id`),
  ADD KEY `FKbfw2o7crrc9qacbelwatodaoy` (`bot_command_id`),
  ADD KEY `FKkxe2b8q35d0baph3krucvraif` (`conversation_id`);

--
-- Indices de la tabla `conversation`
--
ALTER TABLE `conversation`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `error_log`
--
ALTER TABLE `error_log`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3ketg2luo2hgktqdtsjnlv1kw` (`chat_message_id`);

--
-- Indices de la tabla `message_topic`
--
ALTER TABLE `message_topic`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `relevance`
--
ALTER TABLE `relevance`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKkk6gyvy4vtmy391alt4x26pl1` (`level`);

--
-- Indices de la tabla `user_preference`
--
ALTER TABLE `user_preference`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user_session`
--
ALTER TABLE `user_session`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbcikyyl997wny3snm0w8q9fou` (`user_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKt22vikl7h1xf01vbypuvl36ff` (`preference_id`),
  ADD KEY `FK9gjvyukk9owdo6e625l54a7fq` (`conversation_id`);

--
-- Indices de la tabla `webhook_config`
--
ALTER TABLE `webhook_config`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bot_command`
--
ALTER TABLE `bot_command`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `bot_response`
--
ALTER TABLE `bot_response`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `chat_message`
--
ALTER TABLE `chat_message`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `conversation`
--
ALTER TABLE `conversation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `error_log`
--
ALTER TABLE `error_log`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `message_topic`
--
ALTER TABLE `message_topic`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `relevance`
--
ALTER TABLE `relevance`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `user_preference`
--
ALTER TABLE `user_preference`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `user_session`
--
ALTER TABLE `user_session`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `webhook_config`
--
ALTER TABLE `webhook_config`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bot_response`
--
ALTER TABLE `bot_response`
  ADD CONSTRAINT `FKsgv137pt58ey6k1n8iy0craef` FOREIGN KEY (`chat_message_id`) REFERENCES `chat_message` (`id`);

--
-- Filtros para la tabla `chat_message`
--
ALTER TABLE `chat_message`
  ADD CONSTRAINT `FK3qae6h0bvf2twrpueb4b2isya` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `FK45mikere1xx3dsdrhn28fmaiw` FOREIGN KEY (`topic_id`) REFERENCES `message_topic` (`id`),
  ADD CONSTRAINT `FKbfw2o7crrc9qacbelwatodaoy` FOREIGN KEY (`bot_command_id`) REFERENCES `bot_command` (`id`),
  ADD CONSTRAINT `FKkxe2b8q35d0baph3krucvraif` FOREIGN KEY (`conversation_id`) REFERENCES `conversation` (`id`);

--
-- Filtros para la tabla `error_log`
--
ALTER TABLE `error_log`
  ADD CONSTRAINT `FK3ketg2luo2hgktqdtsjnlv1kw` FOREIGN KEY (`chat_message_id`) REFERENCES `chat_message` (`id`);

--
-- Filtros para la tabla `user_session`
--
ALTER TABLE `user_session`
  ADD CONSTRAINT `FKbcikyyl997wny3snm0w8q9fou` FOREIGN KEY (`user_id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `FK4qs7b29ums8o532aqglayk6v2` FOREIGN KEY (`preference_id`) REFERENCES `user_preference` (`id`),
  ADD CONSTRAINT `FK9gjvyukk9owdo6e625l54a7fq` FOREIGN KEY (`conversation_id`) REFERENCES `conversation` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
