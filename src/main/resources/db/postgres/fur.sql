DROP TABLE IF EXISTS furniture;

-- -----------------------------------------------------
-- Table `Furniture`.`order`
-- -----------------------------------------------------
CREATE TABLE orders (
  id     BIGSERIAL   NOT NULL PRIMARY KEY,
  name   VARCHAR(45) NOT NULL,
  author VARCHAR(45) NOT NULL
);

-- -----------------------------------------------------
-- Table `Furniture`.`color_detail`
-- -----------------------------------------------------
CREATE TABLE color_detail (
  id                   BIGSERIAL   NOT NULL PRIMARY KEY,
  title                VARCHAR(45) NOT NULL,
  title_manufacturer   VARCHAR(45) NOT NULL,
  country_manufacturer VARCHAR(45) NOT NULL,
  price                DECIMAL     NOT NULL
);

-- -----------------------------------------------------
-- Table `Furniture`.`edge_material`
-- -----------------------------------------------------
CREATE TABLE edge_material (
  id          BIGSERIAL        NOT NULL PRIMARY KEY,
  name        VARCHAR(45)      NOT NULL,
  edge_type   VARCHAR(50)      NOT NULL,
  colorDetail VARCHAR(45)      NOT NULL,
  price       DECIMAL          NOT NULL,
  thickness   DOUBLE PRECISION NOT NULL,
  country     VARCHAR(45)      NOT NULL
);

-- -----------------------------------------------------
-- Table `Furniture`.`edge_material has side`
-- -----------------------------------------------------
CREATE TABLE edge_material_has_side (
  edge_material_id INTEGER NOT NULL,
  side             VARCHAR(45),
  FOREIGN KEY (edge_material_id) REFERENCES edge_material (id)

);

-- -----------------------------------------------------
-- Table `Furniture`.`module`
-- -----------------------------------------------------

CREATE TABLE module (
  id          BIGSERIAL   NOT NULL,
  title       VARCHAR(45) NOT NULL,
  module_type VARCHAR(45) NOT NULL,
  order_id    INT         NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT Fk_ord FOREIGN KEY (order_id) REFERENCES orders (id)
);

