CREATE DATABASE IF NOT EXISTS helpcenter;
USE helpcenter;

CREATE TABLE IF NOT EXISTS helpcenter.`conversation` (
	`id` int AUTO_INCREMENT NOT NULL UNIQUE,
	`archive` boolean NOT NULL DEFAULT false,
	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS helpcenter.`message` (
	`id` int AUTO_INCREMENT NOT NULL UNIQUE,
	`isSupport` boolean NOT NULL,
	`content` text NOT NULL,
	`create_at` timestamp NOT NULL,
	`conversation_id` int NOT NULL,
	PRIMARY KEY (`id`)
);


ALTER TABLE helpcenter.`message` ADD CONSTRAINT `message_fk4` FOREIGN KEY (`conversation_id`) REFERENCES helpcenter.`conversation`(`id`);