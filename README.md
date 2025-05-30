<h1 align="center">Progetto RollTheDice</h1>

<p align="center" style="font-family: monospace">Alessandro Stefanucci <a href="https://github.com/LaggoSeeingo">@LaggoSeeingo</a></p>

## Scopo del Progetto
Realizzare un'app per android, sviluppando in kotlin + XML, che consenta di estrarre un numero randomico e di visualizzare l'immagine del dado corrispondente al numero estratto.
Nello stesso tempo deve essere possibile visualizzare un messaggio temporaneo e passare ad una nuova schermata per verificare la vittoria o meno in funzione del lancio fatto.


## Activity

### 1. MainActivity
Prima activity che permette di lanciare il dado

#### Dettaglio della funzione rollDice()
```kotlin
        private fun rollDice(){

        Log.d(TAG, "Dice rolling")
        val randomNumber = (1..6).random()
        Log.d(TAG, "Numero estratto: "+ randomNumber.toString())

       // txtNumber.text = randomNumber.toString()

        val imgDiceRes = when(randomNumber){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //imgDice.setImageResource(imgDiceRes)

        val intent = Intent(this, RollActivity::class.java).apply{
            putExtra("NUMERO", randomNumber.toString())
            putExtra("IMGRES", imgDiceRes)
        }
        startActivity(intent)

    }
```
La funzione:
- Genera un numero casuale da 1 a 6
- Legge il numero estratto e assegna alla variabile imgDiceRes la risorsa dell'immagine del dado corrispondente
- Istanzia un Intent che conduce alla seconda activity inserendo nel bundle i dati del numero estratto e dell'immagine associata



### 2. RollActivity
Activity a cui si accede dopo aver lanciato il dado, visualizza il risultato, l'immagine e contiene il bottone di verifica

#### Dettaglio della funzione verify()
```kotlin
 private fun verify(){

        val message = intent.getStringExtra("NUMERO")

        val txtRisultato = when(message){
            "1" -> "Numero dispari, hai perso..."
            "2" -> "Numero pari! Hai vinto!"
            "3" -> "Numero dispari, hai perso..."
            "4" -> "Numero pari! Hai vinto!"
            "5" -> "Numero dispari, hai perso..."
            else -> "Numero pari! Hai vinto!"
        }

        val imgVerifica = when(txtRisultato){
            "Numero dispari, hai perso..." -> R.drawable.sadpinkpanther
            else -> R.drawable.happypinkpanther
        }



        val intentVerifica = Intent(this, VerificaActivity::class.java).apply{
            putExtra("IMG", imgVerifica)
            putExtra("TXT", txtRisultato)
        }
        startActivity(intentVerifica)
    }
```
La funzione:
- Recupera il numero estratto dal bundle dell'intent istanziato dalla funzione rollDice()
- Legge il numero estratto e assegna alla variabile txtRisultato un valore string che annuncia la vittoria o la sconfitta
- In base all'esito (vittoria se il numero è pari o sconfitta se è dispari), assegna alla variabile imgVerifica la risorsa della pantera rosa felice o triste

### 3. VerificaActivity
Mostra l'esito



