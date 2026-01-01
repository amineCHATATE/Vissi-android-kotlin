package com.vissi.screens.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.vissi.model.Product
import com.vissi.screens.navigation.Screens

@Composable
fun ProductScreen (
    categoryId: String,
    navController: NavController
) {

    val productList: List<Product> = listOf (
        Product("1", "Smartphones", 999.99, "https://cdn-icons-png.flaticon.com/512/186/186239.png "),
        Product("2", "T-Shirts", 19.99, "https://cdn-icons-png.flaticon.com/512/2935/2935183.png"),
        Product("3", "Laptops", 9999.99, "https://cdn-icons-png.flaticon.com/512/610/610021.png"),
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Product of Category Id : $categoryId",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
            )

        if (productList.isEmpty()){
            Text(
                text = "No prducts found!",
                modifier = Modifier.padding(16.dp)
                )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(productList){ product ->
                    ProductItem(
                        product = product,
                        onClick = {
                            navController.navigate(Screens.ProductDetails.createRoute(product.id))
                        },
                        onAddToCart = {

                        }
                    )

                }
            }
        }
    }
}