/*insert into color_detail (id, title, title_manufacturer, country_manufacturer, price) VALUES
  (1,'Кантри','SWISSPAN','UKRAINE',9),
  (2,'Пепел','SWISSPAN','UKRAINE',9),
  (3,'Крем','SWISSPAN','UKRAINE',9);

insert into edge_material (id, name, edge_type, colordetail, price, thickness, country) VALUES
  (1, 'Пепел','PVH','ПЕПЕЛ','1.23','0.8','UKRAINE');

INSERT INTO edge_material_has_side (edge_material_id, side) VALUES
  (1,'SIDE_DOUBLE_X');*/
/*INSERT into orders (id, name, author) VALUES
  (1, 'заказ №1','anton_azarenka')*/

/*insert INTO module (id, title, module_type, order_id) VALUES
  (1,'Крой на стол','CUTTING',1);*/

INSERT into  details (id, name, x, y, count, color_detail_id, material, thickness, module_id) VALUES
 /* (1,'Боковина','500','800','2','1','DSP','18', 1);*/
  (2,'Боковина','500','800','2','1','DSP','18', 1),
(3,'Боковина','500','800','2','1','DSP','18', 1),
(4,'Боковина','500','800','2','1','DSP','18', 1)

/*INSERT INTO details_has_edge_material (edge_material_id, details_id) VALUES
  ('1','1');*/



