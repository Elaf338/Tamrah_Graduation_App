package com.innovation.mygraduationproject

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.IconButton
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.ui.Alignment
import com.innovation.mygraduationproject.ui.theme.BarBg
import com.innovation.mygraduationproject.ui.theme.FabBg
import com.innovation.mygraduationproject.ui.theme.FabIcon
import com.innovation.mygraduationproject.ui.theme.Selected
import com.innovation.mygraduationproject.ui.theme.Unselected

@Composable
fun AppBottomBar(
    currentRoute: String?,
    onHome: () -> Unit,
    onCamera: () -> Unit,
    onSettings: () -> Unit
) {
    BottomAppBar(
        backgroundColor = BarBg,
        cutoutShape = CircleShape,
        elevation = 10.dp
    ) {
        BottomItem(
            selected = currentRoute == Routes.HOME,
            label = "Home",
            onClick = onHome,
            icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = if (currentRoute == Routes.HOME) Selected else Unselected) }
        )

        Spacer(Modifier.weight(1f))

        BottomItem(
            selected = currentRoute == Routes.SETTINGS,
            label = "Settings",
            onClick = onSettings,
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings", tint = if (currentRoute == Routes.SETTINGS) Selected else Unselected) }
        )
    }
}

@Composable
private fun BottomItem(
    selected: Boolean,
    label: String,
    onClick: () -> Unit,
    icon: @Composable () -> Unit
) {
    val tint = if (selected) Selected else Unselected

    Column(
        modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = onClick) { icon() }
        Text(text = label, color = tint)
    }
}

@Composable
fun CenterCameraFab(
    onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        backgroundColor = FabBg,
        contentColor = FabIcon,
        shape = CircleShape,
        elevation = androidx.compose.material.FloatingActionButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 14.dp
        )
    ) {
        Icon(
            imageVector = Icons.Default.PhotoCamera,
            contentDescription = "Camera"
        )
    }
}