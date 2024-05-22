package ua.kpi.its.lab.data.svc

import ua.kpi.its.lab.data.entity.Cinema
import ua.kpi.its.lab.data.entity.Movie

interface CinemaService {
    fun create(cinema: Cinema): Cinema
    fun retrieve(id: Long): Cinema?
    fun update(cinema: Cinema): Cinema
    fun delete(id: Long)
}

interface MovieService {
    fun create(movie: Movie): Movie
    fun retrieve(id: Long): Movie?
    fun update(movie: Movie): Movie
    fun delete(id: Long)
}
