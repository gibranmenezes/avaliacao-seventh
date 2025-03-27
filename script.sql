-- scripts de criação das tabelas

create table cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE
)


create table Pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT NOT NULL,
    data DATE NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

--script de inserção de dados
insert into Cliente (nome, email) VALUES
('João Silva', 'joao.silva@email.com'),
('Maria Oliveira', 'maria.oliveira@email.com'),
('Carlos Souza', 'carlos.souza@email.com');

insert into Pedido (cliente_id, data, total) VALUES
(1, '2025-03-01', 150.50),
(2, '2025-03-02', 99.99),
(1, '2025-03-03', 200.00),
(3, '2025-03-04', 350.75),
(2, '2025-03-05', 120.25);

-- script de consulta 

select 
    cli.nome, as "Cliente"
    p.data AS 'Data Pedido',
    p.total AS 'Valor Total'
from 
    Pedido p
join 
    Cliente cli ON p.cliente_id = cli.id
where 
    p.total > 100
order by 
    p.data desc;