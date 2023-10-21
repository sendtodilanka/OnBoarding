package com.codeboxlk.tutorial.onboarding.util

import androidx.annotation.DrawableRes
import com.codeboxlk.tutorial.onboarding.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    data object First : OnBoardingPage(
        image = R.drawable.ic_around_the_world_pana,
        title = "Meeting",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    data object Second : OnBoardingPage(
        image = R.drawable.ic_voice_chat_pana,
        title = "Coordination",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    data object Third : OnBoardingPage(
        image = R.drawable.ic_learning_languages_bro,
        title = "Dialogue",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
}