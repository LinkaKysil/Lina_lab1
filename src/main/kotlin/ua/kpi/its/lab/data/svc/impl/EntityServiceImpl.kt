package ua.kpi.its.lab.data.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.data.entity.Cinema
import ua.kpi.its.lab.data.entity.Movie
import ua.kpi.its.lab.data.repo.CinemaRepository
import ua.kpi.its.lab.data.repo.MovieRepository
import ua.kpi.its.lab.data.svc.CinemaService
import ua.kpi.its.lab.data.svc.MovieService

@Service
class CinemaServiceImpl(private val repo: CinemaRepository) : CinemaService {
    override fun create(cinema: Cinema) = repo.save(cinema)
    override fun retrieve(id: Long) = repo.findById(id).orElse(null)
    override fun update(cinema: Cinema) = repo.save(cinema)
    override fun delete(id: Long) = repo.deleteById(id)
}

@Service
class MovieServiceImpl(private val repo: MovieRepository) : MovieService {
    override fun create(movie: Movie) = repo.save(movie)
    override fun retrieve(id: Long) = repo.findById(id).orElse(null)
    override fun update(movie: Movie) = repo.save(movie)
    override fun delete(id: Long) = repo.deleteById(id)
}
