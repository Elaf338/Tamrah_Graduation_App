package com.innovation.mygraduationproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Search
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.innovation.mygraduationproject.data.DateType
import com.innovation.mygraduationproject.data.DatesCatalog
import com.innovation.mygraduationproject.model.Post
import com.innovation.mygraduationproject.ui.theme.*
import com.innovation.mygraduationproject.viewmodel.UiState
import com.innovation.mygraduationproject.di.AppGraph
import com.innovation.mygraduationproject.viewmodel.HomePostsVm
import com.innovation.mygraduationproject.viewmodel.HomePostsVmFactory

@Composable
fun Home_Screen(
    lang: Language,
    onToggleLang: () -> Unit,
    onOpenDetails: (String) -> Unit,
    onOpenSearch: () -> Unit
) {
    val strings = remember(lang) { stringsFor(lang) }
    val dates = remember { DatesCatalog.all }
    val bg = Brush.verticalGradient(colors = listOf(BgTop, BgMid, BgBottom))
    val postsVm: HomePostsVm = viewModel(
        factory = HomePostsVmFactory(AppGraph.getPostsUseCase)
    )
    val postsState = postsVm.state

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(bg),
        contentPadding = PaddingValues(bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            HeroSection(
                strings = strings,
                onToggleLang = onToggleLang,
                onOpenSearch = onOpenSearch
            )
        }
        item {
            ApiPostsSection(
                lang = lang,
                state = postsState,
                onRetry = { postsVm.load() },
                onOpenPost = { postId ->
                    onOpenDetails("post:$postId")
                }
            )
        }
        item {
            Text(
                text = if (lang == Language.AR) "أنواع التمور" else "Date Varieties",
                color = TextPrimary,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        items(dates) { date ->
            DateCard(
                lang = lang,
                date = date,
                onClick = { onOpenDetails("date:${date.id}") }
            )
        }
    }
}

@Composable
private fun HeroSection(
    strings: Strings,
    onToggleLang: () -> Unit,
    onOpenSearch: () -> Unit
) {
    val context = LocalContext.current
    val heroId = remember {
        context.resources.getIdentifier("explore", "drawable", context.packageName)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        if (heroId != 0) {
            Image(
                painter = painterResource(heroId),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )
        } else {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(SurfaceDark)
            )
        }
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(colors = listOf(
                        OverlayDark.copy(alpha = 0.35f),
                        OverlayDark.copy(alpha = 0.85f)
                    )
                    )
                )
        )

        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .clickable { onOpenSearch() },
                color = SurfaceDark.copy(alpha = 0.9f),
                shadowElevation = 6.dp
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = GoldSand
                    )
                }
            }

            Surface(
                modifier = Modifier
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
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text(
                text = strings.heroTitle,
                color = TextPrimary,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = strings.heroSubtitle,
                color = TextSecondary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun ApiPostsSection(
    lang: Language,
    state: UiState<List<Post>>,
    onRetry: () -> Unit,
    onOpenPost: (Int) -> Unit
) {
    val title = if (lang == Language.AR) "تحديثات من API" else "API Updates"
    val retryText = if (lang == Language.AR) "إعادة المحاولة" else "Retry"

    Surface(
        color = SurfaceElev,
        shape = RoundedCornerShape(18.dp),
        tonalElevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column(Modifier.padding(14.dp)) {
            Text(title, color = GoldSand, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(10.dp))

            when (state) {
                is UiState.Idle -> {
                    Text(
                        text = if (lang == Language.AR) "جاري التجهيز..." else "Preparing...",
                        color = TextSecondary
                    )
                }
                is UiState.Loading -> {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        CircularProgressIndicator(
                            color = GoldSand,
                            strokeWidth = 2.dp,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = if (lang == Language.AR) "جاري التحميل..." else "Loading...",
                            color = TextSecondary
                        )
                    }
                }
                is UiState.Error -> {

                    Text(
                        text = state.message,
                        color = TextPrimary
                    )
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = onRetry,
                        colors = ButtonDefaults.buttonColors(containerColor = GoldSand),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text(retryText, color = SurfaceDark)
                    }
                }
                is UiState.Success -> {
                    val posts = state.data
                    posts.take(5).forEach { post ->
                        PostRow(post = post, onClick = { onOpenPost(post.id) })
                        Spacer(Modifier.height(8.dp))
                    }
                    Text(
                        text = if (lang == Language.AR)
                            "اضغط على أي عنوان لفتح التفاصيل ✅"
                        else
                            "Tap any title to open details ✅",
                        color = TextMuted
                    )
                }
            }
        }
    }
}
@Composable
private fun PostRow(
    post: Post,
    onClick: () -> Unit
) {
    Surface(
        color = SurfaceDark2.copy(alpha = 0.45f),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Text(
            text = post.title.replaceFirstChar { it.uppercase() },
            color = TextPrimary,
            modifier = Modifier.padding(12.dp),
            maxLines = 2
        )
    }
}
@Composable
private fun DateCard(
    lang: Language,
    date: DateType,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    val imgId = remember(date.imageResName) {
        context.resources.getIdentifier(date.imageResName, "drawable", context.packageName)
    }

    val title = if (lang == Language.AR) date.nameAr else date.nameEn
    val sub = if (lang == Language.AR) date.regionAr else date.regionEn

    ElevatedCard(
        onClick = onClick,
        shape = RoundedCornerShape(18.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(SurfaceElev)
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(1f)) {
                Text(
                    text = title,
                    color = TextPrimary,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = sub,
                    color = TextMuted,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(Modifier.width(12.dp))

            Box(
                Modifier
                    .size(78.dp)
                    .clip(RoundedCornerShape(16.dp))
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
                    Text("IMG", color = TextMuted)
                }
            }
        }
    }
}