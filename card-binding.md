## Card binding
Binds bank card. If bank card was bound earlier, rewrites it

### Method signature
```ruby
    MobileSdk.bindNewCardForResult(
        activity: AppCompatActivity,
        mobileAuthorizationToken: String,
        bindingMethodData: Binding.Data,
        showStatusScreen: Boolean = true,
        customizations: ArrayList<Customization>? = null,
        environment: Environments,
        launcher: ActivityResultLauncher<Intent>
    )
```
##### Mandatory params
 - `activity` for calling our Activity
 - `mobileAuthorizationToken` Mobile token received from Unlimint (authentication mobile token)
 - `bindingMethodData` needed information for binding
 - `launcher` ActivityResultLauncher instance received after registering for activity result
 - `environment` Environment to send requests to

##### Optional params
 - `showStatusScreen` flag that manages rendering of Unlimint's status screen (Success/Decline), default value is true
 - `customizations` list of parameters to render custom texts and colors of UI elements

### Examples
To start using SDK one must get authorization token from our backend mobile service.
Examples of getting token can be found in code of this project.
Mobile service API described [here](https://cardpay.github.io/android-sdk-demo/mobile-service-description)

##### Binding for payment
```kotlin
        UnlimintSdk.bindNewCardForResult(
                activity = activity,
                mobileAuthorizationToken = token,
                bindingMethodData = Binding.Data(
                    currency = Currency.getInstance("USD),
                    type = Binding.Type.fromString("PAYMENT"),
                    customer = Customer(
                                id = "some-customer-id",
                                email = "some@email.com"
                    ),
                    merchantOrder = MerchantOrder(
                                description = "some description",
                                id = "some-id"
                    )
                ),
                environment = serverType.environments,
                launcher = launcher
        )
```

##### Binding for recurring
```kotlin
        UnlimintSdk.bindNewCardForResult(
                activity = activity,
                mobileAuthorizationToken = token,
                bindingMethodData = Binding.Data(
                    currency = Currency.getInstance("USD),
                    type = Binding.Type.fromString("RECURRING"),
                    customer = Customer(
                        id = "some-customer-id",
                        email = "some@email.com"
                    ),
                    merchantOrder = MerchantOrder(
                        description = "some description",
                        id = "some-id"
                    )
                ),
                environment = serverType.environments,
                launcher = launcher
        )
```
