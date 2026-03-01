package com.example.praktam2_2417051054

import Model.BarangSource
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktam2_2417051054.ui.theme.PrakTAM2_2417051054Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrakTAM2_2417051054Theme {
                Main()
            }
        }
    }
}

@Composable
fun Main() {
    Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
        DaftarBarang(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun DaftarBarang(modifier: Modifier = Modifier) {

    Column (modifier = modifier.fillMaxSize().padding(all = 30.dp)) {
        for (barang in BarangSource.listBarang) {
            Row {
                Image(
                    painter = painterResource(id = barang.ImagesRes),
                    contentDescription = null,
                    modifier = Modifier.height(80.dp).width(80.dp)
                )

                Spacer(Modifier.width(15.dp))

                Column {
                    Text(text = barang.nama, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Rp ${barang.harga}", fontSize = 20.sp)
                    Text(text = "Stock: ${barang.stok}", fontSize = 15.sp)
                }
            }

            Spacer(Modifier.height(20.dp))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DaftarBarangPreview() {
    PrakTAM2_2417051054Theme {
        Main()
    }
}