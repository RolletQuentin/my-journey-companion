CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Users
INSERT INTO userentity (id, firstname, lastname, email)
VALUES
    (uuid_generate_v4(), 'Quentin', 'Rollet', 'rolletquen@cy-tech.fr');

INSERT INTO userentity_roles (userentity_id, roles)
VALUES
    ((SELECT id FROM userentity WHERE email = 'rolletquen@cy-tech.fr'), 'USER'),
    ((SELECT id FROM userentity WHERE email = 'rolletquen@cy-tech.fr'), 'ADMIN');
