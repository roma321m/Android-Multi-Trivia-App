package com.roman.android_multi_trivia_app.domain.fake_impl

import com.example.android_multi_trivia_app.R
import com.roman.android_multi_trivia_app.domain.Resources

data class FakeResources(
    override val title: Int = R.string.app_name,
    override val icon: Int = R.drawable.ic_launcher_background
) : Resources