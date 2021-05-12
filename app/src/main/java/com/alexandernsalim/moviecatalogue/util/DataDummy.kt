package com.alexandernsalim.moviecatalogue.util

import com.alexandernsalim.moviecatalogue.R
import com.alexandernsalim.moviecatalogue.data.MovieEntity
import com.alexandernsalim.moviecatalogue.data.SeasonEntity
import com.alexandernsalim.moviecatalogue.data.TvShowEntity

object DataDummy {
    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                1,
                "A Star Is Born",
                75f,
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "R",
                "10/05/2018",
                "2h 16m",
                "Drama, Romance, Music",
                R.drawable.poster_a_start_is_born
            )
        )
        movies.add(
            MovieEntity(
                2,
                "Alita: Battle Angel",
                72f,
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "PG-13",
                "02/14/2019",
                "2h 2m",
                "Action, Science Fiction, Adventure",
                R.drawable.poster_alita
            )
        )
        movies.add(
            MovieEntity(
                3,
                "Aquaman",
                69f,
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "PG-13",
                "12/21/2018",
                "2h 23m",
                "Action, Adventure, Fantasy",
                R.drawable.poster_aquaman
            )
        )
        movies.add(
            MovieEntity(
                4,
                "Bohemian Rhapsody",
                80f,
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "PG-13",
                "11/02/2018",
                "2h 15m",
                "Music, Drama, History",
                R.drawable.poster_bohemian
            )
        )
        movies.add(
            MovieEntity(
                5,
                "Cold Pursuit",
                57f,
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "R",
                "02/08/2019",
                "1h 59m",
                "Action, Crime, Thriller",
                R.drawable.poster_cold_persuit
            )
        )
        movies.add(
            MovieEntity(
                6,
                "Creed II",
                69f,
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "PG-13",
                "11/21/2018",
                "2h 10m",
                "Drama",
                R.drawable.poster_creed
            )
        )
        movies.add(
            MovieEntity(
                7,
                "Fantastic Beasts: The Crimes of Grindelwald",
                69f,
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "PG-13",
                "11/16/2018",
                "2h 14m",
                "Adventure, Fantasy, Drama",
                R.drawable.poster_crimes
            )
        )
        movies.add(
            MovieEntity(
                8,
                "Glass",
                67f,
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "PG-13",
                "01/18/2019",
                "2h 9m",
                "Thriller, Drama, Science Fiction",
                R.drawable.poster_glass
            )
        )
        movies.add(
            MovieEntity(
                9,
                "How to Train Your Dragon: The Hidden World",
                78f,
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "SU",
                "01/09/2019",
                "1h 44m",
                "Animation, Family, Adventure",
                R.drawable.poster_how_to_train
            )
        )
        movies.add(
            MovieEntity(
                10,
                "Avengers: Infinity War",
                83f,
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "PG-13",
                "04/27/2018",
                "2h 29m",
                "Adventure, Action, Science Fiction",
                R.drawable.poster_infinity_war
            )
        )
        movies.add(
            MovieEntity(
                11,
                "Mary Queen of Scots",
                66f,
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "R",
                "12/21/2018",
                "2h 4m",
                "Drama, History",
                R.drawable.poster_marry_queen
            )
        )
        movies.add(
            MovieEntity(
                12,
                "Master Z: Ip Man Legacy",
                60f,
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "PG-13",
                "12/26/2018",
                "1h 47m",
                "Action",
                R.drawable.poster_master_z
            )
        )
        movies.add(
            MovieEntity(
                13,
                "Mortal Engines",
                61f,
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "PG-13",
                "12/14/2018",
                "2h 9m",
                "Adventure, Science Fiction",
                R.drawable.poster_mortal_engines
            )
        )
        movies.add(
            MovieEntity(
                14,
                "Overlord",
                67f,
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "R",
                "11/09/2018",
                "1h 50m",
                "Horror, War, Science Fiction",
                R.drawable.poster_overlord
            )
        )
        movies.add(
            MovieEntity(
                15,
                "Ralph Breaks The Internet",
                72f,
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "PG",
                "11/21/2018",
                "1h 52m",
                "Family, Animation, Comedy, Adventure",
                R.drawable.poster_ralph
            )
        )
        movies.add(
            MovieEntity(
                16,
                "Robin Hood",
                59f,
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "PG-13",
                "11/21/2018",
                "1h 56m",
                "Adventure, Action, Thriller",
                R.drawable.poster_robin_hood
            )
        )
        movies.add(
            MovieEntity(
                17,
                "Serenity",
                54f,
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                "R",
                "01/25/2019",
                "1h 42m",
                "Thriller, Mystery, Drama",
                R.drawable.poster_serenity
            )
        )
        movies.add(
            MovieEntity(
                18,
                "Spider-Man: Into the Spider-Verse",
                84f,
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "PG",
                "12/14/2018",
                "1h 57m",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                R.drawable.poster_spiderman
            )
        )
        movies.add(
            MovieEntity(
                19,
                "T-34",
                60f,
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "12+",
                "01/01/2019",
                "2h 19m",
                "War, Action, Drama, History",
                R.drawable.poster_t34
            )
        )

        return movies
    }

    fun generateDummyTvShows(): List<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()
        tvShows.add(
            TvShowEntity(
                1,
                "Arrow",
                66f,
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "TV-14",
                "42m",
                "Crime, Drama, Mystery, Action & Adventure",
                R.drawable.poster_arrow
            )
        )
        tvShows.add(
            TvShowEntity(
                2,
                "Doom Patrol",
                76f,
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "TV-MA",
                "49m",
                "Sci-Fi & Fantasy, Comedy, Drama",
                R.drawable.poster_doom_patrol
            )
        )
        tvShows.add(
            TvShowEntity(
                3,
                "Dragon Ball",
                81f,
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "TV-PG",
                "25m",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                R.drawable.poster_dragon_ball
            )
        )
        tvShows.add(
            TvShowEntity(
                4,
                "Fairy Tail",
                78f,
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "TV-14",
                "25m",
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy, Mystery",
                R.drawable.poster_fairytail
            )
        )
        tvShows.add(
            TvShowEntity(
                5,
                "Family Guy",
                70f,
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "TV-14",
                "22m",
                "Animation, Comedy",
                R.drawable.poster_family_guy
            )
        )
        tvShows.add(
            TvShowEntity(
                6,
                "The Flash",
                77f,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "TV-14",
                "44m",
                "Drama, Sci-Fi & Fantasy",
                R.drawable.poster_flash
            )
        )
        tvShows.add(
            TvShowEntity(
                7,
                "The Umbrella Academy",
                87f,
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "TV-MA",
                "55m",
                "Action & Adventure, Sci-Fi & Fantasy, Drama",
                R.drawable.poster_the_umbrella
            )
        )
        tvShows.add(
            TvShowEntity(
                8,
                "Hanna",
                75f,
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "TV-MA",
                "50m",
                "Action & Adventure, Drama",
                R.drawable.poster_hanna
            )
        )
        tvShows.add(
            TvShowEntity(
                9,
                "Iron Fist",
                66f,
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "TV-MA",
                "55m",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                R.drawable.poster_iron_fist
            )
        )
        tvShows.add(
            TvShowEntity(
                10,
                "Riverdale",
                86f,
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "TV-14",
                "45m",
                "Mystery, Drama, Crime",
                R.drawable.poster_riverdale
            )
        )

        return tvShows
    }

    fun generateDummySeason(tvShowId: Int): List<SeasonEntity> {
        val seasons = ArrayList<SeasonEntity>()
        seasons.add(
            SeasonEntity(
                1,
                1,
                "October 10, 2012",
                23,
                "Oliver Queen returns to Starling city after being deserted on a hellish island for five years. He decides to become a mask wearing vigilante to fulfil his father's wishes and rid the city of crime. In his journey to do so, he is forced to make tough decisions even as he makes new friends and even more enemies which continue question his lethal ways of controlling crime."
            )
        )
        seasons.add(
            SeasonEntity(
                1,
                2,
                "October 9, 2013",
                23,
                "At the end of Season 1, Starling city suffered a huge loss and so did Oliver Queen. Learning from his mistakes, Oliver decides to change his methods even while honouring his promises to his friend. Meanwhile a new enemy from his past resurfaces to make life difficult for Oliver."
            )
        )
        seasons.add(
            SeasonEntity(
                1,
                3,
                "October 8, 2014",
                23,
                "Having achieved true hero status - Oliver Queen faces new challenges with a foe who has come back from the dead. This time, he has help in the form a new hero/side kick and a lot of familiar faces. There is also a new player - Ray Palmer (future atom) - in the mix, who has a new vision for turning Starling City into Star City."
            )
        )
        seasons.add(
            SeasonEntity(
                1,
                4,
                "October 5, 2015",
                23,
                "After defeating his most formidable foe to date and riding off into the sunset with longtime flame Felicity Smoak, Oliver Queen (aka The Arrow) left Starling City with the hopes of beginning a new life. But will Oliver ever truly be able to leave behind his past as the Arrow, and, if so, what becomes of the team he has worked so hard to assemble? Will military vet John Diggle, Oliver’s sister Thea Queen, and lawyer-turned-vigilante Laurel Lance be left to continue Oliver's crusade without him? And with Malcolm Merlyn having ascended to the top of the League of Assassins as the new Ra's al Ghul, is anyone really safe? The action-packed series continues with new villains, new heroes and new challenges!"
            )
        )
        seasons.add(
            SeasonEntity(
                1,
                5,
                "October 5, 2016",
                23,
                "Newly appointed Mayor Oliver Queen finds himself challenged as he fights on two fronts for the future of Star City. With his right hand, John Diggle, back in the military and his sister Thea adamant about hanging up her vigilante hood as Speedy, Team Green Arrow is down to just Oliver and Felicity – but they’re no longer the only vigilantes in town. Green Arrow’s public defeat of Damien Darhk at the end of Season Four has inspired a new crop of masked heroes to step up and defend the city, though their painful inexperience makes them obstacles rather than allies in the field. The arrival of a deadly new adversary will force Oliver to confront questions about his own legacy, both as mayor and as the Green Arrow."
            )
        )
        seasons.add(
            SeasonEntity(
                1,
                6,
                "October 12, 2017",
                23,
                "Oliver has finally solidified and strengthened his crime-fighting team only to have it threatened when unexpected enemies from his past , including Black Siren, return to Star City, forcing Oliver to rethink his relationship with each member of his “family.” With the team left hanging in the balance, the focus shifts to the fates of every member of Team Arrow!"
            )
        )
        seasons.add(
            SeasonEntity(
                1,
                7,
                "October 15, 2018",
                22,
                "There has been no shortage of close calls for Oliver Queen when it comes to protecting his superhero identity, but in the season six finale he was finally backed into a corner and forced to reveal himself to the world as the Green Arrow. Now, Oliver will come face-to-face with many of the criminals he placed behind bars, as he makes a new home for himself at Slabside Maximum Security Prison. Oliver will find himself vulnerable in a way unlike ever before when a mysterious new enemy begins to unravel his work as Green Arrow, challenging him to redeem his name or risk losing everything."
            )
        )
        seasons.add(
            SeasonEntity(
                1,
                8,
                "October 15, 2019",
                10,
                "In Arrow's final season, Oliver Queen is forced to confront the reality of what it means to be a hero."
            )
        )
        seasons.add(
            SeasonEntity(
                2,
                1,
                "February 15, 2019",
                15,
                "Set after the events of Titans, the Doom Patrol – consisting of Robotman, Negative Man, Elasti-Woman, and Crazy Jane, and led by Dr. Niles Caulder / The Chief – receive a mission from Cyborg that they cannot ignore and will change their lives."
            )
        )
        seasons.add(
            SeasonEntity(
                2,
                2,
                "June 25, 2010",
                9,
                "The members of the Doom Patrol now find themselves mini-sized and stranded on Cliff’s toy race car track. Here they begin to deal with their feelings of betrayal by Niles Caulder aka The Chief, while confronting their own personal baggage. And as each member faces the challenge of growing beyond their own past traumatic experiences, they must come together to embrace and protect the newest member of the family: Dorothy Spinner, Niles’ daughter, whose powers remain a mysterious but real threat to bringing on the end of the world."
            )
        )
        seasons.add(
            SeasonEntity(
                3,
                1,
                "February 26, 1986",
                153,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                4,
                1,
                "October 12, 2009",
                48,
                "In the land of Fiore, magic is everywhere. Sorcerers are like skilled tradesmen who band together in \"guilds\" and take on paying assignments for non-magic wielders, like hunting monsters, retrieving lost items or running odd errands. Lucy is an aspiring wizard who wants to hook up with the coolest guild around, Fairy Tail. One day, she meets a red-headed boy who saves her from a unscrupulous wizard, and before she knows it, she's introduced to the wild and wacky band of wizards of Fairy Tail and begins the adventure of a lifetime."
            )
        )
        seasons.add(
            SeasonEntity(
                4,
                2,
                "October 11, 2010",
                48,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                4,
                3,
                "September 17, 2011",
                54,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                4,
                4,
                "October 6, 2011",
                25,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                4,
                5,
                "April 5, 2014",
                51,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                4,
                6,
                "April 4, 2015",
                39,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                4,
                7,
                "January 9, 2016",
                12,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                4,
                8,
                "October 7, 2018",
                51,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                1,
                "January 31, 1999",
                7,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                2,
                "September 23, 1999",
                21,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                3,
                "July 11, 2001",
                22,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                4,
                "May 1, 2005",
                30,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                5,
                "September 10, 2006",
                18,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                6,
                "September 23, 2007",
                12,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                7,
                "September 28, 2008",
                16,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                8,
                "September 27, 2009",
                20,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                9,
                "September 26, 2010",
                18,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                10,
                "September 25, 2011",
                23,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                11,
                "September 30, 2012",
                22,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                12,
                "September 29, 2013",
                21,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                13,
                "September 28, 2014",
                18,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                14,
                "September 27, 2015",
                20,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                15,
                "September 25, 2016",
                20,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                16,
                "October 1, 2017",
                20,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                17,
                "September 30, 2018",
                20,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                18,
                "September 29, 2019",
                20,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                5,
                19,
                "September 27, 2020",
                20,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                6,
                1,
                "October 7, 2014",
                23,
                "When an unexpected accident at the S.T.A.R. Labs Particle Accelerator facility strikes Barry, he finds himself suddenly charged with the incredible power to move at super speeds. While Barry has always been a hero in his soul, his newfound powers have finally given him the ability to act like one. With the help of the research team at S.T.A.R. Labs, Barry begins testing the limits of his evolving powers and using them to stop crime. With a winning personality and a smile on his face, Barry Allen — aka The Flash — is finally moving forward in life … very, very fast!"
            )
        )
        seasons.add(
            SeasonEntity(
                6,
                2,
                "October 6, 2015",
                23,
                "Following the dramatic events of season 1, Team Flash quickly turns their attention to a threat high above Central City. Armed with the heart of a hero and the ability to move at super speeds, will Barry be able to save his city from impending doom?"
            )
        )
        seasons.add(
            SeasonEntity(
                6,
                3,
                "October 4, 2016",
                23,
                "Forensic scientist Barry Allen, aka The Flash, is living his dream life. His parents are alive. He's dating beautiful, smart Iris West. And he's able to stand back and let the new speedster in town, Kid Flash, step in to protect Central City. But the better Barry's life gets, the more dangerous it becomes. His nemesis, Reverse Flash, warns Barry of serious repercussions if he remains in the alternate Flashpoint universe: In addition to memory loss, his powers will fade. When disaster strikes, Barry must decide whether to continue life as Barry Allen or return to his universe as The Flash. As Barry deals with his identity crisis, he and the S.T.A.R. Labs team fight off lethal threats from the God of Speed, Savitar."
            )
        )
        seasons.add(
            SeasonEntity(
                6,
                4,
                "October 10, 2017",
                23,
                "The mission of Barry Allen, aka The Flash, is once more to protect Central City from metahuman threats. But with Barry trapped in the Speed Force, this mission falls to his family – Detective Joe West; fiancée Iris West; and Wally West/Kid Flash – and the team at S.T.A.R. Labs: Caitlin Snow/Killer Frost, Cisco Ramon/Vibe and brilliant scientist Harrison Wells. When a powerful villain threatens to level the city unless The Flash appears, Cisco risks everything to free Barry. But this is only the first move in a deadly game with Clifford DeVoe, aka The Thinker, a mastermind who’s always ten steps ahead of Barry, no matter how fast Barry runs."
            )
        )
        seasons.add(
            SeasonEntity(
                6,
                5,
                "October 9, 2018",
                22,
                "Barry Allen and his new wife, Iris West, finally settling into married life when they're visited by Nora West-Allen, their speedster daughter from the future. Nora's arrival brings to light the legacy every member of Team Flash will leave years from now, causing many to question who they are today. And while Nora idolizes Barry, she holds a mysterious grudge against Iris. As Team Flash adjusts to the next generation of speedster, they discover Nora's presence has triggered the arrival of the most ruthless, vicious and relentless villain they have ever faced: Cicada!"
            )
        )
        seasons.add(
            SeasonEntity(
                6,
                6,
                "October 8, 2019",
                19,
                "When Barry and Iris deal with loss of their daughter, the team faces their greatest threat yet - one that threatens to destroy all of Central City; Killer Frost has a brush with death that will change her relationship with Caitlin. Faced with the news of his impending death, Barry's resiliency suffers as he struggles to fight fate."
            )
        )
        seasons.add(
            SeasonEntity(
                6,
                7,
                "March 2, 2021",
                9,
                "After a thrilling cliffhanger last season which saw Mirror Monarch victorious and still-at-large in Central City, The Flash must regroup in order to stop her and find a way to make contact with his missing wife, Iris West-Allen. With help from the rest of Team Flash, Barry will ultimately defeat Mirror Master. But in doing so, he’ll also unleash an even more powerful and devastating threat on Central City: one that threatens to tear his team—and his marriage—apart."
            )
        )
        seasons.add(
            SeasonEntity(
                7,
                1,
                "February 15, 2019",
                10,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                7,
                2,
                "July 31, 2020",
                10,
                "Blasted back in time to 1960s Dallas, the scattered siblings build new lives for themselves — until a new doomsday threat pulls them back together."
            )
        )
        seasons.add(
            SeasonEntity(
                8,
                1,
                "March 28, 2019",
                8,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                8,
                2,
                "July 3, 2020",
                8,
                "In Season 2, Hanna is drawn out of hiding when her sole friend is recaptured by Utrax. With the help of Marissa Wiegler, Hanna infiltrates the strange new Utrax facility called ‘The Meadows’ to rescue Clara."
            )
        )
        seasons.add(
            SeasonEntity(
                9,
                1,
                "March 17, 2017",
                13,
                "Fifteen years after being presumed dead in a plane crash, Danny Rand mysteriously returns to New York City determined to reclaim his birthright and family company. However, when a long-destined enemy rises in New York, this living weapon is forced to choose between his family’s legacy and his duties as the Iron Fist."
            )
        )
        seasons.add(
            SeasonEntity(
                9,
                2,
                "September 7, 2018",
                10,
                "Season 2 furthers the transformation of Danny, a character with a fish out of water coming of age story making his way in a harsh new world, battling to work out who he is. This season, Danny has promised that with Matt Murdock gone, he will step up and protect his city. But a sinister plot twist threatens his very identity and he must conquer his villains to protect the town and people he holds close to his heart."
            )
        )
        seasons.add(
            SeasonEntity(
                10,
                1,
                "January 6, 2017",
                13,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                10,
                2,
                "October 11, 2017",
                22,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                10,
                3,
                "October 10, 2018",
                22,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                10,
                4,
                "October 9, 2019",
                19,
                ""
            )
        )
        seasons.add(
            SeasonEntity(
                10,
                5,
                "January 20, 2021",
                11,
                ""
            )
        )

        return seasons.filter { it.tvShowId == tvShowId }
    }
}