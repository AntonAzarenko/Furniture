

-- -----------------------------------------------------
-- Table `Furniture`.`users`
-- -----------------------------------------------------
create table users (
  id         bigserial   not null,
  name       VARCHAR(100),
  email      varchar(45) not null unique,
  password   varchar(255) not null,
  enabled    boolean     not null,
  registered timestamp default (now()),
  primary key (id)
);

-- -----------------------------------------------------
-- Table `Furniture`.`roles`
-- -----------------------------------------------------
create table roles (
  users_id int         not null,
  role     varchar(45) not null,
  constraint fk_roles_users1
  foreign key (users_id)
  references users (id)
  on delete cascade
  on update cascade
);

-- -----------------------------------------------------
-- Table `Furniture`.`order`
-- -----------------------------------------------------
create table orders (
  id               bigserial    not null primary key,
  name             VARCHAR(45),
  author           varchar(45),
  user_name        varchar(100) not null,
  address          varchar(255),
  customer_name    varchar(255),
  tel_number       varchar(255),
  date_of_create   timestamp default (now()),
  date_of_contract timestamp,
  constraint U_N foreign key (user_name) references users (email)
);

create table module (
  id          bigserial   not null,
  title       varchar(45) not null,
  module_type varchar(45) not null,
  order_id    int         not null,
  primary key (id),
  constraint Fk_ord foreign key (order_id) references orders (id)
  on delete cascade
);
-- -----------------------------------------------------
-- Table `Furniture`.`color_detail`
-- -----------------------------------------------------
create table color_detail (
  id                   bigserial   not null primary key,
  title                varchar(45) not null,
  title_manufacturer   varchar(45) not null,
  country_manufacturer varchar(45) not null,
  price                decimal     not null
);

-- -----------------------------------------------------
-- Table `Furniture`.`edge`
-- -----------------------------------------------------
create table edge (
  id        bigserial        not null primary key,
  name      VARCHAR(45)      NOT NULL,
  edge_type varchar(50)      not null,
  color     varchar(45)      not null,
  price     decimal          not null,
  thickness DOUBLE PRECISION not null,
  country   varchar(45)      not null
);

-- -----------------------------------------------------
-- Table `Furniture`.`details`
-- -----------------------------------------------------
create table details (
  id              bigserial        not null primary key,
  name            VARCHAR(45)      NOT NULL,
  x               int              not null,
  y               int              not null,
  count           int              not null,
  color_detail_id int              not null,
  material        varchar(45)      not null,
  thickness       DOUBLE PRECISION not null,
  module_id       int              not null,

  constraint fk_module
  foreign key (module_id)
  references module (id)
  on delete cascade
  on update cascade,

  constraint fk_details_color_detail1
  foreign key (color_detail_id)
  references color_detail (id)
  on delete cascade
  on update cascade

);
-- -----------------------------------------------------
-- Table `Furniture`.`edge_material_has_side
-- -----------------------------------------------------
create table edge_material (
  id      bigserial not null primary key,
  edge_id integer   not null,
  side    varchar(45),
  foreign key (edge_id) references edge (id)
  on delete cascade

);

-- -----------------------------------------------------
-- Table `Furniture`. detail_has_edge_material
-- -----------------------------------------------------

create table detail_has_edge_material (
  detail_id        integer not null,
  edge_material_id integer not null,
  foreign key (detail_id) references details (id),
  foreign key (edge_material_id) references edge_material (id)
);

-- -----------------------------------------------------
-- Table `Furniture`.`handle_catalog`
-- -----------------------------------------------------
create table  handle_catalog (
id bigserial not null primary key,
article varchar(25) not null unique,
file_name varchar(255)
);

-- -----------------------------------------------------
-- Table `Furniture`.`handle_params`
-- -----------------------------------------------------

create table handle_params(
id bigserial primary key,
id_handle bigint not null,
center_distance integer not null,
price decimal(10,2) not  null,
foreign key (id_handle) references handle_catalog (id)
);

-- -----------------------------------------------------
-- Table `Furniture`.`handle_colors`
-- -----------------------------------------------------

create table handle_colors(
id_handle bigint not null,
color varchar (100),
foreign key (id_handle) references handle_catalog (id)
);



-- -----------------------------------------------------
-- Table `Furniture`.`fitting`
-- -----------------------------------------------------

/*create table fitting(
id bigserial primary key,
count bigint not null,
price DECIMAL (10,2),
module_id bigint
);


-- -----------------------------------------------------
-- Table `Furniture`.`fitting_params`
-- -----------------------------------------------------

create table fitting_params(
id bigserial primary key,
id_param bigint,
id_fitting bigint ,
foreign key (id_fitting) references fitting (id)
);*/


