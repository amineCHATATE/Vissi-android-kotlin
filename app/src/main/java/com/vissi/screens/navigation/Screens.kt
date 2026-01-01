package com.vissi.screens.navigation

import android.R

sealed class Screens (val route: String) {

    object Cart: Screens("Cart")
    object Profile: Screens("Profile")
    object Home: Screens("Home")
    object Login: Screens("Login")
    object SingUp: Screens("SingUp")
    object Categories: Screens("Categories")
    object WishList: Screens("WishList")

    object CategoryList: Screens("category_list")

    object ProductList: Screens("product_list/{categoryId}") {
        fun createRoute(categoryId: String) = "product_list/$categoryId"
    }
    object ProductDetails: Screens("product_details/{productId}") {
        fun createRoute(productId: String) = "product_details/$productId"
    }

}