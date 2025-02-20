package com.example.ejemplo1

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
        painter = painterResource(id = R.drawable.matematicas),
        contentDescription = "imagen",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun Texto(){

    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text1,
        modifier = Modifier.padding(horizontal = 70.dp)
            .fillMaxWidth(1f),
            onValueChange = {
                text1 = it
            }
        ,
        label = {Text("Valor 1")},
        placeholder = { Text(text = "Teclea el primer valor") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    OutlinedTextField(
        value = text2,
        modifier = Modifier.padding(horizontal = 70.dp, vertical = 50.dp)
            .fillMaxWidth(1f),
        onValueChange = {
            text2 = it
        }
        ,
        label = {Text("Valor 2")},
        placeholder = { Text(text = "Teclea el segundo valor") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    var resultado by remember{(mutableStateOf(0.0))}

    Button(
        onClick = {
            resultado = text1.toDouble() + text2.toDouble()

        },
        border = BorderStroke(1.dp, Color.Black),
        colors = ButtonDefaults.buttonColors(Color.Black),
        modifier = Modifier.padding(horizontal = 145.dp, vertical = 7.dp)

    ) {
        Text(text = "Calcular", color = Color.White)
    }

    Text(
        "El resultado de la suma es: " + resultado,
        modifier = Modifier.padding(horizontal = 90.dp)
    )
}


