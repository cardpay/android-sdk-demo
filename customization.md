## Customization

| #   | Customization block          | Description                                          |
|-----|------------------------------|------------------------------------------------------|
| 1   | Screen.titleText             | Text of form                                         |
| 2   | Screen.titleTextColor        | Color of form title text                             |
| 3   | Screen.backgroundColor       | Background color of form                             |
| 4   | CardForm.cardLabelText       | Text on card                                         |
| 5   | CardForm.cardLabelColor      | Color if card text                                   |
| 6   | CardForm.cardBackgroundColor | Background of card form                              |
| 7   | CardForm.cardNumberText      | Text of PAN field                                    |
| 8   | CardForm.expirationText      | Text of Expiration field                             |
| 9   | CardForm.secretCodeText      | Text of Secret code field                            |
| 10  | CardForm.fieldsTextColor     | Color of 7-9                                         |
| 11  | OrderDescription.textColor   | Color of order description                           |
| 12  | NextButton.buttonText        | Text of Pay button                                   |
| 13  | NextButton.buttonTextColor   | Color of Pay button text                             |
| 14  | NextButton.enabledColor      | Color of enable Pay button. Works only with 15       |
| 15  | NextButton.disabledColor     | Color of disable Pay button. Works only with 14      |
| 16  | NextButton.backgroundColor   | Background color of button. Can be set the same as 6 |

![Description](/pics/customization-map.png)

```kotlin
    arrayListOf(
        Customization.Screen().set(
            titleText = "One more step",
            titleTextColor = "#004A7C",
            backgroundColor = "#b7c9e2"
        ),
        Customization.CardForm().set(
            cardLabelText = "Brand new card",
            cardLabelColor = "#CDCDCD",
            cardBackgroundColor = "#004A7C",
            cardNumberText = "Enter card number here",
            expirationText = "expiration here",
            secretCodeText = "cvv2/cvc2 here",
            fieldsTextColor = "#005691"
        ),
        Customization.OrderDescription().set(
            textColor = "#FFFFFF"
        ),
        Customization.NextButton().set(
            buttonText = "Total",
            buttonTextColor = "#CDCDCD",
            enabledColor = "#005691",
            disabledColor = "#F2F2F2",
            backgroundColor = "#272C34"
        )
    )
```
