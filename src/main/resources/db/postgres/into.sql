/*insert into color_detail (id, title, title_manufacturer, country_manufacturer, price) VALUES
  (1,'Кантри','SWISSPAN','UKRAINE',9);*/

/*insert into edge_material (id, name, edge_type, colordetail, price, thickness, country) VALUES
  (1, 'Пепел','PVH','ПЕПЕЛ','1.23','0.8','UKRAINE')*/
/*INSERT INTO edge_material_has_side (edge_material_id, side) VALUES
  (1,'SIDE_DOUBLE_X')*/
INSERT into  details (id, name, x, y, count, material, color_detail_id, thickness) VALUES
  (8,'Бокавина','500','800','2','DSP','1','18')
/*
INSERT INTO details_has_edge_material (edge_material_id, details_id) VALUES
  ('1','1');*/