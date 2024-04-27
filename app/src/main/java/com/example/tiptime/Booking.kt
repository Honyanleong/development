package com.example.tiptime



import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tiptime.Data.Booking
import com.example.tiptime.Data.Hotel
import com.example.tiptime.Data.room
import com.example.tiptime.ui.theme.TipTimeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.nio.file.WatchEvent


@Composable
fun booking (
    onNextButtonClicked:() -> Unit = {},
    onCancelButtonClicked : () -> Unit = {},
    Address : String,
    hotelName : String,
    roomtype : String,
    price : Double
){
    val text = " "
    Column {
        Row (
            ){
            Image(painter = painterResource(R.drawable.nitro_wallpaper_02_3840x2400), contentDescription = null )
        }
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 245.dp),

    ){
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = hotelName , color = Color.White, fontSize = 35.sp )

        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(

        ) {
            Text(text = Address, fontSize = 15.sp , color = Color.White,)
        }
    }

    Column (
        Modifier
            .fillMaxSize()
            .padding(top = 400.dp),

    ){

        Box(modifier = Modifier){
            HorizontalDivider(modifier = Modifier.padding(start = 2.dp ), thickness = 3.dp)
            Row {
                Column {
                    Text(text = roomtype, color = Color.White , fontSize = 20.sp,modifier = Modifier.padding(top = 35.dp))
                }
                Column(

                ) {
                    Text(text = price.toString(), color = Color.White , fontSize = 20.sp,modifier = Modifier.padding(top = 35.dp,start = 270.dp))
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(start = 2.dp , top = 90.dp),
                thickness = 3.dp
            )
            Row {
                Column {
                    Text(text = roomtype, color = Color.White , fontSize = 20.sp,modifier = Modifier.padding(top = 35.dp))
                }
                Column(

                ) {
                    Text(text = checkAvailable(roomtype = roomtype).toString(), color = Color.White , fontSize = 20.sp,modifier = Modifier.padding(top = 35.dp,start = 270.dp))
                }
            }
            HorizontalDivider(
                modifier = Modifier.padding(start = 2.dp , top = 190.dp),
                thickness = 3.dp
            )
            Row {
                Column {
                    Text(text = checkAvailable(roomtype = roomtype).toString(), color = Color.White , fontSize = 20.sp,modifier = Modifier.padding(top = 35.dp))
                }
                Column(

                ) {
                    Text(text = checkAvailable(roomtype = roomtype).toString() , color = Color.White , fontSize = 20.sp,modifier = Modifier.padding(top = 35.dp,start = 270.dp))
                }
            }
            HorizontalDivider(
                modifier = Modifier.padding(start = 2.dp , top = 290.dp),
                thickness = 3.dp
            )



        }

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(modifier = Modifier
            .padding(start = 45.dp)
            .fillMaxWidth()) {
            OutlinedButton(
                onClick =  onCancelButtonClicked,modifier = Modifier
                    .padding(end = 100.dp)
                    .size(width = 100.dp, height = 50.dp)) {
                Text(text = "Cancel")
            }
            OutlinedButton(onClick = onNextButtonClicked,modifier = Modifier.size(width = 100.dp, height = 50.dp)) {
                Text(text = "Next")
            }

        }
        Spacer(modifier = Modifier.height(50.dp))

    }

}
/*@Preview
@Composable
fun Bookings() {

    TipTimeTheme {
        booking()
    }
}
*/
@Composable
fun checkAvailable(roomtype: String) : String{
    val status by remember {
        mutableStateOf("Available")
    }
    val price : Double = 0.00
    var canClick by remember{ mutableStateOf(false) }
    var selectedRoom by remember { mutableStateOf(false) }
    var textcolor by remember{ mutableStateOf(Color.Green) }
    if(status == "Available"){
        canClick =true
        Text(text = price.toString(), modifier = Modifier.clickable { selectedRoom = true },color = textcolor)
        if(selectedRoom){
            textcolor = Color.Red
        }else{
            textcolor = Color.Green
        }
    }else{
        canClick = false
        Text(text = "UnAvailable" , color = Color.Red)
    }
    return price.toString()

}
