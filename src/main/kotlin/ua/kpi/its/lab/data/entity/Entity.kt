package ua.kpi.its.lab.data.entity

import jakarta.persistence.*
import java.util.*

@Entity
data class Cinema(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
    val address: String,
    val openingDate: Date,
    val seatCount: Int,
    val screenCount: Int,
    val soundTechnology: String,
    val has3D: Boolean,

    @OneToMany(mappedBy = "cinema", cascade = [CascadeType.ALL], orphanRemoval = true)
    val movies: MutableList<Movie> = mutableListOf()
) : Comparable<Cinema> {
    override fun compareTo(other: Cinema): Int {
        val nameComparison = name.compareTo(other.name)
        return if (nameComparison != 0) nameComparison else id.compareTo(other.id)
    }
}

@Entity
data class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val title: String,
    val country: String,
    val productionCompany: String,
    val duration: Int,
    val budget: Double,
    val premiereDate: Date,
    val ageRestriction: Boolean,

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    val cinema: Cinema
) : Comparable<Movie> {
    override fun compareTo(other: Movie): Int {
        val titleComparison = title.compareTo(other.title)
        return if (titleComparison != 0) titleComparison else id.compareTo(other.id)
    }
}
