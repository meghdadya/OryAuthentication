package com.example.oryAuthentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feature.login.LoginRoute
import com.example.feature.register.RegisterRoute
import com.example.oryAuthentication.navigation.Route
import com.example.ui_component.ui.theme.RapytonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RapytonTheme {
                val navController = rememberNavController()

                Surface(modifier = Modifier.fillMaxSize()) {
                    NavHost(navController = navController, startDestination = Route.LOGIN) {
                        composable(Route.REGISTER) {
                            RegisterRoute()
                        }

                        composable(Route.LOGIN) {
                            LoginRoute(onNavigate = { navController.navigate(Route.REGISTER) })
                        }
                    }

                }
            }
        }
    }
}
