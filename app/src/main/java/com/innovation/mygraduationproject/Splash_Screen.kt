package com.innovation.mygraduationproject

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.innovation.mygraduationproject.ui.theme.*
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onFinish: () -> Unit,
    modifier: Modifier = Modifier
) {
    val logoScale = remember { Animatable(0.7f) }
    val logoAlpha = remember { Animatable(0f) }
    val textAlpha = remember { Animatable(0f) }
    val textOffset = remember { Animatable(18f) }

    LaunchedEffect(Unit) {
        logoAlpha.animateTo(1f, tween(500))
        logoScale.animateTo(1f, tween(750))
        textAlpha.animateTo(1f, tween(600))
        textOffset.animateTo(0f, tween(600))
        delay(2400)
        onFinish()
    }
    val bg = Brush.verticalGradient(
        colors = listOf(BgTop, BgMid, BgBottom)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(140.dp)
                    .alpha(logoAlpha.value)
                    .scale(logoScale.value)
                    .clip(RoundedCornerShape(36.dp))
                    .background(SurfaceDark)
                    .border(
                        width = 1.2.dp,
                        color = GoldSand.copy(alpha = 0.8f),
                        shape = RoundedCornerShape(36.dp)
                    )
                    .shadow(
                        elevation = 28.dp,
                        shape = RoundedCornerShape(36.dp),
                        ambientColor = GoldSand.copy(alpha = 0.25f),
                        spotColor = GoldSand.copy(alpha = 0.35f)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tamrah_logo),
                    contentDescription = "Tamrah Logo",
                    modifier = Modifier.size(88.dp)
                )
            }
            Spacer(Modifier.height(26.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .alpha(textAlpha.value)
                    .offset(y = textOffset.value.dp)
            ) {
                Text(
                    text = "تمرة",
                    color = TextPrimary,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 0.6.sp
                )
                Text(
                    text = "TAMRAH",
                    color = GoldSand,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 4.sp
                )
                Spacer(Modifier.height(16.dp))
                Box(
                    Modifier
                        .width(120.dp)
                        .height(1.dp)
                        .background(GoldSand.copy(alpha = 0.75f))
                )
            }
        }
    }
}

