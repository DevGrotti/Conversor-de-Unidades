package br.udemy.unitconverterexercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlin.math.absoluteValue

@Composable
fun Conversor(){

    var inputValor by remember { mutableStateOf("")}
    var outputValor by remember { mutableStateOf("")}
    var inputUnidade by remember { mutableStateOf("Metros")}
    var outputUnidade by remember { mutableStateOf("Metros")}
    var inputExpandido by remember { mutableStateOf(false)}
    var outputExpandido by remember { mutableStateOf(false)}
    var inputConversor = remember { mutableStateOf(1.00)}
    var outputConversor = remember { mutableStateOf(1.00)}


    fun converterUnidades() {

        val inputValorDecimal = inputValor.toDoubleOrNull() ?: 0.00
        val res = (inputValorDecimal * inputConversor.value * 100.0 / outputConversor.value) / 100.0
        outputValor = res.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.titulo), style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValor,
            onValueChange = {
                inputValor = it
                converterUnidades()
            },
            label = { Text(stringResource(R.string.hint))})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box{
                Button(onClick = {inputExpandido = true}) {
                    Text(text = inputUnidade)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
                DropdownMenu(expanded = inputExpandido, onDismissRequest = { inputExpandido = false }) {
                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.milimetro)) },
                        onClick = {
                            inputExpandido = false
                            inputUnidade = "Milimetros"
                            inputConversor.value = 0.001
                            converterUnidades()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.centimetro)) },
                        onClick = {
                            inputExpandido = false
                            inputUnidade = "Centímetros"
                            inputConversor.value = 0.01
                            converterUnidades()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.decimetro)) },
                        onClick = {
                            inputExpandido = false
                            inputUnidade = "Decimetros"
                            inputConversor.value = 0.1
                            converterUnidades()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.metro)) },
                        onClick = {
                            inputExpandido = false
                            inputUnidade = "Metros"
                            inputConversor.value = 1.00
                            converterUnidades()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.decametro)) },
                        onClick = {
                            inputExpandido = false
                            inputUnidade = "Decametros"
                            inputConversor.value = 10.0
                            converterUnidades()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.hectometro)) },
                        onClick = {
                            inputExpandido = false
                            inputUnidade = "Hectômetros"
                            inputConversor.value = 100.00
                            converterUnidades()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.quilometro)) },
                        onClick = {
                            inputExpandido = false
                            inputUnidade = "Quilômetros"
                            inputConversor.value = 1000.00
                            converterUnidades()
                        }
                    )

                }

            }
            Spacer(modifier = Modifier.width(16.dp))

            Box{

                Button(onClick = { outputExpandido = true}) {
                    Text(text = outputUnidade)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
                DropdownMenu(expanded = outputExpandido, onDismissRequest = { outputExpandido = false }) {
                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.milimetro)) },
                        onClick = {
                            outputExpandido = false
                            outputUnidade = "Milimetros"
                            outputConversor.value = 0.001
                            converterUnidades()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.centimetro)) },
                        onClick = {
                            outputExpandido = false
                            outputUnidade = "Centímetros"
                            outputConversor.value = 0.01
                            converterUnidades()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.decimetro)) },
                        onClick = {
                            outputExpandido = false
                            outputUnidade = "Decimetro"
                            outputConversor.value = 0.1
                            converterUnidades()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.metro)) },
                        onClick = {
                            outputExpandido = false
                            outputUnidade = "Metros"
                            outputConversor.value = 1.00
                            converterUnidades()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.decametro)) },
                        onClick = {
                            outputExpandido = false
                            outputUnidade = "Decametro"
                            outputConversor.value = 10.0
                            converterUnidades()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.hectometro)) },
                        onClick = {
                            outputExpandido = false
                            outputUnidade = "Hectômetro"
                            outputConversor.value = 100.00
                            converterUnidades()
                        }
                    )

                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.quilometro)) },
                        onClick = {
                            outputExpandido = false
                            outputUnidade = "Quilômetros"
                            outputConversor.value = 1000.00
                            converterUnidades()
                        }
                    )

                }

            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Resultado: $outputValor $outputUnidade", style = MaterialTheme.typography.headlineMedium)
    }
}


