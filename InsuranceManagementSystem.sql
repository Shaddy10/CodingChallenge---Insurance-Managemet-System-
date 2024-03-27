create database InsuranceManagement;
use InsuranceManagement;
CREATE TABLE User (
    userId INT PRIMARY KEY,
    userName VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(50)
);

CREATE TABLE Client (
    clientId INT PRIMARY KEY,
    clientName VARCHAR(255),
    contactInfo VARCHAR(255),
    policy VARCHAR(255)
);

CREATE TABLE Claim (
    claimId INT PRIMARY KEY,
    claimNumber VARCHAR(255),
    dateFiled DATE,
    claimAmount DECIMAL(10, 2),
    status VARCHAR(50),
    policy VARCHAR(255),
    clientId INT,
    FOREIGN KEY (clientId) REFERENCES Client(clientId)
);


CREATE TABLE Payment (
    paymentId INT PRIMARY KEY,
    paymentDate DATE,
    paymentAmount DECIMAL(10, 2),
    clientId INT,
    FOREIGN KEY (clientId) REFERENCES Client(clientId)
);

CREATE TABLE Policy (
    policyId INT PRIMARY KEY,
    policyName VARCHAR(255)
);

-- Inserting data into User table
INSERT INTO User (userId, username, password, role) VALUES
(1, 'user1', 'password1', 'admin'),
(2, 'user2', 'password2', 'user'),
(3, 'user3', 'password3', 'user');

-- Inserting data into Client table
INSERT INTO Client (clientId, clientName, contactInfo, policy) VALUES
(1, 'Client A', '123-456-7890', 'Policy A'),
(2, 'Client B', '987-654-3210', 'Policy B'),
(3, 'Client C', '555-555-5555', 'Policy C');

-- Inserting data into Claim table
INSERT INTO Claim (claimId, claimNumber, dateFiled, claimAmount, status, policy, clientId) VALUES
(1, 'C01', '2023-02-003', 1000.00, 'Pending', 'Policy A', 1),
(2, 'C02', '2023-03-07', 1700.00, 'Approved', 'Policy B', 2),
(3, 'C03', '2023-03-10', 2000.00, 'Denied', 'Policy C', 3);

-- Inserting data into Payment table
INSERT INTO Payment (paymentId, paymentDate, paymentAmount, clientId) VALUES
(1, '2023-02-01', 500.00, 1),
(2, '2023-03-10', 750.00, 2),
(3, '2023-04-15', 1000.00, 3);

-- Inserting data into Policy table
INSERT INTO Policy (policyId, policyName) VALUES
(1, 'PolicyA'),
(2, 'PolicyB'),
(3, 'PolicyC');

select * from policy;
truncate Policy;
delete from Policy where policyId=4;