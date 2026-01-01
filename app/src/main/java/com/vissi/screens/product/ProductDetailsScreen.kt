package com.vissi.screens.product

import android.graphics.drawable.Icon
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.vissi.model.Product

@Composable
fun ProductDetailsScreen(
    productId: String
) {

    val dummyProduct = Product("1", "Smartphones", 999.99, "https://cdn-icons-png.flaticon.com/512/186/186239.png ")

    if (dummyProduct == null){
        Text(text = "No product found")
    } else {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = dummyProduct.imageUrl),
                contentScale = ContentScale.Crop,
                contentDescription = "Product Image",
                modifier = Modifier.fillMaxSize()
                    .height(300.dp)
                    .clip(RoundedCornerShape(12.dp)),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = dummyProduct.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$${dummyProduct.price}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Product description",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
            )
        }
        IconButton(
            onClick = {},
            modifier = Modifier.padding(16.dp)
                .background(MaterialTheme.colorScheme.primary, shape = CircleShape),
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Add to cart",
                tint = Color.White
            )
        }
    }
}