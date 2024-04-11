CREATE DATABASE iscodhelpdeskbootcamp;
CREATE TABLE IF NOT EXISTS iscodhelpdeskbootcamp.`message` (
	`id` int AUTO_INCREMENT NOT NULL UNIQUE,
	`isSupport` boolean NOT NULL,
	`content` text NOT NULL,
	`create_at` timestamp NOT NULL,
	`username` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);