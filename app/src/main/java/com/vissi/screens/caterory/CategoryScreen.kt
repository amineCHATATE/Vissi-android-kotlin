package com.vissi.screens.caterory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vissi.model.Category
import com.vissi.screens.navigation.Screens

@Composable
fun CategoryScreen(
    navController: NavController
) {
    val categories : List<Category> = listOf(
        Category(1, "Hommes", "https://cdn-icons-png.flaticon.com/512/1555/1555401.png"),
        Category(2, "Femmes", "https://cdn-icons-png.flaticon.com/512/2935/2935183.png"),
        Category(2, "Enfants", "https://cdn-icons-png.flaticon.com/512/2935/2935183.png"),
    )

    Column {
        if (categories.isEmpty()){
            Box(modifier = Modifier.fillMaxSize().padding(16.dp)){
                Text(
                    text = "Aucune catégorie trouvée",
                    style = MaterialTheme.typography.bodyLarge)
            }
        } else {
            Text(
                text = "Categories",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            ) {
                items(categories) {category ->
                    CategoryItem(
                        category = category,
                        onClick = {
                            navController.navigate(Screens.ProductList.createRoute(category.id.toString()))
                        }
                    )
                }
            }
        }
    }

}