package com.vissi.screens.home

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vissi.model.BottomNavItem
import com.vissi.screens.navigation.Screens

@Composable
fun BottomNavigationBar() {
    var currentRoute = ""

    val items = listOf(
        BottomNavItem(title = "Home", icon = Icons.Default.Home, route = Screens.Home.route),
        BottomNavItem(title = "Categories", icon = Icons.Default.Search, route = Screens.Categories.route),
        BottomNavItem(title = "WishList", icon = Icons.Default.Favorite, route = Screens.WishList.route, badgeCount = 5),
        BottomNavItem(title = "Cart", icon = Icons.Default.ShoppingCart, route = Screens.Cart.route, badgeCount = 3),
        BottomNavItem(title = "Profile", icon = Icons.Default.Person, route = Screens.Profile.route)
    )

    NavigationBar (
        modifier = Modifier.height(height = 82.dp),
        containerColor = Color.White,
        tonalElevation = 8.dp
    ) {
        items.forEach {
            NavigationBarItem(
                icon = {
                    if (it.badgeCount > 0) {
                        BadgedBox(badge = { Badge { Text(it.badgeCount.toString()) } }) {
                            Icon(
                                imageVector = it.icon,
                                contentDescription = it.title,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    } else {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = it.title,
                            modifier = Modifier.size(size = 24.dp)
                        )
                    }
                },
                selected = currentRoute == it.route,
                onClick = { },
                label = { Text(text = it.title) },
            )
        }
    }

}

