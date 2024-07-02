package com.example.mvvmspedtalk.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmspedtalk.AppViewState

@Composable
fun AppContent( viewState: AppViewState,
                onChangeName: (String) -> Unit,
                onChangeMajor: (String) -> Unit,
                onChangeAge: (String) -> Unit,
                updateName: () -> Unit,
                updateMajor: () -> Unit,
                updateAge: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Column {
            Text(text = "SpedTalk App", modifier = Modifier.align(Alignment.CenterHorizontally), fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(modifier = Modifier.size(16.dp))
            ViewAndEdit("Name", viewState.name, onChangeName, updateName)
            ViewAndEdit("Major", viewState.major, onChangeMajor, updateMajor)
            ViewAndEdit("Age", viewState.age, onChangeAge, updateAge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    val fakeViewState = AppViewState(
        name = "Name",
        major = "Major",
        age = "Age"
    )

    AppContent(fakeViewState, {}, {}, {}, {}, {}, {})
}

@Composable
fun ViewAndEdit(category: String, currentValue: String,
                onValueChange: (String) -> Unit, onSave: () -> Unit) {

    var textFieldValue by remember { mutableStateOf(currentValue) }

    // Update textFieldValue when currentValue changes
    LaunchedEffect(currentValue) {
        textFieldValue = currentValue
    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {

        Text(category, modifier = Modifier.weight(1f), color = Color.DarkGray, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.weight(.1f))

        BasicTextField(value = textFieldValue, modifier = Modifier
            .weight(1f)
            .background(Color.LightGray)
            .padding(8.dp),
            onValueChange = {
                textFieldValue = it
                onValueChange(it)
            }
        )

        Spacer(modifier = Modifier.weight(.1f))

        Button(modifier = Modifier.weight(.7f), onClick = { onSave() }) {
            Text("Save")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewAndEditPreview() {
    ViewAndEdit("Category", "Value", {}, {})
}