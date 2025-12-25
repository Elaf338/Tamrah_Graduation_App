package com.innovation.mygraduationproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.innovation.mygraduationproject.data.DatesCatalog
import com.innovation.mygraduationproject.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    id: String,
    lang: Language,
    onToggleLang: () -> Unit,
    onBack: () -> Unit
) {

    val bg = Brush.verticalGradient(listOf(BgTop, BgMid, BgBottom))
    Scaffold(
        containerColor = BgBottom,
        topBar = {
            TopAppBar(
                title = { Text("", color = TextPrimary) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = if (lang == Language.AR) Icons.Filled.ChevronRight else Icons.Filled.ChevronLeft,
                            contentDescription = null,
                            tint = GoldSand
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onToggleLang) {
                        Icon(Icons.Default.Language, contentDescription = null, tint = GoldSand)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = BgTop)
            )
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(bg)
                .padding(padding)
        ) {
            val dateId = if (id.startsWith("date:")) id.removePrefix("date:") else id
            DateDetailsContent(lang = lang, dateId = dateId)
        }
    }
}

/* -------------------- Date Details (Local Catalog) -------------------- */
@Composable
fun DateDetailsContent(
    lang: Language,
    dateId: String
) {
    val date = remember(dateId) { DatesCatalog.byId(dateId) }
    if (date == null) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = if (lang == Language.AR) "غير موجود" else "Not found",
                color = TextPrimary
            )
        }
        return
    }

    val name = if (lang == Language.AR) date.nameAr else date.nameEn
    val region = if (lang == Language.AR) date.regionAr else date.regionEn
    val overview = if (lang == Language.AR) date.generalDescAr else date.generalDescEn
    val color = if (lang == Language.AR) date.colorAr else date.colorEn
    val texture = if (lang == Language.AR) date.textureAr else date.textureEn
    val size = if (lang == Language.AR) date.sizeAr else date.sizeEn
    val freshness = if (lang == Language.AR) date.freshnessTipsAr else date.freshnessTipsEn
    val uses = if (lang == Language.AR) date.usesAr else date.usesEn

    val context = LocalContext.current
    val imgId = remember(date.imageResName) {
        context.resources.getIdentifier(date.imageResName, "drawable", context.packageName)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(BgTop, BgMid, BgBottom)))
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = name,
            color = TextPrimary,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.ExtraBold
        )

        Box(
            Modifier
                .fillMaxWidth()
                .height(185.dp)
                .clip(RoundedCornerShape(18.dp))
                .background(SurfaceDark),
            contentAlignment = Alignment.Center
        ) {
            if (imgId != 0) {
                Image(
                    painter = painterResource(imgId),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Text("IMAGE", color = TextMuted)
            }
        }

        InfoCard(title = if (lang == Language.AR) "المنطقة" else "Region") {
            Text(region, color = TextSecondary)
        }

        InfoCard(title = if (lang == Language.AR) "الوصف العام" else "Overview") {
            Text(overview, color = TextSecondary)
        }

        InfoCard(title = if (lang == Language.AR) "اللون والشكل" else "Color & Shape") {
            Bullet(if (lang == Language.AR) "اللون: $color" else "Color: $color")
            Bullet(if (lang == Language.AR) "القوام: $texture" else "Texture: $texture")
            Bullet(if (lang == Language.AR) "الحجم: $size" else "Size: $size")
        }

        InfoCard(title = if (lang == Language.AR) "كيف أعرف أنه صالح؟" else "Freshness") {
            freshness.forEach { Bullet(it) }
        }

        InfoCard(title = if (lang == Language.AR) "الاستخدامات" else "Uses") {
            uses.forEach { Bullet(it) }
        }

        InfoCard(title = if (lang == Language.AR) "القيمة الغذائية" else "Nutrition") {
            Bullet("Calories: ${date.nutrition.caloriesKcal} kcal")
            Bullet("Carbs: ${date.nutrition.carbsPercent}%")
            Bullet("Fiber: ${date.nutrition.fiberPercent}%")
            Bullet("Minerals: ${date.nutrition.minerals}")
        }
    }
}

/* -------------------- Shared UI -------------------- */

@Composable
private fun InfoCard(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        color = SurfaceElev,
        shape = RoundedCornerShape(18.dp),
        tonalElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(Modifier.padding(14.dp)) {
            Text(title, color = GoldSand, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(8.dp))
            content()
        }
    }
}
@Composable
private fun Bullet(text: String) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top) {
        Text("•  ", color = GoldSand, fontWeight = FontWeight.Bold)
        Text(text, color = TextSecondary, modifier = Modifier.weight(1f))
    }
}
