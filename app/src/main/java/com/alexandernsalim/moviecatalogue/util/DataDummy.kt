package com.alexandernsalim.moviecatalogue.util

import com.alexandernsalim.moviecatalogue.data.CastEntity
import com.alexandernsalim.moviecatalogue.data.MovieEntity
import com.alexandernsalim.moviecatalogue.data.SeasonEntity
import com.alexandernsalim.moviecatalogue.data.TvShowEntity
import com.alexandernsalim.moviecatalogue.data.source.remote.response.*

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> = listOf(
        MovieEntity(
            1,
            "A Star Is Born",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "10/05/2018",
            "2h 16m",
            75.0,
            listOf("Drama", "Romance", "Music"),
            "poster/1234.jpg"
        ),

        MovieEntity(
            2,
            "Alita: Battle Angel",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "02/14/2019",
            "2h 2m",
            72.0,
            listOf("Action", "Science Fiction", "Adventure"),
            "poster/2345.jpg"
        )
    )

    fun generateDummyTvShows(): List<TvShowEntity> = listOf(
        TvShowEntity(
            1,
            "Arrow",
            "2021-05-15",
            "42m",
            66.0,
            listOf("Crime", "Drama", "Mystery", "Action & Adventure"),
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "",
            listOf(
                SeasonEntity(
                    1,
                    "October 10, 2012",
                    23,
                    "Oliver Queen returns to Starling city after being deserted on a hellish island for five years. He decides to become a mask wearing vigilante to fulfil his father's wishes and rid the city of crime. In his journey to do so, he is forced to make tough decisions even as he makes new friends and even more enemies which continue question his lethal ways of controlling crime.",
                    "poster/1234.jpg"
                ),
                SeasonEntity(
                    2,
                    "October 9, 2013",
                    23,
                    "At the end of Season 1, Starling city suffered a huge loss and so did Oliver Queen. Learning from his mistakes, Oliver decides to change his methods even while honouring his promises to his friend. Meanwhile a new enemy from his past resurfaces to make life difficult for Oliver.",
                    "poster/2345.jpg"
                )
            )
        ),
        TvShowEntity(
            2,
            "Doom Patrol",
            "2021-05-14",
            "49m",
            76.0,
            listOf("Sci-Fi & Fantasy", "Comedy", "Drama"),
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chie.0, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "",
            listOf(
                SeasonEntity(
                    1,
                    "February 15, 2019",
                    15,
                    "Set after the events of Titans, the Doom Patrol – consisting of Robotman, Negative Man, Elasti-Woman, and Crazy Jane, and led by Dr. Niles Caulder / The Chief – receive a mission from Cyborg that they cannot ignore and will change their lives.",
                    "poster/1234.jpg"
                ),
                SeasonEntity(
                    2,
                    "June 25, 2010",
                    9,
                    "The members of the Doom Patrol now find themselves mini-sized and stranded on Cliff’s toy race car track. Here they begin to deal with their feelings of betrayal by Niles Caulder aka The Chief, while confronting their own personal baggage. And as each member faces the challenge of growing beyond their own past traumatic experiences, they must come together to embrace and protect the newest member of the family: Dorothy Spinner, Niles’ daughter, whose powers remain a mysterious but real threat to bringing on the end of the world.",
                    "poster/2345.jpg"
                )
            )
        )
    )

    fun generateDummyCasts(): List<CastEntity> = listOf(
        CastEntity(
            "Actor 1",
            "Character 1",
            "profile/1234.jpg"
        ),
        CastEntity(
            "Actor 2",
            "Character 2",
            "profile/2345.jpg"
        )
    )

    fun generatePopularMoviesResponse(): PopularMoviesResponse = PopularMoviesResponse(
        1,
        1,
        listOf(
            ResultsItem(
                id = 1,
                title = "Title",
                overview = "Overview",
                posterPath = "poster/1234.jpg",
                releaseDate = "15 May 2021",
                voteAverage = 7.0
            )
        ),
        1
    )

    fun generateMovieDetailResponse(): MovieDetailResponse = MovieDetailResponse(
        id = 1,
        title = "Title",
        overview = "Overview",
        releaseDate = "15 May 2021",
        runtime = 120,
        genres = listOf(
            GenresItem("Action", 1)
        ),
        voteAverage = 7.0,
        posterPath = "poster/1234.jpg"
    )

    fun generatePopularTvShowsResponse(): PopularTvShowResponse = PopularTvShowResponse(
        1,
        1,
        listOf(
            TvResultsItem(
                id = 1,
                name = "Title",
                overview = "Overview",
                posterPath = "poster/1234.jpg",
                firstAirDate = "15 May 2021",
                voteAverage = 7.0
            )
        ),
        1
    )

    fun generateTvShowDetailResponse(): TvShowDetailResponse = TvShowDetailResponse(
        1,
        "Title",
        "2021-05-15",
        listOf(
            GenresItem("Action", 1)
        ),
        listOf(1),
        7.0,
        "Overview",
        "poster/1234.jpg",
        listOf(
            SeasonsItem(
                1,
                1,
                "2021-05-15",
                "Overview",
                "poster/1234.jpg"
            )
        )
    )

    fun generateCreditsResponse(): CreditsResponse = CreditsResponse(
        listOf(
            CastItem(
                "Actor 1",
                "Character 2",
                "profile/1234.jpg"
            ),
            CastItem(
                "Actor 1",
                "Character 2",
                "profile/2345.jpg"
            )
        )
    )
}