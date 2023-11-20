## Card recurring

This method allows you to make recurring. There are two available methods:
- new bank card,
- saved bank card (token)

When customer saves bank card while payment, your server will get a cardToken within unlimint's callback
You need to save this token and pass it to SDK, when customer wants to pay with saved card.

### Method signature
```ruby
    MobileSdk.recurringForResult(
        activity: AppCompatActivity,
        mobileAuthorizationToken: String,
        paymentMethodsData: ArrayList<OrderData>,
        showStatusScreen: Boolean = true,
        showAmountOnButton: Boolean = true,
        customizations: ArrayList<Customization>? = null,
        environment: Environments,
        launcher: ActivityResultLauncher<Intent>
    )
```
##### Mandatory params
- `activity` for calling our Activity
- `mobileAuthorizationToken` Mobile token received from Unlimint (authentication mobile token)
- `paymentMethodsData` arrayList of payment methods with information required for payment
- `launcher` ActivityResultLauncher instance received after registering for activity result
- `environment` Environment to send requests to

##### Optional params
- `showStatusScreen` flag that manages rendering of Unlimint's status screen (Success/Decline), default value is `true`
- `showAmountOnButton` flag that manages rendering of amount on button of payment screen
- `customizations` list of parameters to render custom texts and colors of UI elements

### Examples
To start using our SDK one must get authorization token from our backend mobile service.
Examples of getting token can be found in code of this project.

Payment method which is gonna be used for recurring, (card, card token or paypal), depends on provided data in
`paymentMethodsData` array.

##### Recurring with collecting of card data (SM)
```kotlin
        UnlimintSdk.reecurringForResult(
                activity = activity,
                mobileAuthorizationToken = token,
                paymentMethodsData = arrayListOf(
                    BankCardOrder(
                        merchantName = "Best shop eva",
                        customer = Customer(
                            id = "some-customer-id",
                            email = "some@email.com"
                        ),
                        merchantOrder = MerchantOrder(
                            description = "some description",
                            id = "some-id"
                        ),
                        operationData = ScheduledByMerchantRecurringData(
                            amount = Amount(
                                value = BigDecimal.valueOf(100),
                                currency = Currency.getInstance("USD"),
                            )
                        )
                    )
                ),
                environment = Environments.SANDBOX,
                launcher = launcher
        )
```

##### Recurring with collecting of card data (SA)
```kotlin
        UnlimintSdk.reecurringForResult(
                activity = activity,
                mobileAuthorizationToken = token,
                paymentMethodsData = arrayListOf(
                    BankCardOrder(
                        merchantName = "Best shop eva",
                        customer = Customer(
                            id = "some-customer-id",
                            email = "some@email.com"
                        ),
                        merchantOrder = MerchantOrder(
                            description = "some description",
                            id = "some-id"
                        ),
                        operationData = ScheduledByAcquirerRecurringData(
                            amount = Amount(
                                value = BigDecimal.valueOf(100),
                                currency = Currency.getInstance("USD"),
                            )
                        )
                    )
                ),
                environment = Environments.SANDBOX,
                launcher = launcher
        )
```

##### Payment with saved card token (SM)
```kotlin
        UnlimintSdk.recurringForResult(
                activity = activity,
                mobileAuthorizationToken = token,
                paymentMethodsData = arrayListOf(
                    TokenizedCardOrder(
                        merchantName = "Best shop eva",
                        customer = Customer(
                            id = "some-customer-id",
                            email = "some@email.com"
                        ),
                        merchantOrder = MerchantOrder(
                            description = "some description",
                            id = "some-id"
                        ),
                        cardAccount = TokenizedCardOrder.CardAccount(
                            tokenData = arrayListOf(
                                TokenData(
                                    "token": "test_token_for_payment",
                                    "maskedPan": "400000...0085"
                                )
                            )
                        ),
                        operationData = ScheduledByMerchantRecurringData(
                            amount = Amount(
                                value = BigDecimal.valueOf(100),
                                currency = Currency.getInstance("USD"),
                            )
                        )
                    )
                ),
                environment = Environments.SANDBOX,
                launcher = launcher
        )
```

##### Payment with saved card token (SA)
```kotlin
        UnlimintSdk.recurringForResult(
                activity = activity,
                mobileAuthorizationToken = token,
                paymentMethodsData = arrayListOf(
                    TokenizedCardOrder(
                        merchantName = "Best shop eva",
                        customer = Customer(
                            id = "some-customer-id",
                            email = "some@email.com"
                        ),
                        merchantOrder = MerchantOrder(
                            description = "some description",
                            id = "some-id"
                        ),
                        cardAccount = TokenizedCardOrder.CardAccount(
                            tokenData = arrayListOf(
                                TokenData(
                                    "token": "test_token_for_payment",
                                    "maskedPan": "400000...0085"
                                )
                            )
                        ),
                        operationData = ScheduledByAcquirerRecurringData(
                            amount = Amount(
                                value = BigDecimal.valueOf(100),
                                currency = Currency.getInstance("USD"),
                            )
                        )
                    )
                ),
                environment = Environments.SANDBOX,
                launcher = launcher
        )
```
