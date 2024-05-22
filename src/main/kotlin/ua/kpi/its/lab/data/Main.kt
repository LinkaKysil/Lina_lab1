package ua.kpi.its.lab.data

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import ua.kpi.its.lab.data.entity.Cinema
import ua.kpi.its.lab.data.entity.Movie
import ua.kpi.its.lab.data.svc.impl.CinemaServiceImpl
import ua.kpi.its.lab.data.svc.impl.MovieServiceImpl
import java.util.*

fun main() {
    val context = AnnotationConfigApplicationContext("ua.kpi.its.lab.data")
    val cinemaService = context.getBean(CinemaServiceImpl::class.java)
    val movieService = context.getBean(MovieServiceImpl::class.java)

    // Створюємо 5 кінотеатрів та додаткові фільми
    val cinema1 = Cinema(
        name = "Cinema City",
        address = "123 Main St.",
        openingDate = Date(2000, 1, 1),
        seatCount = 500,
        screenCount = 10,
        soundTechnology = "Dolby Atmos",
        has3D = true
    )
    val cinema2 = Cinema(
        name = "AMC Theatres",
        address = "456 Elm St.",
        openingDate = Date(1920, 1, 1),
        seatCount = 800,
        screenCount = 12,
        soundTechnology = "IMAX",
        has3D = true
    )

    val cinema3 = Cinema(
        name = "Regal Cinemas",
        address = "789 Oak St.",
        openingDate = Date(1989, 5, 15),
        seatCount = 600,
        screenCount = 8,
        soundTechnology = "Dolby Digital",
        has3D = true
    )

    val cinema4 = Cinema(
        name = "Vue Cinemas",
        address = "101 Pine St.",
        openingDate = Date(2003, 8, 22),
        seatCount = 700,
        screenCount = 11,
        soundTechnology = "DTS:X",
        has3D = true
    )

    val cinema5 = Cinema(
        name = "Odeon Cinemas",
        address = "222 Cedar St.",
        openingDate = Date(1930, 12, 10),
        seatCount = 750,
        screenCount = 9,
        soundTechnology = "THX",
        has3D = false
    )

    val movie1 = Movie(
        title = "The Shawshank Redemption",
        country = "USA",
        productionCompany = "Castle Rock Entertainment",
        duration = 142,
        budget = 25000000.0,
        premiereDate = Date(1994, 9, 10),
        ageRestriction = true,
        cinema = cinema1
    )

    // Додаємо створені кінотеатри та фільми в БД
    cinemaService.create(cinema1)
    cinemaService.create(cinema2)
    cinemaService.create(cinema3)
    cinemaService.create(cinema4)
    cinemaService.create(cinema5)
    movieService.create(movie1)

    println("Retrieved cinema: $cinema3")

    // Видаляємо кінотеатр з індексом 4
    cinemaService.delete(4)
}
