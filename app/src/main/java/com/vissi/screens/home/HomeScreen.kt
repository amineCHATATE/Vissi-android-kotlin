package com.vissi.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vissi.model.Category
import com.vissi.model.Product

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    onProfileClick: () -> Unit,
    onCartClick: () -> Unit
) {

    Scaffold (
        topBar = { MyTopBar(onProfileClick, onCartClick) },
        bottomBar = { BottomNavigationBar() }
   ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {

            // Search Section
            val searchQuery = remember { mutableStateOf("") }
            val focusManager = LocalFocusManager.current
            SearchBar(
                query = searchQuery.value,
                onQueryChange = { searchQuery.value = it },
                onSearch = {
                    focusManager.clearFocus()
                },
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            )

            // Search Result Section

            // Categories Section
            SectionTitle("Categories", "See All") {
                navController.navigate("Categories")
            }

            val categories : List<Category> = listOf(
                Category(1, "Hommes", "https://cdn-icons-png.flaticon.com/512/1555/1555401.png"),
                Category(2, "Femmes", "https://cdn-icons-png.flaticon.com/512/2935/2935183.png"),
                Category(2, "Enfants", "https://cdn-icons-png.flaticon.com/512/2935/2935183.png"),
            )

            // the selected category
            val selectedCategory = remember { mutableStateOf(0) }

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories.size) {
                    CategoryChip (
                        icon = categories[it].imageUrl,
                        text = categories[it].name,
                        isSelected = selectedCategory.value == it,
                        onClick = { selectedCategory.value = it }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Featured Products Section
            Spacer(modifier = Modifier.height(16.dp))
            SectionTitle("Featured", "See All") {
                /* TODO() */
            }

            val productList: List<Product> = listOf (
                Product("1", "Smartphones", 999.99, "https://cdn-icons-png.flaticon.com/512/186/186239.png "),
                Product("2", "T-Shirts", 19.99, "https://cdn-icons-png.flaticon.com/512/2935/2935183.png"),
                Product("3", "Laptops", 9999.99, "https://cdn-icons-png.flaticon.com/512/610/610021.png"),
                )
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(productList) { product ->
                    FeaturedProductCard(product) {

                    }
                }
            }
        }
    }
}