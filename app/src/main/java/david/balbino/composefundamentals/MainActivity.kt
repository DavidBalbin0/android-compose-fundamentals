package david.balbino.composefundamentals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import david.balbino.composefundamentals.ui.theme.ColorPrimary
import david.balbino.composefundamentals.ui.theme.ComposeFundamentalsTheme
import david.balbino.textcomponent.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFundamentalsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Form()
                }
            }
        }
    }
}

@Composable
fun Form() {
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var address by remember {
        mutableStateOf("")
    }

    var javaIsSelected by remember {
        mutableStateOf(false)
    }
    var kotlinIsSelected by remember {
        mutableStateOf(false)
    }
    var pythonIsSelected by remember {
        mutableStateOf(false)
    }
    var radioSelected by remember {
        mutableStateOf(0)
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .background(Color(30, 30, 30, 255))
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = "FIAP",
                fontSize = 30.sp,
                color = Color(0xFFED145B),
                fontWeight = FontWeight.Bold

            )
        }

        Spacer(modifier = Modifier
            .height(20.dp)
        )
        
        OutlinedTextField(
            value = name,
            onValueChange = { name = it},
            label = {
                Text(text = "Name and last name")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.person_24),
                    contentDescription = "person icon",
                    tint = ColorPrimary
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = ColorPrimary
            )
        )

        Spacer(modifier = Modifier
            .height(20.dp)
        )

        OutlinedTextField(
            email, { email = it},
            label = {
                Text(text = "What's your email?")
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = ColorPrimary
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.email_24),
                    contentDescription = "person icon",
                    tint = ColorPrimary
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier
            .height(20.dp)
        )

        OutlinedTextField(
            value = address,
            onValueChange = { address = it},
            label = {
                Text(text = "Where do you live?")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.house_24),
                    contentDescription = "person icon",
                    tint = ColorPrimary
                )
            },

            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = ColorPrimary
            )
        )

        Spacer(modifier = Modifier
            .height(20.dp)
        )

        Column {
            Text(text = "Select your programming languages")
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {

                Checkbox(
                    checked = javaIsSelected,
                    onCheckedChange = { javaIsSelected = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = ColorPrimary
                    )
                )
                Text(text = "Java")
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = kotlinIsSelected,
                    onCheckedChange = { kotlinIsSelected = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = ColorPrimary
                    )
                )
                Text(text = "Kotlin")
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = pythonIsSelected,
                    onCheckedChange = { pythonIsSelected = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = ColorPrimary
                    )
                )
                Text(text = "Python")
            }
        }
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        Text(text = "What's your operational system?")
        Row  {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = radioSelected == 1,
                    onClick = { radioSelected = 1 },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = ColorPrimary
                    )
                )
                Text(text = "MacOS")
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = radioSelected == 2,
                    onClick = { radioSelected = 2 },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = ColorPrimary
                    ),
                )
                Text(text = "Windows")
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = radioSelected == 3,
                    onClick = { radioSelected = 3 },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = ColorPrimary
                    )
                )
                Text(text = "GNU/Linux")
            }
        }

        Spacer(modifier = Modifier
            .height(80.dp)
        )

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = ColorPrimary
            ),
            modifier = Modifier
                .size(width = 200.dp, height = 60.dp)
            ) {
            Text(text = "Click")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        ComposeFundamentalsTheme {
            Form()
        }
    }
}