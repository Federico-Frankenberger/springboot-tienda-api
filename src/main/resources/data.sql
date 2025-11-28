-- Carga de Categorías
INSERT INTO categorias (nombre, descripcion) VALUES ('Electrónica', 'Dispositivos electrónicos y gadgets');
INSERT INTO categorias (nombre, descripcion) VALUES ('Hogar', 'Artículos para la decoración y uso doméstico');
INSERT INTO categorias (nombre, descripcion) VALUES ('Ropa', 'Indumentaria masculina y femenina');

-- Carga de Sucursales
INSERT INTO sucursales (nombre, direccion) VALUES ('Sucursal Central', 'Av. Corrientes 1234, CABA');
INSERT INTO sucursales (nombre, direccion) VALUES ('Sucursal Norte', 'Calle Falsa 123, Córdoba');

-- Carga de Clientes
INSERT INTO clientes (nombre, apellido, dni, email, telefono, direccion) VALUES ('Juan', 'Pérez', '30123456', 'juan.perez@mail.com', '1122334455', 'Calle 1');
INSERT INTO clientes (nombre, apellido, dni, email, telefono, direccion) VALUES ('Maria', 'Gomez', '31654321', 'maria.gomez@mail.com', '1155443322', 'Calle 2');

-- Carga de Productos
INSERT INTO productos (nombre, marca, precio, stock, categoria_id) VALUES ('Smartphone Samsung', 'Samsung', 500.00, 50, 1);
INSERT INTO productos (nombre, marca, precio, stock, categoria_id) VALUES ('Notebook HP', 'HP', 900.00, 20, 1);
INSERT INTO productos (nombre, marca, precio, stock, categoria_id) VALUES ('Cafetera Express', 'Philips', 120.00, 15, 2);
INSERT INTO productos (nombre, marca, precio, stock, categoria_id) VALUES ('Remera Básica', 'Nike', 25.00, 100, 3);