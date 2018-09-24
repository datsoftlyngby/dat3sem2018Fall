DELETE FROM `class_member` WHERE 1;
DELETE FROM `user` WHERE 1;
DELETE FROM `permission` WHERE 1;

INSERT INTO `permission` VALUES
('admin', 68719476735),
('student', 1360089141),
('teacher', 66024595317);

INSERT INTO `user`(`username`, `name`) VALUES 
('cph-sb339', 'Simon Schønberg Bojesen'),
('cph-mf227', 'Morten Feldt'),
('cph-cm267', 'Christian Falk Moustesgård'),
('cph-md254', 'Mark Dyrby Denner'),
('cph-ja265', 'Jamal Abdiqadir Ahmed'),
('cph-le97',  'Lau Egeberg Ewertsen'),
('cph-mk523', 'Mathias Baunsgaard Kristensen'),
('cph-jo130', 'Jörg Erwin Oertel'),
('cph-kp222', 'Kim Peder Pedersen'),
('cph-rj173', 'Rasmus Lynge Jacobsen'),
('cph-aw99',  'Alexander Weikop'),
('cph-jr221', 'Johan Christian Ryge'),
('cph-nr87',  'Nikolai Rojahn'),
('cph-mf226', 'Mads Christian Fløistrup'),
('cph-dt63',  'Dan Tomicic'),
('cph-mh720', 'Mads Rønbo Harretche'),
('cph-ln240', 'Lea Gemzøe Nielsen'),
('cph-mk525', 'Magnus Albeck Klitmose'),
('cph-dd62',  'Damjan Djurisic'),
('cph-jp284', 'Jesper Petersen'),
('cph-mj679', 'Mark Jespersen'),
('cph-jh409', 'Jonatan Mejer Hjelm'),
('cph-rp127', 'Rasmus Porse'),
('cph-cj331', 'Claudia Victoria Jensen'),
('cph-dt64',  'Dogan Mike Turan'),
('cph-mn492', 'Mads Wulff Nielsen'),
('cph-cm268', 'Casper Marx'),
('cph-ed66',  'Esben Dalgaard'),
('cph-mp447', 'Michael Due Pedersen'),
('cph-jc173', 'Jesper Christensen'),
('cph-mr393', 'Mathias Malthe Roed'),
('cph-oh45',  'Oliver Jais Helholt'),
('cph-ln239', 'Lasse Arendholdt Nielsen'),
('cph-mk524', 'Marko Kvasina'),
('cph-at89',  'Arik Twena'),
('cph-fo35',  'Frank Arvid Olsen'),
('cph-rb126', 'Rasmus Zimmermann Bach'),
('cph-ns156', 'Nur-Alhussein Salem Sabet');

INSERT INTO `class_member` 
SELECT `username`, 'l18dat1af' 
FROM `user`;

INSERT INTO `user`(`username`, `name`, `permission_name`) VALUES 
('RODA', 'Ronnie Dalsgaard', 'teacher'),
('KOE', 'Kasper Østerbye', 'teacher');



