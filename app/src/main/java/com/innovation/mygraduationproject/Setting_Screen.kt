package com.innovation.mygraduationproject

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.innovation.mygraduationproject.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    lang: Language,
    onToggleLang: () -> Unit,
    onBack: () -> Unit,
    onOpenHelp: () -> Unit = {},
    onOpenAbout: () -> Unit = {},
    onOpenPrivacy: () -> Unit = {}
) {

    val title = if (lang == Language.AR) "الإعدادات" else "Settings"

    val bg = Brush.verticalGradient(listOf(BgTop, BgMid, BgBottom))
    val context = LocalContext.current
    var notificationsEnabled by rememberSaveable { mutableStateOf(true) }
    val dir = if (lang == Language.AR) LayoutDirection.Rtl else LayoutDirection.Ltr

    CompositionLocalProvider(LocalLayoutDirection provides dir) {

        Scaffold(
            containerColor = BgBottom,
            topBar = {
                TopAppBar(
                    title = {
                        Text(title, color = TextPrimary, fontWeight = FontWeight.ExtraBold)
                    },
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
                                        Icons.Default.ChevronRight
                                    else
                                        Icons.Default.ChevronLeft,
                                    contentDescription = null,
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
                                Icon(Icons.Default.Language, null, tint = GoldSand)
                            }
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
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                SettingsCard(
                    lang,
                    Icons.Default.Public,
                    if (lang == Language.AR) "اللغة والبلد" else "Language & Country",
                    if (lang == Language.AR) "العربية • السعودية" else "English • Saudi Arabia",
                    onToggleLang
                )

                SettingsSwitchCard(
                    Icons.Default.Notifications,
                    if (lang == Language.AR) "التنبيهات" else "Notifications",
                    notificationsEnabled
                ) { notificationsEnabled = it }

                SettingsCard(
                    lang,
                    Icons.Default.SupportAgent,
                    if (lang == Language.AR) "المساعدة وخدمة العملاء" else "Help & Support",
                    if (lang == Language.AR) "الأسئلة الشائعة والتواصل" else "FAQ & Contact",
                    onOpenHelp
                )

                SettingsCard(
                    lang,
                    Icons.Default.Info,
                    if (lang == Language.AR) "من نحن؟" else "About Us",
                    if (lang == Language.AR) "نبذة عن تطبيق تمرة" else "About Tamrah App",
                    onOpenAbout
                )

                SettingsCard(
                    lang,
                    Icons.Default.Share,
                    if (lang == Language.AR) "مشاركة التطبيق" else "Share App",
                    if (lang == Language.AR) "شارك التطبيق مع أصدقائك" else "Share with friends"
                ) {
                    val i = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, "Tamrah App ✨")
                    }
                    context.startActivity(Intent.createChooser(i, null))
                }

                SettingsCard(
                    lang,
                    Icons.Default.StarRate,
                    if (lang == Language.AR) "تقييم التطبيق" else "Rate App",
                    if (lang == Language.AR) "قيّم تجربتك" else "Rate your experience"
                ) {
                    val url =
                        "https://play.google.com/store/apps/details?id=${context.packageName}"
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                }

                SettingsCard(
                    lang,
                    Icons.Default.PrivacyTip,
                    if (lang == Language.AR) "سياسة الخصوصية" else "Privacy Policy",
                    if (lang == Language.AR) "اطّلع على سياسة الخصوصية" else "Read privacy policy",
                    onOpenPrivacy
                )
            }
        }
    }
}
@Composable
private fun SettingsCard(
    lang: Language,
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {

    Surface(
        color = SurfaceElev,
        shape = RoundedCornerShape(18.dp),
        tonalElevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(Modifier.width(10.dp))

            Column(Modifier.weight(1f)) {
                Text(title, color = TextPrimary, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(4.dp))
                Text(subtitle, color = TextMuted, style = MaterialTheme.typography.bodyMedium)
            }
            Surface(
                color = SurfaceDark,
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.size(44.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(icon, null, tint = GoldSand)
                }
            }
        }
    }
}
@Composable
private fun SettingsSwitchCard(
    icon: ImageVector,
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Surface(
        color = SurfaceElev,
        shape = RoundedCornerShape(18.dp),
        tonalElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {Row(
        modifier = Modifier.padding(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Surface(
            color = SurfaceDark,
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier.size(44.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(icon, null, tint = GoldSand)
            }
        }

        Spacer(Modifier.width(12.dp))

        Text(
            title,
            color = TextPrimary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f)
        )

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = SurfaceDark,
                checkedTrackColor = GoldSand,
                uncheckedThumbColor = TextMuted,
                uncheckedTrackColor = SurfaceDark2
            )
        )
    }
    }
}