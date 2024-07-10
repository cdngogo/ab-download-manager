package com.abdownloadmanager.desktop.pages.queue

import com.abdownloadmanager.desktop.ui.customwindow.CustomWindow
import com.abdownloadmanager.desktop.utils.mvi.HandleEffects
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.rememberWindowState

@Composable
fun QueuesWindow(queuesComponent: QueuesComponent) {
    val state = rememberWindowState()
    CustomWindow(
        state = state,
        onCloseRequest = queuesComponent.close
    ) {
        HandleEffects(queuesComponent) {
            if (it == QueuesComponentEffects.ToFront) {
                state.isMinimized = false
                window.toFront()
            }
        }
        QueuePage(queuesComponent)
    }
}