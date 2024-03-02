package br.com.hexagonal._shared.repository

interface ICacheRepository<K, D> {
    fun save(key: K, data: D)

    fun delete(key: K)

    fun find(key: K): D?

    fun findAll(): List<D>

    fun update(key: K, data: D)

    fun exists(key: K): Boolean
}