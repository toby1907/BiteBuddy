package org.example.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.project.di.initKoinJVM


val koin = initKoinJVM()
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "BiteBuddy",
    ) {
        App()
    }
}