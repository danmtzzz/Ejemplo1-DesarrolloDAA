package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {
                    setContent()
                }
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    setContent()
}

@Composable
fun setContent()
{
    Column {

        SimpleButton()
        ButtonWithColor()
        ButtonWithTwoTextView()
        ButtonWithIcon()
    }
}

@Composable
fun SimpleButton(){
    Button(onClick = {

    }) {
        Text(text = "Simple Button")
    }
}

@Composable
fun ButtonWithColor(){
    Button(onClick = {

    },colors = ButtonDefaults.buttonColors(Color.DarkGray))
    {
        Text(text = "Button with Gray Background", color = Color.White)
    }
}

@Composable
fun ButtonWithTwoTextView(){
    Button(onClick = {

    }){
        Text(text = "Click", color = Color.Magenta)
        Text(text = "Here", color = Color.Green)
    }
}

@Composable
fun ButtonWithIcon(){
    Button(onClick = {}) {
        Image(
            painterResource(id = R.drawable.cart),
            contentDescription ="Cart button icon",
            modifier = Modifier.size(20.dp))

        Text(text = "Add to cart",Modifier.padding(start = 10.dp))
    }
}


