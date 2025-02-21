package com.example.ejemplo1

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {
                GreetingPreview()
                }
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
Column {
    Imagen()
    Texto()
}
}

@Composable
fun Imagen(){
    Image(
        painter = painterResource(id = R.drawable.walmart),
        contentDescription = "imagen",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun Texto(){

    var precio by remember { mutableStateOf("") }
    var descuento by remember { mutableStateOf("") }
    Row {
    OutlinedTextField(
        value = precio,
        modifier = Modifier.padding(horizontal = 20.dp)
            .fillMaxWidth(0.5f),
            onValueChange = {
                precio = it
            }
        ,
        label = {Text("Precio")},
        placeholder = { Text(text = "Ingresa el precio del producto") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    OutlinedTextField(
        value = descuento,
        modifier = Modifier.padding(horizontal = 5.dp/*, vertical = 50.dp*/)
            .fillMaxWidth(0.9f),
        onValueChange = {
            descuento = it
        }
        ,
        label = {Text("Descuento")},
        placeholder = { Text(text = "Ingresa el porcentaje de descuento(%)") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}
    var descuentoTotal by remember{(mutableStateOf(0.0))}
    var precioNuevo by remember{(mutableStateOf(0.0))}

    Button(
        onClick = {
            descuentoTotal = (precio.toDouble() * descuento.toDouble())/100
            precioNuevo = precio.toDouble() - descuentoTotal

        },
        border = BorderStroke(1.dp, Color.Black),
        colors = ButtonDefaults.buttonColors(Color.Black),
        modifier = Modifier.padding(horizontal = 145.dp, vertical = 7.dp)


    ) {
        Text(text = "Calcular", color = Color.White)
    }

    Text(
        "El precio con el descuento aplicado es de: " + precioNuevo,
        modifier = Modifier.padding(horizontal = 50.dp),
        color = Color.Blue
    )
}


