package me.podlesnykh.androidacademyapplication.data

object MovieStorage {
    val getMovies =
        listOf(
            Movie(
                like = false,
                posterLink = "https://image.tmdb.org/t/p/w220_and_h330_face/vbA0HK1TwPPZWo9EeucaCVwtlLp.jpg",
                minAge = "12+",
                genre = "Documentary, War",
                rating = 4,
                reviewsCount = 4,
                title = "Moscow Strikes Back",
                duration = 55,
                backDropPosterLink = "https://m.media-amazon.com/images/M/MV5BOGMzOGNlNTAtNzc4NS00ZjViLThiMGMtNzgyNTRlMjBhZjIyL2ltYWdlXkEyXkFqcGdeQXVyMDMxMjQwMw@@._V1_FMjpg_UX1000_.jpg",
                movieDescription = "Soviet documentary about the defeat of the Nazis near Moscow. Warning - graphic images. Edward G. Robinson narrates the English language version.",
                actor1Name = "N. Dubravin",
                actor2Name = "Edward G. Robinson",
                actor3Name = "Joseph Stalin",
                actor4Name = "Georgy Zhukov",
                actor1PhotoLink = "https://m.media-amazon.com/images/G/01/imdb/images/nopicture/medium/name-2135195744._CB466677935_.png",
                actor2PhotoLink = "https://m.media-amazon.com/images/M/MV5BMjE0NzcwMzU5Nl5BMl5BanBnXkFtZTYwNTkwMjI2._V1_UY317_CR18,0,214,317_AL_.jpg",
                actor3PhotoLink = "https://m.media-amazon.com/images/M/MV5BMTYzODMzMDU2M15BMl5BanBnXkFtZTgwNzk4NjExNzE@._V1_UY317_CR70,0,214,317_AL_.jpg",
                actor4PhotoLink = "https://upload.wikimedia.org/wikipedia/commons/f/fa/Zhukov_LIFE.jpg"
            ),
            Movie(
                like = true,
                posterLink = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/z2EzMUAQArkaaBZuImVc68qMXYE.jpg",
                minAge = "12+",
                genre = "Comedy, Drama, Science Fiction",
                rating = 4,
                reviewsCount = 66,
                title = "Kin-dza-dza!",
                duration = 135,
                backDropPosterLink = "https://m.media-amazon.com/images/M/MV5BMTQxYzRiNjEtYjcwYS00ZjcyLWI1OGMtY2ZkYjllYmI0YjEwXkEyXkFqcGdeQXVyNjg3MTIwODI@._V1_FMjpg_UX1000_.jpg",
                movieDescription = "Two Soviet humans previously unknown to each other are transported to the planet Pluke in the Kin-dza-da galaxy due to a chance encounter with an alien teleportation device. They must come to grips with a language barrier and Plukian social norms (not to mention the laws of space and time) if they ever hope to return to Earth.",
                actor1Name = "Stanislav Lyubshin",
                actor2Name = "Evgeniy Leonov",
                actor3Name = "Yuriy Yakovlev",
                actor4Name = "Levan Gabriadze",
                actor1PhotoLink = "https://m.media-amazon.com/images/M/MV5BZjQ2OGFhMjMtOTY2OS00ZjVmLTk2MmQtMTA4NDNhZWYwMjIxXkEyXkFqcGdeQXVyNjY0Njk3ODk@._V1_UY317_CR110,0,214,317_AL_.jpg",
                actor2PhotoLink = "https://m.media-amazon.com/images/M/MV5BMDkzMWE2MjItYTI5ZS00MDgxLTk0MDMtZjIwZjZhYjMwMGViXkEyXkFqcGdeQXVyNjY0Njk3ODk@._V1_UY317_CR175,0,214,317_AL_.jpg",
                actor3PhotoLink = "https://m.media-amazon.com/images/M/MV5BYzFiN2ZlMTgtY2EzMS00ODRkLTgwNWMtMzY3NWExMTg4YzNiXkEyXkFqcGdeQXVyNjMwOTA1MDM@._V1_UY317_CR1,0,214,317_AL_.jpg",
                actor4PhotoLink = "https://m.media-amazon.com/images/M/MV5BYWU3ZGQxMWQtYzczOS00NWEzLWJmNjYtN2NlZDlkYzA5Y2Y2XkEyXkFqcGdeQXVyNjY0Njk3ODk@._V1_UY317_CR110,0,214,317_AL_.jpg"
            ),
            Movie(
                like = false,
                posterLink = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/flZzAgxkUY17x13MLjHuURgui1z.jpg",
                minAge = "13+",
                genre = "Drama",
                rating = 4,
                reviewsCount = 991,
                title = "The Pursuit of Happyness",
                duration = 117,
                backDropPosterLink = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/NxDl4PgtQOVZzigrRG85JDR4Lm.jpg",
                movieDescription = "A struggling salesman takes custody of his son as he's poised to begin a life-changing professional career.",
                actor1Name = "Will Smith",
                actor2Name = "Jaden Smith",
                actor3Name = "Thandie Newton",
                actor4Name = "Brian Howe",
                actor1PhotoLink = "https://m.media-amazon.com/images/M/MV5BNTczMzk1MjU1MV5BMl5BanBnXkFtZTcwNDk2MzAyMg@@._V1_UY317_CR2,0,214,317_AL_.jpg",
                actor2PhotoLink = "https://m.media-amazon.com/images/M/MV5BMjMwMjU2MTQ4MF5BMl5BanBnXkFtZTgwODM5OTMzODE@._V1_UX214_CR0,0,214,317_AL_.jpg",
                actor3PhotoLink = "https://m.media-amazon.com/images/M/MV5BNjMzNTAxNDUwNV5BMl5BanBnXkFtZTcwMjMyNjI5MQ@@._V1_UY317_CR15,0,214,317_AL_.jpg",
                actor4PhotoLink = "https://m.media-amazon.com/images/M/MV5BYjhhYWRmNGUtOTZkZi00MjI5LWJiZGItMmM0M2VkNTQ0MzRlL2ltYWdlXkEyXkFqcGdeQXVyMDAyODEwMw@@._V1_UY317_CR4,0,214,317_AL_.jpg"
            )
        )
}