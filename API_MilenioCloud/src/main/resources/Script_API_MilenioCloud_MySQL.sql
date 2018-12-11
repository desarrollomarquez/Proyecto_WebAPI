
SELECT * FROM notes_app.notes

create database concretepage;


CREATE TABLE concretepage.articles (
	articleId INT(5) NOT NULL AUTO_INCREMENT,
	title VARCHAR(200) NOT NULL,
	category VARCHAR(100) NOT NULL,
	PRIMARY KEY (articleId)
) ;

 