-- -----------------------------------------------------
-- Table `Furniture`.`details`
-- -----------------------------------------------------
CREATE TABLE details (
  id              BIGSERIAL        NOT NULL PRIMARY KEY,
  name            VARCHAR(45)      NOT NULL,
  x               INT              NOT NULL,
  y               INT              NOT NULL,
  count           INT              NOT NULL,
  color_detail_id INT              NOT NULL,
  material        VARCHAR(45)      NOT NULL,
  thickness       DOUBLE PRECISION NOT NULL,
  module_id       INT              NOT NULL,

  CONSTRAINT fk_module
  FOREIGN KEY (module_id)
  REFERENCES module (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,

  CONSTRAINT fk_details_color_detail1
  FOREIGN KEY (color_detail_id)
  REFERENCES color_detail (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Table details_has_edge_material
-- -----------------------------------------------------
CREATE TABLE details_has_edge_Material (
  edge_material_id INT NOT NULL,
  details_id       INT NOT NULL,
  PRIMARY KEY (edge_material_id, details_id),
  CONSTRAINT fk_order_has_details_order1
  FOREIGN KEY (edge_material_id)
  REFERENCES edge_material (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT fk_order_has_details_details1
  FOREIGN KEY (details_id) REFERENCES details (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Table `Furniture`.`users`
-- -----------------------------------------------------
/*CREATE TABLE IF NOT EXISTS ` Furniture`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  ` name ` VARCHAR (45
) NOT NULL,
  `email` VARCHAR (45
) NOT NULL,
  ` password ` VARCHAR (45
) NOT NULL,
  ` enabled ` TINYINT NOT NULL,
PRIMARY KEY (`id`
)
)
  ENGINE = InnoDB;*/

-- -----------------------------------------------------
-- Table `Furniture`.`facade`
-- -----------------------------------------------------
/*CREATE TABLE IF NOT EXISTS ` Furniture`.`facade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `facade_type` VARCHAR (45
) NOT NULL,
  `details_id` INT NOT NULL,
PRIMARY KEY (`id`
),
INDEX `fk_facade_details_idx` (`details_id` ASC
),
CONSTRAINT `fk_facade_details`
FOREIGN KEY (`details_id`
)
REFERENCES `Furniture`.`details` (`id`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
  ENGINE = InnoDB;*/

-- -----------------------------------------------------
-- Table `Furniture`.`furniture`
-- -----------------------------------------------------
/*CREATE TABLE IF NOT EXISTS ` Furniture`.`furniture` (
  `id` INT NOT NULL AUTO_INCREMENT,
  ` count ` INT NOT NULL,
  `price` DECIMAL NOT NULL,
PRIMARY KEY (`id`
)
)
  ENGINE = InnoDB;*/

-- -----------------------------------------------------
-- Table `Furniture`.`order_has_details`
-- -----------------------------------------------------
/*CREATE TABLE IF NOT EXISTS ` Furniture`.`order_has_details` (
  `order_id` INT NOT NULL,
  `details_id` INT NOT NULL,
PRIMARY KEY (`order_id`, `details_id`
),
INDEX `fk_order_has_details_details1_idx` (`details_id` ASC
),
INDEX `fk_order_has_details_order1_idx` (`order_id` ASC
),
CONSTRAINT `fk_order_has_details_order1`
FOREIGN KEY (`order_id`
)
REFERENCES `Furniture`.` order ` (`id`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_order_has_details_details1`
FOREIGN KEY (`details_id`
)
REFERENCES `Furniture`.`details` (`id`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
  ENGINE = InnoDB;*/

-- -----------------------------------------------------
-- Table `Furniture`.`order_has_furniture`
-- -----------------------------------------------------
/*CREATE TABLE IF NOT EXISTS ` Furniture`.`order_has_furniture` (
  `order_id` INT NOT NULL,
  `furniture_id` INT NOT NULL,
PRIMARY KEY (`order_id`, `furniture_id`
),
INDEX `fk_order_has_furniture_furniture1_idx` (`furniture_id` ASC
),
INDEX `fk_order_has_furniture_order1_idx` (`order_id` ASC
),
CONSTRAINT `fk_order_has_furniture_order1`
FOREIGN KEY (`order_id`
)
REFERENCES `Furniture`.` order ` (`id`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_order_has_furniture_furniture1`
FOREIGN KEY (`furniture_id`
)
REFERENCES `Furniture`.`furniture` (`id`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
  ENGINE = InnoDB;
*/
-- -----------------------------------------------------
-- Table `Furniture`.`order_has_facade`
-- -----------------------------------------------------
/*CREATE TABLE IF NOT EXISTS ` Furniture`.`order_has_facade` (
  `order_id` INT NOT NULL,
  `facade_id` INT NOT NULL,
PRIMARY KEY (`order_id`, `facade_id`
),
INDEX `fk_order_has_facade_facade1_idx` (`facade_id` ASC
),
INDEX `fk_order_has_facade_order1_idx` (`order_id` ASC
),
CONSTRAINT `fk_order_has_facade_order1`
FOREIGN KEY (`order_id`
)
REFERENCES `Furniture`.` order ` (`id`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_order_has_facade_facade1`
FOREIGN KEY (`facade_id`
)
REFERENCES `Furniture`.`facade` (`id`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
  ENGINE = InnoDB;*/

-- -----------------------------------------------------
-- Table `Furniture`.`roles`
-- -----------------------------------------------------
/*CREATE TABLE roles (
  users_id INT         NOT NULL,
  roles    VARCHAR(45) NOT NULL,
  CONSTRAINT fk_roles_users1
  FOREIGN KEY (users_id)
  REFERENCES users (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
);*/


-- -----------------------------------------------------
-- Table `Furniture`.`module_has_facade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ` Furniture`.`module_has_facade` (
  `module_id` INT NOT NULL,
  `facade_id` INT NOT NULL,
PRIMARY KEY (`module_id`, `facade_id`
),
INDEX `fk_module_has_facade_facade1_idx` (`facade_id` ASC
),
INDEX `fk_module_has_facade_module1_idx` (`module_id` ASC
),
CONSTRAINT `fk_module_has_facade_module1`
FOREIGN KEY (`module_id`
)
REFERENCES `Furniture`.`module` (`id`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_module_has_facade_facade1`
FOREIGN KEY (`facade_id`
)
REFERENCES `Furniture`.`facade` (`id`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Furniture`.`module_has_furniture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ` Furniture`.`module_has_furniture` (
  `module_id` INT NOT NULL,
  `furniture_id` INT NOT NULL,
PRIMARY KEY (`module_id`, `furniture_id`
),
INDEX `fk_module_has_furniture_furniture1_idx` (`furniture_id` ASC
),
INDEX `fk_module_has_furniture_module1_idx` (`module_id` ASC
),
CONSTRAINT `fk_module_has_furniture_module1`
FOREIGN KEY (`module_id`
)
REFERENCES `Furniture`.`module` (`id`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_module_has_furniture_furniture1`
FOREIGN KEY (`furniture_id`
)
REFERENCES `Furniture`.`furniture` (`id`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Furniture`.`articuls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ` Furniture`.`articuls` (
  `articuls` INT NOT NULL AUTO_INCREMENT,
  `furniture_id` INT NOT NULL,
PRIMARY KEY (`articuls`
),
INDEX `fk_articuls_furniture1_idx` (`furniture_id` ASC
),
CONSTRAINT `fk_articuls_furniture1`
FOREIGN KEY (`furniture_id`
)
REFERENCES `Furniture`.`furniture` (`id`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Furniture`.`lifts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ` Furniture`.`lifts` (
  `articul` INT NOT NULL,
  `name_manufacture` VARCHAR (45
) NOT NULL,
  `county` VARCHAR (45
) NOT NULL,
  `articuls_articuls` INT NOT NULL,
PRIMARY KEY (`articul`
),
INDEX `fk_lifts_articuls1_idx` (`articuls_articuls` ASC
),
CONSTRAINT `fk_lifts_articuls1`
FOREIGN KEY (`articuls_articuls`
)
REFERENCES `Furniture`.`articuls` (`articuls`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Furniture`.`angle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ` Furniture`.`angle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  ` NAME ` VARCHAR (45
) NOT NULL,
  `angle` DOUBLE NOT NULL,
PRIMARY KEY (`id`
)
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Furniture`.`loops`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ` Furniture`.`loops` (
  `articul` INT NOT NULL,
  `name_manufacture` VARCHAR (45
) NOT NULL,
  `country` VARCHAR (45
) NOT NULL,
  `angle_id` INT NOT NULL,
  `microlift` TINYINT NOT NULL,
  `articuls_articuls` INT NOT NULL,
PRIMARY KEY (`articul`
),
INDEX `fk_loops_angle1_idx` (`angle_id` ASC
),
INDEX `fk_loops_articuls1_idx` (`articuls_articuls` ASC
),
CONSTRAINT `fk_loops_angle1`
FOREIGN KEY (`angle_id`
)
REFERENCES `Furniture`.`angle` (`id`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_loops_articuls1`
FOREIGN KEY (`articuls_articuls`
)
REFERENCES `Furniture`.`articuls` (`articuls`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Furniture`.`type_lifts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ` Furniture`.`type_lifts` (
  `lifts_articul` INT NOT NULL,
  ` TYPE ` VARCHAR (45
) NOT NULL,
INDEX `fk_type_lifts_lifts1_idx` (`lifts_articul` ASC
),
CONSTRAINT `fk_type_lifts_lifts1`
FOREIGN KEY (`lifts_articul`
)
REFERENCES `Furniture`.`lifts` (`articul`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Furniture`.`type_loop`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ` Furniture`.`type_loop` (
  `loops_articul` INT NOT NULL,
  ` TYPE ` VARCHAR (45
) NOT NULL,
INDEX `fk_type_loop_loops1_idx` (`loops_articul` ASC
),
CONSTRAINT `fk_type_loop_loops1`
FOREIGN KEY (`loops_articul`
)
REFERENCES `Furniture`.`loops` (`articul`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Furniture`.`handle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ` Furniture`.`handle` (
  `articul` INT NOT NULL,
  `center_distance` INT NOT NULL,
  `articuls_articuls` INT NOT NULL,
PRIMARY KEY (`articul`
),
INDEX `fk_handle_articuls1_idx` (`articuls_articuls` ASC
),
CONSTRAINT `fk_handle_articuls1`
FOREIGN KEY (`articuls_articuls`
)
REFERENCES `Furniture`.`articuls` (`articuls`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Furniture`.`handle_color`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ` Furniture`.`handle_color` (
  `handle_articul` INT NOT NULL,
  `colorDetail` VARCHAR (45
) NULL,
INDEX `fk_handle_color_handle1_idx` (`handle_articul` ASC
),
CONSTRAINT `fk_handle_color_handle1`
FOREIGN KEY (`handle_articul`
)
REFERENCES `Furniture`.`handle` (`articul`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Furniture`.`guiedes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ` Furniture`.`guiedes` (
  `articul` INT NOT NULL,
  `name_manufacture` VARCHAR (45
) NOT NULL,
  ` LENGTH ` INT NOT NULL,
  `microlift` TINYINT NULL,
  `articuls_articuls` INT NOT NULL,
PRIMARY KEY (`articul`
),
INDEX `fk_guiedes_articuls1_idx` (`articuls_articuls` ASC
),
CONSTRAINT `fk_guiedes_articuls1`
FOREIGN KEY (`articuls_articuls`
)
REFERENCES `Furniture`.`articuls` (`articuls`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Furniture`.`other`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ` Furniture`.`other` (
  `articul` INT NOT NULL,
  ` NAME ` VARCHAR (45
) NOT NULL,
  `articuls_articuls` INT NOT NULL,
PRIMARY KEY (`articul`
),
INDEX `fk_other_articuls1_idx` (`articuls_articuls` ASC
),
CONSTRAINT `fk_other_articuls1`
FOREIGN KEY (`articuls_articuls`
)
REFERENCES `Furniture`.`articuls` (`articuls`
)
ON DELETE NO ACTION
ON UPDATE NO ACTION
);

