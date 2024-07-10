package com.abdownloadmanager.desktop.ui.icon

import com.abdownloadmanager.desktop.ui.LocalContentAlpha
import com.abdownloadmanager.desktop.ui.LocalContentColor
import com.abdownloadmanager.desktop.ui.widget.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource

@Immutable
sealed interface IconSource {
    val value: Any

    @Composable
    fun rememberPainter(): Painter

    @Immutable
    data class StorageIconSource(
        override val value: String,
    ) : IconSource {
        @Composable
        override fun rememberPainter():Painter = painterResource(value)
    }

    @Immutable
    data class VectorIconSource(
        override val value: ImageVector,
    ) : IconSource {
        @Composable
        override fun rememberPainter():Painter = rememberVectorPainter(value)
    }
}

context (IMyIcons)
fun ImageVector.asIconSource() = IconSource.VectorIconSource(this)

context (IMyIcons)
fun String.asIconSource() = IconSource.StorageIconSource(this)


@Composable
fun MyIcon(
    icon: IconSource,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
) {
    Icon(
        painter = icon.rememberPainter(),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint,
    )
}


interface IMyIcons {
    val appIcon:IconSource

    val settings: IconSource
    val search: IconSource
    val info: IconSource
    val check: IconSource
    val link: IconSource
    val download: IconSource
    val windowMinimize: IconSource
    val windowFloating: IconSource
    val windowMaximize: IconSource
    val windowClose: IconSource
    val exit: IconSource
    val undo: IconSource
//    val menu: IconSource
//    val menuClose: IconSource

    val openSource: IconSource

    val next: IconSource
    val back: IconSource
    val up: IconSource
    val down: IconSource
    val activeCount: IconSource
    val speed: IconSource
    val resume: IconSource
    val pause: IconSource
    val stop: IconSource
    val queue: IconSource
    val remove: IconSource
    val clear: IconSource
    val add: IconSource
    val paste: IconSource
    val copy: IconSource
    val refresh: IconSource
    val editFolder: IconSource
    val share: IconSource
    val file: IconSource
    val folder: IconSource
    val fileOpen: IconSource
    val folderOpen: IconSource
    val pictureFile: IconSource
    val musicFile: IconSource
    val zipFile: IconSource
    val videoFile: IconSource
    val applicationFile: IconSource
    val documentFile: IconSource
    val otherFile: IconSource
    val lock: IconSource
    val question: IconSource
    val sortUp: IconSource
    val sortDown: IconSource
    val verticalDirection: IconSource.StorageIconSource
    val appearance: IconSource
    val downloadEngine: IconSource
    val browserIntegration: IconSource
    val network: IconSource
    val externalLink: IconSource
}