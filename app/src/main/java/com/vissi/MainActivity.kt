package com.vissi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vissi.screens.cart.CartScreen
import com.vissi.screens.caterory.CategoryScreen
import com.vissi.screens.home.HomeScreen
import com.vissi.screens.navigation.Screens
import com.vissi.screens.product.ProductScreen
import com.vissi.screens.profile.ProfileScreen
import com.vissi.screens.profile.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost (
                navController = navController,
                startDestination = Screens.Home.route)
            {
                composable(Screens.Home.route) {
                    HomeScreen(
                        navController = navController,
                        onProfileClick = { navController.navigate(Screens.Profile.route) },
                        onCartClick = { navController.navigate(Screens.Cart.route) }
                    )
                }

                composable(Screens.Cart.route) {
                    CartScreen(navController = navController)
                }

                composable(Screens.Profile.route) {
                    ProfileScreen(navController = navController, onSignOut = {
                        navController.navigate(Screens.Home.route)
                    })
                }

                composable(Screens.Categories.route) {
                    CategoryScreen(navController = navController)
                }

                composable(Screens.ProductList.route) {
                    val categoryId = it.arguments?.getString("categoryId")
                    if (categoryId != null) {
                        ProductScreen(categoryId, navController)
                    }
                }

                composable(Screens.SingUp.route){
                    SignUpScreen(
                        onNavigateToLogin = { navController.navigate(Screens.Login.route) },
                        onSignUpSuccess = { navController.navigate(Screens.Home.route)}
                    )
                }

            }
        }
    }
}
