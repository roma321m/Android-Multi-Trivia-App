package com.example.android_multi_trivia_app

data class FakeResources(
    override val title: Int = R.string.app_name,
    override val background: Int = R.drawable.ic_launcher_background
) : Resources