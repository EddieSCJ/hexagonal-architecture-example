package br.com.hexagonal._shared.repository

interface IDBWriter<D> {
    fun save(entity: D): D

    fun update(entity: D): D

    fun delete(entity: D)
}