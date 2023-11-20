## Card payment

This method allows you to make payment. There are three available methods:
 - new bank card,
 - saved bank card (token),
 - PayPal.

When customer saves bank card while payment, your server will get a cardToken within unlimint's callback
You need to save this token and pass it to SDK, when customer wants to pay with saved card.

### Method signature
```ruby
    MobileSdk.paymentForResult(
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
To start using SDK one must get authorization token from our backend mobile service.
Examples of getting token can be found in code of this project.
Mobile service API described [here](https://cardpay.github.io/android-sdk-demo/mobile-service-description)

Payment method which is gonna be used for payment, (card, card token or paypal), depends on provided data in
`paymentMethodsData` array. 
When single payment method data provided, then SDK opens corresponding screen without delay. 
Also, one have an option to provide multiple methods inside the array, then SDK will ask the end user to choose, 
what method is preferred for current transaction.

Code samples can be found below.

##### Payment with collecting of card data
```kotlin
        UnlimintSdk.paymentForResult(
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
                        operationData = PaymentData(
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

##### Payment with saved card token
```kotlin
        UnlimintSdk.paymentForResult(
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
                        operationData = PaymentData(
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

##### Payment with PayPal
```kotlin
        UnlimintSdk.paymentForResult(
                activity = activity,
                mobileAuthorizationToken = token,
                paymentMethodsData = arrayListOf(
                    PayPalOrder(
                        merchantName = "Best shop eva",
                        customer = Customer(
                            id = "some-customer-id",
                            email = "some@email.com"
                        ),
                        merchantOrder = MerchantOrder(
                            description = "some description",
                            id = "some-id"
                        ),
                        operationData = PaymentData(
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
