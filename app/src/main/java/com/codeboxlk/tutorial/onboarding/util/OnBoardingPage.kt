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
        image = R.drawable.ic_launcher_foreground,
        title = "Meeting",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    data object Second : OnBoardingPage(
        image = R.drawable.ic_launcher_foreground,
        title = "Coordination",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )

    data object Third : OnBoardingPage(
        image = R.drawable.ic_launcher_foreground,
        title = "Dialogue",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod."
    )
}