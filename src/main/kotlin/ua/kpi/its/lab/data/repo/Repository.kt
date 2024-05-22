package ua.kpi.its.lab.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import ua.kpi.its.lab.data.entity.Cinema
import ua.kpi.its.lab.data.entity.Movie

interface CinemaRepository : JpaRepository<Cinema, Long> {
    // додаткові методи, якщо потрібно
}

interface MovieRepository : JpaRepository<Movie, Long> {
    // додаткові методи, якщо потрібно
}
