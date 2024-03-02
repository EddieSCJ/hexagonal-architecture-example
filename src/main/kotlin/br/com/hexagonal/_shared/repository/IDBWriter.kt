package br.com.hexagonal._shared.repository

interface IDBWriter<I, D> {
    fun save(entity: D): D

    fun update(entity: D): D

    fun deleteById(id: I)
}