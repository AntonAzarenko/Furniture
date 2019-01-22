insert into color_detail (id, title, title_manufacturer, country_manufacturer, price) VALUES
  (1,'Кантри','SWISSPAN','UKRAINE',9),
  (2,'Пепел','SWISSPAN','UKRAINE',9),
  (3,'Крем','SWISSPAN','UKRAINE',9);


INSERT INTO edge (id, name, edge_type, color, price, thickness, country) VALUES
  (1, 'Пепел', 'PVH', 'ПЕПЕЛ', '1.23', '0.8', 'UKRAINE');

INSERT INTO orders (id, name, author) VALUES
  (1, 'заказ №1', 'anton_azarenka');

INSERT INTO module (id, title, module_type, order_id) VALUES
  (1, 'Крой на стол', 'CUTTING', 1);

INSERT INTO details (id, name, x, y, count, color_detail_id, material, thickness, module_id) VALUES
   (1,'Боковина','500','800','2','1','DSP','18', 1),
  (2, 'Боковина', '500', '800', '2', '1', 'DSP', '18', 1),
  (3, 'Боковина', '500', '800', '2', '1', 'DSP', '18', 1),
  (4, 'Боковина', '500', '800', '2', '1', 'DSP', '18', 1);

INSERT INTO edge_of_detail_has_side ( edge_id, detail_id, side) VALUES
  (1, 1, 'SIDE_DOUBLE_X');




