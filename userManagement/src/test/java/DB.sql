-- Création de la table User
CREATE TABLE IF NOT EXISTS user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    role VARCHAR(100)
);

-- Insertion de données fictives
INSERT INTO user (first_name, last_name, role) VALUES ('Cedric', 'Chanfreau', 'admin');
INSERT INTO user (first_name, last_name, role) VALUES ('Timothé', 'Bigot', 'user');