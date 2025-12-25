package com.innovation.mygraduationproject

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.innovation.mygraduationproject.ui.theme.*
import com.innovation.mygraduationproject.viewmodel.SearchDatesVm
import com.innovation.mygraduationproject.viewmodel.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    lang: Language,
    onToggleLang: () -> Unit,
    onOpenDetails: (String) -> Unit,
    onBack: () -> Unit
) {
    val bg = Brush.verticalGradient(listOf(BgTop, BgMid, BgBottom))
    var query by remember { mutableStateOf("") }

    val vm: SearchDatesVm = viewModel()
    val state = vm.state

    LaunchedEffect(query, lang) {
        if (query.isBlank()) return@LaunchedEffect
        kotlinx.coroutines.delay(350)
        vm.search(query, lang)
    }

    Scaffold(
        containerColor = BgBottom,
        topBar = {
            TopAppBar(
                title = { Text(if (lang == Language.AR) "بحث" else "Search", color = TextPrimary) },
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(bg)
                .padding(padding)
                .padding(16.dp)
        ) {

            OutlinedTextField(
                value = query,
                onValueChange = {
                    query = it
                    if (it.isBlank()) vm.search("", lang)
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(if (lang == Language.AR) "ابحث مثلاً: سكري، عجوة..." else "Search e.g. Sukkari, Ajwa...")
                },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                trailingIcon = {
                    if (query.isNotBlank()) {
                        IconButton(onClick = {
                            query = ""
                            vm.search("", lang)
                        }) { Icon(Icons.Default.Close, contentDescription = "Clear") }
                    }
                },
                shape = RoundedCornerShape(14.dp)
            )

            Spacer(Modifier.height(14.dp))

            when {
                query.isBlank() -> {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    }
                }

                state is UiState.Loading -> {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            CircularProgressIndicator(color = GoldSand, strokeWidth = 2.dp)
                            Spacer(Modifier.height(10.dp))
                            Text(
                                text = if (lang == Language.AR) "جاري البحث..." else "Searching...",
                                color = TextSecondary
                            )
                        }
                    }
                }

                state is UiState.Error -> {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text(state.message, color = TextSecondary)
                    }
                }

                state is UiState.Success -> {
                    val results = state.data
                    if (results.isEmpty()) {
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text(
                                text = if (lang == Language.AR) "لاتوجد نتائج 😕" else "No results 😕",
                                color = TextSecondary
                            )
                        }
                    } else {
                        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            items(results) { date ->
                                Surface(
                                    color = SurfaceElev,
                                    shape = RoundedCornerShape(16.dp),
                                    tonalElevation = 2.dp,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { onOpenDetails("date:${date.id}") }
                                ) {
                                    Column(Modifier.padding(14.dp)) {
                                        Text(
                                            text = if (lang == Language.AR) date.nameAr else date.nameEn,
                                            color = TextPrimary,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                        Spacer(Modifier.height(6.dp))
                                        Text(
                                            text = if (lang == Language.AR) date.regionAr else date.regionEn,
                                            color = TextMuted
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
