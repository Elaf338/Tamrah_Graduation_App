package com.innovation.mygraduationproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.innovation.mygraduationproject.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyScreen(
    lang: Language,
    onToggleLang: () -> Unit,
    onBack: () -> Unit
) {
    val title = if (lang == Language.AR) "سياسة الخصوصية" else "Privacy Policy"
    val bg = Brush.verticalGradient(listOf(BgTop, BgMid, BgBottom))

    Scaffold(
        containerColor = BgBottom,
        topBar = {
            TopAppBar(
                title = { Text(title, color = TextPrimary) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = if (lang == Language.AR)
                                Icons.Filled.ChevronRight
                            else
                                Icons.Filled.ChevronLeft,
                            contentDescription = null,
                            tint = GoldSand
                        )
                    }
                },
                actions = {
                    Surface(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(38.dp)
                            .clip(CircleShape),
                        color = SurfaceDark.copy(alpha = 0.9f),
                        shadowElevation = 6.dp,
                        onClick = onToggleLang
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(Icons.Default.Language, contentDescription = null, tint = GoldSand)
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BgTop)
            )
        }
    ) { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .background(bg)
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Surface(color = SurfaceElev, shape = MaterialTheme.shapes.large) {
                Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = if (lang == Language.AR)
                            "نحن نحترم خصوصيتك. لا نجمع بيانات شخصية بدون إذن. الصور (إن وجدت) تبقى على جهازك."
                        else
                            "We respect your privacy. We don’t collect personal data without consent. Photos (if any) stay on your device.",
                        color = TextSecondary
                    )
                }
            }
        }
    }
}