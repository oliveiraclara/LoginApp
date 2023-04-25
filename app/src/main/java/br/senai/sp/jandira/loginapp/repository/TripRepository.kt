package br.senai.sp.jandira.loginapp.repository

import br.senai.sp.jandira.loginapp.model.Trip
import java.time.LocalDate

class TripRepository {
    companion object {
        fun getTrips(): List<Trip> {
            return listOf(
                Trip(
                    id = 1,
                    location = "Jandira",
                    description = "Cidade feia, não gosto desse lugar e não pretendo voltar.",
                    startDate = LocalDate.of(2023, 4, 21),
                    endDate = LocalDate.of(2023, 5, 21)
                ),
                Trip(
                    id = 2,
                    location = "Rio de Janeiro",
                    description = "Cidadde bonita, realmente maravilhosa, cheia de montanhas.",
                    startDate = LocalDate.of(2023, 4, 21),
                    endDate = LocalDate.of(2023, 5, 21)
                ),
                Trip(
                    id = 3,
                    location = "Salvador",
                    description = "Cidadde bonita, pessoas legais e simpáticas.",
                    startDate = LocalDate.of(2023, 4, 21),
                    endDate = LocalDate.of(2023, 5, 21)
                )
            )
        }
    }
}