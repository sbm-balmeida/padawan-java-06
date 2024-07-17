CREATE DATABASE  IF NOT EXISTS `loja_virtual` ;
USE `loja_virtual`;


DROP TABLE IF EXISTS `produto`;

CREATE TABLE `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 
INSERT INTO `produto` VALUES (1,'NOTEBOOK','NOTEBOOK SAMSUNG');
