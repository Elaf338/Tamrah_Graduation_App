@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.innovation.mygraduationproject

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Collections
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.innovation.mygraduationproject.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Camera_Screen(
    lang: Language,
    onToggleLang: () -> Unit,
    onBack: () -> Unit
) {
    val strings = remember(lang) { stringsFor(lang) }
    val bg = Brush.verticalGradient(colors = listOf(BgTop, BgMid, BgBottom))
    val pickFromGalleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
    }
    val takePhotoLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap: Bitmap? ->
    }

    Scaffold(
        containerColor = BgBottom,
        topBar = {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                    Surface(
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .size(38.dp)
                            .clip(CircleShape)
                            .clickable { onBack() },
                        color = SurfaceDark.copy(alpha = 0.9f),
                        shadowElevation = 6.dp
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = if (lang == Language.AR)
                                    Icons.Filled.ChevronRight
                                else
                                    Icons.Filled.ChevronLeft,
                                contentDescription = "Back",
                                tint = GoldSand
                            )
                        }
                    }
                },
                actions = {
                    Surface(
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .size(38.dp)
                            .clip(CircleShape)
                            .clickable { onToggleLang() },
                        color = SurfaceDark.copy(alpha = 0.9f),
                        shadowElevation = 6.dp
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Default.Language,
                                contentDescription = "Change language",
                                tint = GoldSand
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BgTop)
            )}
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(bg)
                .padding(padding)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 18.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = { pickFromGalleryLauncher.launch("image/*") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GoldSand,
                        contentColor = SurfaceDark
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp)
                ) {
                    Text(
                        text = strings.pickFromGallery,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(Modifier.width(10.dp))
                    Icon(
                        imageVector = Icons.Default.Collections,
                        contentDescription = null
                    )
                }
                OutlinedButton(
                    onClick = { takePhotoLauncher.launch(null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.5.dp, GoldSand),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = TextPrimary
                    )
                ) {
                    Text(
                        text = strings.takePhotoNow,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(Modifier.width(10.dp))
                    Icon(
                        imageVector = Icons.Default.PhotoCamera,
                        contentDescription = null,
                        tint = GoldSand
                    )
                }
            }
        }
    }
}