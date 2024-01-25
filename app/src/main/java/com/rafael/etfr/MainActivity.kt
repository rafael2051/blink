package com.rafael.etfr

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.rafael.etfr.ui.theme.EtfrTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EtfrTheme {
                PdfSelector()
            }
        }
    }
}

@Composable
fun PdfSelector(modifier: Modifier = Modifier){
    val back = painterResource(R.drawable.back)
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Column() {
            Row {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .fillMaxHeight(0.25f)
                ) {
                    Button(onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Black
                        ),
                        shape = RectangleShape,
                        modifier = Modifier.fillMaxWidth()) {
                        Icon(imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Seta para trás",
                            modifier = Modifier.fillMaxSize(1f))
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .fillMaxHeight(0.25f)
                ) {
                    Button(onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.Black
                        ),
                        shape = RectangleShape,
                        modifier = Modifier.fillMaxWidth()) {
                        Icon(imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Seta para trás",
                            modifier = Modifier.fillMaxSize(1f))
                    }
                }
            }
            Row{
                Column(
                    modifier = Modifier.fillMaxHeight(0.75f)
                ) {
                    Pdfs(0.5f)
                    Pdfs(1f)
                }
            }
            Column(
                modifier = Modifier.fillMaxHeight()
            ){
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black
                    ),
                    shape = RectangleShape,
                    modifier = Modifier.fillMaxSize()) {
                    Icon(imageVector = Icons.Default.Home,
                        contentDescription = "Icone de uma casa pra voltar pra pagina inicial",
                        modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun PdfImage(){
    val pdf = painterResource(R.drawable.pdf_icon)
    Image(
        painter = pdf,
        contentDescription = "Imagem mostra ícone de pdf",
        modifier = Modifier.fillMaxWidth().
                    fillMaxHeight(0.75f))
}

@Composable
fun PdfTitle(titulo: String){
    Text(
        text = titulo,
        fontSize = 10.sp,
        textAlign = TextAlign.Center,
        color = Color.Blue,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun Pdfs(spaceOccupied: Float){
    var titulo:String = stringResource(R.string.titulo_livro)
    LazyRow{
        items(2){i ->
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                ),
                shape = RectangleShape,
                modifier = Modifier
                    .fillParentMaxWidth(0.5f)
                    .fillParentMaxHeight(spaceOccupied)) {
                Column {
                    PdfImage()
                    PdfTitle(titulo)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EtfrTheme {
        PdfSelector()
    }
}