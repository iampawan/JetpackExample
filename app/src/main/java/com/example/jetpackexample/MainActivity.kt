package com.example.jetpackexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.text.TextStyle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           myApp()
        }

    }

    @Composable
    fun myApp(){
        var count = +state { 0 }
        MaterialTheme {
            FlexColumn {
                inflexible {
                    TopAppBar<MenuItem>(title = { Text("JetPack Compose", style = TextStyle(
                        color = Color.White
                    ))},
                        color = Color(0xff00574b))
                }
                expanded(1F){
                    Center {
                        Column(mainAxisAlignment = MainAxisAlignment.Center,
                            crossAxisAlignment = CrossAxisAlignment.Center) {
                            Text("Counter count is ${count.value}")

                        }
                    }

                }
                inflexible {
                    Row(mainAxisSize = LayoutSize.Expand,mainAxisAlignment = MainAxisAlignment.End){
                        Padding(padding = EdgeInsets(all = 16.dp)){
                            FloatingActionButton(text = "Add", onClick = {
                                count.value++
                            },
                                color = Color(0xff00574b),textStyle = TextStyle(
                                    color = Color.White
                                ))
                        }
                        Padding(padding = EdgeInsets(all = 16.dp)){
                            FloatingActionButton(text = "Subtract", onClick = {
                                count.value--
                            },
                                color = Color(0xff00574b),textStyle = TextStyle(
                                    color = Color.White
                                ))
                        }
                    }
                }
            }
        }

    }
}
