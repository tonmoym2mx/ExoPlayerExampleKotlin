package com.tonmoy.gakk.player.data.remote

import com.tonmoy.gakk.player.R
import com.tonmoy.gakk.player.data.model.Video
import kotlinx.coroutines.delay

class VideoApis {
    //Fake Data
    suspend fun fetchVideo(): List<Video>? {
        delay(1000L)
        return listOf(
            Video(
                id = 0,
                title = "Two Cats and 500 Balls in a Ball Pit !!",
                description = "I surprised my two cats with a huge ball pit filled with 500 multi-colored balls! My cats went wild and played like crazy in that pit!",
                views = 3445,
                videoUrl = "https://firebasestorage.googleapis.com/v0/b/exoplayerdemo-aea95.appspot.com/o/yt1s.com%20-%20Funny%20Cats%20in%20Water%20Cats%20Love%20Water%20Video%20Compilation_480p.mp4?alt=media&token=3faf2da5-887f-4bde-b161-790bf5274caa",
                videoThumbnailImage = R.drawable.cat6
            ),
            Video(
                id = 1,
                title = "Funny Cats And Babies Playing Together ★ Animals Trolling Babies",
                description = "Dogs are not the only ones who love babies, cats also know how to express their feelings towards the cute little babies",
                views = 34234,
                videoUrl = "https://firebasestorage.googleapis.com/v0/b/exoplayerdemo-aea95.appspot.com/o/yt1s.com%20-%20Cat%20Fight%20%20HD%201080p_480p.mp4?alt=media&token=9a99bc57-b428-4e75-ad24-415ae2b26f2e",
                videoThumbnailImage = R.drawable.cat1
            ),
            Video(
                id = 2,
                title = "Baby Cats",
                description = "Cute and Funny Cat Videos Compilation #34 | Aww Animals",
                views = 10040,
                videoUrl = "https://firebasestorage.googleapis.com/v0/b/exoplayerdemo-aea95.appspot.com/o/yt1s.com%20-%208%20Male%20Cats%20chasing%20the%20Female%20Cat%20want%20to%20have%20the%20female%20cat%20by%20force_480p.mp4?alt=media&token=49d4d63d-e1f6-4096-932c-3359a069136b",
                videoThumbnailImage = R.drawable.cat
            ),
            Video(
                id = 3,
                title = "Cat Scare Of Cucumber - Funny Cat Reaction | Super Cats",
                description = "Welcome to the Super Cats where you can find lots of cute, funny and adorable videos about Pets. If you are an animal lover, you are in the right place. Because we will bring you daily videos ",
                views = 2034,
                videoUrl = "null",
                videoThumbnailImage = R.drawable.cat2
            ),
            Video(
                id = 4,
                title = "Crushing Crunchy & Soft Things by Car! EXPERIMENT: BABY CAT VS CAR 2",
                description = "Crushing Crunchy & Soft Things by Car! EXPERIMENT: BABY CAT VS CAR 2",
                views = 4234,
                videoUrl = "https://firebasestorage.googleapis.com/v0/b/exoplayerdemo-aea95.appspot.com/o/yt1s.com%20-%20Cats%20In%20HD%20III_480p.mp4?alt=media&token=37dcc82b-f73b-4200-868f-3bbc4b21172d",
                videoThumbnailImage = R.drawable.cat3
            ),
            Video(
                id = 5,
                title = "HOLD YOUR LAUGH IF YOU CAN \uD83D\uDE38-FUNNIEST And CUTEST CAT VIDEOS 2020 | YUFUS",
                description = "The best and funniest cat videos ever! Get ready to wipe your laughing tears because this is so super hilarious! Cats just never fail to amuse us and make us laugh! The hardest try not to laugh challenge ever! Just look at all these cats and kittens how they fail, behave, meow, spin, beg",
                views = 7565,
                videoUrl = "https://firebasestorage.googleapis.com/v0/b/exoplayerdemo-aea95.appspot.com/o/yt1s.com%20-%20Cats%20In%20HD%20IV_480p.mp4?alt=media&token=8b89e2c9-07b6-49f3-b86a-e577e361cacb",
                videoThumbnailImage = R.drawable.cat4
            ),
            Video(
                id = 6,
                title = "OMG So Cute Cats ♥ Best Funny Cat Videos 2021 #95",
                description = "We really hope you enjoy our videos (≧▽≦) " +
                        "Don't forget to LEAVE COMMENT below ♡",
                views = 5632,
                videoUrl = "https://firebasestorage.googleapis.com/v0/b/exoplayerdemo-aea95.appspot.com/o/yt1s.com%20-%20Funny%20Cats%20and%20Kittens%20Meowing%20Compilation_480p.mp4?alt=media&token=6b646f8c-51b7-4d30-95d2-452027a7852a",
                videoThumbnailImage = R.drawable.cat5
            ),
            Video(
                id = 7,
                title = "Kittens meowing (too much cuteness) - All talking at the same time!",
                description = "7 kittens meowing and talking all at the same time! Too much cuteness! They are from 2 sibling mother cats and they live in my grandmother's yard. 3 of the kittens are 5 weeks old and 4 of ",
                views = 3467,
                videoUrl = "https://firebasestorage.googleapis.com/v0/b/exoplayerdemo-aea95.appspot.com/o/Funny%20Cats%20And%20Babies%20Playing%20Together%20%E2%98%85%20Animals%20Trolling%20Babies.mp4?alt=media&token=b7b2d60d-b970-4723-a7ea-dd460e1e9fc3",
                videoThumbnailImage = R.drawable.cat7
            )
        )
    }
}