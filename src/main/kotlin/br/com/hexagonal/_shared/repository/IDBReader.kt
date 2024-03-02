package br.com.hexagonal._shared.repository

interface IDBReader<I, D> {
    fun findAll(): List<D>

    fun findById(id: I): D?

}