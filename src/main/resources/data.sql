INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('heidarik@sheridancollege.ca', '$2a$12$p6XLc9QA7fK4h1ZP3SgvpuWRZ.loGWqNwmt7ceXluuiUJ8o/wIf7C', 1);

INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('frank@sheridancollege.ca', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);


INSERT INTO sec_role (roleName)
VALUES ('ROLE_USER');
 
INSERT INTO sec_role (roleName)
VALUES ('ROLE_GUEST');

 
INSERT INTO user_role (userId, roleId)
VALUES (1, 1);
 
INSERT INTO user_role (userId, roleId)
VALUES (2, 2);



INSERT INTO furnace(asin,brand ,Wattage ,price,Weight ,description)values
('839733','Goodman',1500,3000,3,'Goodman GMVC960804CN Upflow/Horizontal Furnace
Variable-Speed ECM Two-Stage 96% AFUE Energy Star ComfortBridge CoolCloud'),
('955413','Williams',1200,2500,2,'PolyTuf Textured Powder Coating The Raypak gas heater has a polyester-coated, non-corrosive cabinet that is more durable than solventborne- and waterborne-coated metal cabinets.'),
('654798','Rinnai',1300,2900,1,'Stainless Steel Tube Sheet Stainless steel tube sheets are used on all Raypak heaters with the polymer headers. This allows for a completely nonferrous waterway, leaving your pool truly rust-free.');




