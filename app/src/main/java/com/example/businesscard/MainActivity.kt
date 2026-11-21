package com.example.businesscard

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Email
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                     BusinessCardApp()
                }
            }
        }
    }
}
@Composable
fun BusinessCardApp() {
    Box(Modifier.fillMaxSize().background(Color(0xFFD2E8D4)).padding(16.dp)){
        ProfileSection(      //isme hmara nam or title dia jayega ki hm kya hai ya kya krte hai
            name= "RudraPratap Singh",
            title= "Full-Stack Android Developer",
            Modifier.align(Alignment.Center)
                      )

        ContactSection(       // isme contact details aayegi jisem number od github and email likhi jayegi
            phone= "+91 8630239530",
            socialHandle= "GitHub = coderhack7274",
            email= "rudrapratap7911@gmail.com",
            Modifier.align(Alignment.BottomCenter).padding(bottom=32.dp)
                      )
    }
}
@Composable
fun ProfileSection(name:String, title: String, modifier: Modifier=Modifier){
    Column(modifier= modifier, horizontalAlignment= Alignment.CenterHorizontally){
        Box( Modifier
            .size(110.dp)
            .background(Color(0xFF073042))
            .padding(12.dp),
            contentAlignment = Alignment.Center
           ){
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription= "Android Logo",
                Modifier.fillMaxSize()
                 )
        }
        Spacer(Modifier.height(12.dp))

        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color= Color(0xFF006D3B)
            )
    }
}

@Composable
fun ContactSection(phone:String, socialHandle: String, email: String, modifier: Modifier = Modifier){
    Column(modifier=modifier.width(IntrinsicSize.Max),
     verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        ContactRow(icon=Icons.Rounded.Phone, text=phone)
        ContactRow(icon=Icons.Rounded.Share, text=socialHandle)
        ContactRow(icon=Icons.Rounded.Email, text=email)
    }
}

@Composable
fun ContactRow(icon: ImageVector, text:String) {
    Row(
        verticalAlignment= Alignment.CenterVertically,
       modifier= Modifier.fillMaxWidth()
       ){
        Icon(
            imageVector=icon,
            contentDescription= null,
            tint= Color(0xFF006D3B),
            modifier= Modifier.size(25.dp)
        )
        Spacer(Modifier.width(16.dp))

        Text(
        text= text,
            fontSize=15.sp,
            color= Color(0xFF073042)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}