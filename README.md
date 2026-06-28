# Distributed Key Value Store (Mini Redis)

A multithreaded distributed key value store implemented in Java using TCP sockets.

## Features

- Client-server architecture
- Concurrent client handling using multithreading
- In-memory hash table storage
- File persistence
- TCP socket communication
- Command interface (SET, GET, DELETE)

## Technologies

Java
Socket Programming
Multithreading
Hash Tables
File I/O

## How to Run

Compile:
javac server/*.java client/*.java

Run server:
java server.KeyValueServer

Run client:
java client.KeyValueClient

## Example Commands

SET name Harshita
GET name
DELETE name
