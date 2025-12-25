package com.innovation.mygraduationproject.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.material.Scaffold
import androidx.compose.material.FabPosition
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.innovation.mygraduationproject.AppBottomBar
import com.innovation.mygraduationproject.CenterCameraFab
import com.innovation.mygraduationproject.DetailsScreen
import com.innovation.mygraduationproject.Home_Screen
import com.innovation.mygraduationproject.Language
import com.innovation.mygraduationproject.SearchScreen
import com.innovation.mygraduationproject.SettingsScreen
import com.innovation.mygraduationproject.SplashScreen
import com.innovation.mygraduationproject.AboutScreen
import com.innovation.mygraduationproject.Camera_Screen
import com.innovation.mygraduationproject.HelpScreen
import com.innovation.mygraduationproject.PrivacyScreen
import com.innovation.mygraduationproject.Routes


@Composable
fun AppNavigator(startDestination: String = Routes.SPLASH) {

    var lang by rememberSaveable { mutableStateOf(Language.AR) }
    val dir = if (lang == Language.AR) LayoutDirection.Rtl else LayoutDirection.Ltr
    val nav = rememberNavController()
    val backStack by nav.currentBackStackEntryAsState()
    val currentRoute = backStack?.destination?.route
    val showBottomBar = currentRoute != Routes.SPLASH
    val onToggleLang: () -> Unit = {
        lang = if (lang == Language.AR) Language.EN else Language.AR
    }

    CompositionLocalProvider(LocalLayoutDirection provides dir) {

        Scaffold(
            bottomBar = {
                if (showBottomBar) {
                    AppBottomBar(
                        currentRoute = currentRoute,
                        onHome = {
                            nav.navigate(Routes.HOME) {
                                launchSingleTop = true
                                popUpTo(Routes.HOME) { inclusive = false }
                            }
                        },
                        onCamera = { nav.navigate(Routes.CAMERA) { launchSingleTop = true } },
                        onSettings = { nav.navigate(Routes.SETTINGS) { launchSingleTop = true } }
                    )
                }
            },
            floatingActionButton = {
                if (showBottomBar) {
                    CenterCameraFab {
                        nav.navigate(Routes.CAMERA) { launchSingleTop = true }
                    }
                }
            },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true
        ) { padding ->

            NavHost(
                navController = nav,
                startDestination = startDestination,
                modifier = Modifier.padding(padding)
            ) {

                composable(Routes.SPLASH) {
                    SplashScreen(
                        onFinish = {
                            nav.navigate(Routes.HOME) {
                                popUpTo(Routes.SPLASH) { inclusive = true }
                            }
                        }
                    )
                }

                composable(Routes.HOME) {
                    Home_Screen(
                        lang = lang,
                        onToggleLang = {
                            lang = if (lang == Language.AR) Language.EN else Language.AR
                        },
                        onOpenDetails = { id -> nav.navigate(Routes.details(id)) },
                        onOpenSearch = { nav.navigate(Routes.SEARCH) }
                    )
                }

                composable(
                    route = Routes.DETAILS,
                    arguments = listOf(navArgument("id") { type = NavType.StringType })
                ) { entry ->
                    val id = entry.arguments?.getString("id").orEmpty()
                    DetailsScreen(
                        id = id,
                        lang = lang,
                        onToggleLang = {
                            lang = if (lang == Language.AR) Language.EN else Language.AR
                        },
                        onBack = { nav.popBackStack() }
                    )
                }

                composable(Routes.SEARCH) {
                    SearchScreen(
                        lang = lang,
                        onToggleLang = {
                            lang = if (lang == Language.AR) Language.EN else Language.AR
                        },
                        onOpenDetails = { id -> nav.navigate(Routes.details(id.toString())) },
                        onBack = { nav.popBackStack() }
                    )
                }
                composable(Routes.CAMERA) {
                    Camera_Screen(
                        lang = lang,
                        onToggleLang = onToggleLang,
                        onBack = { nav.popBackStack() }
                    )
                }
                composable(Routes.SETTINGS) {
                    SettingsScreen(
                        lang = lang,
                        onToggleLang = onToggleLang,
                        onBack = { nav.popBackStack() },
                        onOpenHelp = { nav.navigate(Routes.HELP) },
                        onOpenAbout = { nav.navigate(Routes.ABOUT) },
                        onOpenPrivacy = { nav.navigate(Routes.PRIVACY) }
                    )
                }
                composable(Routes.HELP) {
                    HelpScreen(lang = lang, onToggleLang = onToggleLang, onBack = { nav.popBackStack() })
                }

                composable(Routes.ABOUT) {
                    AboutScreen(lang = lang, onToggleLang = onToggleLang, onBack = { nav.popBackStack() })
                }

                composable(Routes.PRIVACY) {
                    PrivacyScreen(lang = lang, onToggleLang = onToggleLang, onBack = { nav.popBackStack() })
                }

            }
        }
    }}